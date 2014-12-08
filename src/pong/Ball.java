package pong;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ball {
	
	private int x, y, dx, dy;
	private Image paddleImage;
	private ImageIcon paddlePic;
	
	public Ball(int X, int Y) {
		x = X;
		y = Y;	
		paddlePic = new ImageIcon("Ball");
		paddleImage = paddlePic.getImage();
	}
	
	public void move() {
		
	}
	
	public Image getImage() {
		return paddleImage;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
