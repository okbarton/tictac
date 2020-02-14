//Import the required packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainMenu extends JPanel implements ActionListener {

    //Declares the labels and titles to be used
    JLabel title1;
    JButton onePlayer, twoPlayer,helpMe, logOut;


    MainMenu() throws ParseException {

        //Setting the layout to "Flow"
        this.setLayout((new FlowLayout(FlowLayout.CENTER)));
        //Making a JPanel within the layout with a Grid Layout within it.
        JPanel inner = new JPanel((new GridLayout(5, 1, 15, 20)));
        //Sets the title using the name variable
        title1 = new JLabel("Tic Tac Fantastic");
        //Sets the title colour
        title1.setForeground(Color.blue);
        //Sets the title font
        title1.setFont(new Font("Serif", Font.BOLD, 20));


        //Makes buttons to be used later with text on them
        onePlayer = new JButton("One Player");
        twoPlayer = new JButton("Two Player");
        helpMe = new JButton("Help");
        logOut = new JButton("Log Out");

        //Sets the size of the title
        title1.setPreferredSize(new Dimension(350, 30));
        //Makes everything visible to the user
        inner.setVisible(true);
        inner.add(title1);
        inner.add(onePlayer);
        inner.add(twoPlayer);
        inner.add(helpMe);
        inner.add(logOut);


        //Adding listeners and commands to run when them listeners are triggered
        onePlayer.addActionListener(this);
        onePlayer.setActionCommand("one");
        twoPlayer.addActionListener(this);
        twoPlayer.setActionCommand("two");
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

        TwoPlayer two = new TwoPlayer();
        if (actionEvent.getActionCommand().equals("one")) {
            //Opens the corresponding menu
            w.startOne();



        } else if (actionEvent.getActionCommand().equals("two")) {
            //Opens the corresponding menu
            two.DecideTurn();
            w.startTwo();

        } else if (actionEvent.getActionCommand().equals("help")) {
            //Opens the corresponding menu
            w.startHelp();

        }else if (actionEvent.getActionCommand().equals("quit")) {
            //Opens the corresponding menu
            System.exit(0);

        }

    }
}

