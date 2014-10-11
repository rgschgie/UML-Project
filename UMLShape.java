import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class UMLShape extends JPanel implements MouseListener{
	
	protected boolean isSelected = false;
	protected boolean isSecondSelected = false;
	
	UMLShape(int x, int y, boolean selected)
	{
		this.setLocation(x, y);
		this.setSize(100, 100);

		this.setVisible(true);

		isSelected = selected;
		isSecondSelected = false;
	}
	
	public void setSelected(boolean selected)
	{
		isSelected = selected;
	}
	
	public void setSecondSelected(boolean selected)
	{
		isSecondSelected = selected;
	}
	
	public boolean selectedState()
	{
		return isSelected;
	}

}
