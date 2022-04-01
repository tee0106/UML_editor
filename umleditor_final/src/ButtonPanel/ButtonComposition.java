package ButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Program.umlCanvas;
import Mode.ModeComposition;

public class ButtonComposition extends JButton{
	
	private umlCanvas canvas;
	private ButtonPanel panel;
	
	public ButtonComposition(umlCanvas umlcanvas, final ButtonPanel panel){
		this.panel = panel;
		canvas = umlcanvas;
		Icon icon = new ImageIcon("img/composition.png");
	    this.setIcon(icon);
		this.setText("Composition");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentMode(new ModeComposition(canvas));
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