package backend;


import java.util.*;

public class BFS implements ISearch{
	
	private ArrayList<Position> positions;
	private ArrayList<Position> path;
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
        path = new ArrayList<>();
        queue = new LinkedList<Node>();

    }
	
	 private void doMove(Position agentPosition, String operator, Node father)
	 {
		 Position newPosition = getNewPosition(operator, agentPosition);
		 
		 if(Validate.isValidMovement(environment.getBoxes(), newPosition, agentPosition))
		 {
			 
			 
			 
			 

			 Node newNode= new  Node(environment, father,operator, father.getDeep()+1, father.getCost()+1);  
	         if(!Validate.isCreated(positions, newPosition)) {
	        	 
	        	 queue.add(newNode);
	        	 positions.add(newPosition);
	        	//-----------------NUEVO---------------
		         Printer.show("Agent move "+ operator);
		         Printer.show("Child:  "+newPosition.getI()+" "+newPosition.getJ());
	        	 
	         };
	        
	         
			 
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
	 
	 
	 private Position getNewReversePosition(String operator, Position agentPosition)
	 {
		 Position position = new Position(null,null);
		 if(operator.equalsIgnoreCase("right"))
		 {
			 position =  agent.propuseMove(agentPosition, new Position(0, -1));
		 }else
		 if(operator.equalsIgnoreCase("left"))
		 {
			 position = agent.propuseMove(agentPosition, new Position(0, 1));
		 }else
		if(operator.equalsIgnoreCase("up"))
		{
			position =agent.propuseMove(agentPosition, new Position(1, 0));
			
		}else
		if(operator.equalsIgnoreCase("down"))
		{
			System.out.println("DOWN");
			position =agent.propuseMove(agentPosition, new Position(-1, 0));
		}else
		{
			Printer.show("Las opciones validas son: right, left, down, up");
		}
		 
		 return position;
	 }
	 
	 private void  updateNodeCostIfFindEnemy(Node father, Position agentPosition)
	 {
		 
		    if(agent.getAmountCollectedSeeds()>0 && environment.getBoxes()[agentPosition.getI()][agentPosition.getJ()].getId() == Environment.CELL)
            {
            	father.setCost(father.getCost()+6);
            }
            if(agent.getAmountCollectedSeeds()>0 && environment.getBoxes()[agentPosition.getI()][agentPosition.getJ()].getId() == Environment.FREEZER)
            {
            		father.setCost(father.getCost()+3);
            }
          
		 
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

	        //!Validate.isSolved(environment.getBoxes(), Environment.DRAGON_BALL)
	        while(!Validate.isSolved(environment.getBoxes(), Environment.DRAGON_BALL))
	        {
	        	
	            Printer.show("******** Iteración: "+ counter+" ************");

	            Printer.show("Father: "+agentPosition.getI()+" "+agentPosition.getJ());
	            path.add(agentPosition);
	        
	            updateNodeCostIfFindEnemy(father, agentPosition);
	            environment.update(agentPosition, agent);
	            
	           
	            	for(int i=0; i<movements.length;i++)
	 	            {
	 	            	String movement = movements[i];
	 	            	doMove(agentPosition, movement ,father);
	 	            	
	 	            }
	            	
	           
	            if(!Validate.isSolved(environment.getBoxes(), Environment.DRAGON_BALL))
	            {
	            		   		Printer.show(queue);
	            		   		Printer.show(positions);
	         	 	           queue.remove();
	         	 	           father =  queue.element();
	         	 	           positions.remove(0);
	         	 	           agentPosition = positions.get(0);
	         	 	            counter++;
	            		
	            }else
	            {
	            	 Printer.show(queue);
        	          Printer.show(positions);
        	          father =  queue.element();
        	          agentPosition = positions.get(0);
  	 	            	counter++;
        	 	        
	            	
	            }
	       
	            	
	          
	            
	        }
	        //path.add(agentPosition);
	        showFinalResult(thereAreValidMovements);
	        Printer.show(queue);
	        Printer.show(positions);
	        Printer.show("FINAL");
	        Printer.show(path);
	        
	        
	}
	
	
	
	public void getPath(Box [][] boxes)
	{
		
	
		Node node = queue.element();
		String operator = node.getOperator();
		Position agentPosition = positions.get(0);
		//path.add(agentPosition);
		environment.setBoxes(boxes);
		while(!Objects.equals(operator, null))
		{
			Printer.show(boxes);
			
			try {
				node = node.getFather();
				operator = node.getOperator();
				Position newPosition = getNewReversePosition(operator, agentPosition);
				System.out.println(agentPosition.getI() +" "+ agentPosition.getJ());
				if(Validate.isValidMovement(environment.getBoxes(), newPosition, agentPosition))
				 {
				//Re-interpretación: de las instrucciones left, right, down,up y hacer validación
					path.add(agentPosition);
					
				 }
				agentPosition = newPosition;
				
			}catch(Exception e)
			{
				
			}
			
			
		}
		Printer.show(path);
	}
	

	
	

}
