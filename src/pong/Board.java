package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	private Paddle paddle1, paddle2;
	private Ball ball;
	private Date fpsDate;
	private Timer tickTimer;
	private int baseWidth, baseHeight, boardWidth, boardHeight;
	private int player1NumberOfWins, player2NumberOfWins;
	private int fps;
	public boolean checkBase = false;
	private Base f1;
	
	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(801,601));
		
		player1NumberOfWins = 0;
		player2NumberOfWins = 0;	
		fpsDate = new Date();
		tickTimer = new Timer(16,this);
		
	}
	
	public void dimensionCheck() {
		
		f1 = (Base) SwingUtilities.getWindowAncestor(this);
		if(f1 == null) 
			System.out.println("Base is null!");
		baseWidth = f1.getWidth();
		baseHeight = f1.getHeight();
		boardWidth = this.getWidth();
		boardHeight = this.getHeight();
		
		System.out.println(baseWidth + " baseWidth");
		System.out.println(baseHeight + " baseHeight");			
		System.out.println(boardWidth + " boardWidth");
		System.out.println(boardHeight + " boardHeight");
		checkBase = false;
		
		paddle1 = new Paddle(1);
		paddle2 = new Paddle(2); 
		setBall(); 
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.WHITE);
		g2d.drawRect(0, 0, 800, 99);
		g2d.setFont(new Font("American Typewriter", Font.PLAIN, 100));
		g2d.drawString("" + player1NumberOfWins, 80, 82);
		g2d.drawString("" + player2NumberOfWins, 660, 82);
		
		if(paddle1 != null)
			g2d.drawImage(paddle1.getImage(), paddle1.getX(), paddle1.getY(), this);
		if(paddle2 != null)
			g2d.drawImage(paddle2.getImage(), paddle2.getX(), paddle2.getY(), this);
		if(ball != null)
			g2d.drawImage(ball.getImage(), (int)Math.round(ball.getX()), (int)Math.round(ball.getY()), this);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(checkBase) 
			dimensionCheck();
		paddle1.move();
		paddle2.move();
		ball.move();
		checkCollisions();
		if(ball.getX() <= 0) {
			setBall();
			player2NumberOfWins++;
		}	
		if(ball.getX() >= 783) {
			setBall();
			player1NumberOfWins++;
		}	
		repaint();
		fps++;
		//calculateFPS();
	}

	public void checkCollisions() {
		Rectangle ballRect = ball.getBounds();
		Rectangle paddle1Rect = paddle1.getBounds();
		Rectangle paddle2Rect = paddle2.getBounds();
		double angle = ball.getAngle();
		
		if(ballRect.intersects(paddle1Rect) || (ballRect.intersects(paddle2Rect))) {
			double yBallCenter = ball.getY() + 8;
			double yPaddleCenter = 0;
			double angleMultiplier = 1.5;
			
			if(ballRect.intersects(paddle1Rect)) {
				yPaddleCenter = paddle1.getY() + 34;
				angle = (yPaddleCenter - yBallCenter) * Math.PI / 180 * angleMultiplier;
			}	
			
			if(ballRect.intersects(
					paddle2Rect)) {
				yPaddleCenter = paddle2.getY() + 34;	
				angle = Math.PI - (yPaddleCenter - yBallCenter) * Math.PI / 180 * angleMultiplier;
			}	
			
			ball.setAngle(angle);
			ball.incrementMag();
			ball.calculateVector();
			
			if(ballRect.intersects(paddle1Rect))
				ball.setX(61);
			if(ballRect.intersects(paddle2Rect))
				ball.setX(722);
		}
	}
	
	public void setBall() {
		int[] angleMults = {0,3,4,7};
		ball = new Ball(392, 342, 5 , ((int)(Math.random() * 45) + angleMults[(int)(Math.random() * 4)] * 45));
	}
	
	public void startTimer() {
		tickTimer.start();
	}
	
	public void calculateFPS() {
		long sec1Time = new Date().getTime();
		long fpsTime = fpsDate.getTime();
		if(sec1Time - fpsTime >= 1000) {
			System.out.println(fps + "   " + (sec1Time - fpsTime));
			fpsDate = new Date();
			fps = 0;
		}
	}
	
	
	private class TAdapter extends KeyAdapter { 
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_P) {
				setBall();
			}
			if(key == KeyEvent.VK_R) {
				setBall();
				player1NumberOfWins = 0;
				player2NumberOfWins = 0;
			}
			
			if((key == KeyEvent.VK_ESCAPE)) {
				System.exit(key);
			}
			if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_S)) { 
				paddle1.keyPressed(e);
			}
			if((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
				paddle2.keyPressed(e);
			}		
		}
		
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_S)) { 
				paddle1.keyReleased(e);
			}
			if((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
				paddle2.keyReleased(e);
			}			
		}	
	}
}



