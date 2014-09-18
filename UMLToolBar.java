import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JToggleButton;
import javax.swing.JToolBar;


@SuppressWarnings("serial")
public class UMLToolBar extends JToolBar {

	private JToggleButton	umlShape_Class = null;
	private JToggleButton	umlShape_Line = null;
	
	UMLToolBar()
	{
		this.setPreferredSize(new Dimension(100, super.getPreferredSize().height));
		this.setLayout(new GridLayout(15, 50, 3, 3));
		
		
		umlShape_Class	= new JToggleButton("Class");
		umlShape_Line		= new JToggleButton("Line");

		umlShape_Class.setFocusable(false);
		umlShape_Line.setFocusable(false);
		
		
		// TODO Add actionListener for toggle buttons so if one is selected and then
		// another toggle button is selected, we ensure all toggle buttons are de-toggled
		// except the one last clicked on. Right now we can toggle all buttons.
		
		this.add(umlShape_Class);
		this.add(umlShape_Line);
		
		this.setFloatable(false);
		
	}
	
	// 
	JToggleButton getUMLShape_Class()
	{
		return umlShape_Class;
	}
	
	
	// TODO Add rest of "getUMLShape_**** toggle buttons - or just add an array list and
	// iterate over it checking the state of the current indexed togglebutton
	
}
