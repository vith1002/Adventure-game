package Adventure;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private ArrayList<Item> items;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description, ArrayList<Item> items){
        this.name = name;
        this.description = description;
        this.items = items;
    }

    public Item findItem(String shortName){
        for (Item item : items){
            if(shortName.equalsIgnoreCase(item.getShortName())){
                return item;
            }
        }
        return null;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void setNorth(Room north){
        this.north = north;
    }

    public Room getNorth() {
        return north;
    }

    public void setEast(Room east){
        this.east = east;
    }

    public Room getEast() {
        return east;
    }
    public void setSouth(Room south){
        this.south = south;
    }

    public Room getSouth() {
        return south;
    }
    public void setWest(Room west){
        this.west = west;
    }

    public Room getWest() {
        return west;
    }


}

