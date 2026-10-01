package Adventure;

import java.util.ArrayList;

public class Map {

    private Room startRoom;

    public Map() {

        Item bog1 = new Item("Book of Askaban","Askaban Book", 2, false);
        Item bog2 = new Item("Book of water","Water Book", 2, false);
        Item bog3 = new Item("Book of fire","Fire Book", 2, false);
        Item rusticSword = new Item("A Rustic Sword","Rustic Sword", 2, false);
        //Sword
        Item shield = new Item("A Shield From The Viking Times","Shield", 2, false);
        //Shield
        Item painting = new Item("","", 2, false);
        //May be needed for a secret door


        Item rusticKey = new Item("Old Rustic Key Seems Important","Rustic Key", 1, false);
        //Used to open the Basement
        Item silverKey = new Item("Silver Key Seems Important", "Silver Key", 1, false);
        //Used to open the Study
        Item goldenKey = new Item("Shiny Golden Key Seems Important", "Golden Key", 1, false);
        //Used to open the Secret Attic
        Item cryptoKey = new Item("Dark Auro Embessels The Objekt Looking Like A Key", "Crypto Key", 1, false);
        //Used to open End Area
        Item theHauntedIdol = new Item("Mystrious Force That Feels Overwhelming", "Haunted Idol", 20, false);
        //Win Condition
        Item flashLight = new Item("Flashligt It Seems Like It Needs Batteries", "Flash Light", 1, false);
        //Used to see more items
        Item batteries = new Item("Old Batteries Seems To Have Some Power Left", "Batteries", 1, false);
        //Used to power the flashlight
        Item backPack = new Item("Old BackPack Might Be Of Use", "BackPack", -20, false);
        //Lets The User Have More Inventory Space
        Item map = new Item("Old Map Seems To Be Of The House", "Map", 1, false);
        //Lets The Player See Every Room
        Item oldDiary = new Item("Old Diary Belongs To Edward Thomsen", "Diary", 1, false);
        //Gives Information From A Person Who Got Lost In The House

        Item something = new Food("An Old Loaf Of Half Eaten Bread", "Bread", 1, 10, false);

        ArrayList<Item> ItemsRoom1 = new ArrayList<>();
        ItemsRoom1.add(shield);
        ItemsRoom1.add(rusticKey);
        ItemsRoom1.add(rusticSword);

        ArrayList<Item> ItemsRoom2 = new ArrayList<>();
        ItemsRoom2.add(bog1);
        ItemsRoom2.add(bog2);

        ArrayList<Item> ItemsRoom3 = new ArrayList<>();
        ArrayList<Item> ItemsRoom4 = new ArrayList<>();
        ArrayList<Item> ItemsRoom5 = new ArrayList<>();
        ItemsRoom5.add(shield);
        ItemsRoom5.add(rusticSword);
        ItemsRoom5.add(map);
        ArrayList<Item> ItemsRoom6 = new ArrayList<>();
        ArrayList<Item> ItemsRoom7 = new ArrayList<>();
        ArrayList<Item> ItemsRoom8 = new ArrayList<>();
        ArrayList<Item> ItemsRoom9 = new ArrayList<>();
        ArrayList<Item> ItemsRoom10 = new ArrayList<>();
        ArrayList<Item> ItemsRoom11 = new ArrayList<>();
        ArrayList<Item> ItemsRoom12 = new ArrayList<>();
        ArrayList<Item> ItemsRoom13 = new ArrayList<>();
        ArrayList<Item> ItemsRoom14 = new ArrayList<>();
        ArrayList<Item> ItemsRoom15 = new ArrayList<>();

        Room room1 = new Room("Gate", "Den rustne port til godset.", ItemsRoom1, false);
        Room room2 = new Room("Porch", "En gammel træveranda.", ItemsRoom2, false);
        Room room3 = new Room("Entrance", "Indgangen til det hjemsøgte hus.", ItemsRoom3, false);
        Room room4 = new Room("Main Hall", "Den store centrale hal.", ItemsRoom4, false);
        Room room5 = new Room("Library", "Et støvet bibliotek.", ItemsRoom5, false);
        Room room6 = new Room("Study", "Et gammelt arbejdsværelse.", ItemsRoom6, false);
        Room room7 = new Room("Bedroom", "Et forladt soveværelse.", ItemsRoom7, false);
        Room room8 = new Room("Ballroom", "En mørk balsal.", ItemsRoom8, false);
        Room room9 = new Room("Dining Room", "En stor spisestue.", ItemsRoom9, false);

        Room room10 = new Room("Kitchen", "Et gammelt køkken.", ItemsRoom10, false);
        Room room11 = new Room("Basement", "En fugtig kælder.", ItemsRoom11, true);
        Room room12 = new Room("Boiler Room", "Kedlerne brummer svagt.", ItemsRoom12, false);
        Room room13 = new Room("Attic", "Et mørkt loft.", ItemsRoom13, false);
        Room room14 = new Room("Storage Loft", "Fyldt med gamle kasser.", ItemsRoom14, false);
        Room room15 = new Room("Secret Attic", "Et skjult loftsrum.", ItemsRoom15, false);


        //Every way you can walk in the haunted House Game
        //Gate <-> Porch <-> Entrance
        room1.setNorth(room2);
        room2.setSouth(room1);

        room2.setNorth(room3);
        room3.setSouth(room2);

        //Entrance <-> Main Hall
        room3.setNorth(room4);
        room4.setSouth(room3);

        //Main Hall <-> Dining
        room4.setWest(room9);
        room9.setEast(room4);

        //Dining <-> Kitchen
        room9.setWest(room10);
        room10.setEast(room9);

        //Kitchen <-> Study
        room10.setNorth(room6);
        room6.setSouth(room10);

        //Study <-> Library
        room6.setEast(room5);
        room5.setWest(room6);

        //Library <-> Bedroom
        room5.setEast(room7);
        room7.setWest(room5);

        //Bedroom <-> Ballroom
        room7.setSouth(room8);
        room8.setNorth(room7);

        //Ballroom <-> Main Hall
        room8.setWest(room4);
        room4.setEast(room8);

        //Loft <-> veje
        room5.setNorth(room13);
        room13.setSouth(room5);

        room13.setNorth(room14);
        room14.setSouth(room13);

        room14.setNorth(room15);
        room15.setSouth(room14);

        //Basement <-> veje
        room10.setSouth(room11);
        room11.setNorth(room10);

        room11.setSouth(room12);
        room12.setNorth(room11);


        startRoom = room5;
    }

    public Room getStartRoom() {
        return startRoom;
    }
}
