package backend;

public class Validate {

    private static Boolean isValidBoundary(Integer[][] board, Position newPosition){
      
        
        return (newPosition.getI()>=0 && newPosition.getI()<=board.length-1) &&
        (newPosition.getJ()>=0 && newPosition.getJ()<=board[0].length-1);
      
    }
    
    
    private static Boolean isValidBoundary(Box[][] boxes, Position newPosition){
      
        
        return (newPosition.getI()>=0 && newPosition.getI()<=boxes.length-1) &&
        (newPosition.getJ()>=0 && newPosition.getJ()<=boxes[0].length-1);
      
    }

    private static Boolean isValidBox(Integer[][] board, Position newPosition, Integer invalid){
      
        Boolean result= false;
        try {
            result = (board[newPosition.getI()][newPosition.getJ()] != invalid);
        } catch (Exception e) {
            Printer.show("isValidBox: Index out of bound");
        }
     
        return result;

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
    
    private static Boolean isAvailableBox(Box[][] boxes, Position newPosition){
        
        Boolean result= null;
        try {
        	AvailableBox availableBox = 
        			(AvailableBox) boxes[newPosition.getI()][newPosition.getJ()];
            result = !availableBox.getIsTried();
        } catch (Exception e) {
            Printer.show("isInvalidValidBox: Index out of bound");
        }
     
        return result;

    }

    public static Boolean isValidMovement(Integer[][] board, Position newPosition)
    {
        Boolean isValidBoundary = (Validate.isValidBoundary(board, newPosition));
        Boolean isValidBox=false;
        if(isValidBoundary)
        {
            isValidBox = (Validate.isValidBox(board, newPosition, 1)
            && Validate.isValidBox(board, newPosition, 10)
            && Validate.isValidBox(board, newPosition, 11));

        }
        

        return isValidBoundary && isValidBox;
        

    }
    
    
    public static Boolean isValidMovement(Box[][] boxes, Position newPosition)
    {
        Boolean isValidBoundary = (Validate.isValidBoundary(boxes, newPosition));
        Boolean isValidBox=false;
        if(isValidBoundary)
        {
            isValidBox = (Validate.isValidBox(boxes, newPosition, 1)//Wall
            && Validate.isAvailableBox(boxes, newPosition)//tried
            && Validate.isValidBox(boxes, newPosition, 2));//start

        }
        

        return isValidBoundary && isValidBox;
        

    }
    
    public static Boolean isSolved(Integer[][] board, Integer id)
    {
        return (Locate.getAmountElement(board,id) == 0);
    }
    
    public static Boolean isSolved(Box[][] boxes, Integer id)
    {
        return (Locate.getAmountElement(boxes,id) == 0);
    }
    
}
