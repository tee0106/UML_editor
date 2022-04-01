package ButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Program.umlCanvas;
import Mode.ModeAssociation;
import Objects.ShapeObj;

public class ButtonAssociation extends JButton{
	
	private umlCanvas canvas;
	private ButtonPanel panel;
	
	public ButtonAssociation(umlCanvas umlcanvas, final ButtonPanel panel){
		this.panel = panel;
		canvas = umlcanvas;
		Icon icon = new ImageIcon("img/association.png");
	    this.setIcon(icon);
		this.setText("Association");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentMode(new ModeAssociation(canvas));
				panel.resetSelectedObj();
				panel.resetButtons();
				ButtonClicked();
			}
			
		});
	}
	
	public void ButtonClicked(){
		this.setBackground(Color.BLACK);
	}
}
