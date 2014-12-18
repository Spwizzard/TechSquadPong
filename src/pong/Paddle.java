package pong;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Paddle {

	private int x, y, width, height;
	private Image paddleImage;
	private boolean PaddleUp, PaddleDown;
	
	
	public Paddle(int whichPaddle) {
		if(whichPaddle == 1) {
			x = 51;
			y = 316;
		}
		else {
			x = 741;
			y = 316;
		}
		
		paddleImage = new ImageIcon("Paddle.png").getImage();
		width = paddleImage.getWidth(null);
		height = paddleImage.getHeight(null);
		
		PaddleUp = false;
		PaddleDown = false;		
		
	}
	
	public void move() {
		
		if(PaddleUp && !PaddleDown) {
			y += -8;
		}
		else if(!PaddleUp && PaddleDown) {
			y += 8;
		}
		else if(PaddleUp && PaddleDown) {
			y += 0;
		}
		else if(!PaddleUp && !PaddleDown) {
			y += 0;
		}
		
		if(y < 100) {
			y = 100;
		}
		
		if(y > 530) {
			y = 530;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
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
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {
			PaddleUp = true;
		}
		
		if((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
			PaddleDown = true;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP)) {
			PaddleUp = false;
		}
		if((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
			PaddleDown = false;
		}
	}
	
}
