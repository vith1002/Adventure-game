package Adventure;

public class RangedWeapon extends Weapon{
    private int ammunition;

    public RangedWeapon(String longName, String shortName, int weight, boolean requiresLight, int damage, int ammunition) {
        super(longName, shortName, weight, requiresLight, damage);
        this.ammunition = ammunition;
    }

    public int getAmmunition(){
        return ammunition;
    }

    @Override
    public boolean canUse(){
        return ammunition > 0;
    }

    @Override
    public void use(){
        ammunition--;
    }

    @Override
    public String getAttackVerb() {
        return "Fire";
    }

    @Override
    public String getUsesLeftText() {
        return "You have " + ammunition + " ammo left";
    }
}
