package Adventure;

public class Weapon extends Item{

    private int damage;

    public Weapon(String longName, String shortName, int weight, boolean requiresLight, int damage) {
        super(longName, shortName, weight, requiresLight);
        this.damage = damage;
    }
}
