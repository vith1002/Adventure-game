package Adventure;

public class Enemy {
    private String shortName;
    private String longName;
    private String description;
    private int health;
    private Weapon weapon;
    private Room room;

    public Enemy(String shortName, String longName, String description, int health, Weapon weapon, Room room) {
        this.shortName = shortName;
        this.longName = longName;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
        this.room = room;
    }

    public boolean Attack(Player player) {

        if (!weapon.canUse()) {
            return false;
        }
        weapon.use();
        player.hit(weapon.getDamage());
        return true;
    }

    public int hit(int damage){
        setHealth(health-damage);

        if(health <= 0){
            room.getItems().add(weapon);
            room.remove(this);
            return health;
        }else{
            return health;
        }
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return health;
    }

    public String getShortName(){
        return shortName;
    }

    public Room getRoom(){
        return room;
    }

    public String getDescription(){
        return description;
    }
}
