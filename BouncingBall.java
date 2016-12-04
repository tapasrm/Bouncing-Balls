import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

class Ball  {
	int x,y,radius,x1,y1;
	Color BallColor;
	public Ball(int x, int y, int radius, int x1, int y1, Color bcolor)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.x1 = x1;
		this.y1 = y1;
		BallColor = bcolor;
	}
}
public class BouncingBall extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2577897787488150740L;
	Ball redball, blueball;
	public void init()  {
		redball = new Ball(80,80,20,2,3,Color.red);
		blueball = new Ball(40,40,20,2,3,Color.blue);
		Thread t=new Thread(this);
		t.start();
	}
	public void paint(Graphics g) {
		g.setColor(redball.BallColor);
		g.fillOval(redball.x, redball.y, redball.radius, redball.radius);
		g.setColor(blueball.BallColor);
		g.fillOval(blueball.x, blueball.y, blueball.radius, blueball.radius);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				bounce(redball);
				bounce(blueball);
				Thread.sleep(10);
				
			}catch(Exception e){ }
		}
	}
	public void bounce(Ball b) {
		if(b.y>=200 || b.y<=0)
			b.y1=-b.y1;
		if(b.x>=200 || b.x<=0)
			b.x1=-b.x1;
		b.y=b.y-b.y1;
		b.x=b.x-b.x1;
	}
}
