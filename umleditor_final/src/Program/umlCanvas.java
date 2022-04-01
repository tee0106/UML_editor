package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.*;

import Mode.Mode;
import Mode.ModeSelect;
import Objects.*;

public class umlCanvas extends JPanel{

	private static umlCanvas instance;
	private Mode currentMode;
	private umlMouseListener mouseListener;
	public ArrayList<ShapeObj> shapeObj = new ArrayList<ShapeObj>();
	public Rectangle selectionRect;
	public Point dragStartPoint, dragEndPoint;
	
	private umlCanvas(){
		
	}
	
	public static umlCanvas getInstance() {
		 if(instance == null) {
	         instance = new umlCanvas();
	     }
	     return instance;
	}
	
	public void initCanvas(){
		
		setBackground(Color.white);
		setVisible(true);
		
		currentMode = new ModeSelect(this);
		mouseListener = new umlMouseListener(this, currentMode);
		addMouseMotionListener(mouseListener);		 
	    addMouseListener(mouseListener);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(ShapeObj obj: shapeObj){ //draw all objects
			obj.drawShape(g);
		}
		
		Graphics2D g2d = (Graphics2D) g;
		// draw selection rectangle when dragging mouse
		if(selectionRect != null){
			g2d.setColor( new Color(200, 200, 200, 50) );
			g2d.fillRect(selectionRect.x, selectionRect.y, selectionRect.width, selectionRect.height);
			g2d.setColor( Color.BLACK );
			g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
			g2d.draw(selectionRect);
		}
		// draw line when dragging mouse
		else if(dragStartPoint!=null && dragEndPoint!=null){
			Stroke oldStroke = g2d.getStroke();
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor( Color.BLACK );
			g2d.drawLine(dragStartPoint.x, dragStartPoint.y, dragEndPoint.x, dragEndPoint.y);
			g2d.setStroke(oldStroke);
		}
	}
	
	public void setCurrentMode(Mode newMode){
		currentMode = newMode;
		this.removeMouseListener(mouseListener);
		this.removeMouseMotionListener(mouseListener);
		mouseListener = new umlMouseListener(this, currentMode);
		addMouseMotionListener(mouseListener);		 
	    addMouseListener(mouseListener);
	}
	
	public ArrayList<ShapeObj> getObjList() {
		return shapeObj;
	}
}
