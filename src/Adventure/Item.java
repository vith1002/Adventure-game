package Adventure;

public class Item {
    private String longName;
    private String shortName;
    private int weight;
    private boolean requiresLight;

    public Item(String longName, String shortName,  int weight, boolean requiresLight){
        this.longName = longName;
        this.shortName = shortName;
        this.weight = weight;
        this.requiresLight = requiresLight;
    }

    public boolean isRequiresLight(){
        return requiresLight;
    }

    public void setRequiresLight(boolean requiresLight){
        this.requiresLight = requiresLight;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String getLongName(){
        return longName;
    }

    public void setLongName(String longName){
        this.longName = longName;
    }

    public String getShortName(){
        return shortName;
    }

    public void setShortName(String shortName){
        this.shortName = shortName;
    }

}
