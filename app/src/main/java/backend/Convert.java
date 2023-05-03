package backend;

public class Convert{

    private static Integer [][] stringToInt2DArray(String sourceStr, int rows, int colums)
    {
        Integer int2DArray[][] = new Integer [rows][colums]; 
        String  stringArray[] = sourceStr.split(" ");

        int row=0;
        int colum =0; 
        for (int i = 0; i < stringArray.length; i++) {
            int2DArray[row][colum] = Integer.parseInt(stringArray[i]);
           if((i+1)%10 ==0)
           {
            row++;
            colum =0;
           }else{
            colum++;
           }
           
        }


        return int2DArray;

    }

    public static Box [][] stringToBox2DArray(String sourceStr, int rows, int colums)
    {
        Integer[][] int2DArray = stringToInt2DArray(sourceStr, rows, colums);

        Box box2DArray[][] = new Box [int2DArray.length][int2DArray[0].length]; 
      
        for (int i = 0; i < int2DArray.length; i++) {

            for (int j = 0; j < int2DArray[0].length; j++) {

                if(int2DArray[i][j] == 3 || int2DArray[i][j] == 4 )
                {
                    box2DArray[i][j]  = Generate.enemy(int2DArray[i][j]);

                }else{
                    box2DArray[i][j] = Generate.box(int2DArray[i][j]);
                }
                
            
           
            }
            
           
        }


        return box2DArray;

    }


}