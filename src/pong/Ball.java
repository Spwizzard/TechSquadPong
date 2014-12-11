package pong;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ball {
	
	private int x, y, dx, dy;
	private Image ballImage;
	private ImageIcon ballPic;
	private double xComp , YComp;
	private int magnitude;
	
	public Ball(int X, int Y, int mag) {
		x = X;
		y = Y;	
		magnitude = mag;
		ballPic = new ImageIcon("Ball.png");
		ballImage = ballPic.getImage();
	}
	
	public void move() {
		
	}
	
	public void incrementMag() {
		magnitude++;
	}
	
	public Image getImage() {
		return ballImage;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	
}
