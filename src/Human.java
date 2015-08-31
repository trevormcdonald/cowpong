import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Human extends Character implements KeyListener {
	
	
	private int up=KeyEvent.VK_UP;
	private int down=KeyEvent.VK_DOWN;
	private int left=KeyEvent.VK_LEFT;
	private int right=KeyEvent.VK_RIGHT;


	
	public Human(int x, int y, String name, String style){
		super(x, y, name);
		
		if (style.equals("wasd")){
			this.up=KeyEvent.VK_W;
			this.down=KeyEvent.VK_S;
			this.left=KeyEvent.VK_A;
			this.right=KeyEvent.VK_D;
			
		}
		else{
			//this.up=KeyEvent.;
			//this.down=;
			//this.left=;
			//this.right;
		}
	}
	

	
	@Override
	public void keyPressed(KeyEvent e) {
		int key= e.getKeyCode();
		
		if (key==up){
			setDY(-5);
		}
		if (key==down){
			setDY(5);
		}
		if (key==left){
			setDX(-5);
		}
		if (key==right){
			setDX(5);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key= e.getKeyCode();
		
		if (key==up){
			setDY(0);
		}
		if (key==down){
			setDY(0);
		}
		if (key==left){
			setDX(0);
		}
		if (key==right){
			setDX(0);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		return;
				
	}


}
