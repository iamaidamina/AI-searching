package backend;

public class DynamicBox extends Box {
	
	private Boolean isTried;
	
	public DynamicBox(Integer id, String name, String color) {

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
