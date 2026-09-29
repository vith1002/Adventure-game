package Adventure;

import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int maxWeight = 20;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void removeItemFromRoom(Item item){
        currentRoom.getItems().remove(item);
    }

    public int inventoryWeight(){
        int invWeight = 0;
        for (int i = 0; i < inventory.size(); i++) {
            int itemWeight = inventory.get(i).getWeight();
            invWeight += itemWeight;
        }

        return invWeight;
    }

    public int getMaxWeight(){
        return maxWeight;
    }

    public Item takeItem(String shortName){
        Item itemFound = getCurrentRoom().findItem(shortName);
        if(itemFound != null && inventoryWeight() + itemFound.getWeight() < maxWeight){
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

    public boolean takeItemFromInventory(String shortName){
        String itemHave = shortName;

        for (int i = 0; i < inventory.size(); i++) {
            if(itemHave.equalsIgnoreCase(inventory.get(i).getShortName())){
                inventory.remove(itemHave);
                return true;
            }
        }
        return false;
    }

    public void printInventory(){
        if(inventory.size() > 0){
            for (Item item : inventory){
                System.out.println(item.getShortName());
            }
        }
    }

    public boolean move(String direction) {
        boolean isRoomLocked = false;
        Room nextRoom = null;
        if(currentRoom.isLocked() == true){
            isRoomLocked = true;
            return isRoomLocked;
        }

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