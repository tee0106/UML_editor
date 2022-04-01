package Mode;

import javax.swing.event.*;

import java.awt.Point;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.*;
import Program.umlCanvas;
import Objects.ClassObj;
import Objects.LineObj;
import Objects.Port;
import Objects.ShapeObj;
import Objects.UseCaseObj;

public class Mode extends MouseInputAdapter {
	
	public umlCanvas canvas;
	public ShapeObj selectedObj, selectedTargetObj;
	public Point startPoint,endPoint;
	
	public Mode(umlCanvas umlcanvas){
		canvas = umlcanvas;
	}
	
	public ShapeObj detectedInObj(int mouseX, int mouseY){
    	ShapeObj detectedObj = null;
    	for(ShapeObj obj : canvas.shapeObj){
    		if( obj.getX() < mouseX && mouseX < obj.getX() + obj.getWidth()
    			&& obj.getY() < mouseY && mouseY < obj.getY() + obj.getHeight() 
    			&& obj.getWidth()>0 && obj.getHeight()>0 )
    		{
    			detectedObj = obj;
    		}
    	}
    	return detectedObj;
    }
	
	public ShapeObj detectedInLine(int mouseX, int mouseY){
		ShapeObj detectedObj = null;
    	for(ShapeObj obj : canvas.shapeObj){
    		Line2D line = new Line2D.Double(obj.getX(), obj.getY(), obj.getX2(), obj.getY2());
			double lineDistance = line.ptLineDist(mouseX, mouseY);
			if(lineDistance < 3){
				detectedObj = obj;
			}
    	}
    	return detectedObj;
    }
	
	//find the nearest port in the object
	public Point findPort(ShapeObj obj, int X, int Y)
	{
		Point[] linkPort = obj.getport();
		int dx, dy, Di = 0;
		double Dmin = Integer.MAX_VALUE;
		
		for(int i=0; i<linkPort.length; i++){
			dx = X - linkPort[i].x;
			dy = Y - linkPort[i].y;
			if(Dmin > Math.sqrt(dx*dx + dy*dy)){
				Di = i;
				Dmin = Math.sqrt(dx*dx + dy*dy);
			}
		}
		
		return linkPort[Di];
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
    	
    }

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
}
