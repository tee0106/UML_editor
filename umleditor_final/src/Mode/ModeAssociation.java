package Mode;

import java.awt.Point;
import java.awt.event.*;

import Objects.AssociationLine;
import Objects.LineObj;
import Program.umlCanvas;

public class ModeAssociation extends Mode{
	
	public ModeAssociation(umlCanvas canvas){
		super(canvas);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		selectedObj = detectedInObj(e.getX(), e.getY());
		
		if(selectedObj!=null && selectedObj.getObjName()!="#GroupObj#"){
			startPoint = findPort(selectedObj, e.getX(), e.getY());
			canvas.dragStartPoint = startPoint;
		}
		canvas.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		canvas.dragEndPoint = e.getPoint();
		canvas.repaint();
    }

	@Override
	public void mouseReleased(MouseEvent e) {
		
		selectedTargetObj = detectedInObj(e.getX(), e.getY());
		
		if(selectedObj!=null && selectedTargetObj!=null && selectedTargetObj!=selectedObj
			&& selectedTargetObj.getHeight()>0 && selectedTargetObj.getObjName()!="#GroupObj#"){
			endPoint = findPort(selectedTargetObj, e.getX(), e.getY());
			LineObj line = new AssociationLine(startPoint, endPoint);
			canvas.shapeObj.add(line);
		}
		
		startPoint = null;
		selectedObj = null;
		selectedTargetObj = null;
		canvas.dragStartPoint = null;
		canvas.dragEndPoint = null;
		canvas.repaint();
	}
}
