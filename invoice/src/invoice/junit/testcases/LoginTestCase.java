package invoice.junit.testcases;

import invoice.database.MyDatabaseHelper;
import junit.framework.TestCase;

import org.junit.Test;

public class LoginTestCase extends TestCase {
	MyDatabaseHelper myDatabaseHelper;
	 public void setUp() {
		 myDatabaseHelper=new MyDatabaseHelper();
	 }	
	 public void tearDown() {
		 myDatabaseHelper=null;
	 }	
	 public void testIsShowing() {
		 assertNotNull(myDatabaseHelper.getEmployeeByUsername("harsha"));
		 assertNull(myDatabaseHelper.getEmployeeByUsername(""));
	 }	
}  
