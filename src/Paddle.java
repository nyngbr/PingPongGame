//Class for the game paddle

//importing libraries
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle{ //To display it like a rectangle

    int id;
    int yVelocity; //How fast the paddle moves up and down
    //constructor
    Paddle(){

    }

    //Methods
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    public void setYDirection(int yDirection){}  //The paddles are only going to move up and down, therefore no need to set the X direction
    public void move(){}
    public void draw(Graphics g){}
}
