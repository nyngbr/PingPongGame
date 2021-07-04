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
    public void newBall(){
        random = new Random();
        ball = new Ball((GAME_WIDTH/2) - (BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT - BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }


    public void newPaddles(){
        paddle1 = new Paddle(0,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle1 = new Paddle(GAME_WIDTH - PADDLE_WIDTH,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }


    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight()); //getWidth and getHeight to retrieve the dimensions of our panel
        graphics = image.getGraphics();
        draw(graphics); //calling the draw() to draw all the components
        g.drawImage(image,0,0,this);
    }


    public void draw(Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
    }


    public void move(){
        //to make them move smother
        paddle1.move();
        paddle2.move();
        ball.move();
    }


    public void checkCollision(){
        //stops paddles at window edges
        if (paddle1.y <= 0)
            paddle1.y = 0;
        if (paddle1.y <= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if (paddle2.y <= 0)
            paddle2.y = 0;
        if (paddle2.y <= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;


        //bounce the ball off top & bottom edges
        if (ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }
    }


    public void run(){
        //Game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        //noinspection InfiniteLoopStatement
        while (true){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;

            if (delta >=1 ){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }


    public class AL extends KeyAdapter{     //AL short for Action Listener
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
