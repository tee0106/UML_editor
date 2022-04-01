package MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Objects.GroupObj;
import Objects.ShapeObj;
import Program.umlCanvas;

public class MenuItemGroup extends JMenuItem {

	private umlCanvas canvas;
	
	public MenuItemGroup(umlCanvas umlcanvas){
		canvas = umlcanvas;
		this.setText("Group");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				for(ShapeObj selectedobj : canvas.shapeObj){
					if(selectedobj.getSelected()==true && selectedobj.getHeight()>0){
						i++;
					}
				}
				if(i>1){
					GroupObj groupObj = new GroupObj(canvas);
					for(ShapeObj obj : canvas.shapeObj){
						if(obj.getSelected()==true){
							groupObj.addtoGroupObj(obj);
						}
					}
					groupObj.findGroupObjSize();
					groupObj.setPort();
					canvas.shapeObj.add(groupObj);
					groupObj.setSelected(true);
				}
				else{
					JOptionPane.showMessageDialog(canvas, "Please select at least 2 objects.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				canvas.repaint();	
			}
			
		});
	}
}
