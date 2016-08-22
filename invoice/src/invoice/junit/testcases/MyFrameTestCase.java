package invoice.junit.testcases;


import invoice.main.GUIFrames;
import junit.framework.TestCase;

public class MyFrameTestCase extends TestCase{
	GUIFrames myframe;	
	public void setUp() {
		myframe=new GUIFrames();
		myframe.setVisible(true);
	}	
	public void tearDown() {
		myframe.dispose();
	}	
	public void testIsShowing() {
		assertTrue(myframe.isShowing());
	}
}
