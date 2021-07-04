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
    int initialSpeed = 2;
    //constructor
    Ball(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
        int randomXDirection = random.nextInt(2);

        if (randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection * initialSpeed);

        int randomYDirection = random.nextInt(2);

        if (randomYDirection == 0)
            randomXDirection--;
        setXDirection(randomYDirection * initialSpeed);
    }

    //Methods
    //The ball will move up and down, therefore we'll need two methods, one for x-positions the other one for y-positions
    //Once the ball is created it is going to appear at a random x and y position, will set an Action Listener to take care of it
    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }
    public void move(){
        x += xVelocity;
        y += yVelocity;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,height,width);
    }
}
