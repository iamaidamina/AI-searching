package backend;

public class Box {

    private Integer id;
    private String name;
    private String color;
    private Boolean isTried;

    public Box(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.isTried = false;
    }
    
    public void setTried() {
        this.isTried = !isTried;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
   
    public String getColor() {
        return color;
    }
    
    public Boolean getIsTried() {
        return isTried;
    }
   
    

}
