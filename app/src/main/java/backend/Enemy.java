package backend;

public class Enemy extends Box{


    private Boolean isRemove;
    private Integer damage;

    
    public Enemy(Integer id, String name, String color, Integer damage) {

        super(id,name,color);
        this.damage = damage;
        this.isRemove = false;
        
    }

    public Boolean getIsRemove() {
        return isRemove;
    }

    public void setIsRemove() {
        this.isRemove = !this.isRemove;
    }

    public Integer getDamage() {
        return damage;
    }

    

}
