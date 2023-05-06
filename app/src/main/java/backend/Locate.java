package backend;


public class Locate {

    public static Position getPosition(Integer[][] board, Integer id )
    {
      
        int I=0,  J=0;
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
            
                if(board[i][j] == id)
                {
                     I= i; J=j;
                    
                }
            }
            
        }
        
        return new Position(I, J);
    }
    
    public static Position getPosition(Box[][] boxes, Integer id )
    {
      
        int I=0,  J=0;
        for (int i=0; i < boxes.length; i++) {
            for (int j=0; j < boxes[0].length; j++) {
            
                if(boxes[i][j].getId() == id)
                {
                     I= i; J=j;
                    
                }
            }
            
        }
        
        return new Position(I, J);
    }

    public static Integer getAmountElement(Integer[][] board, Integer element)
    {
      
        Integer counter=0;
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
            
                if(board[i][j] == element)
                {
                     counter++;
                }
            }
            
        }

        return counter;

        
    }

	public static int getAmountElement(Box[][] boxes, Integer element) {
		 Integer counter=0;
	        for (int i=0; i < boxes.length; i++) {
	            for (int j=0; j < boxes[0].length; j++) {
	            
	                if(boxes[i][j].getId() == element)
	                {
	                     counter++;
	                }
	            }
	            
	        }
	        
	        System.out.println("Amout Balls: "+counter);

	        return counter;
	}
    
}
