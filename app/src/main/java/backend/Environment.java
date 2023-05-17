package backend;


public class Environment {


    private Box [][] boxes;
   
    public static final Integer FREE =0;
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
    	availableBox.increseVisits();//NO PERMITE REPETIR CELDAS
    	
    	if(availableBox.getId() == DRAGON_BALL){removeDynamicBox(newPosition, DRAGON_BALL, agent);}
    	if(availableBox.getId() == SEED){removeDynamicBox(newPosition, SEED, agent);}
    	if(availableBox.getId() == CELL){removeEnemyBox(newPosition, CELL, agent);}
    	if(availableBox.getId() == FREEZER){removeEnemyBox(newPosition, FREEZER, agent);}
    
        
        
        

    }
    
    private void removeDynamicBox(Position newPosition, Integer id, Agent agent)
    {
    	
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
    	boxes[newPosition.getI()][newPosition.getJ()]= Generate.availableBox(FREE);
    	AvailableBox availableBox = (AvailableBox)boxes[newPosition.getI()][newPosition.getJ()];
    	availableBox.increseVisits();
 
    		
    	
    }
    
    private void removeEnemyBox(Position newPosition, Integer id, Agent agent)
    {
    	EnemyBox enemyBox = (EnemyBox) boxes[newPosition.getI()][newPosition.getJ()];
    	
    	
    	switch(id)
    	{
    		case 3:
    			
    			Printer.show("--- Freezer Finded ----");
    			break;
    		case 4:
    			Printer.show("--- Cell Finded ----");
    			break;
    	
    	}
    	if(agent.getAmountCollectedSeeds()>0)
    	{
    		boxes[newPosition.getI()][newPosition.getJ()]= Generate.availableBox(FREE);
        	AvailableBox availableBox = (AvailableBox)boxes[newPosition.getI()][newPosition.getJ()];
        	availableBox.increseVisits();
        	agent.loseSeed();
    		
    	}
    }
    

    public Box[][] setBoxes(Box[][] boxes) {
        return this.boxes = boxes;
    }
    
    public Box[][] getBoxes() {
        return boxes;
    }



    

    

    
    
}
