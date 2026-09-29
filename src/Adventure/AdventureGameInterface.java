package Adventure;

import java.util.Scanner;

public class AdventureGameInterface {

    public static void main(String[] args) {

        Map map = new Map();
        Player player = new Player(map.getStartRoom());

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nDu er i: " + player.getCurrentRoom().getName());
            System.out.println(player.getCurrentRoom().getDescription());

            System.out.println("Go (north/south/east/west) or other options: ");
            System.out.println("'quit' to exit the game!\n");

            String command = scanner.nextLine().toLowerCase();

            if (command.equals("quit")) {
                System.out.println("Tak for spillet!");
                break;
            }

            if (!player.move(command)) {
                System.out.println("Du kan ikke gå den vej!");
            }

            if(command.equalsIgnoreCase("other options")){
                System.out.println("Other commands:");
                System.out.println("View Inventory");
                System.out.println("Look For Items");
                System.out.print("Type your action");
                command = scanner.nextLine().toLowerCase();

                switch (command){
                    case "look for items":
                        System.out.println("\nItems in current room:");
                        for(Item item : player.getCurrentRoom().getItems()) {
                            System.out.println(item.getShortName());
                        }
                        break;
                    case "view inventory":
                        player.printInventory();
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
