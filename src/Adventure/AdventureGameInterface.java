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

            System.out.print("Go (north/south/east/west) or quit: ");

            String command = scanner.nextLine().toLowerCase();

            if (command.equals("quit")) {
                System.out.println("Tak for spillet!");
                break;
            }

            if (!player.move(command)) {
                System.out.println("Du kan ikke gå den vej!");
            }
        }

        scanner.close();
    }
}
