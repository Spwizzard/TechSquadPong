package pong;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Paddle {

	private int x, y;
	private Image paddleImage;
	private ImageIcon paddlePic;
	private boolean PaddleUp, PaddleDown;
	
	
	public Paddle(int whichPaddle) {
		if(whichPaddle == 1) {
			x = 50;
			y = 300;
		}
		else {
			x = 540;
			y = 300;
		}
		paddlePic = new ImageIcon("Paddle.png");
		paddleImage = paddlePic.getImage();
		
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
