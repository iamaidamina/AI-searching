package backend;

public class Convert{

    private static Integer [][] stringToInt2DArray(String sourceStr)
    {
         
        String  stringArray[] = sourceStr.split(" ");
        Integer size = (int) Math.sqrt(stringArray.length);
        Integer int2DArray[][] = new Integer [size][size];
        int row=0, colum=0; 
        
        for (int i = 0; i < stringArray.length; i++) {
        	
            int2DArray[row][colum] = Integer.parseInt(stringArray[i]);
            
           if((i+1)%size ==0){ row++; colum =0;
           }else{ colum++;}
           
        }


        return int2DArray;

    }

    public static Box [][] stringToBox2DArray(String sourceStr)
    {
        Integer[][] int2DArray = stringToInt2DArray(sourceStr);

        Box box2DArray[][] = new Box [int2DArray.length][int2DArray[0].length]; 
      
        for (int i = 0; i < int2DArray.length; i++) {

            for (int j = 0; j < int2DArray[0].length; j++) {

                if(int2DArray[i][j] == 1)
                {
                	 box2DArray[i][j]  = Generate.box(int2DArray[i][j]);
                }
            	else
            	if(int2DArray[i][j] == 3 || int2DArray[i][j] == 4 ){
            		
                    box2DArray[i][j]  = Generate.enemyBox(int2DArray[i][j]);

                }else
                if(int2DArray[i][j] == 0 || int2DArray[i][j] == 2 ){
                    box2DArray[i][j] = Generate.availableBox(int2DArray[i][j]);
                }else
                {
                	box2DArray[i][j] = Generate.dynamicBox(int2DArray[i][j]);
                }
                
            
           
            }
            
           
        }


        return box2DArray;

    }


}