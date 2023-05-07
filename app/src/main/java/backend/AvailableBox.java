package backend;

public class AvailableBox extends Box {
	
	private Integer visitsCounter;
	
	public AvailableBox(Integer id, String name, String color) {

        super(id,name,color);
        this.visitsCounter = 0;
        
    }
	
    public void increseVisits() {
    	visitsCounter++;
    }
    
    public Integer howManyVsits() {
        return visitsCounter;
    }
   

}
