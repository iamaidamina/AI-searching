package backend;

public class Agent {

    public Integer id;
    private String name;

    public Agent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Position propuseMove(Position position, Position direction)
    {
         
        return new Position(
            (position.getI() + direction.getI()),
            (position.getJ() + direction.getJ()) );
    }
    
}
