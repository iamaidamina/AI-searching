package backend;

import java.util.ArrayList;

public class Search implements ISearch{

    private ArrayList<Position> path;
    private Environment environment;
    private Agent agent;

    public Search(Environment environment, Agent agent)
    {
        this.agent = agent;
        this.environment =environment;
        path = new ArrayList<>();

    }
    
 
    
    private void doMove(Position agentPosition, Position newPosition, Agent agent)
    {
      
                 environment.update(newPosition, agent);
                 path.add(agentPosition);
                  

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
 

    @Override
    public void traverse() {
    

        Position agentPosition = Locate.getPosition(environment.getBoxes(),2);//Nuevo
        
        Position leftPosition = null, rigthPosition = null, upPosition = null, downPosition = null;
        Boolean thereAreValidMovements = true;

        Integer counter = 1;

      
        while(!Validate.isSolved(environment.getBoxes(), 6) && thereAreValidMovements)
        {
        	
            Printer.show("Iteración: "+ counter);

            Printer.show("Posicion inicial Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
            leftPosition = agent.propuseMove(agentPosition, new Position(0, -1));//left
            rigthPosition = agent.propuseMove(agentPosition, new Position(0, 1));//right
            upPosition = agent.propuseMove(agentPosition, new Position(-1, 0));//up
            downPosition = agent.propuseMove(agentPosition, new Position(1, 0));//down
            

          
            if(Validate.isValidMovement(environment.getBoxes(), leftPosition, agentPosition))
            {
            	
                doMove(agentPosition, leftPosition, agent);
                agentPosition= leftPosition;
                Printer.show("Agent move left");
                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());

            }else 
         
            if(Validate.isValidMovement(environment.getBoxes(), rigthPosition, agentPosition))
            {
                doMove(agentPosition, rigthPosition, agent);
                agentPosition= rigthPosition;
                Printer.show("Agent move rigth");
                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());

            }else
            if(Validate.isValidMovement(environment.getBoxes(), upPosition, agentPosition))
            {//;
                doMove(agentPosition, upPosition, agent);
                agentPosition= upPosition;
                Printer.show("Agent move up");
                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());

            }else 
            if(Validate.isValidMovement(environment.getBoxes(), downPosition, agentPosition))
            {
                doMove(agentPosition, downPosition, agent);
                agentPosition= downPosition;
                Printer.show("Agent move down");
                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());

            }else{

                path.add(agentPosition);
                agentPosition =reverse();
                //thereAreValidMovements = false;
                Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
            }
           
            counter++;
            
        }
        path.add(agentPosition);
        showFinalResult(thereAreValidMovements);
        Printer.show(path);
            
            
            
    
           
           
            
        }
      
        
}
    

