package TicTac;

import javax.swing.*;
import java.text.ParseException;

public class Window extends JFrame {

    static JFrame jf;
    static JPanel main;
    static JPanel help;
    static JPanel oneplayer;
    static JPanel twoplayer;


    public static void main(String[] args) throws ParseException {
        Window w = new Window();
        w.init();
    }

    private void init() throws ParseException {

        jf = new JFrame();
        main= new MainMenu();
        help  = new Help();
        twoplayer = new TwoPlayer();

        main.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setSize(600, 400);
        startMain();


    }

    void startMain() {
        //Sets the other JPanels to invisible

        twoplayer.setVisible(false);
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
        jf.setTitle("Tic Tac Toe");
        //Packs it all together
        jf.pack();
        //Set the size needed
        jf.setSize(600, 600);
        //Allows the user to move the pane
        jf.setLocationRelativeTo(null);
    }


    void startOne() {
        //Sets the other JPanels to invisible
        twoplayer.setVisible(false);
        main.setVisible(false);
        help.setVisible(false);
        jf.setVisible(false);
        jf.getContentPane().removeAll();
        //Sets this JPanel to visible
        OnePlayer op = new OnePlayer();
        op.getOnePlayer();
    }

    void startTwo() {
        //Sets the other JPanels to invisible

        main.setVisible(false);
        help.setVisible(false);
        //Sets this JPanel to visible
        twoplayer.setVisible(true);
        //Removes all the content from the pre-existing windows
        jf.getContentPane().removeAll();
        //Adds the new content as defined above
        jf.getContentPane().add(twoplayer);
        //Sets the new JPanel to visible
        jf.setVisible(true);
        //Sets the window title
        jf.setTitle("Two Player");
        //Packs it all together
        jf.pack();
        //Set the size needed
        jf.setSize(530, 550);
        //Allows the user to move the pane
        jf.setLocationRelativeTo(null);
    }

    void startHelp() {

        twoplayer.setVisible(false);
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
        jf.setTitle("TicTac.Help Section");
        //Packs it all together
        jf.pack();
        //Set the size needed
        jf.setSize(750, 500);
        //Allows the user to move the pane
        jf.setLocationRelativeTo(null);
    }
}
