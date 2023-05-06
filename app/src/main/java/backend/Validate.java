package backend;

public class Validate {

    private static Boolean isValidBoundary(Integer[][] board, Position newPosition){
      
        
        return (newPosition.getI()>=0 && newPosition.getI()<=board.length-1) &&
        (newPosition.getJ()>=0 && newPosition.getJ()<=board[0].length-1);
      
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

    public static Boolean isSolved(Integer[][] board, Integer id)
    {
        return (Locate.getAmountElement(board,id) == 0);
    }
    
}
