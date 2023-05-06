package backend;

public class AvailableBox extends Box {
	
	private Boolean isTried;
	
	public AvailableBox(Integer id, String name, String color) {

        super(id,name,color);
        this.isTried = false;
        
    }
	
    public void setTried() {
        this.isTried = !isTried;
    }
    
    public Boolean getIsTried() {
        return isTried;
    }
   

}
