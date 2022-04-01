package MenuBar;

import javax.swing.*;
import Program.umlCanvas;

public class MenuFile extends JMenu {
		
	private umlCanvas umlcanvas;
	
	public MenuFile(umlCanvas canvas){
		umlcanvas = canvas;
		this.setText("File");
	}
}
