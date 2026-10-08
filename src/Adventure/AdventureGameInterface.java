package Adventure;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

            if(player.getCurrentRoom().getEnemies() != null){

                while(!player.getCurrentRoom().getEnemies().isEmpty()){

                    ArrayList<Enemy> enemies = player.getCurrentRoom().getEnemies();

                    Room thisRoom = player.getCurrentRoom();

                    for (int i = 0; i < enemies.size(); i++) {
                        if(player.attack() == AttackResult.ATTACK_SUCCES){
                            int damage = player.getEquipped().getDamage();

                            enemies.get(i).hit(damage);

                            enemies.get(i).getDescription();
                            enemies.get(i).Attack(player);


                        }else if(player.attack() == AttackResult.NO_AMMO){
                            System.out.println("You Are Out Of Ammo!");

                            enemies.get(i).getDescription();
                            enemies.get(i).Attack(player);

                        }else if(player.attack() == AttackResult.NO_WEAPON){
                            System.out.println("You dont have a weapon equipped");

                            enemies.get(i).getDescription();
                            enemies.get(i).Attack(player);
                        }
                    }

                    System.out.println("Do you want to run?");

                    String command = scanner.nextLine();

                    if(command.toLowerCase().equals("run")){

                        System.out.println("You run!");

                        player.canMove();

                        System.out.println();

                        System.out.println("n/s/e/w or menu");
                        System.out.println("=============================================");
                        System.out.print("> ");

                        command = scanner.nextLine().toLowerCase();

                        if (!player.move(command) && !command.equalsIgnoreCase("menu")) {
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
                                        case "storage loft":
                                            if(player.searchItemFromInventory("silver key") != null){
                                                player.takeItemFromInventory("Silver Key");
                                                player.getCurrentRoom().setLocked(false);
                                                break;
                                            }else{
                                                System.out.println("You Need The Silver Key!");
                                                break;
                                            }
                                        case "porch":
                                            if(player.searchItemFromInventory("golden key") != null) {
                                                player.takeItemFromInventory("Golden Key");
                                                player.getCurrentRoom().setLocked(false);
                                                break;
                                            }else{
                                                System.out.println("You Need The Golden Key To Enter The Secret Attic");
                                                break;
                                            }
                                        case "secret attic":
                                            if(player.searchItemFromInventory("gate key") != null) {
                                                player.takeItemFromInventory("gate Key");
                                                player.getCurrentRoom().setLocked(false);
                                                break;
                                            }else{
                                                System.out.println("You Need A Gate Key To Exit!");
                                                break;
                                            }
                                    }
                                }
                            }else{
                                System.out.println("You Cant Enter Here!");
                            }
                        }

                        if(thisRoom != player.getCurrentRoom()){
                            break;
                        }

                    }

                }

            }

            if(player.getCurrentRoom().getName().equals("Exit")
                    && player.searchItemFromInventory("Haunted Idol") != null){

                System.out.println("You escaped with the Haunted Idol!");
                System.out.println("You Win!");

                break;
            }

            if(player.searchItemFromInventory("Map") != null){
                mapAquired = true;
            }
            if(player.searchItemFromInventory("flashlight") != null
                    && player.searchItemFromInventory("batteries") != null){

                flashLightOn = true;

                System.out.println();
                System.out.println("You put the batteries in the FlashLight");
                System.out.println("Everything in front of you brightens up a little bit");
                System.out.println("You Might be able to see more items with the flashlight");
                System.out.println();

                player.takeItemFromInventory("Batteries");
            }


            System.out.print("=============================================");
            System.out.println("\nYou Are In: " + player.getCurrentRoom().getName());
            System.out.println(player.getCurrentRoom().getDescription());

            player.canMove();

            System.out.println();

            System.out.println("n/s/e/w or menu");
            System.out.println("=============================================");
            System.out.print("> ");


            String command = scanner.nextLine().toLowerCase();

            if (command.equals("quit")) {
                System.out.println("Game Over!");
                break;
            }

            if (!player.move(command) && !command.equalsIgnoreCase("menu")) {
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
                            case "storage loft":
                                if(player.searchItemFromInventory("silver key") != null){
                                    player.takeItemFromInventory("Silver Key");
                                    player.getCurrentRoom().setLocked(false);
                                    break;
                                }else{
                                    System.out.println("You Need The Silver Key!");
                                    break;
                                }
                            case "porch":
                                if(player.searchItemFromInventory("golden key") != null) {
                                    player.takeItemFromInventory("Golden Key");
                                    player.getCurrentRoom().setLocked(false);
                                    break;
                                }else{
                                    System.out.println("You Need The Golden Key To Enter The Secret Attic");
                                    break;
                                }
                            case "secret attic":
                                if(player.searchItemFromInventory("gate key") != null) {
                                    player.takeItemFromInventory("gate Key");
                                    player.getCurrentRoom().setLocked(false);
                                    break;
                                }else{
                                    System.out.println("You Need A Gate Key To Exit!");
                                    break;
                                }
                        }
                    }
                }else{
                    System.out.println("You Cant Enter Here!");
                }
            }

            if(command.equalsIgnoreCase("menu")){
                System.out.println();
                System.out.println("menu");
                System.out.println("=============================================");
                System.out.println("Equip Weapon");
                System.out.println("Attack");
                System.out.println("Look For Items");
                System.out.println();
                System.out.println("View Inventory");
                System.out.println("Drop Item");
                System.out.println();
                System.out.println("Use Map");
                System.out.println("=============================================");
                System.out.print("> ");

                command = scanner.nextLine().toLowerCase();

                switch (command){
                    case "look", "look for items":
                        System.out.println("\nItems in " + player.getCurrentRoom().getName() + " :\n");
                        int count = 0;
                        for(Item item : player.getCurrentRoom().getItems()) {
                            if(item.isRequiresLight() && !flashLightOn){
                                if(count == 0){
                                    System.out.println("Its Too Dark In Here To See Every Item");
                                }
                                count++;
                            }else{
                                System.out.println(item.getShortName());
                                System.out.println();
                            }
                        }
                        System.out.println("Take item or leave");

                        command = scanner.nextLine().toLowerCase();

                        if (command.equalsIgnoreCase("take item") || command.equalsIgnoreCase("take")){
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

                    case "view inventory", "view":
                        player.printInventory();
                        break;
                    case "drop item", "drop":
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
                    case "equip weapon", "equip":

                        System.out.println("What weapon would you like to equip?");
                        player.printInventory();
                        command = scanner.nextLine();

                        Weapon weapon = player.equip(command.toLowerCase());

                        if(weapon == null){
                            System.out.println("You cannot equip that.");
                        }else{
                            System.out.println(
                                    "You have equipped " + weapon.getShortName()
                            );
                        }

                        break;
                    case "attack":

                        AttackResult result = player.attack();

                        switch(result){

                            case NO_WEAPON:
                                System.out.println("You have no weapon equipped.");
                                break;

                            case NO_AMMO:
                                System.out.println("Your weapon is out of ammunition.");
                                break;

                            case ATTACK_SUCCES:
                                System.out.println(
                                        "You " + player.getEquipped().getAttackVerb() + " the "
                                                + player.getEquipped().getShortName() + " at the empty air. "
                                                + player.getEquipped().getUsesLeftText()
                                );
                                break;
                        }
                        break;

                    case "use map":
                        if (mapAquired){
                            System.out.println(
                                    "                   Secret Attic\n" +
                                            "                        |\n" +
                                            "                   Storage Loft\n" +
                                            "                        |\n" +
                                            "                      Attic\n" +
                                            "                        |\n" +
                                            "                     Library\n" +
                                            "                    /       \\\n" +
                                            "               Study       Bedroom\n" +
                                            "                 |            |\n" +
                                            " Basement  --  Kitchen     Ballroom\n" +
                                            "      |          |            |\n" +
                                            " Boiler Room  Dining Room -- Main Hall\n" +
                                            "                               |\n" +
                                            "                           Entrance\n" +
                                            "                               |\n" +
                                            "                             Porch\n" +
                                            "                               |\n" +
                                            "                              Gate"
                            );
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
        scanner.close();
    }
}
