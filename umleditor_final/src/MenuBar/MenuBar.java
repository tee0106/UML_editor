package MenuBar;

import javax.swing.*;
import java.awt.*;
import Program.umlCanvas;

public class MenuBar extends JMenuBar {
	
	private umlCanvas canvas;
	JMenu menuFile, menuEdit;
	
	public MenuBar(umlCanvas umlcanvas){
		canvas = umlcanvas;
		menuFile = new MenuFile(canvas);
		menuEdit = new MenuEdit(canvas);
		this.add(menuFile);
		this.add(menuEdit);
	}
}
