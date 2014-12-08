package pong;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Paddle {

	private int x, y, dy;
	private Image paddleImage;
	private ImageIcon paddlePic;
	
	public Paddle(int whichPaddle) {
		if(whichPaddle == 1) {
			x = 50;
			y = 300;
		}
		else {
			x = 540;
			y = 300;
		}
		paddlePic = new ImageIcon("Paddle");
		paddleImage = paddlePic.getImage();
	}
	
	public void move() {
		y += dy;
		
		if(y < 100) {
			y = 100;
		}
		
		if(y > 530) {
			y = 530;
		}
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
			dy = -4;
		}
		
		if((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
			dy = 4;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP) || (key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN)) {
			dy = 0;
		}
	}
	
}
