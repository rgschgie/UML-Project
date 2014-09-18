import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.RootPaneContainer;


public class main {

	public static void main(String[] args) {

		UMLMainWindow mainWindow 	= new UMLMainWindow();	
		UMLCanvas umlCanvas 		= new UMLCanvas();
		UMLToolBar umlToolBar 		= new UMLToolBar();
		UMLMainMenu mainMenu 		= new UMLMainMenu();
		
		mainWindow.add(umlToolBar, BorderLayout.WEST);
		((JFrame) mainWindow).setJMenuBar(mainMenu);
		umlCanvas.setUMLToolBar(umlToolBar);
		
		
		((RootPaneContainer) mainWindow).getContentPane().add(umlCanvas);
		mainWindow.setVisible(true);	

	}

}
