package Adventure;

import java.util.Scanner;

public class AdventureGameInterface {

    public static void main(String[] args) {

        Map map = new Map();
        Player player = new Player(map.getStartRoom());

        Scanner scanner = new Scanner(System.in);

        boolean flashLightOn = false;
        boolean mapAquired = false;

        System.out.println("'quit' to exit the game!\n");

        while (true) {
            if(player.searchItemFromInventory("Map") != null){
                mapAquired = true;
            }

            System.out.println("\nYou Are In: " + player.getCurrentRoom().getName());
            System.out.println(player.getCurrentRoom().getDescription());

            System.out.println("n/s/e/w or other options: ");

            String command = scanner.nextLine().toLowerCase();

            if (command.equals("quit")) {
                System.out.println("Game Over!");
                break;
            }

            if (!player.move(command) && !command.equalsIgnoreCase("other options")) {
                if(player.getCurrentRoom().isLocked()){
                    System.out.println("The Door Is Locked!");
                    System.out.println("Do You Have The Key?");
                    command = scanner.nextLine().toLowerCase();

                    if(command.equals("yes")){
                        switch (player.getCurrentRoom().getName().toLowerCase()){

                            case "basement":
                                if (player.searchItemFromInventory("rustic key") != null){
                                    player.takeItemFromInventory("Rustic Key");
                                    player.getCurrentRoom().setLocked(false);
                                    break;
                                }else{
                                    System.out.println("You Need The Rustic Key To Enter The Basement!");
                                    break;
                                }
                            case "study":
                                if(player.searchItemFromInventory("silver key") != null){
                                    player.takeItemFromInventory("Silver Key");
                                    player.getCurrentRoom().setLocked(false);
                                    break;
                                }else{
                                    System.out.println("You Need The Silver Key!");
                                    break;
                                }
                            case "secret attic":
                                if(player.searchItemFromInventory("golden key") != null) {
                                    player.takeItemFromInventory("Golden Key");
                                    player.getCurrentRoom().setLocked(false);
                                    break;
                                }else{
                                    System.out.println("You Need The Golden Key To Enter The Secret Attic");
                                    break;
                                }
                            case "slutområde":
                                if(player.searchItemFromInventory("crypto key") != null) {
                                    player.takeItemFromInventory("Crypto Key");
                                    player.getCurrentRoom().setLocked(false);
                                    break;
                                }else{
                                    System.out.println("You Need A Crypto Key For This Area!");
                                    break;
                                }
                        }
                    }
                }else{
                    System.out.println("You Cant Enter Here!");
                }
            }



            if(command.equalsIgnoreCase("other options")){
                System.out.println("Other commands:");
                System.out.println("View Inventory");
                System.out.println("Look For Items");
                System.out.println("Drop Item");
                System.out.println("Use Map");
                System.out.print("Type your action");
                command = scanner.nextLine().toLowerCase();

                switch (command){
                    case "look for items":
                        System.out.println("\nItems in current room:");
                        int count = 0;
                        for(Item item : player.getCurrentRoom().getItems()) {
                            if(item.isRequiresLight() && !flashLightOn){
                                if(count == 0){
                                    System.out.println("Its Too Dark In Here");
                                }
                                count++;
                            }else{
                                System.out.println(item.getShortName());
                            }
                        }
                        System.out.println("Take an item or leave them");

                        command = scanner.nextLine().toLowerCase();

                        if (command.equalsIgnoreCase("take an item")){
                            System.out.println("What item do you wish to take?");

                            command = scanner.nextLine().toLowerCase();
                            Item checkItem = player.searchItemFromRoom(command);

                            if(checkItem != null && player.inventoryWeight() + checkItem.getWeight() < 20){
                                System.out.println("Item Collected!");
                                player.takeItem(command);
                            }else if(checkItem != null && player.inventoryWeight() + checkItem.getWeight() >= 20){
                                System.out.println("You Cant Pick This Item Up Its Too Heavy!");
                                System.out.println("Drop Something To Get Space");
                            }else{
                                System.out.println("No Such Item Is In This Room!");
                            }
                        }
                        break;
                    case "view inventory":
                        player.printInventory();
                        break;
                    case "drop item":
                        Item checkItem;
                        System.out.println("Which item would you like to drop");
                        player.printInventory();
                        System.out.println("Input: ");
                        command = scanner.nextLine().toLowerCase();
                        checkItem = player.dropItem(command);
                        if (checkItem != null){
                            System.out.println("Item Dropped");
                        }else{
                            System.out.println("No Such Item Is In Your Inventory!");
                        }
                        break;
                    case "eat item":
                        System.out.println("What Item Would You Like to Eat?\n:");
                        command = scanner.nextLine().toLowerCase();

                        EatOutcome eatOutcome = player.eat(command);

                        switch (eatOutcome.getResult()) {
                            case NOT_FOUND:
                                System.out.println("There is nothing like " + command + " to eat around here");
                                break;
                            case NOT_FOOD:
                                System.out.println("You cannot eat the " + eatOutcome.getItemName());
                                break;
                            case EATEN:
                                System.out.println("You eat the " + eatOutcome.getItemName());
                                player.printHealthPoints();
                                break;
                        }
                        break;
                    case "use map":
                        if (mapAquired){
                            System.out.println("                   Secret Attic\n" +
                                    "                        |\n" +
                                    "                   Storage Loft\n" +
                                    "                        |\n" +
                                    "                      Attic\n" +
                                    "                        |\n" +
                                    "                     Library\n" +
                                    "                    /       \\\n" +
                                    "               Study       Bedroom\n" +
                                    "                 |            |\n" +
                                    "              Kitchen     Ballroom\n" +
                                    "                 |            |\n" +
                                    "             Dining Room  Main Hall\n" +
                                    "                  \\        /\n" +
                                    "                   \\      /\n" +
                                    "                  Entrance\n" +
                                    "                      |\n" +
                                    "                    Porch\n" +
                                    "                      |\n" +
                                    "                     Gate\n" +
                                    "\n" +
                                    "                 Basement\n" +
                                    "                      |\n" +
                                    "                 Boiler Room");
                        }else{
                            System.out.println("You Dont Have A Map!");
                        }
                        break;
                    default:
                        System.out.println("No Such Action Exist!");
                        break;
                }
            }
        }

        if(player.searchItemFromInventory("flashlight") != null
                && player.searchItemFromInventory("batteries") != null){

            flashLightOn = true;

            System.out.println("You put the batteries in the FlashLight");
            System.out.println("Everything in front of you brightens up a little bit");
            System.out.println("You Might be able to see more items with the flashlight");

            player.takeItemFromInventory("Batteries");
        }



        scanner.close();
    }
}
