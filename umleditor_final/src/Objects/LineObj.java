package Objects;

import java.awt.Point;

public abstract class LineObj extends ShapeObj {

	Point portSource, portTarget;
	
	public Point getPortSource() {
		return portSource;
	}
	
	public Point getPortTarget() {
		return portTarget;
	}
	
	public void setPortSource(Point port) {}
	
	public void setPortTarget(Point port) {}
	
}
