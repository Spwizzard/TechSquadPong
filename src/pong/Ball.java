package pong;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ball {
	
	final private double radToDeg = (180/Math.PI);
	private double x, y, xRight, yBottom;
	private Image ballImage;
	private double XComp , YComp, angle;
	private int magnitude;
	public Ball(double X, double Y, int mag , double ang) {
		x = X;
		y = Y;
		xRight = x + 17;
		yBottom = y + 17;
		magnitude = mag;
		ballImage = new ImageIcon("Ball.png").getImage();
		setAngle((ang / radToDeg));
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
		if(x < 0) {
			x = 0;
			if(angle > 0)
				angle = -angle + Math.PI;
			else if(angle < 0) {
				angle = -angle - Math.PI;
			}
			else
				System.out.println("wat");
			setAngle(angle);
			calculateVector();
		}
		if(xRight > 600) {
			x = 583;
			if(angle >= 0)
				angle = -angle + Math.PI;
			else if(angle < 0) {
				angle = -angle - Math.PI;
			}
			else
				System.out.println("wat");
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
