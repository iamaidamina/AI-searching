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


    
}
