package Objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class CompositionLine extends LineObj{

	Point portSource, portTarget;
	boolean selected;
	int dy, dx, w = 10, h = 10;
	double D, xm, xn, ym, yn, xp, yp, sin, cos, x;
	
	public CompositionLine(Point portSource, Point portTarget) {
		super();
		this.portSource = portSource;
		this.portTarget = portTarget;
	}

	public void drawShape(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(2));
		g2.setColor( Color.BLACK );
		g2.drawLine(portSource.x, portSource.y, portTarget.x, portTarget.y);
		findArrowPoint(portSource.x, portSource.y, portTarget.x, portTarget.y, w, h);
		int[] xpoints = {portTarget.x, (int) xm, (int) xp, (int) xn};
		int[] ypoints = {portTarget.y, (int) ym, (int) yp, (int) yn};
		g2.setColor( Color.WHITE );
		g2.fillPolygon(xpoints, ypoints, 4);
		g2.setColor( Color.BLACK );
		g2.drawPolygon(xpoints, ypoints, 4);
		g2.setStroke(oldStroke);
		
		// draw 2 dots for ports
		if(selected){
			g.fillRect(portSource.x-5, portSource.y-5, 10, 10);
			g.fillRect(portTarget.x-5, portTarget.y-5, 10, 10);
		}
	}
	
	public void findArrowPoint(int x1, int y1, int x2, int y2, int w, int h){

		dx = x2 - x1;
		dy = y2 - y1;
		D = Math.sqrt(dx*dx + dy*dy);
		xm = D - w;
		xn = xm; 
		ym = h;
		yn = -h;
		sin = dy/D;
		cos = dx/D;
		
		x = xm*cos - ym*sin + x1;
		ym = xm*sin + ym*cos + y1;
		xm = x;
		
		x = xn*cos - yn*sin + x1;
		yn = xn*sin + yn*cos + y1;
		xn = x;
		
		xp = (h*2/D)*x1 + ((D-h*2)/D)*x2;
        yp = (h*2/D)*y1 + ((D-h*2)/D)*y2;

	}
	
	public Point getPortSource() {
		return portSource;
	}

	public Point getPortTarget() {
		return portTarget;
	}

	public void setPortSource(Point port) {
		portSource = port;
	}

	public void setPortTarget(Point port) {
		portTarget = port;
	}

	public int getX() {
		return portSource.x;
	}

	public int getY() {
		return portSource.y;
	}
	
	public int getX2() {
		return portTarget.x;
	}

	public int getY2() {
		return portTarget.y;
	}

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean bool) {
		selected = bool;
	}
	
}