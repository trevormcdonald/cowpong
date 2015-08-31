import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Board extends JPanel implements Runnable {
	

	
	public final int WIDTH= 750;
	public final int HEIGHT= 750;
	private Character background;
	
	private final int DELAY=25;
	protected boolean ingame;
	
	private Human Anne;
	private Human Diana;
	private Cow Cow;
	
	private Thread animator;
	
	private static final long serialVersionUID = 1L;
	
	
	public Board(){
		
		initBoard();
	}
	
	private void initBoard() {
		
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		background= new Character(0, 0, "back.jpg");
		Anne=new Human(20, 200, "anne2.png","");
		Diana= new Human(20,20, "diane.jpg", "wasd");
		Cow= new Cow(WIDTH/2, HEIGHT/2, "cow2.png", this);
		this.addKeyListener(Diana);
		this.addKeyListener(Anne);

		this.setFocusable(true);
		ingame=true;
		
		
	}
	
	@Override
	public void addNotify(){
		super.addNotify();
		
		animator=new Thread(this);
		animator.start();
	}
	
	public Human getAnne() {
		return Anne;
	}
	
	public Human getDiana() {
		return Diana;
	}
	
	public void bounder(Human c) {
		if (c.getBounds().getMinX()<= 0 || c.getBounds().getMaxX() >= WIDTH){
			c.setX(0);
		}
		if (c.getBounds().getMinY()<=0 || c.getBounds().getMaxY() >= HEIGHT) {
			c.setY(0);
		}
		//if (c.getBounds().intersects(Cow.getBounds())){
			//c.setDY(0);
			//c.setDX(0);
		//}
	}
	
	private void cycle() {
		
		
		bounder(Anne);
		bounder(Diana);
		Anne.move();
		Diana.move();
		Cow.move();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (!ingame) {
			gameOver(g);
		}
		else{
			Graphics2D g2d= (Graphics2D) g;
			
			g2d.drawImage(background.getImg(), 0, 0, WIDTH, HEIGHT, this);
			g2d.drawImage(Anne.getImg(), Anne.getX(), Anne.getY(), this);
			g2d.drawImage(Diana.getImg(), Diana.getX(), Diana.getY(), this);
			g2d.drawImage(Cow.getImg(), Cow.getX(), Cow.getY(), this);
		}
	}
	
	private void gameOver(Graphics g) {
		String msg= "You won!";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);
		
		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg,  (WIDTH - fm.stringWidth(msg))/2, HEIGHT/2);
		
	}

	@Override
	public void run() {
		long before, diff, sleep;
		
		before=System.currentTimeMillis();
		
		while (ingame) {
			cycle();
			repaint();

			
			diff=System.currentTimeMillis() - before;
			sleep=DELAY - diff;
			
			if (sleep <0) {
				sleep = 2;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
			
			before=System.currentTimeMillis();
		}
		ingame=false;
		repaint();
		System.out.println("out of loop");
		
		animator.interrupt();
		
		
	}

}
