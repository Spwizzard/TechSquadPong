package pong;

import javax.swing.JFrame;

public class Base extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		new Base();
	}

	public Base() {
		add(new Board());
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
	}
}
