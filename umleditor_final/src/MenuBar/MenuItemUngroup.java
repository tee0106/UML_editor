package MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Objects.GroupObj;
import Objects.ShapeObj;
import Program.umlCanvas;

public class MenuItemUngroup extends JMenuItem {
	
	private umlCanvas canvas;
	
	public MenuItemUngroup(umlCanvas umlcanvas){
		canvas = umlcanvas;
		this.setText("Ungroup");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				for(ShapeObj obj : canvas.shapeObj){
					if(obj.getSelected()==true && obj.getObjList()!=null){
						i++;
					}
				}
				if(i<1){
					JOptionPane.showMessageDialog(canvas, "Please select at least 1 composite object.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					while(i!=0){
						ShapeObj removeObj = null;
						for(ShapeObj obj : canvas.shapeObj){
							if(obj.getSelected()==true && obj.getObjList()!=null){
								removeObj = obj;
							}
						}
						canvas.shapeObj.remove(removeObj);
						canvas.repaint();
						i--;
					}
				}
			}
			
		});
	}
}
