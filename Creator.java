import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Creator extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1579073538329576288L;

	static Game game = new Game();
	
	static int score = 0;
    
	static int hits = 5;
	
	static int pspeedmax = 5;
	
	//create frame
	public static void main(String args[]) throws InterruptedException{
		
		
		
		JFrame frame = new JFrame();
		
		/*Scanner i = new Scanner(System.in);
		
		System.out.print("Ball Difficulty: ");
		int b = i.nextInt();
		System.out.print("Projectile Difficulty: ");
		int p = i.nextInt();
		
		game.setDiff(b, p);*/
		
		frame.add(game);
		
		frame.setSize(630, 652);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    Graphics g = frame.getGraphics();
		g.setColor(Color.BLACK);
		
		
		gameInit(frame);
		
	}
	
	
	//starts game
	public static void gameInit(JFrame frame) throws InterruptedException {
		
		boolean began = false;
		
		//game.drawField();
		game.setHits(hits);
		game.setPSpeedMax(pspeedmax);
		game.createProjectileLeft(20, 5);
		
		
		
		JOptionPane.showMessageDialog(frame, "Ready? Get " + hits + " Hits", "Start", JOptionPane.YES_NO_OPTION);
		
		Thread.sleep(1000);
		
		if(began) {
			for(int i = 0; i < 20; i++) {
				game.itPos();
				game.repaint();
			}
		} 
		
		long s = System.currentTimeMillis();
		
		while (game.getScore() < game.getHits()) {
			game.itPos();
			game.repaint();
			
			Thread.sleep(5);
		}
		
		long e = System.currentTimeMillis() - s;
				
		game.postTime(e);
		
		Thread.sleep(1000);
		
		//allow restart and exit
		int choice = JOptionPane.showConfirmDialog(frame, "Try Again?", "Game Over", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			game.reset();
			began = true;
			gameInit(frame);
			//System.exit(0);
		} else {
			System.exit(ABORT);
		}
	}
}