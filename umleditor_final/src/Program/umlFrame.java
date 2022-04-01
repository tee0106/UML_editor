package Program;

import javax.swing.*;
import java.awt.*;
import MenuBar.*;
import MenuBar.MenuBar;
import ButtonPanel.ButtonPanel;

public class umlFrame extends JFrame{

	private umlCanvas canvas;
	
	public void setumlFrame(){
		canvas = umlCanvas.getInstance();
		canvas.initCanvas();
		this.setTitle("UML Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 800);
		
		this.setLayout(new BorderLayout());
		this.add(new MenuBar(canvas), BorderLayout.NORTH);
		this.add(new ButtonPanel(canvas), BorderLayout.WEST);  
		this.add(canvas, BorderLayout.CENTER);
		this.getContentPane().add(canvas);
		this.setVisible(true);
	}
}
