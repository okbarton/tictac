package Minesweeper;//Imports the required packages

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends JPanel implements ActionListener {


    Help() {

        String Display= " You are presented with a board of squares. Some squares contain mines (bombs), others don't.\nIf you click on a square containing a bomb, you lose. If you manage to click all the squares (without clicking on any bombs) you win.\n\n" +
                "Clicking a square which doesn't have a bomb reveals the number of neighbouring squares containing bombs.\nUse this information plus some guess work to avoid the bombs.\n\n" +
                "To open a square, point at the square and click on it.\nTo mark a square you think is a bomb, point and right-click (or hover with the mouse and press Space).";
        //Adds the required Jbuttons
        JButton back;
        back = new JButton("Return");
        JPanel middlePanel = new JPanel();
        //Adds a panel with a boarder to display the text in
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "TicTacToe Rules"));
        //sets the area of the text box
        JTextArea display = new JTextArea(25, 55);
        // set textArea non-editable
        display.setEditable(false);
        //Inserts a scroll wheel
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //Adds an actionlisteners for the back button
        back.addActionListener(this);

        //Add Textarea in to middle panel
        display.setText(Display);
        middlePanel.add(scroll);
        middlePanel.add(back);
        this.add(middlePanel);

    }


    @Override
    //Defines an action to be called upon by the user, I.e. this is what will run when the listener is triggered
    public void actionPerformed(ActionEvent actionEvent) {
        Window w = new Window();
        w.startMain();
    }
}
