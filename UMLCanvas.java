import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class UMLCanvas extends JPanel implements MouseListener {

	@SuppressWarnings("unused")
	private Image img = null; 	// We Can load an image to use as our background, 
	// perhaps an image with 'dots' for 'alignment' purposes?


	static final int Z_TOP_CHILD 	= 0;
	private static UMLShape lastSelectedShape = null;
	private static UMLShape secondSelectedShape = null;

	private UMLToolBar umlToolBar = null; // Used to track state of the toggle buttons (better way perhaps?)
	private UMLPopupMenu umlPopupMenu = null;	


	UMLCanvas()
	{
		// TODO Initialization code as needed

		umlPopupMenu = new UMLPopupMenu();
		addMouseListener(this);


		this.setBackground(Color.WHITE);
		this.setLayout(null);


	}


	// Overload to set the background image to draw in paint update if we wish to add
	// a dotted background on the canvas
	UMLCanvas(Image imgObject)
	{
		img = imgObject;
	}



	public void setUMLToolBar(UMLToolBar toolbar)
	{
		umlToolBar = toolbar;
	}

	public void setSecondSelected(UMLShape s)
	{
		secondSelectedShape = s;
	}

	public UMLShape getSecondSelected()
	{
		return secondSelectedShape;
	}

	public void setLastSelected(UMLShape s)
	{
		lastSelectedShape = s;
	}

	public UMLShape getLastSelected()
	{
		return lastSelectedShape;
	}


	public void updateSelectedShape(UMLShape newSelectedShape)
	{
		if (umlToolBar.getBtnShape_Class().isSelected())
		{
			if(newSelectedShape == null)
			{
				System.out.println("newSelected == null");
				return;
			}

			// If this is the same shape as last time bail out
			if (newSelectedShape == lastSelectedShape)
			{
				System.out.println("newSelectedShape == lastSelectedShape");
				return;
			}


			if (lastSelectedShape != null)
			{
				System.out.println("lastSelectedShape != null");

				// Update the last selected shape's selected state to false
				lastSelectedShape.setSelected(false);
			}

			if (secondSelectedShape == null)
			{
				System.out.println("secondSelectedShape == null");


			}

			System.out.println("before update");

			// Update the new selected shape's z order and set it's selected state to true
			this.setComponentZOrder(newSelectedShape, Z_TOP_CHILD);
			newSelectedShape.setSelected(true);


			System.out.println("before last selected update");
			// Set the new lastSelectedState
			lastSelectedShape = newSelectedShape;

			// repaint
			this.repaint();

			System.out.println("lastSelectedShape = " + lastSelectedShape);

		}

		if(umlToolBar.getBtnShape_Line().isSelected())
		{
			if (lastSelectedShape != null && secondSelectedShape == null)
			{	
				//second shape is the same as the first
				if (lastSelectedShape == newSelectedShape)
				{
					System.out.println("lastSelectedShape == newSelectedShape");
					return;
				}
				// second shape is different from first, 
				if (lastSelectedShape != newSelectedShape)
				{
					System.out.println("First is selected, second isn't");
					secondSelectedShape = newSelectedShape;
					System.out.println("Now second shape selected");
					this.setComponentZOrder(newSelectedShape, Z_TOP_CHILD);
					
					
					if (lastSelectedShape != null && secondSelectedShape != null)
					{
						System.out.println("Reached Here");
						
						System.out.println("Coordinates for lastSeletedShape: " +lastSelectedShape.getX() +  " , " + lastSelectedShape.getY());
						System.out.println("Coordinates for secondSeletedShape: " +secondSelectedShape.getX() +  " , " + secondSelectedShape.getY());
						
						
						this.add(new UMLLine(lastSelectedShape.getX(), lastSelectedShape.getY(), secondSelectedShape.getX(), secondSelectedShape.getY(), this));
						
						
						System.out.println("Reached Here");
						this.repaint();
						
						
					
						
						
						//System.out.println("Coordinates for lastSeletedShape: " +lastSelectedShape.getX() +  " , " + lastSelectedShape.getY());
						//System.out.println("Coordinates for secondSeletedShape: " +secondSelectedShape.getX() +  " , " + secondSelectedShape.getY());
						
					}
					newSelectedShape = null;
					secondSelectedShape = null;
					return;

				}
				
			}
			// check to see if its the first shape
			if (lastSelectedShape == null && secondSelectedShape == null)
			{
				System.out.println("No Shapes Selected");
				lastSelectedShape = newSelectedShape;
				System.out.println("First shape is selected");
				this.setComponentZOrder(newSelectedShape, Z_TOP_CHILD);
			}

			// first shape is occupied, check to see if second shape and occupy it

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			for (int i = 0; i < this.getComponentCount(); ++i ){
			System.out.println(this.getComponent(i));
			}
			
			this.repaint();
		}
		
		
		if(e.getButton() == MouseEvent.BUTTON1 && umlToolBar != null)
		{

			// Check if there is a child at this location first
			Component c = this.findComponentAt(e.getX(), e.getY());
			System.out.println("x: " + e.getX() + " y: " + e.getY() + "  findComponentAt.class = " + c.getClass());

			// If the left mouse click is inside the canvas object .. check if any toggle buttons are selected
			// if so create a new object at the mouse position
			if(c.getClass() == this.getClass())
			{
				// TODO Do a loop and take the correct action based on the toggled button
				// umlToolBar.getToggledButtons(); <-- add toggle buttons to an array list

				// One for now - add more later
				// Check if the class toggle button is selected

				if(umlToolBar.getBtnShape_Class().isSelected())
				{
					this.add(new UMLShape_Class(e.getX(), e.getY(), false));
					this.repaint();										

					// De-select the class shape? or leave toggled to create more class objects?
					// Design decision we need to decide on.
				}
			}

			// If the class at the location x,y is of a UMLShape, set it's selection to true
			else if(c instanceof UMLShape)
			{
				updateSelectedShape((UMLShape)c);
			}
		}
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		showPopup(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
		//showPopup(e);

	}

	private void showPopup(MouseEvent e)
	{
		if(e.isPopupTrigger())
		{
			umlPopupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	}
	
	
	
	
	

