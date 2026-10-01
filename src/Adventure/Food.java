package Adventure;

public class Food extends Item{

    private int changeHealth;

    public Food(String longName, String shortName, int weight, int changeHealth, boolean flashLightOn) {
        super(longName, shortName, weight, flashLightOn);
        this.changeHealth = changeHealth;
    }

    public int getChangeHealth(){
        return changeHealth;
    }

    public void setChangeHealth(int changeHealth){
        this.changeHealth = changeHealth;
    }
}
