package Minesweeper;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;

public class Window extends JFrame {

    static JFrame jf;
    static JPanel main;
    static JPanel help;
    static JPanel mine;


    public static void main(String[] args) throws ParseException, IOException {
        Window w = new Window();
        w.init();
    }

    public void init() throws ParseException, IOException {

        jf = new JFrame();
        main= new MainMenu();
        help  = new Help();
        mine  = new Mine();


        main.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setSize(600, 400);
        startMain();


    }

    void startMain() {
        //Sets the other JPanels to invisible
        jf.setVisible(true);
        mine.setVisible(false);
        help.setVisible(false);
        //Sets this JPanel to visible
        main.setVisible(true);
        //Removes all the content from the pre-existing windows
        jf.getContentPane().removeAll();
        //Adds the new content as defined above
        jf.getContentPane().add(main);
        //Sets the new JPanel to visible
        jf.setVisible(true);
        //Sets the window title
        jf.setTitle("Minesweeper");
        //Packs it all together
        jf.pack();
        //Set the size needed
        jf.setSize(600, 600);
        //Allows the user to move the pane
        jf.setLocationRelativeTo(null);
    }


    void startMine() {
//        main.setVisible(false);
//        help.setVisible(false);
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
        jf.setVisible(false);
        final int gridSize = 10;
        SwingUtilities.invokeLater(() -> Mine.run(gridSize));
    }



    void startHelp() {
        jf.setVisible(true);
        mine.setVisible(false);
        main.setVisible(false);
        //Sets this JPanel to visible
        help.setVisible(true);
        //Removes all the content from the pre-existing windows
        jf.getContentPane().removeAll();
        //Adds the new content as defined above
        jf.getContentPane().add(help);
        //Sets the new JPanel to visible
        jf.setVisible(true);
        //Sets the window title
        jf.setTitle("Help Section");
        //Packs it all together
        jf.pack();
        //Set the size needed
        jf.setSize(750, 500);
        //Allows the user to move the pane
        jf.setLocationRelativeTo(null);
    }
}
