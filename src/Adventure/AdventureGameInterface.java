package Adventure;

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
            if (player.getHealthPoints() <= 0) {
                System.out.println("You died!");
                System.out.println("Game Over!");
                scanner.close();
                return;
            }

            if(player.getCurrentRoom().getEnemies() != null){

                Room enemiesRoom = player.getCurrentRoom();
                while(!player.getCurrentRoom().getEnemies().isEmpty() && enemiesRoom == player.getCurrentRoom()){

                    ArrayList<Enemy> enemies = player.getCurrentRoom().getEnemies();

                    Room thisRoom = player.getCurrentRoom();

                    for (int i = 0; i < enemies.size(); i++) {

                        if (player.getHealthPoints() <= 0) {
                            break;
                        }

                        AttackResult result = player.attack();

                        if(result == AttackResult.ATTACK_SUCCES){
                            int damage = player.getEquipped().getDamage();

                            Enemy enemy = enemies.get(i);
                            int healthLeft = enemy.hit(damage);

                            if (healthLeft > 0) {
                                System.out.println(enemies.get(i).getDescription());
                                enemy.Attack(player);
                            }else{
                                System.out.println(enemy.getShortName() + " died!");
                                i--;
                            }


                        }else if(result == AttackResult.NO_AMMO){
                            System.out.println("You Are Out Of Ammo!");

                            Enemy enemy = enemies.get(i);
                            int healthLeft = enemies.get(i).getHealth();

                            if (healthLeft > 0) {
                                System.out.println(enemies.get(i).getDescription());
                                enemy.Attack(player);
                            }else{
                                System.out.println(enemy.getShortName() + " died!");
                                i--;
                            }

                        }else if(result == AttackResult.NO_WEAPON){
                            System.out.println("You dont have a weapon equipped");

                            Enemy enemy = enemies.get(i);
                            int healthLeft = enemies.get(i).getHealth();

                            if(healthLeft > 0) {
                                System.out.println(enemies.get(i).getDescription());
                                enemy.Attack(player);
                            }else{
                                System.out.println(enemy.getShortName() + " died!");
                                i--;
                            }
                        }
                        if(player.getHealthPoints() <= 0) {
                            System.out.println("You died!");
                            System.out.println("Game Over!");
                            scanner.close();
                            return;
                        }
                    }

                    System.out.println("Do you want to run or fight?");
                    System.out.print("> ");

                    String command = scanner.nextLine().toLowerCase();

                    if(command.equals("run")) {

                        player.canMove();

                        System.out.println("Choose direction (n/s/e/w):");
                        System.out.print("> ");

                        command = scanner.nextLine().toLowerCase();

                        if(player.move(command)) {
                            System.out.println("You escaped!");
                        }else{
                            System.out.println("You cannot escape that way!");
                        }

                    }else if(command.equals("fight")) {

                        System.out.println("You continue fighting!");

                    }else{

                        System.out.println("Please type run or fight.");
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

            if (!command.equalsIgnoreCase("menu")) {
                if (!player.move(command)) {
                    System.out.println("You cannot go that way or the door is locked!");
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
                System.out.println("Eat Item");
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
                                            "                     Library ------- Bedroom\n" +
                                            "                    /                      |\n" +
                                            "                 Study                 Ballroom\n" +
                                            "                   |                       |\n" +
                                            " Boiler Room    Kitchen                Main Hall\n" +
                                            "      |         /    \\                  /  |\n" +
                                            "  Basement ----      Dining Room ------    |\n" +
                                            "                                        Entrance\n" +
                                            "                                            |\n" +
                                            "                                          Porch\n" +
                                            "                                            |\n" +
                                            "                                           Gate\n" +
                                            "                                            |\n" +
                                            "                                           Exit"
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
