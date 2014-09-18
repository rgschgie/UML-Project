import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JTextArea;


public class UMLShape_Class extends UMLShape implements MouseListener{
	
	private JTextArea classText = new JTextArea("Class Name\nFunctions\nVariables");
	
	UMLShape_Class(int x, int y, boolean selected)
	{
		super(x, y, selected);	
		classText.setBounds(x, y, 95, 95);
		classText.setVisible(true);
	}

		
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.isSelected = true;
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		isSelected = !isSelected;
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {



		// If this is selected, draw an outline indicating it is
		if(isSelected)
		{
			g.setColor(Color.YELLOW);
			g.fillRect(ptTopLeft.x - 2, ptTopLeft.y - 2, 100 + 2, 100 + 2);
		}
		
		
		g.setColor(Color.WHITE);
		g.fillRoundRect(ptTopLeft.x, ptTopLeft.y, 100 - 2, 100 - 2, 10, 10);
		g.setColor(Color.BLACK);
		g.drawRoundRect(ptTopLeft.x, ptTopLeft.y, 100, 100, 10, 10);
		
		
		// TODO Known issue with the class text not showing properly on top of the shape location
		classText.paint(g);

		
		

	}

}
