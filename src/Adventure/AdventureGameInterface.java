package Adventure;

import java.util.Scanner;

public class AdventureGameInterface {

    public static void main(String[] args) {

        Map map = new Map();
        Player player = new Player(map.getStartRoom());

        Scanner scanner = new Scanner(System.in);

        System.out.println("'quit' to exit the game!\n");

        while (true) {

            System.out.println("\nYou Are In: " + player.getCurrentRoom().getName());
            System.out.println(player.getCurrentRoom().getDescription());

            System.out.println("n/s/e/w or other options: ");

            String command = scanner.nextLine().toLowerCase();

            if (command.equals("quit")) {
                System.out.println("Game Over!");
                break;
            }

            if (!player.move(command) && !command.equalsIgnoreCase("other options")) {
                if(player.getCurrentRoom().isLocked() == true){
                    System.out.println("The Door Is Locked!");
                    System.out.println("Do You Have The Key?");
                    command = scanner.nextLine().toLowerCase();
                    if(command.equals("yes")){
                        switch (player.getCurrentRoom().getName().toLowerCase()){

                            case "basement":
                                if (player.takeItemFromInventory("rustic item"))
                                player.takeItem("Rustic Key");


                            case "study":

                            case "secret attic":

                            case "slutområde":

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
                System.out.print("Type your action");
                command = scanner.nextLine().toLowerCase();

                switch (command){
                    case "look for items":
                        System.out.println("\nItems in current room:");
                        for(Item item : player.getCurrentRoom().getItems()) {
                            System.out.println(item.getShortName());
                        }
                        System.out.println("Take an item or leave them");
                        command = scanner.nextLine().toLowerCase();
                        if (command.equalsIgnoreCase("take an item")){
                            System.out.println("What item do you wish to take?");
                            command = scanner.nextLine().toLowerCase();
                            Item checkItem = player.takeItem(command);
                            if(checkItem != null){
                                System.out.println("Item Collected!");
                            }else if(player.inventoryWeight() + checkItem.getWeight() > 20){
                                System.out.println("Inventory Max Weight: " +
                                player.inventoryWeight() + checkItem.getWeight()+
                                        "\nsmid noget for at få plads!");
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
                    default:
                        System.out.println("No Such Action Exist!");
                        break;
                }
            }
        }
        scanner.close();
    }
}
