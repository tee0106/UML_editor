package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Program.umlCanvas;

public class GroupObj extends BasicObj{

	int posX, posY, W, H;
	boolean selected;
	String objName = "#GroupObj#";
	ArrayList<ShapeObj> groupObjList = new ArrayList<ShapeObj>();
	
	public Point[] port; //0:Up, 1:Down, 2:Left, 3:Right
	
	public umlCanvas canvas;
	
	public GroupObj(umlCanvas canvas) {
		super();
		this.canvas = canvas;
	}
	
	public void addtoGroupObj(ShapeObj shapeObj){
		groupObjList.add(shapeObj);
	}
	
	public void drawShape(Graphics g) {
		g.setColor( Color.BLACK );
		g.drawRect(posX, posY, W, H);
		g.setColor( new Color(200, 200, 200, 20) );
		g.fillRect(posX, posY, W, H);
		
		if(selected){
			g.setColor( Color.BLUE );
			g.drawRect(posX, posY, W, H);
			g.setColor( new Color(0, 0, 200, 20) );
			g.fillRect(posX, posY, W, H);
		}
	}
	
	public void findGroupObjSize(){
		
		//find the most Left Top Point, the most Right Point.x, the most Bottom Point.y
		//to draw the Group Rectangle
		
		int mostRight, mostDown;
		Point[] objPort;
		
		posX = Integer.MAX_VALUE; 
		posY = Integer.MAX_VALUE; 
		mostRight = Integer.MIN_VALUE;
		mostDown = Integer.MIN_VALUE;
		
		for(ShapeObj obj : groupObjList){
			
			if(obj.getHeight() > 0){ 	//ignore line objects
				objPort = obj.getport();
				
				if(obj.getX() < posX){
					posX = obj.getX();
				}
				if(obj.getY() < posY){
					posY = obj.getY();
				}
				if(objPort[3].x > mostRight){
					mostRight = objPort[3].x;
				}
				if(objPort[1].y > mostDown){
					mostDown = objPort[1].y;
				}
			}
		}
		
		W = mostRight - posX;
		H = mostDown - posY;
	}
	
	public void moveGroupMembers(int dx, int dy){
		
		for(ShapeObj objInGroup : groupObjList){
			objInGroup.setX(objInGroup.getX() + dx);
			objInGroup.setY(objInGroup.getY() + dy);
			objInGroup.setPortToNewPos();
			canvas.repaint();
		}
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

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean bool) {
		selected = bool;
	}

	public String getObjName() {
		return objName;
	}
	
	public void unselectMembers() {
		for(ShapeObj objINGroup : groupObjList){
			objINGroup.setSelected(false);
		}
	}

	public void sortMembers() {
		int i = 0;
		for(ShapeObj objINGroup : groupObjList){
			for(ShapeObj currentObj : canvas.shapeObj){
				if(currentObj == objINGroup){
					break;
				}
				i++;
			}
			canvas.shapeObj.remove(this);
			canvas.shapeObj.remove(i);
			canvas.shapeObj.add(objINGroup);
			canvas.shapeObj.add(this);
			i = 0;
		}
	}

	public ArrayList<ShapeObj> getObjList() {
		return groupObjList;
	}

}
