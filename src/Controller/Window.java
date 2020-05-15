package Controller;



import Snake.snake;
import SpaceInvade.com.SpaceInvaders;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;

public class Window extends JFrame {

    static JFrame jf;
    static JPanel main;



    public static void main(String[] args) throws ParseException, IOException {
        Window w = new Window();
        w.init();
    }

    public void init() throws ParseException, IOException {

        jf = new JFrame();
        main= new MainMenu();



        main.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setSize(600, 400);
        startMain();


    }

    void startMain() {
        //Sets the other JPanels to invisible
        jf.setVisible(true);
        //Sets this JPanel to visible
        main.setVisible(true);
        //Removes all the content from the pre-existing windows
        jf.getContentPane().removeAll();
        //Adds the new content as defined above
        jf.getContentPane().add(main);
        //Sets the new JPanel to visible
        jf.setVisible(true);
        //Sets the window title
        jf.setTitle("Main Menu");
        //Packs it all together
        jf.pack();
        //Set the size needed
        jf.setSize(600, 600);
        //Allows the user to move the pane
        jf.setLocationRelativeTo(null);
    }


    void startMineW() {
//        main.setVisible(false);
//        tiktacw.setVisible(false);
//        //Sets this JPanel to visible
//        mine.setVisible(true);
//        //Removes all the content from the pre-existing windows
//        jf.getContentPane().removeAll();
//        //Adds the new content as defined above
//        jf.getContentPane().add(mine);
//        //Sets the new JPanel to visible
//        jf.setVisible(true);
//        //Sets the window title
//        jf.setTitle("Start!");
//        //Packs it all together
//        jf.pack();
//        //Set the size needed
//        jf.setSize(530, 550);
//        //Allows the user to move the pane
//        jf.setLocationRelativeTo(null);
        main.setVisible(false);
        jf.dispose();
        Minesweeper.Window MineWindow = new Minesweeper.Window();
        try {
            MineWindow.init();
        }catch (Exception e){
            System.out.println(e);
        }

    }



    void startTicTacW() {
//        jf.setVisible(true);
//        mine.setVisible(false);
//        main.setVisible(false);
//        //Sets this JPanel to visible
//        help.setVisible(true);
//        //Removes all the content from the pre-existing windows
//        jf.getContentPane().removeAll();
//        //Adds the new content as defined above
//        jf.getContentPane().add(help);
//        //Sets the new JPanel to visible
//        jf.setVisible(true);
//        //Sets the window title
//        jf.setTitle("Help Section");
//        //Packs it all together
//        jf.pack();
//        //Set the size needed
//        jf.setSize(750, 500);
//        //Allows the user to move the pane
//        jf.setLocationRelativeTo(null);
        main.setVisible(false);
        jf.dispose();

        TicTacFantastic.Window TicTacWindow = new TicTacFantastic.Window();
        try {
            TicTacWindow.init();
        }catch (Exception e){
            System.out.println(e);
        }
    }


    void startSnakeW() {
//        jf.setVisible(true);
//        mine.setVisible(false);
//        main.setVisible(false);
//        //Sets this JPanel to visible
//        help.setVisible(true);
//        //Removes all the content from the pre-existing windows
//        jf.getContentPane().removeAll();
//        //Adds the new content as defined above
//        jf.getContentPane().add(help);
//        //Sets the new JPanel to visible
//        jf.setVisible(true);
//        //Sets the window title
//        jf.setTitle("Help Section");
//        //Packs it all together
//        jf.pack();
//        //Set the size needed
//        jf.setSize(750, 500);
//        //Allows the user to move the pane
//        jf.setLocationRelativeTo(null);
        main.setVisible(false);
        jf.dispose();
        Snake.snake snake = new Snake.snake();
        try {
            snake.start();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    void startSpaceW() {
//        jf.setVisible(true);
//        mine.setVisible(false);
//        main.setVisible(false);
//        //Sets this JPanel to visible
//        help.setVisible(true);
//        //Removes all the content from the pre-existing windows
//        jf.getContentPane().removeAll();
//        //Adds the new content as defined above
//        jf.getContentPane().add(help);
//        //Sets the new JPanel to visible
//        jf.setVisible(true);
//        //Sets the window title
//        jf.setTitle("Help Section");
//        //Packs it all together
//        jf.pack();
//        //Set the size needed
//        jf.setSize(750, 500);
//        //Allows the user to move the pane
//        jf.setLocationRelativeTo(null);
        main.setVisible(false);
        jf.dispose();
        SpaceInvaders sp = new SpaceInvaders();
        try {
            sp.main(null);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
