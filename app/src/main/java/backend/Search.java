package backend;

public class Search implements ISearch{

    //private ArrayList<Coordenate> path;
    private Environment environment;
    private Agent agent;

    public Search(Environment environment, Agent agent)
    {
        this.agent = agent;
        this.environment =environment;
        //path = new ArrayList<>();

    }
    private void doMove(Position agentPosition, Position newPosition)
    {
      
         
                    environment.update(newPosition);
                     
                    environment.markPath(agentPosition);


    }

    @Override
    public void traverse() {
    
        Position agentPosition = Locate.get(environment.getBoard(),5);
        Position leftPosition = null;
        Position rigthPosition = null;
        Position upPosition = null;
        Position downPosition = null;
        Boolean thereAreValidMovements = true;
        Boolean isSolved = Validate.isSolved(environment.getBoard(), 4); 
        Integer counter = 1;

      
        while(!isSolved && thereAreValidMovements)
        {
            Printer.show("Iteración: "+ counter);

            Printer.show("Posicion inicial Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
            leftPosition = agent.propuseMove(agentPosition, new Position(0, -1));//left
            rigthPosition = agent.propuseMove(agentPosition, new Position(0, 1));//right
            upPosition = agent.propuseMove(agentPosition, new Position(-1, 0));//up
            downPosition = agent.propuseMove(agentPosition, new Position(1, 0));//down
            
            if(Validate.isValidMovement(environment.getBoard(), leftPosition))
            {
                doMove(agentPosition, leftPosition);
                agentPosition= leftPosition;

            }else 
            if(Validate.isValidMovement(environment.getBoard(), rigthPosition))
            {
                doMove(agentPosition, rigthPosition);
                agentPosition= rigthPosition;

            }else
            if(Validate.isValidMovement(environment.getBoard(), upPosition))
            {
                doMove(agentPosition, upPosition);
                agentPosition= upPosition;

            }else 
            if(Validate.isValidMovement(environment.getBoard(), downPosition))
            {
                doMove(agentPosition, downPosition);
                agentPosition= downPosition;

            }else{
                
                thereAreValidMovements = false;
            }
            isSolved = Validate.isSolved(environment.getBoard(), 4);
            counter++;
            Printer.show("Posicion nueva Agente: "+agentPosition.getI()+" "+agentPosition.getJ());
        }
        if(thereAreValidMovements)
        {
            Printer.show("Success");
            Printer.show(environment.getBoard());

        }else{
            Printer.show("There are not valid movements!");
            Printer.show(environment.getBoard());

        }
            
            
            
    
           
           
            
        }
      
        
}
    

