/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package backend;

import frontend.MainFrame;

public class App {
  
    public static void main(String[] args) {
        
        String strBoard =  FileManager.upload("app/src/main/resources/Prueba1.txt");
        StringToArrayOfStrings.convert(strBoard).toString();

           
        new MainFrame();
        
        
    }
}
