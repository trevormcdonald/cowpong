import java.util.Random;


public class Cow extends Character {

	
	private Board board;

	public Cow(int x, int y, String name, Board b) {
		super(x, y, name);
		this.board=b;
		this.setDX(1);
		this.setDY(1);
		
	}
	
	@Override
	public void move() {
		//Check to not move through walls
		//Check to move away from Humans
		//Add a bit of randomness to movement
		//Make slightly faster than Humans
		Human a=board.getAnne();
		Human d= board.getDiana();
		
		java.awt.Rectangle r= this.getBounds();
		java.awt.Rectangle ar= a.getBounds();
		java.awt.Rectangle dr= d.getBounds();
		
		if(r.intersects(ar)&&(!r.contains(ar.x, ar.y))){
			this.setDX((getDX()+a.getDX())*-1);
			this.setDY((getDY()+a.getDY())*-1);
		}
		
		if(r.intersects(dr)&&(!r.contains(dr.x, dr.y))){
			this.setDX((getDX()+d.getDX())*-1);
			this.setDY((getDY()+d.getDY())*-1);
		}
		if(r.intersects(ar)&&r.intersects(dr)){
			if((r.getMinX()<=0) && (r.getMinY()<=0 || r.getMaxY()>=board.WIDTH) ){
				board.ingame=false;
				setDY(0);
				setDX(0);
			}
			if((r.getMaxX()>=board.HEIGHT) && (r.getMinY()<=0 || r.getMaxY()>=board.WIDTH) ){
				board.ingame=false;
				setDY(0);
				setDX(0);
			}
		}
		
		Random rn= new Random();
		int what = rn.nextInt(1000)+1;
		
		if (r.getMinX()<= 0 || r.getMaxX() >= board.WIDTH ||what==42){
			this.setX(0);
			this.setDX(1);
			this.setDY(1);
		}
		if (r.getMinY()<=0 || r.getMaxY() >= board.HEIGHT||what==42) {
			this.setY(0);
			this.setDX(1);
			this.setDY(1);
		}
		
		super.move();
	}
	

}
