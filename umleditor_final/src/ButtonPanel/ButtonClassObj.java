package ButtonPanel;

import javax.swing.*;

import Mode.ModeSelect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Program.umlCanvas;
import Mode.ModeClass;

public class ButtonClassObj extends JButton{
	
	private umlCanvas canvas;
	private ButtonPanel panel;
	
	public ButtonClassObj(umlCanvas umlcanvas, final ButtonPanel panel){
		this.panel = panel;
		canvas = umlcanvas;
		Icon icon = new ImageIcon("img/class.png");
	    this.setIcon(icon);
		this.setText("Class");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentMode(new ModeClass(canvas));
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
