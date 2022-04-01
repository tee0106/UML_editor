package Objects;

import java.util.ArrayList;
import java.util.List;

public class Port {
	
	public int x, y;
	
	public Port(int X, int Y){
		super();
		this.x = X;
		this.y = Y;
	}
	
	public void setLocation(int newX, int newY){
		this.x = newX;
		this.y = newY;
	}
}
