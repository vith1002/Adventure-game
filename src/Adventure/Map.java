package Adventure;

import java.util.ArrayList;

public class Map {

    private Room startRoom;

    public Map() {

        //quest items
        Item rusticKey = new Item("Old Rustic Key Seems Important","Rustic Key", 1, false);
        //Used to open the Basement
        Item silverKey = new Item("Silver Key Seems Important", "Silver Key", 1, true);
        //Used to open the Study
        Item goldenKey = new Item("Shiny Golden Key Seems Important", "Golden Key", 1, true);
        //Used to open the Secret Attic
        Item cryptoKey = new Item("Dark Auro Embessels The Objekt Looking Like A Key", "Crypto Key", 1, true);
        //Used to open End Area
        Item theHauntedIdol = new Item("Mystrious Force That Feels Overwhelming", "Haunted Idol", 20, false);
        //Win Condition
        Item flashLight = new Item("Flashlight It Seems Like It Needs Batteries", "FlashLight", 1, false);
        //Used to see more items
        Item batteries = new Item("Old Batteries Seems To Have Some Power Left", "Batteries", 1, false);
        //Used to power the flashlight
        Item backPack = new Item("Old BackPack Might Be Of Use", "BackPack", -20, true);
        //Lets The User Have More Inventory Space
        Item map = new Item("Old Map Seems To Be Of The House", "Map", 1, false);
        //Lets The Player See Every Room
        Weapon revolver = new RangedWeapon("Old Revolver from the 70's", "Revolver", 2, false, 30, 4);
        //Revolver weapon
        Item silverKnuckles = new MeleeWeapon("Silver Brass knuckles", "Knuckles", 1, false, 15);


        //Food Items
        Item bread = new Food("An Old Loaf Of Half Eaten Bread", "Bread", 1, 10, false);
        Item apple = new Food("A Bruised Red Apple", "Apple", 1, 10, false);
        Item sandwich = new Food("A Stale Sandwich", "Sandwich", 2, 15, false);
        Item beans = new Food("An Old Can Of Beans", "Beans", 2, 20, true);

        Item chocolate = new Food("A Forgotten Chocolate Bar", "Chocolate", 1, 25, true);
        Item cheese = new Food("A Moldy Piece Of Cheese", "Cheese", 1, -5, false);
        Item potato = new Food("A Rotten Potato", "Potato", 1, -15, false);
        Item rottenMeat = new Food("A Piece Of Rotten Meat", "Rotten Meat", 1, -25, true);

        Item berries = new Food("A Handful Of Strange Black Berries", "Berries", 1, 15, true);
        Item mushroom = new Food("A Strange Glowing Mushroom", "Mushroom", 1, -50, true);

        //Lore items
        Item oldDiary = new Item("Old Diary Belongs To Edward Thomsen", "Diary", 1, false);
        Item newspaper = new Item("A Yellowed Newspaper Describing Strange Events At The Mansion", "Newspaper", 1, false);
        Item letter = new Item("A Sealed Letter Addressed To Edward Thomsen", "Letter", 1, false);
        Item journal = new Item("A Water Damaged Journal Filled With Strange Notes", "Journal", 1, false);
        Item familyPhoto = new Item("A Dusty Family Photo Showing The Previous Owners Of The Mansion", "Family Photo", 1, false);

        Item candle = new Item("A Half Melted Candle Covered In Wax", "Candle", 1, false);
        Item pocketWatch = new Item("An Antique Pocket Watch That Stopped Working Long Ago", "Pocket Watch", 1, true);
        Item weddingRing = new Item("A Tarnished Wedding Ring Forgotten Many Years Ago", "Wedding Ring", 1, true);

        Item doll = new Item("An Old Porcelain Doll Stares Back At You", "Doll", 1, true);
        Item cursedDoll = new Item("A Doll With Hollow Black Eyes And A Cracked Smile", "Cursed Doll", 1, true);

        Item mirror = new Item("A Cracked Mirror Covered In Dust", "Mirror", 2, true);
        Item skull = new Item("A Human Skull Covered In Dust", "Skull", 2, true);

        Item fuse = new Item("An Old Electrical Fuse Covered In Rust", "Fuse", 1, true);
        Item painting = new Item("A Large Portrait Of The Mansion Founder Watching Your Every Move", "Painting", 5, true);

        Enemy skeleton = new Enemy("Skeleton","An evil skeleton has appeared and is coming at you!!","something", 100, revolver);
        Enemy owner = new Enemy("Owner","The mansion owner have spotted you!!","Angry",100, revolver);
        Enemy ghost = new Enemy("Ghost","An angry ghost is hunting you!!","Floating ghost", 50, revolver);



        ArrayList<Item> ItemsRoom1 = new ArrayList<>();
        ItemsRoom1.add(silverKey);
        ItemsRoom1.add(apple);

        ArrayList<Item> ItemsRoom2 = new ArrayList<>();
        ItemsRoom2.add(bread);
        ItemsRoom2.add(oldDiary);

        ArrayList<Item> ItemsRoom3 = new ArrayList<>();
        ItemsRoom3.add(familyPhoto);

        ArrayList<Item> ItemsRoom4 = new ArrayList<>();
        ItemsRoom4.add(candle);

        ArrayList<Item> ItemsRoom5 = new ArrayList<>();
        ItemsRoom5.add(map);
        ItemsRoom5.add(newspaper);
        ItemsRoom2.add(rusticKey);
        ItemsRoom5.add(revolver);
        ItemsRoom5.add(silverKnuckles);

        ArrayList<Item> ItemsRoom6 = new ArrayList<>();
        ItemsRoom6.add(flashLight);
        ItemsRoom6.add(letter);
        ItemsRoom6.add(chocolate);

        ArrayList<Item> ItemsRoom7 = new ArrayList<>();
        ItemsRoom7.add(weddingRing);

        ArrayList<Item> ItemsRoom8 = new ArrayList<>();
        ItemsRoom8.add(pocketWatch);

        ArrayList<Item> ItemsRoom9 = new ArrayList<>();
        ItemsRoom9.add(sandwich);
        ItemsRoom9.add(cheese);

        ArrayList<Item> ItemsRoom10 = new ArrayList<>();
        ItemsRoom10.add(beans);
        ItemsRoom10.add(potato);

        ArrayList<Item> ItemsRoom11 = new ArrayList<>();
        ItemsRoom11.add(batteries);
        ItemsRoom11.add(skull);
        ItemsRoom11.add(mushroom);

        ArrayList<Item> ItemsRoom12 = new ArrayList<>();
        ItemsRoom12.add(rottenMeat);
        ItemsRoom12.add(fuse);

        ArrayList<Item> ItemsRoom13 = new ArrayList<>();
        ItemsRoom13.add(goldenKey);
        ItemsRoom13.add(doll);
        ItemsRoom13.add(berries);

        ArrayList<Item> ItemsRoom14 = new ArrayList<>();
        ItemsRoom14.add(backPack);
        ItemsRoom14.add(mirror);
        ItemsRoom14.add(journal);

        ArrayList<Item> ItemsRoom15 = new ArrayList<>();
        ItemsRoom15.add(cryptoKey);
        ItemsRoom15.add(theHauntedIdol);
        ItemsRoom15.add(cursedDoll);
        ItemsRoom15.add(painting);

        ArrayList<Item> ItemsRoom16 = new ArrayList<>();

        ArrayList<Enemy> enemiesRoom1 = new ArrayList<>();


        Room room1 = new Room("Gate", "Den rustne port til godset.", ItemsRoom1, false,null);
        Room room2 = new Room("Porch", "En gammel træveranda.", ItemsRoom2, true,null);
        Room room3 = new Room("Entrance", "Indgangen til det hjemsøgte hus.", ItemsRoom3, false,null);
        Room room4 = new Room("Main Hall", "Den store centrale hal.", ItemsRoom4, false,null);
        Room room5 = new Room("Library", "Et støvet bibliotek.", ItemsRoom5, false,null);
        Room room6 = new Room("Study", "Et gammelt arbejdsværelse.", ItemsRoom6, false, null);
        Room room7 = new Room("Bedroom", "Et forladt soveværelse.", ItemsRoom7, false, null);
        Room room8 = new Room("Ballroom", "En mørk balsal.", ItemsRoom8, false, null);
        Room room9 = new Room("Dining Room", "En stor spisestue.", ItemsRoom9, false, null);
        Room room10 = new Room("Kitchen", "Et gammelt køkken.", ItemsRoom10, false, null);
        Room room11 = new Room("Basement", "En fugtig kælder.", ItemsRoom11, true, null);
        Room room12 = new Room("Boiler Room", "Kedlerne brummer svagt.", ItemsRoom12, false, null);
        Room room13 = new Room("Attic", "Et mørkt loft.", ItemsRoom13, true, null);
        Room room14 = new Room("Storage Loft", "Fyldt med gamle kasser.", ItemsRoom14, true, null);
        Room room15 = new Room("Secret Attic", "Et skjult loftsrum.", ItemsRoom15, true,null);

        Room room16 = new Room("Exit","The gate stands open. Freedom lies beyond.", ItemsRoom16,true,null);


        // Gate <-> Porch
        room1.setNorth(room2);
        room2.setSouth(room1);
        room1.setSouth(room16);
        room16.setNorth(room1);

        // Porch <-> Entrance
        room2.setNorth(room3);
        room3.setSouth(room2);

        // Entrance <-> Main Hall
        room3.setNorth(room4);
        room4.setSouth(room3);

        // Main Hall <-> Ballroom
        room4.setNorth(room8);
        room8.setSouth(room4);

        // Ballroom <-> Bedroom
        room8.setNorth(room7);
        room7.setSouth(room8);

        // Bedroom <-> Library
        room7.setWest(room5);
        room5.setEast(room7);

        // Library <-> Study
        room5.setWest(room6);
        room6.setEast(room5);

        // Study <-> Kitchen
        room6.setSouth(room10);
        room10.setNorth(room6);

        // Kitchen <-> Dining Room
        room10.setEast(room9);
        room9.setWest(room10);

        // Dining Room <-> Main Hall
        room9.setEast(room4);
        room4.setWest(room9);

        // Kitchen <-> Basement
        room10.setWest(room11);
        room11.setEast(room10);

        // Basement <-> Boiler Room
        room11.setWest(room12);
        room12.setEast(room11);

        // Library <-> Attic
        room5.setNorth(room13);
        room13.setSouth(room5);

        // Attic <-> Storage Loft
        room13.setNorth(room14);
        room14.setSouth(room13);

        // Storage Loft <-> Secret Attic
        room14.setNorth(room15);
        room15.setSouth(room14);

        startRoom = room5;
    }

    public Room getStartRoom() {
        return startRoom;
    }
}
