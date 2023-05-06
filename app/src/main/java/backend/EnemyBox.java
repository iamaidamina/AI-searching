package backend;

public class EnemyBox extends DynamicBox{


   
    private Integer damage;

    
    public EnemyBox(Integer id, String name, String color, Integer damage) {

        super(id,name,color);
        this.damage = damage;
        
        
    }



    public Integer getDamage() {
        return damage;
    }

    

}
