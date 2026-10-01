package Adventure;

public class EatOutcome {
    private final EatResult result;
    private final String itemName;   // tingens lange navn (null hvis den ikke blev fundet)
    private final int healthChange;  // 0 hvis intet blev spist

    public EatOutcome(EatResult result, String itemName, int healthChange) {
        this.result = result;
        this.itemName = itemName;
        this.healthChange = healthChange;
    }

    public String getItemName() {
        return itemName;
    }

    public int getHealthChange() {
        return healthChange;
    }

    public EatResult getResult(){
        return result;
    }

    // getResult(), getItemName() og getHealthChange()
}