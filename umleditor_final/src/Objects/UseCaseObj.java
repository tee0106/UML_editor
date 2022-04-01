package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Program.umlCanvas;

public class UseCaseObj extends BasicObj{

	int W = 150, H = 100, portSize = 10;
	int posX, posY;
	boolean selected;
	String objName = "";
	
	public Point[] port; //0:Up, 1:Down, 2:Left, 3:Right
	
	umlCanvas canvas;

	public UseCaseObj(int posX, int posY, umlCanvas canvas) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.canvas = canvas;
	}

	public void drawShape(Graphics g) {
		g.setColor(new Color(220, 220, 220));
		g.fillOval(posX, posY, W, H);
		g.setColor( Color.BLACK );
		g.drawOval(posX, posY, W, H);
		g.drawString(objName, posX+W/5, posY+H/2);
		
		// draw 4 dots for ports
		if(selected){
			g.fillRect(posX+(W/2-5), posY-5, portSize, portSize);
			g.fillRect(posX-5, posY+(H/2-5), portSize, portSize);
			g.fillRect(posX+(W/2-5), posY+(H-5), portSize, portSize);
			g.fillRect(posX+(W-5), posY+(H/2-5), portSize, portSize);
		}
	}
	
	public void setPort() {
		//0:Up, 1:Down, 2:Left, 3:Right
		port = new Point[4];
		port[0] = new Point(posX+W/2, posY);
		port[1] = new Point(posX+W/2, posY+H);
		port[2] = new Point(posX, posY+H/2);
		port[3] = new Point(posX+W, posY+H/2);
	}

	public void setPortToNewPos() {
		port[0].setLocation(posX+W/2, posY);
		port[1].setLocation(posX+W/2, posY+H);
		port[2].setLocation(posX, posY+H/2);
		port[3].setLocation(posX+W, posY+H/2);
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public void setX(int newX) {
		posX = newX;	
	}

	public void setY(int newY) {
		posY = newY;		
	}

	public int getWidth() {
		return W;
	}

	public int getHeight() {
		return H;
	}

	public Point[] getport() {
		return port;
	}

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean bool) {
		selected = bool;
	}

	public int getX2() {
		return 0;
	}

	public int getY2() {
		return 0;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String name) {
		objName = name;
	}
	
}
