package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.lang.management.BufferPoolMXBean;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    // defined constants to be used in game
    // board height and width determine the size of the board
    // DOTS defines the maximum number of possible dots on board
    // (900 = (300*300)/(10*10))
    // random_pos calculates random position for an apple
    // delay determines speed of game

    private final int BOARD_WIDTH = 400;
    private final int BOARD_HEIGHT = 400;
    private final int DOT_SIZE = 10;
    private final int DOTS = 900;
    private final int RANDOM_POS = 29;
    private final int DELAY = 140;

    // store the x and y coordinates of all the joints of a snake
    private final int x[] = new int[DOTS];
    private final int y[] = new int[DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;

    public Board() {
        initBoard();
    }

    public void initBoard() {
        Color backgColor = new Color(94, 158, 195);

        addKeyListener(new TAdapter());
        setBackground(backgColor);
        setFocusable(true);

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        loadImages();
        initGame();
    }

    // get the images for the game. ImageIcon class is used for displaying PNG images.
    public void loadImages() {

        ImageIcon image_dot = new ImageIcon("src/Snake/images/dot.png");
        ball = image_dot.getImage();

        ImageIcon image_apple = new ImageIcon("src/Snake/images/apple.png");
        apple = image_apple.getImage();

        ImageIcon image_head = new ImageIcon("src/Snake/images/head.png");
        head = image_head.getImage();



    }

    // this method creates the snake, randomly locate an apple on the board and start timer
    private void initGame() {

        dots = 3;

        for (int i = 0; i < dots; i++) {
            x[i] = 50 - i * 10;
            y[i] = 50;
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();

    }

    // draws the images onto the canvas
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
            doDrawing(g);
        }

        private void doDrawing(Graphics g) {
            if (inGame) {
                g.drawImage(apple, apple_x, apple_y, this);

                for (int i = 0; i < dots; i++) {
                    if (i == 0) {
                        g.drawImage(head, x[i], y[i], this);

                    } else {
                        g.drawImage(ball, x[i], y[i], this);
                    }
                }
                Toolkit.getDefaultToolkit().sync();

            } else {
                gameOver(g);
        }
    }


    //
    public void gameOver(Graphics g) {
        String msg = "Game Over!";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(msg, (BOARD_WIDTH - metr.stringWidth(msg)) / 2, BOARD_HEIGHT / 2);
    }


    // if the apple collides with the head then we increase the number of joints on the snake.
    // we call the locateApple to make a new apple randomly on the board.
    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++;
            locateApple();
        }
    }

    // player controls the head of the snake
    // each of the joints on the snake move up by onw position in the chain
    // the below moves the joints up the chain
    private void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

    // this moves the head to the left etc.
        if (left) {
            x[0] -= DOT_SIZE;
        }

        if (right) {
            x[0] += DOT_SIZE;
        }

        if (up) {
            y[0] -= DOT_SIZE;
        }

        if (down) {
            y[0] += DOT_SIZE;
        }
    }

    // if the snake hits itself then game over
    // if thr snake hits the board then game over
    private void checkCollision() {
        for (int i = dots; i > 0; i--) {
            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
        }

        if (y[0] >= BOARD_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= BOARD_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RANDOM_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RANDOM_POS);
        apple_y = ((r * DOT_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!right)) {
                left = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                right = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_UP) && (!down)) {
                up = true;
                right = false;
                left = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!up)) {
                down = true;
                right= false;
                left = false;
            }
        }
    }
}
