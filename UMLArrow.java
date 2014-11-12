import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class UMLArrow extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image = null;
	UMLShape secondSelectedShape;
	UMLCanvas mycanvas;
	float angle;
	
	public UMLArrow( UMLShape secondSelectedShape, UMLCanvas mycanvas, float angle )
	
	{
		this.secondSelectedShape = secondSelectedShape;
		this.mycanvas = mycanvas;
		this.angle = angle;
		
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		try {
			image = ImageIO.read(new File("Arrowhead3.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	Graphics2D g2d = (Graphics2D) g;
	AffineTransform tx = new AffineTransform();
	
	
	tx.rotate(((-1) * angle), image.getWidth(null)/2, image.getHeight(null)/2);
	
	
	g2d.translate(secondSelectedShape.getX() + /*base*/ + 133,
			(secondSelectedShape.getY() + (secondSelectedShape.getHeight() / 2))+155);
	
	
	g.drawImage(image, 100, 100, null);
	this.setComponentZOrder(this, 0);
	}
	
}

