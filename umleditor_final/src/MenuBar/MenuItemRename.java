package MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Program.umlCanvas;
import Objects.*;

public class MenuItemRename extends JMenuItem {
	
	private umlCanvas canvas;
	
	public MenuItemRename(umlCanvas umlcanvas){
		canvas = umlcanvas;
		this.setText("Change object name");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				for(ShapeObj selectedobj : canvas.shapeObj){
					if(selectedobj.getSelected()==true){
						i++;
					}
				}
				if(i>0){
					String reName = JOptionPane.showInputDialog("Please type new name");
					for(ShapeObj obj : canvas.shapeObj){
						if(obj.getSelected()==true && reName != null){
							obj.setObjName(reName);
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(canvas, "Please select an object.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				canvas.repaint();	
			}
			
		});
	}
}
