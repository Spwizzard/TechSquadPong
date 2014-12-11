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
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		//getRootPane().setBorder(BorderFactory.createMatteBorder(50, 50, 50, 50, Color.PINK));
		pack();
		setVisible(true);
		setResizable(false);
		
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
	}
	
	public void sizes() {
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
	}
}
