package Mode;

import java.awt.event.*;

import Objects.*;
import Program.umlCanvas;

public class ModeClass extends Mode{
	
	public ModeClass(umlCanvas canvas){
		super(canvas);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mouseClicked(e);
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			BasicObj obj = new ClassObj(e.getX(), e.getY(), canvas);
			obj.setPort();
			canvas.shapeObj.add(obj);
			canvas.repaint();
		}
	}
	
}
