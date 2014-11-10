///*
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class UMLLine extends JPanel{
	
	UMLShape firstSelectedShape = null;
	UMLShape secondSelectedShape = null;
	
	int firstX;
	int firstY;
	int secondX;
	int secondY;
	
	Image image;
	
	
	//UMLCanvas myCanvas;

	/**
	 * 
//	 */
	private static final long serialVersionUID = 1L;

	public UMLLine(UMLShape firstSelectedShape, UMLShape secondSelectedShape, UMLCanvas mycanvas)
	{
		this.setOpaque(false);
		
		this.firstSelectedShape = firstSelectedShape;
		this.secondSelectedShape = secondSelectedShape;
		
		/*
		firstX = lastSelectedShapeX;
		firstY = lastSelectedShapeY;
		secondX = secondSelectedShapeX;
		secondY = secondSelectedShapeY;
		/
		
		System.out.println("First X:" + firstX);
		System.out.println("First Y:" + firstY);
		System.out.println("Second X:" + secondX);
		System.out.println("Second Y:" + secondY);
		*/
		
		
		this.setVisible(true);
		int sizeX = mycanvas.getWidth();
		int sizeY = mycanvas.getHeight();
		
		
		
		
		this.setSize(sizeX, sizeY);
		

	}

	public void setSize()
	{
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{			
		super.paintComponent(g);
			g.setColor(Color.BLACK);
			System.out.println("drawing a line-----------------");
			
			System.out.println("First X:" + firstSelectedShape.getX());
			System.out.println("First Y:" + firstSelectedShape.getY());
			System.out.println("Second X:" + secondSelectedShape.getX());
			System.out.println("Second Y:" + secondSelectedShape.getY());
			
			
			
			
			g.drawLine((firstSelectedShape.getX() + (firstSelectedShape.getWidth() / 2)),
					   (firstSelectedShape.getY() + (firstSelectedShape.getHeight() / 2)),
					   (secondSelectedShape.getX() + (secondSelectedShape.getWidth() / 2)), 
					   (secondSelectedShape.getY() + (secondSelectedShape.getHeight() / 2)));
			

			
			// draws the arrow and finds the angle to rotate it
			try {
				image = ImageIO.read(new File("Arrowhead3.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Graphics2D g2d = (Graphics2D) g;
			AffineTransform tx = new AffineTransform();
			tx.rotate(((-1) * getAngle()), image.getWidth(null)/2, image.getHeight(null)/2);
			g2d.translate(secondSelectedShape.getX() + /*base*/ (secondSelectedShape.getWidth()/2) + 35,
					(secondSelectedShape.getY() + (secondSelectedShape.getHeight() / 2))+45);
			g2d.drawImage(image, tx, null);
	}
	
	
	private float getAngle() {
	    float angle = (float) Math.toDegrees(Math.atan2(firstSelectedShape.getX() - secondSelectedShape.getX(),
	    												firstSelectedShape.getY() - secondSelectedShape.getY()));
	    if(angle < 0){
	        angle += 360;
	    }
	    
	    return (float) Math.toRadians((angle));
	}
	
}