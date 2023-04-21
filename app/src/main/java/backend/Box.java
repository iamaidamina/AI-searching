package backend;

public class Box {

    private String name;
    private String id;
    private String color;
    private int cost;

    public Box(String name, String id, String color, int cost)
    {
        this.name = name;
        this.id = id;
        this.color = color;
        this.cost = cost;

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public int getCost() {
        return cost;
    }

    

    
}
