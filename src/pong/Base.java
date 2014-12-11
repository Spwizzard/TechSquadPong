package pong;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
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
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(50, 50, 50, 50, Color.PINK));
		pack();
		setVisible(true);
		setResizable(false);
	}
	
	public void sizes() {
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
	}
}
