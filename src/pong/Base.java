package pong;

import javax.swing.JFrame;

public class Base extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		new Base();
	}

	public Base() {
		Board testBoard = new Board();
		setContentPane(testBoard);
		testBoard.checkBase = true;
		//setUndecorated(true);
		pack();
		testBoard.startTimer();
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//getRootPane().setBorder(BorderFactory.createMatteBorder(50, 50, 50, 50, Color.PINK));
		
		setVisible(true);
		setResizable(false);
	}
}
