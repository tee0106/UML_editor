package Mode;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;

import Objects.ShapeObj;
import Program.umlCanvas;

public class ModeSelect extends Mode{
	
	public ModeSelect(umlCanvas canvas){
		super(canvas);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		startPoint = e.getPoint();
		canvas.selectionRect = new Rectangle();
		
		if(detectedInObj(startPoint.x, startPoint.y)!=null){
			selectedObj = detectedInObj(startPoint.x, startPoint.y);
		}
		else if(detectedInLine(startPoint.x, startPoint.y)!=null){
			selectedObj = detectedInLine(startPoint.x, startPoint.y);
		}
		
		for(ShapeObj currentObj : canvas.shapeObj){
			currentObj.setSelected(false);
		}
		if(selectedObj!=null){
			int i = 0;
			for(ShapeObj currentObj : canvas.shapeObj){
				if(currentObj == selectedObj){
					currentObj.setSelected(true);
					break;
				}
				i++;
			}
			//sort the shapes to top
			canvas.shapeObj.add(selectedObj);
			canvas.shapeObj.remove(i);
			selectedObj.sortMembers();
		}
		canvas.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		endPoint = e.getPoint();
		
		if(selectedObj!=null){
			int dx = endPoint.x - startPoint.x;
			int dy = endPoint.y - startPoint.y;
			selectedObj.moveGroupMembers(dx, dy);
			selectedObj.setX(selectedObj.getX() + dx);
			selectedObj.setY(selectedObj.getY() + dy);
			selectedObj.setPortToNewPos();
			startPoint = endPoint;
		}
		else{
			int x = Math.min(startPoint.x, endPoint.x);
			int y = Math.min(startPoint.y, endPoint.y);
			int width = Math.abs(startPoint.x - endPoint.x);
			int height = Math.abs(startPoint.y - endPoint.y);
			canvas.selectionRect.setBounds(x, y, width, height);
		}
		canvas.repaint();
    }
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		selectedObj = null;
		
		for(ShapeObj obj : canvas.shapeObj){
			
			Point pSrc = new Point(obj.getX(), obj.getY());
			Point pTar = new Point(obj.getX2(), obj.getY2());
			
			//select class, use case and group objects
			if(canvas.selectionRect.contains(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight())){
				obj.setSelected(true);
			}
			//select line
			else if(canvas.selectionRect.contains(pSrc) && canvas.selectionRect.contains(pTar) && obj.getHeight()==0){
				obj.setSelected(true);
			}
			//unselect the objects in group when the group is unselected
			if(obj.getSelected()==false){
				obj.unselectMembers();
			}
		}
		
		canvas.selectionRect = null;
		canvas.repaint();
	}
	
}
