import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.*;

public class Game extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6669730239765138041L;

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	boolean spin = true;
	
	private int score = 0;
	
	private int hits;
	
	private int pspeedmax;
	
	private int bdiff = 1;
	private int pdiff = 3;
	// private boolean canPaint = true;
	
	Point pos2 = new Point(550, 300);
	Point siz2 = new Point(20, 20);
	
	Ball f = new Ball(pos2, siz2, bdiff);
	
	public Game() {
		addKeyListener(new KeyListener() {
			
			@Override
    		public void keyTyped(KeyEvent e) {
    		}
    		
    		@Override
    		public void keyReleased(KeyEvent e) {
    		}
			
    		@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_SPACE) {
    				spin = !spin;
    			/*} else if(keyCode == KeyEvent.VK_LEFT) {
    				spin = false;
    			} else if(keyCode == KeyEvent.VK_RIGHT) {
    				spin = true;*/
    			}
    		}
		});
		setFocusable(true);
	}
	
	public Projectile createProjectileUp(int x, int y) {
		Point pos = new Point(630/2, 652/2);
		Point siz = new Point(x, y);
		int dir = 0;
		Projectile r = new Projectile(pos, siz, dir);
		Random rand = new Random();
		int pdif = rand.nextInt(pspeedmax - 1) + 2;
		r.setDiff(pdif);
		projectiles.add(r);
		return r;
	}

	public Projectile createProjectileUpRight(int x, int y) {
		Point pos = new Point(630/2, 652/2);
		Point siz = new Point(x, y);
		int dir = 1;
		Projectile r = new Projectile(pos, siz, dir);
		Random rand = new Random();
		int pdif = rand.nextInt(pspeedmax - 1) + 2;
		r.setDiff(pdif);
		projectiles.add(r);
		return r;
	}

	public Projectile createProjectileRight(int x, int y) {
		Point pos = new Point(630/2, 652/2);
		Point siz = new Point(x, y);
		int dir = 2;
		Projectile r = new Projectile(pos, siz, dir);
		Random rand = new Random();
		int pdif = rand.nextInt(pspeedmax - 1) + 2;
		r.setDiff(pdif);
		projectiles.add(r);
		return r;
	}

	public Projectile createProjectileDownRight(int x, int y) {
		Point pos = new Point(630/2, 652/2);
		Point siz = new Point(x, y);
		int dir = 3;
		Projectile r = new Projectile(pos, siz, dir);
		Random rand = new Random();
		int pdif = rand.nextInt(pspeedmax - 1) + 2;
		r.setDiff(pdif);
		projectiles.add(r);
		return r;
	}
	
	public Projectile createProjectileDown(int x, int y) {
		Point pos = new Point(630/2, 652/2);
		Point siz = new Point(x, y);
		int dir = 4;
		Projectile r = new Projectile(pos, siz, dir);
		Random rand = new Random();
		int pdif = rand.nextInt(pspeedmax - 1) + 2;
		r.setDiff(pdif);
		projectiles.add(r);
		return r;
	}
	
	public Projectile createProjectileDownLeft(int x, int y) {
		Point pos = new Point(630/2, 652/2);
		Point siz = new Point(x, y);
		int dir = 5;
		Projectile r = new Projectile(pos, siz, dir);
		Random rand = new Random();
		int pdif = rand.nextInt(pspeedmax - 1) + 2;
		r.setDiff(pdif);
		projectiles.add(r);
		return r;
	}

	public Projectile createProjectileLeft(int x, int y) {
		Point pos = new Point(630/2, 652/2);
		Point siz = new Point(x, y);
		int dir = 6;
		Projectile r = new Projectile(pos, siz, dir);r.setDiff(pdiff);
		Random rand = new Random();
		int pdif = rand.nextInt(pspeedmax - 1) + 2;
		r.setDiff(pdif);
		projectiles.add(r);
		return r;
	}
	
	public Projectile createProjectileUpLeft(int x, int y) {
		Point pos = new Point(630/2, 652/2);
		Point siz = new Point(x, y);
		int dir = 7;
		Projectile r = new Projectile(pos, siz, dir);
		Random rand = new Random();
		int pdif = rand.nextInt(pspeedmax - 1) + 2;
		r.setDiff(pdif);
		projectiles.add(r);
		return r;
	}

	public void itPos() {
		if(spin) {
			f.itPosCC();
		} else {
			f.itPosC();
		}
	}
	
	public int getHits() {
		return hits;
	}
	
	public void setHits(int h) {
		this.hits = h;
	}
	
	public void setPSpeedMax(int m) {
		this.pspeedmax = m;
	}
	
	/*public void setDiff(int b, int p) {
		f.speed = b;
		pdiff = p;
	}*/
	
	public boolean getIntersect() {
		return !(this.f.getBounds().intersects(projectiles.get(0).getBounds()));
	}
	
	public int getScore() {
		return score;
	}
	
	public void reset() {
		score = 0;
		// canPaint = true;
	}
	
	public void drawField() {
		Graphics g = getGraphics();
		g.drawOval(50, 50, 250, 250);
	}
	
	public void postScore() {
		String s = String.valueOf(score);
		Graphics g = getGraphics();
		g.setFont(new Font("SansSerif", Font.PLAIN, 20));
		g.drawString("Hits: " + s, 40, 40);
	}
	
	public void postTime(long e) {
		String s = String.valueOf(e/1000);
		Graphics g = getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 24));
		g.drawString("Time: " + s + " seconds", 40, 40);
		//canPaint = false;
	}

	public void paint(Graphics g) {
		//if (canPaint){
			for(int i = 0; i <= projectiles.size() - 1; i++) {
				Projectile r = projectiles.get(0);
				//this.drawField();
				f.paint(g);
				r.itPos();
				r.paint(g);
				if (!(this.getIntersect())) {
					score++;
					if(score < hits) {
						this.postScore();
					} else {
						break;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (r.getPos().x < -20 || r.getPos().y < -10 || r.getPos().x > 630 || r.getPos().y > 652) {
					Random rand = new Random();
					int projdir = rand.nextInt(8);
					if(projdir == 0) {
						this.createProjectileUp(5, 20);
					} else if (projdir == 1) {
						this.createProjectileUpRight(10, 10);
					} else if (projdir == 2) {
						this.createProjectileRight(20, 5);
					} else if(projdir == 3) {
						this.createProjectileDownRight(10, 10);
					} else if(projdir == 4) {
						this.createProjectileDown(5, 20);
					} else if(projdir == 5) {
						this.createProjectileDownLeft(10, 10);
					} else if(projdir == 6) {
						this.createProjectileLeft(20, 5);
					} else if(projdir == 7) {
						this.createProjectileUpLeft(10, 10);
					}
	
					
					projectiles.remove(0);
					i--;
				}
			}
		//}
	}

	
}
