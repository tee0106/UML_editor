package Objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class ShapeObj {
	int x, y, x2, y2, W, H;
	boolean selected;
	String objName = "";
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getY2() {
		return y2;
	}
	
	public int getWidth() {
		return W;
	}
	
	public int getHeight() {
		return H;
	}
	
	public Point[] getport() {
		return null;
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	public String getObjName() {
		return objName;
	}
	
	public ArrayList<ShapeObj> getObjList() {
		return null;
	}
	
	public void setX(int newX) {}
	
	public void setY(int newY) {}
	
	public void setPort() {}
	
	public void setPortToNewPos() {}
	
	public void setSelected(boolean bool) {}
	
	public void setObjName(String name) {}
	
	public void drawShape(Graphics g) {}
	
	public void moveGroupMembers(int dx, int dy) {}
	
	public void unselectMembers() {}
	
	public void sortMembers() {}
	
}
