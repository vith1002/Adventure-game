package Adventure;

import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int maxWeight = 20;
    private int healthPoints = 100;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.healthPoints = healthPoints;
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

    public int getHealthPoints(){
        return healthPoints;
    }

    public void printHealthPoints(){
        System.out.println(getHealthPoints());
        if(healthPoints > 99){
            System.out.print(" -> You are in perfect health");
        }else if(healthPoints >= 50 && 100 > healthPoints){
            System.out.print(" -> you are in good health, but avoid figthing right now");
        }else if(healthPoints < 50 && healthPoints > 24){
            System.out.print(" -> You are wounded - find something healthy to eat");
        }else if(healthPoints < 25 && healthPoints > 0){
            System.out.print(" -> You are barely alive");
        }else{
            System.out.print(" -> You Should Be Dead!");
        }
    }

    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }

    public int getMaxWeight(){
        return maxWeight;
    }

    public EatOutcome eat(String shortName){

        Item item = searchItemFromInventory(shortName);

        boolean fromInventory = true;

        if(item == null){
            item = searchItemFromRoom(shortName);
            fromInventory = false;
        }

        if(item == null){
            return new EatOutcome(
                    EatResult.NOT_FOUND,
                    null,
                    0
            );
        }

        if(!(item instanceof Food)){
            return new EatOutcome(
                    EatResult.NOT_FOOD,
                    item.getLongName(),
                    0
            );
        }

        Food food = (Food) item;

        healthPoints += food.getChangeHealth();

        if(fromInventory){
            inventory.remove(item);
        }else{
            removeItemFromRoom(item);
        }

        return new EatOutcome(
                EatResult.EATEN,
                food.getLongName(),
                food.getChangeHealth()
        );
    }

    public void setMaxWeight(int maxWeight){
        this.maxWeight = maxWeight;
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

    public Item searchItemFromRoom(String shortName){
        String itemHave = shortName;
        if(currentRoom.findItem(shortName) != null){
            Item item = currentRoom.findItem(shortName);
            return item;
        }
        return null;
    }

    //HeadLine : Inventory Mangement

    public Item takeItemFromInventory(String shortName){
        String itemHave = shortName;

        for (int i = 0; i < inventory.size(); i++) {
            if(itemHave.equalsIgnoreCase(inventory.get(i).getShortName())){
                Item item = inventory.get(i);
                inventory.remove(i);
                return item;
            }
        }
        return null;
    }


    //Overflødig?
    public Item searchItemFromInventory(String shortName){
        String itemHave = shortName;
        for (int i = 0; i < inventory.size(); i++) {
            if(itemHave.equalsIgnoreCase(inventory.get(i).getShortName())){
                Item item = inventory.get(i);
                return item;
            }
        }
        return null;
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

    //Headline : Move System

    //Prints the rooms around the player

    public void canMove(){
        if(currentRoom.getNorth() != null){
            if(currentRoom.getNorth().isLocked() == false){
                System.out.println("You Can Go North");
            }else if(currentRoom.getNorth().isLocked()){
                System.out.println("The Door To The North Is Locked");
            }else{
                System.out.println("You Cant Walk That Way");
            }
        }
        if(currentRoom.getEast() != null){
            if(currentRoom.getEast().isLocked() == false){
                System.out.println("You Can Go East");
            }else{
                System.out.println("The Door To The East Is Locked");
            }
        }
        if(currentRoom.getSouth() != null){
            if(currentRoom.getSouth().isLocked() == false){
                System.out.println("You Can Go South");
            }else{
                System.out.println("The Door To The South Is Locked");
            }
        }
        if(currentRoom.getWest() != null){
            if(currentRoom.getWest().isLocked() == false){
                System.out.println("You Can Go West");
            }else{
                System.out.println("The Door To The West Is Locked");
            }
        }
    }

    //Tjek igennem ift true og false returns
    public boolean move(String direction) {
        boolean isRoomLocked = false;
        Room nextRoom = null;

        if(currentRoom.isLocked()){
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