package MenuBar;

import javax.swing.*;
import Program.umlCanvas;

public class MenuEdit extends JMenu {

	private umlCanvas umlcanvas;
	private JMenuItem group, ungroup, rename;
	
	public MenuEdit(umlCanvas canvas){
		umlcanvas = canvas;
		this.setText("Edit");
		group = new MenuItemGroup(canvas);
		ungroup = new MenuItemUngroup(canvas);
		rename = new MenuItemRename(canvas);
		this.add(group);
		this.add(ungroup);
		this.add(rename);
	}
}
