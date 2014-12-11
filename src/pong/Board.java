package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	private int B_WIDTH;
	private int B_HEIGHT;
	private int player1NumberOfWins;
	private int player2NumberOfWins;
	private int fps;
	public boolean checkBase = false;
	private Base f1;
	
	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(600,600));
		player1NumberOfWins = 0;
		player2NumberOfWins = 0;	
		
		paddle1 = new Paddle(1);
		paddle2 = new Paddle(2);
		
		ball = new Ball(292, 341, 5);
		
		if(checkBase) {
			f1 = ((Base) SwingUtilities.getAncestorOfClass(Base.class, this));
			if(f1 == null) 
				System.out.println("Base is null!");
			B_WIDTH = f1.getWidth();
			B_HEIGHT = f1.getHeight();
		}
		
		fpsDate = new Date();
		
		tickTimer = new Timer(16,this);
		tickTimer.start();
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.WHITE);
		g2d.drawRect(0, 0, 599, 99);
		g2d.setFont(new Font("Courier New", Font.BOLD, 100));
		g2d.drawString("" + player1NumberOfWins, 50, 80);
		g2d.drawString("" + player2NumberOfWins, 500, 80);
		
		
		g2d.setColor(Color.GREEN);
		
		g2d.drawImage(paddle1.getImage(), paddle1.getX(), paddle1.getY(), this);
		g2d.drawImage(paddle2.getImage(), paddle2.getX(), paddle2.getY(), this);
		
		g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(), this);
		
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		paddle1.move();
		paddle2.move();
		repaint();
		fps++;
		//calculateFPS();
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

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_S)) { 
				paddle1.keyReleased(e);
			}
			if((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
				paddle2.keyReleased(e);
			}			
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if((key == KeyEvent.VK_ESCAPE)) {
				
			}
			if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_S)) { 
				paddle1.keyPressed(e);
			}
			if((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
				paddle2.keyPressed(e);
			}		
		}
	}
}



