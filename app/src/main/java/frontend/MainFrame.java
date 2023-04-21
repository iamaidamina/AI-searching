package frontend;
import java.awt.Dimension;

import javax.swing.*;


public class MainFrame extends JFrame{

    public MainFrame()
    {
        //Set dimension of the frame
        setSize(new Dimension(500, 300));
        //Set close when click X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Goku Smart");
        setVisible(true);
        //Maximizado hasta cubrir toda la pantalla
        //setExtendedState(Frame.MAXIMIZED_BOTH);
    }
    
}
