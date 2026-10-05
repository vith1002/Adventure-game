package Adventure;

import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int maxWeight = 20;
    private int healthPoints = 100;
    private Weapon equipped;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.healthPoints = healthPoints;
        this.equipped = equipped;
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
            System.out.print(" -> you are in good health, but avoid fighting right now");
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
            return new EatOutcome(EatResult.NOT_FOUND,null,0);
        }

        if(!(item instanceof Food)){
            return new EatOutcome(EatResult.NOT_FOOD,item.getLongName(),0);
        }

        Food food = (Food) item;

        healthPoints += food.getChangeHealth();

        if(fromInventory){
            inventory.remove(item);
        }else{
            removeItemFromRoom(item);
        }

        return new EatOutcome(EatResult.EATEN, food.getLongName(), food.getChangeHealth());
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

                if(inventory.get(i) instanceof Weapon && inventory.get(i) == getEquipped()){
                    setEquipped(null);
                }

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
        if(equipped != null){
            System.out.println("Equipped Weapon: " + getEquipped().getShortName());
        }
    }


    //Weaponm system

    public Weapon equip(String shortName){

        Item checkItemWeapon = searchItemFromInventory(shortName);

        if(checkItemWeapon == null){
            return null;
        }

        if(checkItemWeapon instanceof Weapon){
            Weapon weapon = (Weapon) checkItemWeapon;

            setEquipped(weapon);

            return weapon;
        }

        return null;
    }

    public Weapon getEquipped(){
        return equipped;
    }

    public void setEquipped(Weapon equipped){
        this.equipped = equipped;
    }

    public AttackResult attack() {

        if (equipped == null) {
            return AttackResult.NO_WEAPON;
        }

        if (!equipped.canUse()) {
            return AttackResult.NO_AMMO;
        }

        equipped.use();
        return AttackResult.ATTACK_SUCCES;
    }


    //if(!(item instanceof Food)){
//        return new EatOutcome(EatResult.NOT_FOOD,item.getLongName(),0);
  //  }

    //Headline : Move System

    //Prints the rooms around the player

    public void canMove(){

        System.out.println();

        if(currentRoom.getNorth() != null && !currentRoom.getNorth().isLocked()){
            System.out.println("North -> " + currentRoom.getNorth().getName());
        } else if (currentRoom.getNorth() != null && currentRoom.getNorth().isLocked()) {
            System.out.println("North -> " + currentRoom.getNorth().getName() + " is locked!");
        }
        if(currentRoom.getWest() != null && !currentRoom.getWest().isLocked()){
            System.out.println("West -> " + currentRoom.getWest().getName());
        } else if (currentRoom.getWest() != null && currentRoom.getWest().isLocked()) {
            System.out.println("West -> " + currentRoom.getWest().getName() + " is locked!");
        }
        if(currentRoom.getSouth() != null && !currentRoom.getSouth().isLocked()){
            System.out.println("South -> " + currentRoom.getSouth().getName());
        } else if (currentRoom.getSouth() != null && currentRoom.getSouth().isLocked()) {
            System.out.println("South -> " + currentRoom.getSouth().getName() + " is locked!");
        }
        if(currentRoom.getEast() != null && !currentRoom.getEast().isLocked()){
            System.out.println("East -> " + currentRoom.getEast().getName());
        } else if (currentRoom.getEast() != null && currentRoom.getEast().isLocked()) {
            System.out.println("East -> " + currentRoom.getEast().getName() + " is locked!");
        }
    }

    //Tjek igennem ift true og false returns
    public boolean move(String direction) {
        boolean isRoomLocked = false;
        Room nextRoom = null;


        switch (direction.toLowerCase()) {

            case "go north", "north", "n":
                nextRoom = currentRoom.getNorth();

                if(nextRoom == null || nextRoom.isLocked()){
                    return false;
                }

                currentRoom = nextRoom;
                return true;

            case "go south", "south", "s":
                nextRoom = currentRoom.getSouth();

                if(nextRoom == null || nextRoom.isLocked()){
                    return false;
                }

                currentRoom = nextRoom;
                return true;

            case "go east", "east", "e":
                nextRoom = currentRoom.getEast();

                if(nextRoom == null || nextRoom.isLocked()){
                    return false;
                }

                currentRoom = nextRoom;
                return true;

            case "go west", "west", "w":
                nextRoom = currentRoom.getWest();

                if(nextRoom == null || nextRoom.isLocked()){
                    return false;
                }

                currentRoom = nextRoom;
                return true;
        }
        return false;
    }
}