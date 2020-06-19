package TicTacFantastic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnePlayer {
	
	Computer player1 = new Computer(1);
	JFrame mainFrame = new JFrame("TicTacFantastic");
	JPanel mainPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel gamePanel = new JPanel();
	
	JButton restartButton = new JButton("Exit");
	JButton buttons[][]= new JButton[3][3];
	Grid mainGrid = new Grid();
	
	buttonhandler handler = new buttonhandler();
	
	private class buttonhandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if( e.getSource() == buttons[i][j] ) {
						
						mainGrid.putIntoGrid(i, j);
						rePaint(mainGrid);
						
						if(mainGrid.findIfWon() == 2) {
							JOptionPane.showMessageDialog(null, "You won, Impossible");
							int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Play Again","Again?",JOptionPane.YES_NO_OPTION);
							if(dialogResult == JOptionPane.YES_OPTION) {
								Window w = new Window();
								w.startOne();
								mainFrame.dispose();

							}else{
								Window w = new Window();
								w.startMain();
								mainFrame.dispose();
							}
						}
						else if(mainGrid.findIfWon() == 0) {
							JOptionPane.showMessageDialog(null, "Its a Draw");
							int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Play Again","Again?",JOptionPane.YES_NO_OPTION);
							if(dialogResult == JOptionPane.YES_OPTION) {
								Window w = new Window();
								w.startOne();
								mainFrame.dispose();

							}else{
								Window w = new Window();
								w.startMain();
								mainFrame.dispose();
							}
						}
						
						computerTurn();
					}
				}
			}
			
			if(e.getSource() == restartButton) {
				System.exit(0); 
			}
		}
	}
	

	
	public void  getOnePlayer() {
		startGame();
	}
	
	private void startGame() {

		showGui();
		
		mainGrid.initialize();
		
		rePaint(mainGrid);
//		mainGrid.putValue(0, 2);
//		player1.giveTurn(mainGrid).printValues();
//		
//		mainGrid.putValue(6, 2);
//		player1.giveTurn(mainGrid).printValues();
		
		
	}
	
	public void computerTurn() {
		player1.giveTurn(mainGrid);
		rePaint(mainGrid);
		
		if(mainGrid.findIfWon() == 1) {
			JOptionPane.showMessageDialog(null, "Computer Wins");
			int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Play Again","Again?",JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION) {
				Window w = new Window();
				w.startOne();
				mainFrame.dispose();

			}else{
				Window w = new Window();
				w.startMain();
				mainFrame.dispose();
			}
		}
		else if(mainGrid.findIfWon() == 0) {
			JOptionPane.showMessageDialog(null, "Its a Draw");
			int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Play Again","Again?",JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION) {
				Window w = new Window();
				w.startOne();
				mainFrame.dispose();

			}else{
				Window w = new Window();
				w.startMain();
				mainFrame.dispose();
			}
		}
	}
	
	
	public void showGui() {



		mainPanel.setLayout(new GridLayout(1, 1));
		mainPanel.setPreferredSize(new Dimension(530, 550));
		gamePanel = new JPanel(new GridLayout(3, 3,20,20));
		gamePanel.setPreferredSize(new Dimension(530, 550));
		gamePanel.setBorder(new EmptyBorder(10, 20, 20, 20));
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {

				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(handler);
				gamePanel.add(buttons[i][j]);
			
			}
		}
		
		mainPanel.add(gamePanel);
		
		//buttonPanel.setLayout(new GridLayout(2, 1));
		//buttonPanel.add( getCircleButton());


		
		restartButton.addActionListener(handler);
		//buttonPanel.add(restartButton);


		
		mainPanel.setBackground(Color.black);
		
		mainFrame.add(mainPanel);
		mainFrame.setLayout(new GridLayout(1, 2,20,20));
		mainFrame.setSize(530, 550);
		mainFrame.getContentPane();
		mainFrame.setVisible(true);
	}
	
	public void rePaint(Grid myGrid) {
		
		gamePanel.removeAll();
		gamePanel.revalidate();
		gamePanel.repaint();
		gamePanel.setPreferredSize(new Dimension(530, 550));
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				
				buttons[i][j].addActionListener(handler);
				if(myGrid.value[i][j] != 0 ) {
					
					if(myGrid.value[i][j] == 1) buttons[i][j] = getCircleButton();
					else buttons[i][j] = getCrossButton();
					//buttons[i][j].setEnabled(false);
				}
				gamePanel.add(buttons[i][j]);
			}
		}
		
		mainPanel.add(gamePanel);
	}
	
	private JButton getCircleButton() {
		JButton button = new JButton();
		
		button.setText("O");
		button.setFont(new Font("Serif",Font.BOLD,50));
		button.setForeground(Color.red);
		
		return button;

	}
	
	private JButton getCrossButton() {
		JButton button = new JButton();
		
		button.setText("X");
		button.setFont(new Font("Serif",Font.BOLD,50));
		button.setForeground(Color.BLUE);
		return button;
	}
	
	private void clearJFrame() {
		mainFrame.dispose();
	}
}
