package backend;


import java.util.*;

public class BFS implements ISearch{
	private ArrayList<Position> path;
	private Queue<Node> queue;
	private Environment environment;
	private Agent agent;
	
	public BFS(Environment environment, Agent agent)
    {
        this.agent = agent;
        this.environment =environment;
        path = new ArrayList<>();
        queue = new LinkedList<Node>();

    }
	
	 private void doMove(Position agentPosition, String operator, Node father)
	 {
		 Position newPosition = getNewPosition(operator, agentPosition);
		 
		 if(Validate.isValidMovement(environment.getBoxes(), newPosition, agentPosition))
		 {
			 
			 
			 
			 environment.update(newPosition, agent);
	        // path.add(agentPosition);
			 
			 agentPosition= newPosition;
	         //-----------------NUEVO--------------------
			 Printer.show("HOLA"+operator+father.getDeep()+1+father.getCost()+1);
			 Node newNode= new  Node(environment, father,operator, father.getDeep()+1, father.getCost()+1);  
	         queue.add(newNode);
	         father = newNode;
	         //-----------------NUEVO---------------
	         Printer.show("Agent move "+ operator);
	         Printer.show("Child:  "+agentPosition.getI()+" "+agentPosition.getJ());
			 
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
	    	 int i= path.size()-1;
	    	 Position agentPosition = null;
	    	 while (!isValid && i>=0) 
	         {
	    		 agentPosition = path.get(i);
	    		 
	    		 
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
		 
	        
	        Boolean thereAreValidMovements = true;

	        Integer counter = 1;

	      //!Validate.isSolved(environment.getBoxes(), 6) && thereAreValidMovements
	        while(counter <=1)
	        {
	        	
	            Printer.show("Iteración: "+ counter);

	            Printer.show("Father: "+agentPosition.getI()+" "+agentPosition.getJ());
	            //leftPosition = agent.propuseMove(agentPosition, new Position(0, -1));//left
	           // rigthPosition = agent.propuseMove(agentPosition, new Position(0, 1));//right
	            //upPosition = agent.propuseMove(agentPosition, new Position(-1, 0));//up
	            //downPosition = agent.propuseMove(agentPosition, new Position(1, 0));//down
	            

	            
	            doMove(agentPosition, "right" ,father);
	            /*
	            if(Validate.isValidMovement(environment.getBoxes(), rigthPosition, agentPosition))
	            {
	            	doMove(agentPosition, rigthPosition, father);
	            	
	            	
	                doMove(agentPosition, rigthPosition, agent);
	                agentPosition= rigthPosition;
	                //-----------------NUEVO--------------------
	                rigthNode= new  Node(environment, father,"rigth", father.getDeep()+1, father.getCost()+1);  
	                queue.add(rigthNode);
	                father = rigthNode;
	                //-----------------NUEVO---------------
	                Printer.show("Agent move rigth");
	                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
					
	            }
	            */
	            doMove(agentPosition, "up" ,father);
	            /*
	            if(Validate.isValidMovement(environment.getBoxes(), upPosition, agentPosition))
	            {
	                doMove(agentPosition, upPosition, agent);
	                agentPosition= upPosition;
	                //-----------------NUEVO--------------------
	                upNode= new  Node(environment, father,"up" ,father.getDeep()+1, father.getCost()+1);  
	                queue.add(upNode);
	                father = upNode;
	                //-----------------NUEVO---------------
	                Printer.show("Agent move up");
	                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());

	            }
	            */
	            
	            doMove(agentPosition, "down" ,father);
	            /*
	            if(Validate.isValidMovement(environment.getBoxes(), downPosition, agentPosition))
	            {
	                doMove(agentPosition, downPosition, agent);
	                agentPosition= downPosition;
	              //-----------------NUEVO--------------------
	                downNode= new  Node(environment, father,"down" ,father.getDeep()+1, father.getCost()+1);  
	                queue.add(downNode);
	                father = downNode;
	                //-----------------NUEVO---------------
	                Printer.show("Agent move down");
	                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());

	            }
	            */
	            doMove(agentPosition, "left" ,father);
	            /*
	            if(Validate.isValidMovement(environment.getBoxes(), leftPosition, agentPosition))
	            {
	            	
	                doMove(agentPosition, leftPosition, agent);
	                agentPosition= leftPosition;
	              //-----------------NUEVO--------------------
	                leftNode= new  Node(environment, father,"left",father.getDeep()+1, father.getCost()+1);  
	                queue.add(leftNode);
	                father = leftNode;
	                //-----------------NUEVO---------------
	                Printer.show("Agent move left");
	                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());

	            }
	             */ 
	            
	         /*
	            if(thereAreValidMovements)
	            {
	            	 path.add(agentPosition);
		                agentPosition =reverse();
		                //thereAreValidMovements = false;
		                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
	            	
	            }
	            
	         */
	            counter++;
	            
	        }
	        //path.add(agentPosition);
	        showFinalResult(thereAreValidMovements);
	        Printer.show(queue);
		
	}
	
	

}
