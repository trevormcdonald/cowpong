import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;



public class Character {
	private int x;
	private int y;
	private int dx=0;
	private int dy=0;
	private Image img;
	private boolean vis;
	
	public Character(int x, int y, String name){
		this.x=x;
		this.y=y;
		
		ImageIcon ii= new ImageIcon(name);
		this.img= ii.getImage();
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY() {
		return y;
	}
	public void setX(int i){
		x=i;
	}
	public void setY(int i){
		y=i;
	}
	
	public int getDX() {
		return dx;
	}
	
	public int getDY() {
		return dy;
	}
	
	public void setDX(int i) {
		dx=i;
	}
	public void setDY(int i) {
		dy=i;
	}
	
	public Image getImg() {
		return img;
	}
	
	public boolean isVisible() {
		return vis;
	}
	public void setVisible(Boolean b) {
		vis=b;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, img.getWidth(null), img.getHeight(null) );
	}
	
	public void move() {
		x=x+dx;
		y=y+dy;
	}


}
