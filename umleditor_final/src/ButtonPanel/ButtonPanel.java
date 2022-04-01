package ButtonPanel;

import javax.swing.*;

import Objects.ShapeObj;

import java.awt.*;
import Program.umlCanvas;

public class ButtonPanel extends JPanel {
	
	private umlCanvas canvas;
	private JButton select, aLine, gLine, cLine, classObj, usecaseObj;
	
	public ButtonPanel(umlCanvas umlcanvas){
		canvas = umlcanvas;
		this.setLayout(new GridLayout(6, 1));
		
		select = new ButtonSelect(canvas, this);
		select.setBackground(Color.BLACK);
		aLine = new ButtonAssociation(canvas, this);
		gLine = new ButtonGeneralization(canvas, this);
		cLine = new ButtonComposition(canvas, this);
		classObj = new ButtonClassObj(canvas, this);
		usecaseObj = new ButtonUseCaseObj(canvas, this);
		
		this.add(select);
		this.add(aLine);
		this.add(gLine);
		this.add(cLine);
		this.add(classObj);
		this.add(usecaseObj);
	}
	
	public void resetButtons(){
		select.setBackground(null);
		aLine.setBackground(null);
		gLine.setBackground(null);
		cLine.setBackground(null);
		classObj.setBackground(null);
		usecaseObj.setBackground(null);
	}
	
	public void resetSelectedObj(){
		for(ShapeObj currentObj : canvas.shapeObj){
			currentObj.setSelected(false);
		}
		canvas.repaint();
	}
}
