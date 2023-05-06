package backend;

public class DynamicBox extends AvailableBox {

	 private Boolean isRemove;
	 
	public DynamicBox(Integer id, String name, String color) {
		super(id, name, color);
		this.isRemove = false;
		
	}
	
    public Boolean getIsRemove() {
        return isRemove;
    }

    public void setIsRemove() {
        this.isRemove = !this.isRemove;
    }

}
