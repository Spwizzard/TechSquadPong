package pong;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ball {
	
	private int x, y, dx, dy;
	private Image paddleImage;
	private ImageIcon paddlePic;
	private double xComp , YComp;
	private int magnitude;
	
	public Ball(int X, int Y, int mag) {
		x = X;
		y = Y;	
		magnitude = mag;
		paddlePic = new ImageIcon("Ball");
		paddleImage = paddlePic.getImage();
	}
	
	public void move() {
		
	}
	
	public void incrementMag() {
		magnitude++;
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
