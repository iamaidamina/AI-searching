package backend;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class FileManager {
    

   
    public static String upload(String filePath)
    {
        String data ="";
      
        try {

            Scanner fileReader = new Scanner(new File(filePath));
            while(fileReader.hasNextLine())
            {
                data += fileReader.nextLine()+" ";
            }
            fileReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
      
        return data;
    }
    
}
