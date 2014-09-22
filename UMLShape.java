import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class UMLShape extends JPanel implements MouseListener{
	
	protected boolean isSelected = false;
	
	UMLShape(int x, int y, boolean selected)
	{
		this.setLocation(x, y);
		this.setSize(100, 100);

		this.setVisible(true);

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

}
