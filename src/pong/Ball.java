package pong;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ball {
	
	private int x, y, dx, dy;
	private Image ballImage;
	private double XComp , YComp, angle;
	private int magnitude;
	
	public Ball(int X, int Y, int mag) {
		x = X;
		y = Y;	
		magnitude = mag;
		XComp = 3;
		YComp = 3;
		ImageIcon ballPic = new ImageIcon("Ball");
		ballImage = ballPic.getImage();
		move();
	}
	
	public void move() {
		calculateVector();
	}
	
	public void calculateVector() {
		angle = Math.atan((YComp/XComp));
		System.out.println(angle);
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
