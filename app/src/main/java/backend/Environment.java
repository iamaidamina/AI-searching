package backend;


public class Environment {


    private Box [][] boxes;
   
    public static final Integer FREEZER =3;
    public static final Integer CELL =4;
    public static final Integer SEED =5;
    public static final Integer DRAGON_BALL =6;
   



    public Environment( Box [][] boxes)
    {
   
        this.boxes = boxes;
;
        
    }

    public void update(Position newPosition, Agent agent)
    {
    	
    	AvailableBox availableBox = (AvailableBox) boxes[newPosition.getI()][newPosition.getJ()];
    	availableBox.setTried();//NO PERMITE REPETIR CELDAS
    	
    	if(availableBox.getId() == DRAGON_BALL){removeBox(newPosition, DRAGON_BALL, agent);}
    	if(availableBox.getId() == SEED){removeBox(newPosition, SEED, agent);}
   	
    
        
        
        

    }
    
    private void removeBox(Position newPosition, Integer id, Agent agent)
    {
    	DynamicBox dynamicBox = (DynamicBox) boxes[newPosition.getI()][newPosition.getJ()];
    	
    	dynamicBox.setIsRemove();
    	switch(id)
    	{
    		case 5:
    			agent.takeSeed();
    			Printer.show("--- Seed Finded ----");
    			break;
    		case 6:
    			Printer.show("--- Dragon Ball Finded ----");
    			break;
    	
    	}
    		
    	
    }
    
    


    public Box[][] getBoxes() {
        return boxes;
    }



    

    

    
    
}
