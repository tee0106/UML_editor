package Program;

import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import Program.umlCanvas;
import Mode.Mode;

public class umlMouseListener extends MouseInputAdapter {

	private umlCanvas canvas;
	private Mode currentMode;
	
	public umlMouseListener(umlCanvas umlcanvas, Mode mode){
		canvas = umlcanvas;
		currentMode = mode;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentMode.mousePressed(e);	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
    	currentMode.mouseDragged(e);
    }
	
	@Override
	public void mouseReleased(MouseEvent e) {
		currentMode.mouseReleased(e);
	}
	
}
