package TicTacFantastic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TwoPlayer extends JPanel implements ActionListener {

    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    boolean PlayerOneTurn;
    static String PlayerOneName;
    static String PlayerTwoName;
    int PlayerOneScore;
    int PlayerTwoScore;
    String TicTac;
    ImageIcon TicTac2;
    boolean Start = true;
    int count=0;
    Color Colour;
    String WinningChar;
    boolean btn1used;
    boolean btn2used;
    boolean btn3used;
    boolean btn4used;
    boolean btn5used;
    boolean btn6used;
    boolean btn7used;
    boolean btn8used;
    boolean btn9used;
    int drawCount;
    Image cross = ImageIO.read(getClass().getResource("Images/Crosses.jpg"));
    Image nought = ImageIO.read(getClass().getResource("Images/Noughts.jpg"));
    Image blank = ImageIO.read(getClass().getResource("Images/Nothing.jpg"));




    TwoPlayer() throws IOException {


        //Setting the layout to "Flow"
        this.setLayout((new FlowLayout(FlowLayout.CENTER)));
        //Making a JPanel within the layout with a TicTac.Grid Layout within it.
        JPanel inner = new JPanel((new GridLayout(3, 3, 20, 20)));



        //Makes buttons to be used later with text on them


        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();

        btn1.setIcon(new ImageIcon(blank));
        btn2.setIcon(new ImageIcon(blank));
        btn3.setIcon(new ImageIcon(blank));
        btn4.setIcon(new ImageIcon(blank));
        btn5.setIcon(new ImageIcon(blank));
        btn6.setIcon(new ImageIcon(blank));
        btn7.setIcon(new ImageIcon(blank));
        btn8.setIcon(new ImageIcon(blank));
        btn9.setIcon(new ImageIcon(blank));
        //Sets the size of the title
        btn1.setPreferredSize(new Dimension(150, 150));
        btn2.setPreferredSize(new Dimension(150, 150));
        btn3.setPreferredSize(new Dimension(150, 150));
        btn4.setPreferredSize(new Dimension(150, 150));
        btn5.setPreferredSize(new Dimension(150, 150));
        btn6.setPreferredSize(new Dimension(150, 150));
        btn7.setPreferredSize(new Dimension(150, 150));
        btn8.setPreferredSize(new Dimension(150, 150));
        btn9.setPreferredSize(new Dimension(150, 150));



        btn1.setFont(new Font("Serif", Font.BOLD, 1));
        btn2.setFont(new Font("Serif", Font.BOLD, 1));
        btn3.setFont(new Font("Serif", Font.BOLD, 1));
        btn4.setFont(new Font("Serif", Font.BOLD, 1));
        btn5.setFont(new Font("Serif", Font.BOLD, 1));
        btn6.setFont(new Font("Serif", Font.BOLD, 1));
        btn7.setFont(new Font("Serif", Font.BOLD, 1));
        btn8.setFont(new Font("Serif", Font.BOLD, 1));
        btn9.setFont(new Font("Serif", Font.BOLD, 1));
        //Makes everything visible to the user
        inner.add(btn1);
        inner.add(btn2);
        inner.add(btn3);
        inner.add(btn4);
        inner.add(btn5);
        inner.add(btn6);
        inner.add(btn7);
        inner.add(btn8);
        inner.add(btn9);

        inner.setVisible(true);


        btn1.addActionListener(this);
        btn1.setActionCommand("btn1");

        btn2.addActionListener(this);
        btn2.setActionCommand("btn2");

        btn3.addActionListener(this);
        btn3.setActionCommand("btn3");

        btn4.addActionListener(this);
        btn4.setActionCommand("btn4");

        btn5.addActionListener(this);
        btn5.setActionCommand("btn5");

        btn6.addActionListener(this);
        btn6.setActionCommand("btn6");

        btn7.addActionListener(this);
        btn7.setActionCommand("btn7");

        btn8.addActionListener(this);
        btn8.setActionCommand("btn8");

        btn9.addActionListener(this);
        btn9.setActionCommand("btn9");



        add(inner);
        Reset();
    }
    public void DecideTurn(){
        JFrame f = new JFrame();
        PlayerOneName=JOptionPane.showInputDialog(f,"Enter Player One Name");
        PlayerTwoName=JOptionPane.showInputDialog(f,"Enter Player Two Name");


        double turn = Math.random();
        if (turn < 0.5){
            PlayerOneTurn=true;
            JOptionPane.showMessageDialog(null, PlayerOneName+" Goes First");
        }else{
            PlayerOneTurn=false;
            JOptionPane.showMessageDialog(null, PlayerTwoName +" Goes First");

        }

    }


    private void CycleTurn() {

        if (Start) {
            if (PlayerOneTurn) {
                TicTac = "X";
                TicTac2 = new ImageIcon(cross);
                count=2;
                Colour = (Color.BLUE);
            } else {
                TicTac = "O";
                TicTac2 = new ImageIcon(nought);
                count=3;
                Colour = (Color.RED);
            }
            Start = false;
        }
        if(count%2==0){
            TicTac = "O";
            TicTac2 = new ImageIcon(nought);
            count++;
            Colour = (Color.RED);


        }else{
            TicTac = "X";
            TicTac2 = new ImageIcon(cross);
            count++;
            Colour = (Color.BLUE);

        }

    }


    private void CheckWin(){
        drawCount++;
        if(btn1.getText().equals(btn2.getText())&&btn2.getText().equals(btn3.getText())){
            WinningChar=btn1.getText();
            if(btn1.getText()!=""){
                Win();
            }
        }

        if(btn4.getText().equals(btn5.getText())&&btn5.getText().equals(btn6.getText())){
            WinningChar=btn4.getText();
            if(btn4.getText()!="") {
                Win();
            }
        }

        if(btn7.getText().equals(btn8.getText())&&btn8.getText().equals(btn9.getText())){
            WinningChar=btn7.getText();
            if(btn7.getText()!="") {
                Win();
            }
        }

        if(btn1.getText().equals(btn4.getText())&&btn4.getText().equals(btn7.getText())){
            WinningChar=btn1.getText();
            if(btn1.getText()!=""){
                Win();
            }
        }

        if(btn2.getText().equals(btn5.getText())&&btn5.getText().equals(btn8.getText())){
            WinningChar=btn2.getText();
            if(btn2.getText()!="") {
                Win();
            }
        }

        if(btn3.getText().equals(btn6.getText())&&btn6.getText().equals(btn9.getText())){
            WinningChar=btn3.getText();
            if(btn3.getText()!="") {
                Win();
            }
        }

        if(btn1.getText().equals(btn5.getText())&&btn5.getText().equals(btn9.getText())){
            WinningChar=btn1.getText();
            if(btn1.getText()!="") {
                Win();
            }
        }

        if(btn3.getText().equals(btn5.getText())&&btn5.getText().equals(btn9.getText())){
            WinningChar=btn3.getText();
            if(btn3.getText()!="") {
                Win();
            }
        }
        if(drawCount>9){
            JOptionPane.showMessageDialog(null, "It's a DRAW");
            int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Play Again","Again?",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION) {
                Reset();

            }else{
                Window w = new Window();
                w.startMain();
            }

        }
    }

    private void Win(){
        if (WinningChar.equals("X")){
            JOptionPane.showMessageDialog(null, PlayerOneName+" Wins");
            PlayerOneScore++;

        }else{
            JOptionPane.showMessageDialog(null, PlayerTwoName+" Wins");
            PlayerTwoScore++;

        }
        JOptionPane.showMessageDialog(null, "The Current Score is,\n"+PlayerOneName+": "+PlayerOneScore+"\n"+PlayerTwoName+": "+PlayerTwoScore);
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Play Again","Again?",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION) {
            Reset();

        }else{
            Window w = new Window();
            w.startMain();
        }

    }

    private void Reset(){
        drawCount=1;
        btn1used = false;
        btn2used = false;
        btn3used = false;
        btn4used = false;
        btn5used = false;
        btn6used = false;
        btn7used = false;
        btn8used = false;
        btn9used = false;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setIcon(new ImageIcon(blank));
        btn2.setIcon(new ImageIcon(blank));
        btn3.setIcon(new ImageIcon(blank));
        btn4.setIcon(new ImageIcon(blank));
        btn5.setIcon(new ImageIcon(blank));
        btn6.setIcon(new ImageIcon(blank));
        btn7.setIcon(new ImageIcon(blank));
        btn8.setIcon(new ImageIcon(blank));
        btn9.setIcon(new ImageIcon(blank));
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getActionCommand().equals("btn1")) {
            if (!btn1used) {
                CycleTurn();
                btn1.setText(TicTac);
                btn1.setIcon(TicTac2);
                btn1.setForeground(Colour);
                btn1used = true;
                CheckWin();
            }

        }
        if (actionEvent.getActionCommand().equals("btn2")) {
            if (!btn2used) {
                CycleTurn();

                btn2.setText(TicTac);
                btn2.setIcon(TicTac2);
                btn2.setForeground(Colour);
                btn2used = true;
                CheckWin();
            }
        }
        if (actionEvent.getActionCommand().equals("btn3")) {
            if (!btn3used) {
                CycleTurn();
                btn3.setText(TicTac);
                btn3.setIcon(TicTac2);
                btn3.setForeground(Colour);
                btn3used = true;
                CheckWin();
            }
        }
        if (actionEvent.getActionCommand().equals("btn4")) {
            if (!btn4used) {
                CycleTurn();
                btn4.setText(TicTac);
                btn4.setIcon(TicTac2);
                btn4.setForeground(Colour);
                btn4used = true;
                CheckWin();
            }
        }
        if (actionEvent.getActionCommand().equals("btn5")) {
            if (!btn5used) {
                CycleTurn();
                btn5.setText(TicTac);
                btn5.setIcon(TicTac2);
                btn5.setForeground(Colour);
                btn5used = true;
                CheckWin();
            }
        }
        if (actionEvent.getActionCommand().equals("btn6")) {
            if (!btn6used) {
                CycleTurn();
                btn6.setText(TicTac);
                btn6.setIcon(TicTac2);
                btn6.setForeground(Colour);
                btn6used = true;
                CheckWin();
            }
        }
        if (actionEvent.getActionCommand().equals("btn7")) {
            if (!btn7used) {
                CycleTurn();
                btn7.setText(TicTac);
                btn7.setIcon(TicTac2);
                btn7.setForeground(Colour);
                btn7used = true;
                CheckWin();

            }
        }
        if (actionEvent.getActionCommand().equals("btn8")) {
            if (!btn8used) {
                CycleTurn();
                btn8.setText(TicTac);
                btn8.setIcon(TicTac2);
                btn8.setForeground(Colour);
                btn8used = true;
                CheckWin();

            }
        }
        if (actionEvent.getActionCommand().equals("btn9")) {
            if (!btn9used) {
                CycleTurn();
                btn9.setText(TicTac);
                btn9.setIcon(TicTac2);
                btn9.setForeground(Colour);
                btn9used = true;
                CheckWin();

            }
        }

    }


}
