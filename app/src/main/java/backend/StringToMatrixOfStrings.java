package backend;

public class StringToMatrixOfStrings{

    public static String [][] convert(String sourceStr, int rows, int colums)
    {
        String matrixOfStrings[][] = new String [rows][colums]; 
        String  arrayOfStrings[] = sourceStr.split(" ");

        int row=0;
        int colum =0; 
        for (int i = 0; i < arrayOfStrings.length; i++) {
           matrixOfStrings[row][colum] = arrayOfStrings[i];
           if((i+1)%10 ==0)
           {
            row++;
            colum =0;
           }else{
            colum++;
           }
           
        }


        return matrixOfStrings;

    }


}