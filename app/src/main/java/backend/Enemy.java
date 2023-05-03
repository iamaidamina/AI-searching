package backend;

public class Enemy extends Box{


    private Boolean isAvailable;
    private Integer damage;

    
    public Enemy(Integer id, String name, String color, Integer damage) {

        super(id,name,color);
        this.damage = damage;
        this.isAvailable = true;
        
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getDamage() {
        return damage;
    }

    

}
