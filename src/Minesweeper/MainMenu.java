package Minesweeper;//Import the required packages

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class MainMenu extends JPanel implements ActionListener {

    //Declares the labels and titles to be used
    JLabel title1;
    JButton mine,helpMe, logOut;


    MainMenu() throws ParseException {

        //Setting the layout to "Flow"
        this.setLayout((new FlowLayout(FlowLayout.CENTER)));
        //Making a JPanel within the layout with a TicTac.Grid Layout within it.
        JPanel inner = new JPanel((new GridLayout(5, 1, 15, 20)));
        //Sets the title using the name variable
        title1 = new JLabel("Minesweeper");
        //Sets the title colour
        title1.setForeground(Color.blue);
        //Sets the title font
        title1.setFont(new Font("Serif", Font.BOLD, 20));


        //Makes buttons to be used later with text on them
        mine = new JButton("Start");
        helpMe = new JButton("Help");
        logOut = new JButton("Log Out");

        //Sets the size of the title
        title1.setPreferredSize(new Dimension(350, 30));
        //Makes everything visible to the user
        inner.setVisible(true);
        inner.add(title1);
        inner.add(mine);
        inner.add(helpMe);
        inner.add(logOut);


        //Adding listeners and commands to run when them listeners are triggered
        mine.addActionListener(this);
        mine.setActionCommand("mine");
        helpMe.addActionListener(this);
        helpMe.setActionCommand("help");
        logOut.addActionListener(this);
        logOut.setActionCommand("quit");

        //Adding everything stored in inner above to the window
        add(inner);
    }

    @Override
    //Defines an action to be called upon by the user, I.e. this is what will run when the listener is triggered
    public void actionPerformed(ActionEvent actionEvent) {
        Window w = new Window();


        if (actionEvent.getActionCommand().equals("mine")) {
            //Opens the corresponding menu
            w.startMine();

        } else if (actionEvent.getActionCommand().equals("help")) {
            //Opens the corresponding menu
            w.startHelp();

        }else if (actionEvent.getActionCommand().equals("quit")) {
            Controller.Window window = new Controller.Window();
            try {
                window.init();
            }catch(Exception e){
                System.out.println(e);
            }
        }

    }
}

