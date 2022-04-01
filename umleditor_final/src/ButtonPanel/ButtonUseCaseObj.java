package ButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Program.umlCanvas;
import Mode.ModeUseCase;

public class ButtonUseCaseObj extends JButton{
	
	private umlCanvas canvas;
	private ButtonPanel panel;
	
	public ButtonUseCaseObj(umlCanvas umlcanvas, final ButtonPanel panel){
		this.panel = panel;
		canvas = umlcanvas;
		Icon icon = new ImageIcon("img/usecase.png");
	    this.setIcon(icon);
		this.setText("Use Case");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setCurrentMode(new ModeUseCase(canvas));
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
