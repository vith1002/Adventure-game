package Adventure;

import java.util.ArrayList;

public class Map {

    private Room startRoom;

    public Map() {

        Item lampe = new Item(" Stor mægtig lampe", "lampe", 20);


        Item bog1 = new Item("Book of Askaban","Askaban Book", 2);
        Item bog2 = new Item("Book of water","Water Book", 2);
        Item bog3 = new Item("Book of fire","Fire Book", 2);
        Item rusticSword = new Item("A Rustic Sword","Rustic Sword", 2);
        //Sword
        Item shield = new Item("A Shield From The Viking Times","Shield", 2);
        //Shield
        Item Rum = new Item("A Very Old Bottle Of Rum","Bottle Of Rum", 2);
        //End up in a random room
        Item painting = new Item("","", 2);
        //May be needed for a secret door
        Item key = new Item("Old Rustic Key With A Skull","Rustic Key", 2);
        //Used to open a locked door


        ArrayList<Item> ItemsRoom1 = new ArrayList<>();
        ItemsRoom1.add(bog1);
        ItemsRoom1.add(bog2);
        ItemsRoom1.add(bog3);

        ArrayList<Item> ItemsRoom2 = new ArrayList<>();
        ArrayList<Item> ItemsRoom3 = new ArrayList<>();
        ArrayList<Item> ItemsRoom4 = new ArrayList<>();
        ArrayList<Item> ItemsRoom5 = new ArrayList<>();
        ArrayList<Item> ItemsRoom6 = new ArrayList<>();

        Room room1 = new Room("Room 1", "Et gammelt bibliotek.", ItemsRoom1);
        Room room2 = new Room("Room 2", "En smal korridor.", ItemsRoom1);
        Room room3 = new Room("Room 3", "Et støvet soveværelse.", ItemsRoom1);
        Room room4 = new Room("Room 4", "En mørk gang.", ItemsRoom1);
        Room room5 = new Room("Room 5", "Den centrale hall.", ItemsRoom1);
        Room room6 = new Room("Room 6", "Et køkken.", ItemsRoom1);
        Room room7 = new Room("Room 7", "En kælder.", ItemsRoom1);
        Room room8 = new Room("Room 8", "Et lager.", ItemsRoom1);
        Room room9 = new Room("Room 9", "Skatkammeret.", ItemsRoom1);

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
