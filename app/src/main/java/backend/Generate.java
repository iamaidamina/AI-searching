package backend;

public class Generate {


    public static AvailableBox availableBox(Integer id)
    {
       
        String name = null, color= null;

        switch(id)
        {
            case 0:
                name = "Free";
                color = "#F8F9F9";
                break;
            case 2:
                name =  "Start";
                color = "#2E86C1";
                break;

        }

        return new AvailableBox(id,name,color);
        
    }
    
    
    public static DynamicBox dynamicBox(Integer id)
    {
       
        String name = null, color= null;

        switch(id)
        {
            case 5:
                name =  "Seed";
                color = "#808000";
                break;
            case 6:
                 name =  "Dragon Ball";
                color = "#C0392B";
                break;

        }
        
        return new DynamicBox(id,name,color);
    }
    
    public static Box box(Integer id)
    {
       
        String name = null, color= null;

        switch(id)
        {
         
            case 1:
                name =  "Wall";
                color = "#E67E22";
                break;
            

        }

        return new Box(id,name,color);
        
    }

    public static EnemyBox enemyBox(Integer id)
    {
        String name = null, color = null;  Integer damage = null; 

        switch(id)
        {
            case 3:
                name = "Freezer";
                color = "#8E44AD";
                damage = 3;
                break; 
            case 4:
                name = "Cell";
                color = "#566573";
                damage = 6;
                break; 
  

        }

        return new EnemyBox(id,name,color,damage) ;
        
    }
    
}
