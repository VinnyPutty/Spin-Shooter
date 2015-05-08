import java.awt.*;

import javax.swing.*;

public class Projectile extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7418400254886232473L;
	
	private Point pos;
	private Point siz;
	private int dir;
	private int speed;
	
	public Projectile(Point position, Point size, int direction) {
		setPos(position);
		setSiz(size);
		setDir(direction);
	}
	
	public void itPos() {
		if(dir == 0) {
			this.itPosUp();
		} else if (dir == 1) {
			this.itPosUpRight();
		} else if (dir == 2) {
			this.itPosRight();
		} else if(dir == 3) {
			this.itPosDownRight();
		} else if(dir == 4) {
			this.itPosDown();
		} else if(dir == 5) {
			this.itPosDownLeft();
		} else if(dir == 6) {
			this.itPosLeft();
		} else if(dir == 7) {
			this.itPosUpLeft();
		}
		
		
	}
	
	public Point getPos() {
		return pos;
	}
	
	public Point getSizeItem() {
		return siz;
	}
	
	public int getDir() {
		return dir;
	}
	
	public void setPos(Point position) {
		this.pos = position;
	}
	
	public void setSiz(Point size) {
		this.siz = size;
	}
	
	public void setDir(int direction) {
		this.dir = direction;
	}
	
	public void setDiff(int difficulty) {
		this.speed = difficulty;
	}
	
	private Point itPosUp() {
		this.pos.translate(0, -speed);
		return pos;
	}
	
	private Point itPosDown() {
		this.pos.translate(0, speed);
		return pos;
	}
	
	private Point itPosLeft() {
		this.pos.translate(-speed, 0);
		return pos;
	}
	
	private Point itPosRight() {
		this.pos.translate(speed, 0);
		return pos;
	}

	private Point itPosUpLeft() {
		this.pos.translate(-speed, -speed);
		return pos;
	}

	private Point itPosUpRight() {
		this.pos.translate(speed, -speed);
		return pos;
	}

	private Point itPosDownLeft() {
		this.pos.translate(-speed, speed);
		return pos;
	}

	private Point itPosDownRight() {
		this.pos.translate(speed, speed);
		return pos;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.pos.x, this.pos.y, this.siz.x, this.siz.y);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillRect(this.pos.x, this.pos.y, this.siz.x, this.siz.y);
	
	}
	
}