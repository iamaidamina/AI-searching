package backend;


public class Printer {

    public static void show(Box[][] boxes)
    {
        for (int i = 0; i < boxes.length; i++) {

            for (int j = 0; j < boxes[0].length; j++) {

               System.out.print(boxes[i][j].getId()+ " ");
            
           
            }
            System.out.println();
           
        }
       
    }

    public static void show(Integer[][] board)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                System.out.print(board[i][j]+" ");
            
            }
            System.out.println();
        }
    }

    public static void show(String message)
    {
        
            System.out.println(message);
      
    }
    
}
