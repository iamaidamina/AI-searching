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
    
        //Position agentPosition = Locate.getPosition(environment.getBoard(),5);//Anterior
        Position agentPosition = Locate.getPosition(environment.getBoxes(),2);//Nuevo
        
        Position leftPosition = null, rigthPosition = null, upPosition = null, downPosition = null;
        Boolean thereAreValidMovements = true;
        //Boolean isSolved = Validate.isSolved(environment.getBoard(), 6);//Anterior
        Boolean isSolved = Validate.isSolved(environment.getBoxes(), 6); //Nuevo
        Integer counter = 1;

      
        while(!isSolved && thereAreValidMovements)
        {
        	path.add(agentPosition);
            Printer.show("Iteración: "+ counter);

            Printer.show("Posicion inicial Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
            leftPosition = agent.propuseMove(agentPosition, new Position(0, -1));//left
            rigthPosition = agent.propuseMove(agentPosition, new Position(0, 1));//right
            upPosition = agent.propuseMove(agentPosition, new Position(-1, 0));//up
            downPosition = agent.propuseMove(agentPosition, new Position(1, 0));//down
            
            Position oldPosition = path.get(path.size()-1);
          
            if(Validate.isValidMovement(environment.getBoxes(), leftPosition, agentPosition, oldPosition))
            {
            	
                doMove(agentPosition, leftPosition, agent);
                agentPosition= leftPosition;
                Printer.show("Agent move left");

            }else 
         
            if(Validate.isValidMovement(environment.getBoxes(), rigthPosition, agentPosition, oldPosition))
            {
                doMove(agentPosition, rigthPosition, agent);
                agentPosition= rigthPosition;
                Printer.show("Agent move rigth");

            }else
            if(Validate.isValidMovement(environment.getBoxes(), upPosition, agentPosition, oldPosition))
            {//;
                doMove(agentPosition, upPosition, agent);
                agentPosition= upPosition;
                Printer.show("Agent move up");

            }else 
            if(Validate.isValidMovement(environment.getBoxes(), downPosition, agentPosition, oldPosition))
            {
                doMove(agentPosition, downPosition, agent);
                agentPosition= downPosition;
                Printer.show("Agent move down");

            }else{
                
                thereAreValidMovements = false;
            }
           
            isSolved = Validate.isSolved(environment.getBoxes(), 6);
            counter++;
            Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
        }
        
        showFinalResult(thereAreValidMovements);
        Printer.show(path);
            
            
            
    
           
           
            
        }
      
        
}
    

