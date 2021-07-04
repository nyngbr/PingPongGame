//Class to define the game frame

//importing libraries
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends JFrame{
    //constructor
    GamePanel panel;
    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game    ||    nyngbr");
        this.setResizable(false); //prevents the player from resizing the frame
        this.setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the app when you hit the "x" button
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);//To display the frame in the middle of the screen
    }
}
