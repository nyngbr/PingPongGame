//Panel for the game

//importing libraries
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1200;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.555)); //Using a real life pong table dimensions ratio to set our panel ratio
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    //Instances declaration
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    //constructor
    GamePanel(){
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true); //to read the key stroke when press a key
        this.addKeyListener(new AL()); //AL : the inner class (Action Listener) will respond to key stroke
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start(); //to start the thread
    }

    //Methods
    public void newBall(){}
    public void newPaddles(){}
    public void paint(Graphics g){}
    public void draw(Graphics g){}
    public void move(){}
    public void checkCollision(){}
    public void run(){}

    public class AL extends KeyAdapter{     //AL short for Action Listener
        public void keyPressed(KeyEvent e){}
        public void keyReleased(KeyEvent e){}
    }
}
