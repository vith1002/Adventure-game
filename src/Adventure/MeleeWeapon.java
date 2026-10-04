package Adventure;

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String longName, String shortName, int weight, boolean requiresLight, int damage) {
        super(longName, shortName, weight, requiresLight, damage);
    }

    @Override
    public boolean canUse(){
        return true;
    }

    @Override
    public void use(){
    }

    @Override
    public String getAttackVerb() {
        return "Swing";
    }

    @Override
    public String getUsesLeftText() {
        return "";
    }


}
