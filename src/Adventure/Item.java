package Adventure;

public class Item {
    private String longName;
    private String shortName;
    private int weight;

    public Item(String longName, String shortName,  int weight){
        this.longName = longName;
        this.shortName = shortName;
        this.weight = weight;
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
