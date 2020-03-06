package TicTac;//Imports the required packages
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends JPanel implements ActionListener {


    Help() {

        String Display= " In a 3-by-3 grid game, the player who is playing \"X\" always goes first.\n\n Players alternate placing Xs and Os on the board until either player has three in a row, horizontally,\n vertically, or diagonally or until all squares on the grid are filled.\n\n If a player is able to draw three Xs or three Os in a row, then that player wins.\n If all squares are filled and neither player has made a complete row of Xs or Os, then the game is a draw.";
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
