package backend;


import java.util.*;

public class BFS implements ISearch{
	
	private ArrayList<Position> positions;
	private Queue<Node> queue;
	private String [] movements;
	private Environment environment;
	private Agent agent;
	
	public BFS(Environment environment, Agent agent, String []movements)
    {
        this.agent = agent;
        this.environment =environment;
        this.movements = movements;
        positions = new ArrayList<>();
        queue = new LinkedList<Node>();

    }
	
	 private void doMove(Position agentPosition, String operator, Node father)
	 {
		 Position newPosition = getNewPosition(operator, agentPosition);
		 
		 if(Validate.isValidMovement(environment.getBoxes(), newPosition, agentPosition))
		 {
			 

			 Node newNode= new  Node(environment, father,operator, father.getDeep()+1, father.getCost()+1);  
	         queue.add(newNode);
	         positions.add(newPosition);
	         //-----------------NUEVO---------------
	         Printer.show("Agent move "+ operator);
	         Printer.show("Child:  "+newPosition.getI()+" "+newPosition.getJ());
			 
		 }
		
	      
	   }
	 
	 
	 private Position getNewPosition(String operator, Position agentPosition)
	 {
		 Position position = new Position(null,null);
		 if(operator.equalsIgnoreCase("right"))
		 {
			 position = agent.propuseMove(agentPosition, new Position(0, 1));
		 }else
		 if(operator.equalsIgnoreCase("left"))
		 {
			position =  agent.propuseMove(agentPosition, new Position(0, -1));
		 }else
		if(operator.equalsIgnoreCase("up"))
		{
			position =agent.propuseMove(agentPosition, new Position(-1, 0));
		}else
		if(operator.equalsIgnoreCase("down"))
		{
			position =agent.propuseMove(agentPosition, new Position(1, 0));
		}else
		{
			Printer.show("Las opciones validas son: right, left, down, up");
		}
		 
		 return position;
	 }
	    
	 private Position reverse()
	    {
	    	 Position leftPosition = null, rigthPosition = null, upPosition = null, downPosition = null;
	    	 Boolean leftIsValid =false, rightIsValid =false, upIsValid =false, downIsValid =false;
	    	 Boolean isValid=leftIsValid ||rightIsValid || upIsValid || downIsValid;
	    	 int i= positions.size()-1;
	    	 Position agentPosition = null;
	    	 while (!isValid && i>=0) 
	         {
	    		 agentPosition = positions.get(i);
	    		 
	    		 
	    		 leftPosition = agent.propuseMove(agentPosition, new Position(0, -1));//left
	             rigthPosition = agent.propuseMove(agentPosition, new Position(0, 1));//right
	             upPosition = agent.propuseMove(agentPosition, new Position(-1, 0));//up
	             downPosition = agent.propuseMove(agentPosition, new Position(1, 0));//down
	             
	             leftIsValid =Validate.isValidMovement(environment.getBoxes(), leftPosition, agentPosition);
	             rightIsValid =Validate.isValidMovement(environment.getBoxes(), rigthPosition, agentPosition);
	             upIsValid =Validate.isValidMovement(environment.getBoxes(), upPosition, agentPosition);		
	             downIsValid =Validate.isValidMovement(environment.getBoxes(), downPosition, agentPosition);
	             isValid=leftIsValid ||rightIsValid || upIsValid || downIsValid;
	             i--;
	             
	         }
	    	return agentPosition;
	    }
	    
	    private void showFinalResult(Boolean thereAreValidMovements)
	    {
	    	 if(thereAreValidMovements)
	         {
	             Printer.show("Success");
	             Printer.show(environment.getBoxes());
	            
	         }else{
	             Printer.show("There are not valid movements!");
	             Printer.show(environment.getBoxes());
	           

	         }
	    }
	    

	@Override
	public void traverse() {
		 Position agentPosition = Locate.getPosition(environment.getBoxes(),2);//Borrar

		 
		 Node father = new  Node(environment, null,null,0, 0);
		 queue.add(father);//Nuevo
		 positions.add(agentPosition);
		 
	        
	        Boolean thereAreValidMovements = true;

	        Integer counter = 1;

	  
	        while(!Validate.isSolved(environment.getBoxes(), 6))
	        {
	        	
	            Printer.show("******** Iteración: "+ counter+" ************");

	            Printer.show("Father: "+agentPosition.getI()+" "+agentPosition.getJ());
	            
	            if(agent.getAmountCollectedSeeds()>0 && environment.getBoxes()[agentPosition.getI()][agentPosition.getJ()].getId() == Environment.CELL)
	            {
	            	father.setCost(father.getCost()+6);
	            }
	            if(agent.getAmountCollectedSeeds()>0 && environment.getBoxes()[agentPosition.getI()][agentPosition.getJ()].getId() == Environment.FREEZER)
	            {
	            		father.setCost(father.getCost()+3);
	            }
	          
	            
	            environment.update(agentPosition, agent);
	            
	            
	            for(int i=0; i<movements.length;i++)
	            {
	            	String movement = movements[i];
	            	doMove(agentPosition, movement ,father);
	            	
	            }
	           
	            
	         /*
	            if(thereAreValidMovements)
	            {
	            	 path.add(agentPosition);
		                agentPosition =reverse();
		                //thereAreValidMovements = false;
		                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
	            	
	            }
	            
	         */
	            Printer.show("Antes de borrar");
	            Printer.show(queue);
	           queue.remove();
	           Printer.show("Despues de borrar");
	           Printer.show(queue);
	           father =  queue.element();
	           positions.remove(0);
	           agentPosition = positions.get(0);
	            counter++;
	            
	        }
	        //path.add(agentPosition);
	        showFinalResult(thereAreValidMovements);
	        
		
	}
	
	

}
