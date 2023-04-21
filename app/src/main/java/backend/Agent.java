package backend;

public class Agent implements IMovement{

    private String id;
    private String color;
    private String name;
 
  
    
    public Agent(String id, String color, String name)
    {
        this.id = id;
        this.color = color; 
        this.name = name;

    }

    public String getId() {
        return id;
    }


    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public void moveLeft(Environment environment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    @Override
    public void moveRight(Environment environment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    @Override
    public void moveUp(Environment environment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveUp'");
    }

    @Override
    public void moveDown(Environment environment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveDown'");
    }



    
}
