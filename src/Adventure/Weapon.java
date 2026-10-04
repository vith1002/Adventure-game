package Adventure;

public abstract class Weapon extends Item{

    private int damage;

    public Weapon(String longName, String shortName, int weight, boolean requiresLight, int damage) {
        super(longName, shortName, weight, requiresLight);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public abstract boolean canUse();

    public abstract void use();

    public abstract String getAttackVerb();

    public abstract String getUsesLeftText();

}