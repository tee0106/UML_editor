package ButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Program.umlCanvas;
import Mode.ModeGeneralization;

public class ButtonGeneralization extends JButton{
	
	private umlCanvas canvas;
	private ButtonPanel panel;
	
	public ButtonGeneralization(umlCanvas umlcanvas, final ButtonPanel panel){
		this.panel = panel;
		canvas = umlcanvas;
		Icon icon = new ImageIcon("img/generalization.png");
	    this.setIcon(icon);
		this.setText("Generalization");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentMode(new ModeGeneralization(canvas));
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
