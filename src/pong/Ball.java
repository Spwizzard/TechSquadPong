package pong;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ball {
	
	final private double radToDeg = (180/Math.PI);
	private double x, y;
	private Image ballImage;
	private double XComp , YComp, angle;
	private int magnitude;
	public Ball(double X, double Y, int mag , double ang) {
		x = X;
		y = Y;	
		magnitude = mag;
		ballImage = new ImageIcon("Ball.png").getImage();
		setAngle(ang);
		move();
	}
	
	public void move() {
		calculateVector();
		x += XComp;
		y += -YComp;
	}
	
	public void calculateVector() {
		
		XComp = magnitude * Math.cos(angle);
		YComp = magnitude * Math.sin(angle);
	}
	
	public void setAngle(double degAngle)  {
		angle = degAngle / radToDeg;
		System.out.println((int)(angle * radToDeg));	
	}
	
	public void incrementMag() {
		magnitude++;
	}
	
	public Image getImage() {
		return ballImage;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	
}
