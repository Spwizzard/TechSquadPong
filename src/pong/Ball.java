package pong;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Ball {
	
	final private double radToDeg = (180/Math.PI);
	final private double degToRad = (Math.PI/180);
	private double x, y, xRight, yBottom;
	private Image ballImage;
	private double XComp , YComp, angle, magnitude;
	private int width, height;
	public Ball(double X, double Y, int mag , double ang) {
		x = X;
		y = Y;
		xRight = x + 17;
		yBottom = y + 17;
		magnitude = mag;
		ballImage = new ImageIcon("kappa.png").getImage();
		width = ballImage.getWidth(null);
		height = ballImage.getHeight(null);
		setAngle((ang * degToRad));
	}
	
	public void move() {
		calculateVector();
		x += XComp;
		xRight += XComp;
		y += -YComp;
		yBottom += -YComp;

		if(y < 100) {
			y = 100;
			angle = -angle;
			setAngle(angle);
			calculateVector();
		}
		if(yBottom > 600) {
			y = 583;
			angle = -angle;
			setAngle(angle);
			calculateVector();
		}
	}
	
	public void calculateVector() {
		XComp = magnitude * Math.cos(angle);
		YComp = magnitude * Math.sin(angle);
	}
	
	public void setAngle(double radAngle)  {
		angle = radAngle;
		System.out.println((int)(radAngle * radToDeg));	
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void incrementMag() {
		if(magnitude < 12) {
			magnitude+=.5;
		}
		System.out.println(magnitude);
	}
	
	public Image getImage() {
		return ballImage;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double X) {
		x = X;
	}
	
	public double getY() {
		return y;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}
	
}
