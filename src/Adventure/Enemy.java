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

        player.getEquipped().getDamage();
    }

    public int hit(int damage){
        int healthLeft = health - damage;

        if(healthLeft > 0){
            room.remove();
        }else{
            System.out.println("Enemy have " + healthLeft + " HitPoints left");
        }
        return healthLeft;
    }

}
