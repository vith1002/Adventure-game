package Adventure;

import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void removeItemFromRoom(Item item){
        currentRoom.getItems().remove(item);
    }

    public Item takeItem(String shortName){
        Item itemFound = getCurrentRoom().findItem(shortName);
        if(itemFound != null){
            removeItemFromRoom(itemFound);
            inventory.add(itemFound);
           return itemFound;
        }else{
            return null;
        }
    }

    public Item dropItem(String shortName){
        String itemHave = shortName;

        for (int i = 0; i < inventory.size(); i++) {
            if(itemHave.equalsIgnoreCase(inventory.get(i).getShortName())){
                currentRoom.getItems().add(inventory.get(i));
                Item item = inventory.get(i);
                inventory.remove(i);
                return item;
            }
        }
        return null;
    }

    public void printInventory(){
        if(inventory.size() > 0){
            for (Item item : inventory){
                System.out.println(item.getShortName());
            }
        }
    }

    public boolean move(String direction) {

        Room nextRoom = null;

        switch (direction.toLowerCase()) {

            case "go north", "north", "n":
                nextRoom = currentRoom.getNorth();
                break;

            case "go south", "south", "s":
                nextRoom = currentRoom.getSouth();
                break;

            case "go east", "east", "e":
                nextRoom = currentRoom.getEast();
                break;

            case "go west", "west", "w":
                nextRoom = currentRoom.getWest();
                break;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }

        return false;
    }
}