package Adventure;

public class Enemy {
    private String shortName;
    private String longName;
    private String description;
    private int health;
    private Weapon weapon;
    private Room room;

    public Enemy(Room room, String shortName, String longName, String description, int health, Weapon weapon) {
        this.room = room;
        this.shortName = shortName;
        this.longName = longName;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public void Attack(Player player){
        int damage = weapon.getDamage();

        if(player.getHealthPoints() > 0){
            player.setHealthPoints(player.getHealthPoints() - damage);
        }
    }

    public int hit(int damage){
        int healthLeft = health - damage;

        if(healthLeft <= 0){
            room.getItems().add(weapon);
            room.remove(this);
            return healthLeft;
        }else{
            return healthLeft;
        }
    }

    public String getShortName(){
        this.shortName = shortName;
    }

}
