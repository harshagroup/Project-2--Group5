package invoice.junit.testcases;

import javax.swing.JFrame;

import invoice.main.GUIFrames;
import invoice.main.SessionManager;
import invoice.screens.AddProjectPanel;



public class ButtonEnabledTestCase extends LoginTestCase {
    private AddProjectPanel emptyPanel;
    private AddProjectPanel tannerPanel;
    GUIFrames frame = new GUIFrames();
    SessionManager sessionManager=new SessionManager();

    public void setUp(){
        this.emptyPanel = new AddProjectPanel(frame,sessionManager);
        this.tannerPanel = new AddProjectPanel(frame,sessionManager);
    }
    public void tearDown() {
    	this.emptyPanel = null;
        this.tannerPanel = null;		 
	}
    public void buttonsDisabled(final JFrame currentGUIFrame,final SessionManager sessionManager) {
        assertTrue("Add New Project",!this.emptyPanel.addnewproject.isEnabled());
    }    
}
