package invoice.junit.testcases;


import static org.junit.Assert.*;
import junit.framework.TestCase;
import invoice.database.MyDatabaseHelper;
import invoice.main.GUIFrames;

import org.junit.Test;

public class ClientdataTestCase extends TestCase{
	
	 MyDatabaseHelper myDatabaseHelper;
	 public void setUp() {
		 myDatabaseHelper=new MyDatabaseHelper();
	 }	
	 public void tearDown() {
		 myDatabaseHelper=null;
	 }	
	 public void testIsShowing() {
		 assertNotNull(myDatabaseHelper.getClients());
		 assertNotNull(myDatabaseHelper.getClientsFromDevelopersHours());
	 }	
}
