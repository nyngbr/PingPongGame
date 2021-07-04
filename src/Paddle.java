//Class for the game paddle

//importing libraries
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle{ //To display it like a rectangle

    int id;
    int yVelocity; //How fast the paddle moves up and down
    int speed = 10;
    //constructor
    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT); // using super to assign default values to our parameters
        this.id = id;

    }

    //Methods
    public void keyPressed(KeyEvent e){
        switch (id){
            case 1:
                if (e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e){
        switch (id){
            case 1:
                if (e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    public void setYDirection(int yDirection){  //The paddles are only going to move up and down, therefore no need to set the X direction
        yVelocity = yDirection;
    }
    public void move(){
        y = y + yVelocity;
    }
    public void draw(Graphics g){
        //setting colors for the players
        if (id == 1)
            g.setColor(Color.black);
        else                            //id values are either 1 or 2, so no need for an other if statement
            g.setColor(Color.white);

        g.fillRect(x,y,width,height); //fills the rectangles that represents the players
    }
}
