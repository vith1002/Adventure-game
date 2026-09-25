package Adventure;

public class Map {

    private Room startRoom;

    public Map() {

        Room room1 = new Room("Room 1", "Et gammelt bibliotek.");
        Room room2 = new Room("Room 2", "En smal korridor.");
        Room room3 = new Room("Room 3", "Et støvet soveværelse.");
        Room room4 = new Room("Room 4", "En mørk gang.");
        Room room5 = new Room("Room 5", "Den centrale hall.");
        Room room6 = new Room("Room 6", "Et køkken.");
        Room room7 = new Room("Room 7", "En kælder.");
        Room room8 = new Room("Room 8", "Et lager.");
        Room room9 = new Room("Room 9", "Skatkammeret.");

        // Nord/Syd forbindelser
        room1.setSouth(room4);
        room4.setNorth(room1);

        room2.setSouth(room5);
        room5.setNorth(room2);

        room3.setSouth(room6);
        room6.setNorth(room3);

        room4.setSouth(room7);
        room7.setNorth(room4);

        room5.setSouth(room8);
        room8.setNorth(room5);

        room6.setSouth(room9);
        room9.setNorth(room6);

        // Øst/Vest forbindelser
        room1.setEast(room2);
        room2.setWest(room1);

        room2.setEast(room3);
        room3.setWest(room2);

        room4.setEast(room5);
        room5.setWest(room4);

        room5.setEast(room6);
        room6.setWest(room5);

        room7.setEast(room8);
        room8.setWest(room7);

        room8.setEast(room9);
        room9.setWest(room8);

        startRoom = room5;
    }

    public Room getStartRoom() {
        return startRoom;
    }
}
