package backend;


public class Environment {

    private Integer [][] board;
 


    public static final Integer TRIED =10;

    public static final Integer START =5;
    public static final Integer PATH =11;

    public Environment(Integer[][] board)
    {
        this.board = board;
;
        
    }

    public void update(Position newPosition)
    {
   
      
        board[newPosition.getI()][newPosition.getJ()]= TRIED;
        
        
        

    }

    public void markPath(Position coordenate)
    {
  
                board[coordenate.getI()][coordenate.getJ()]= PATH;
    
        

    }

    public Integer[][] getBoard() {
        return board;
    }



    

    

    
    
}
