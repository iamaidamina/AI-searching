package backend;

public class Agent {

  
    private String name;
    private Integer amountCollectedSeeds;
    


    public Agent(String name) {
       
        this.name = name;
        amountCollectedSeeds =0;
    }
    

    public String getName() {
        return name;
    }
    
    public void takeSeed() {
        amountCollectedSeeds++;
    }
    
    public void loseSeed() {
    	 amountCollectedSeeds--;
    }
    
    public Integer getAmountCollectedSeeds() {
        return amountCollectedSeeds;
    }

    public Position propuseMove(Position position, Position direction)
    {
         
        return new Position(
            (position.getI() + direction.getI()),
            (position.getJ() + direction.getJ()) );
    }
    
}
