import java.awt.*;
import javax.swing.*;

public class Ball extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -975677487485522349L;
	
	private double theta;
	private Point pos;
	private Point siz;
	public int speed;
	
	public Ball(Point position, Point size, int difficulty) {
		setPos(position);
		setSiz(size);
		setDiff(difficulty);
	}
	
	public Point getPos() {
		return pos;
	}
	
	public Point getSizeItem() {
		return siz;
	}
	
	public void setPos(Point position) {
		this.pos = position;
	}
	
	public void setSiz(Point size) {
		this.siz = size;
	}
	
	public void setDiff(int difficulty) {
		this.speed = difficulty;
	}
	
	public void itPosCC() {
		this.theta = this.theta + Math.toRadians(-speed);
		this.pos.x = 300 + (int) (250 * Math.cos(this.theta));
		this.pos.y = 300 + (int) (250 * Math.sin(this.theta));
	}
	
	public void itPosC() {
		this.theta = this.theta + Math.toRadians(speed);
		this.pos.x = 300 + (int) (250 * Math.cos(this.theta));
		this.pos.y = 300 + (int) (250 * Math.sin(this.theta));
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.pos.x, this.pos.y, this.siz.x - 1, this.siz.y - 1);
	}
	
	public void paint(Graphics g) {
		g.fillOval(this.pos.x, this.pos.y, this.siz.x, this.siz.y);
	
	}
	
}
