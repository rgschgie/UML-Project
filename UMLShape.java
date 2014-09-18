import java.awt.Graphics;
import java.awt.Point;

public abstract class UMLShape {
	protected Point ptTopLeft = new Point();
	protected boolean isSelected = false;

	
	UMLShape()
	{
		ptTopLeft.x = 0;
		ptTopLeft.y = 0;
	}
	
	
	UMLShape(int x, int y, boolean selected)
	{
		ptTopLeft.x = x;
		ptTopLeft.y = y;
		isSelected = selected;
	}
	
	public void setSelected(boolean selected)
	{
		isSelected = selected;
	}
	
	public boolean selectedState()
	{
		return isSelected;
	}
	
	
	abstract public void draw(Graphics g);
}
