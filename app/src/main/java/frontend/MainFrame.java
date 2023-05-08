package frontend;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;


public class MainFrame extends JFrame{

    public MainFrame()
    {
    	
    	Toolkit screen = Toolkit.getDefaultToolkit();
    	Dimension screenSize = screen.getScreenSize();
    	int screenHeight = screenSize.height;
    	int screenWidth = screenSize.width;
        //Set dimension of the frame
        setSize(screenWidth/2, screenHeight/2);
        setLocation(screenWidth/4, screenHeight/4	);
        setTitle("Maze");
        String IconImagePath = "C:\\Users\\crist\\Downloads\\Goku-Smart\\app\\src\\main\\resources\\images\\maze.png";
        Image mazeIcon = screen.getImage(IconImagePath);
        setIconImage(mazeIcon);
        //Set close when click X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
  
        setVisible(true);

    }
    
}
