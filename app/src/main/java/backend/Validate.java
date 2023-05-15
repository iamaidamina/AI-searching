package backend;

public class Validate {


    
    
    private static Boolean isValidBoundary(Box[][] boxes, Position newPosition){
      
        
        return (newPosition.getI()>=0 && newPosition.getI()<=boxes.length-1) &&
        (newPosition.getJ()>=0 && newPosition.getJ()<=boxes[0].length-1);
      
    }


    
    private static Boolean isValidBox(Box[][] boxes, Position newPosition, Integer invalid){
        
        Boolean result= false;
        try {
            result = (boxes[newPosition.getI()][newPosition.getJ()].getId() != invalid);
        } catch (Exception e) {
            Printer.show("isInvalidValidBox: Index out of bound");
        }
     
        return result;

    }
    
    private static Boolean isAvailableBox(Box[][] boxes, Position newPosition, Position actualPosition){
        
        Boolean result= null;
        try {
        	AvailableBox availableBox = 
        			(AvailableBox) boxes[newPosition.getI()][newPosition.getJ()];
            result = (availableBox.howManyVsits()<1);
        } catch (Exception e) {
            Printer.show("isInvalidValidBox: Index out of bound");
        }
     
        return result;

    }


    
    
    public static Boolean isValidMovement(Box[][] boxes, Position newPosition, Position actualPosition)
    {
        Boolean isValidBoundary = (Validate.isValidBoundary(boxes, newPosition));
        Boolean isValidBox=false;
        if(isValidBoundary)
        {
            isValidBox = (Validate.isValidBox(boxes, newPosition, 1)//Wall
            && Validate.isAvailableBox(boxes, newPosition,actualPosition)//tried
            && Validate.isValidBox(boxes, newPosition, 2));//start

        }
        

        return isValidBoundary && isValidBox;
        

    }
    

    public static Boolean isSolved(Box[][] boxes, Integer id)
    {
    	//Printer.show("Amout Balls: "+ Locate.getAmountElement(boxes,id));
    	
        return (Locate.getAmountElement(boxes,id) == 0);
    }
    
}
