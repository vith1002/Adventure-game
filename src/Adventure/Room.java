package Adventure;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private ArrayList<Item> items;
    private boolean locked;
    private ArrayList<Enemy> enemies;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description, ArrayList<Item> items, Boolean locked, ArrayList<Enemy> enemies){

        this.name = name;
        this.description = description;
        this.items = items;
        this.locked = locked;

        if(enemies != null) {
            this.enemies = enemies;
        } else {
            this.enemies = new ArrayList<>();
        }
    }

    public void addEnemy(Enemy enemy){
         enemies.add(enemy);
    }

    public void remove(Enemy enemy){
        enemies.remove(enemy);
    }

    public Enemy findEnemies(String shortName){

        for (int i = 0; i < enemies.size(); i++) {
            if(enemies.get(i).getShortName().equalsIgnoreCase(shortName)){
                return enemies.get(i);
            }
        }
        return null;
    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public Item findItem(String shortName){
        for (Item item : items){
            if(shortName.equalsIgnoreCase(item.getShortName())){
                return item;
            }
        }
        return null;
    }

    public boolean isLocked(){
        return locked;
    }

    public void setLocked(boolean locked){
        this.locked = locked;
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

