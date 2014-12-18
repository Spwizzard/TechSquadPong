package pong;

import javax.swing.JFrame;

public class Base extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		new Base();
	}

	public Base() {
		Board board = new Board();
		setContentPane(board);
		board.checkBase = true;
		setUndecorated(true);
		pack();
		setLocationRelativeTo(null);
		board.startTimer();
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
		setResizable(false);
	}
}
