import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class UMLCanvas extends JPanel implements MouseListener {

	private Image img = null; 	// We Can load an image to use as our background, 
								// perhaps an image with 'dots' for 'alignment' purposes?
	
	private UMLToolBar umlToolBar = null; // Used to track state of the toggle buttons (better way perhaps?)
	private UMLPopupMenu umlPopupMenu;	
	private ArrayList<UMLShape> umlShapes = new ArrayList<UMLShape>();
	
	UMLCanvas()
	{
		// TODO Initialization code as needed
		
		umlPopupMenu = new UMLPopupMenu();
		addMouseListener(this);
		
		
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
	
	
	public void paint(Graphics g)
	{
		
		if(img != null)
		{
			g = img.getGraphics();
			g.drawImage(img, 0,  0,  null);			
		}
		else
		{
			g.setColor(Color.white);
			g.drawRect(0, 0, this.getBounds().width, this.getBounds().height);
			
			g.setColor(Color.BLACK);
			g.drawRoundRect(50,  50, 100, 100, 10, 10);
		}
		
			
		for(int i = 0; i < umlShapes.size(); i++)
		{
			umlShapes.get(i).draw(g);
		}
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

		if(umlToolBar != null)
		{
			// TODO Do a loop and take the correct action based on the toggled button
			// umlToolBar.getToggledButtons(); <-- add toggle buttons to an array list
			
			// Check if the class toggle button is selected
			if(umlToolBar.getUMLShape_Class().isSelected())
			{
				
			
				umlShapes.add(new UMLShape_Class(e.getX(), e.getY(), false));
				this.invalidate();
				this.paint(this.getGraphics());
				
								
				// De-select the class shape? or leave toggled to create more class objects?
				// Design decision we need to decide on.
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
		showPopup(e);
		
	}

	private void showPopup(MouseEvent e)
	{
		if(e.isPopupTrigger())
		{
			umlPopupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}
