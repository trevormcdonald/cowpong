import java.awt.EventQueue;
import javax.swing.JFrame;


public class Application extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private int width=750;
	private int height=750;
	
	public Application() {
		
		initUI();
	}
	
	private void initUI(){
		
		add(new Board());
		
		setResizable(false);
		pack();
		
		setSize(width, height);
		
		setTitle("Cow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				Application ex= new Application();
				ex.setVisible(true);
			}
		});

	}

}
