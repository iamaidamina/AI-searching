package backend;


public class Locate {

    public static Position get(Integer[][] board, Integer id )
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
    
}
