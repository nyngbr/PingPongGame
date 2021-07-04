//Define the ball specs

//importing libraries
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle{ //To display it like a rectangle

    Random random;
    int xVelocity;
    int yVelocity;
    //constructor
    Ball(){

    }

    //Methods
    //The ball will move up and down, therefore we'll need two methods, one for x-positions the other one for y-positions
    //Once the ball is created it is going to appear at a random x and y position, will set an Action Listener to take care of it
    public void setXDirection(int randomXDirection){}
    public void setYDirection(int randomYDirection){}
    public void move(){}
    public void draw(Graphics g){}
}
