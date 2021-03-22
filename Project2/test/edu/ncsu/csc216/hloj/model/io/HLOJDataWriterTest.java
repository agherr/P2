/**
 * 
 */
package edu.ncsu.csc216.hloj.model.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.MenuItem;
import edu.ncsu.csc216.hloj.model.ModelException;
import edu.ncsu.csc216.hloj.model.Order;
import edu.ncsu.csc216.hloj.model.manager.CustomerManager;
import edu.ncsu.csc216.hloj.model.manager.MenuManager;
import edu.ncsu.csc216.hloj.model.manager.OrderManager;

/**
 * Tests the dataWriter class
 * 
 * 
 * @author Ashten Herr
 * @author Claire Davis
 *
 */
public class HLOJDataWriterTest {

	/**
	 * Test method for writeData
	 */
	@Test
	public void testWriteData() {

		OrderManager o = OrderManager.getInstance();
		CustomerManager c = CustomerManager.getInstance();
		MenuManager m = MenuManager.getInstance();
		
		assertNotNull(o);
		assertNotNull(c);
		assertNotNull(m);
		
		o.removeAllOrders();
		c.removeAllCustomers();
		m.removeAllMenuItems();
		o.setLastOrderNumber(0);
		assertEquals(0, o.getLastOrderNumber());

		try {
			// Set objects
			c.addCustomer(new Customer("Ashten", "Herr", "agherr"));
			c.addCustomer(new Customer("Claire", "Davis", "cedavi23"));

			m.addMenuItem(new MenuItem("Coffee", "Black Coffee", 2));
			m.addMenuItem(new MenuItem("Tea", "Apple Tea", 3.0));
			m.addMenuItem(new MenuItem("Tea", "Chai Tea", 2.5));
			m.addMenuItem(new MenuItem("Coffee", "Americano", 3.0));

			// Assign orders to different customers
			
			
			Order order1 = o.getNextOrder(c.getCustomer("agherr"));

			order1.addMenuItem(m.getMenuItem(0));
			order1.addMenuItem(m.getMenuItem(0));
			order1.addMenuItem(m.getMenuItem(2));
			o.placeOrder(order1);

			Order order2 = o.getNextOrder(c.getCustomer("cedavi23"));

			order2.addMenuItem(m.getMenuItem(1));
			order2.addMenuItem(m.getMenuItem(2));
			
			o.placeOrder(order2);
			
			
			
			HLOJDataWriter.writeData("test-files/writer_actual.txt");

		} catch (ModelException e) {
			e.printStackTrace();
			fail();
		}
		
		checkFiles("test-files/writer_expected.txt", "test-files/writer_actual.txt");
	}

	/**
	 * Checks two files and tests if they are both equal to each other. Taken from
	 * previous projects when testing IO classes.
	 * 
	 * @param expFile - expected file to check for equality
	 * @param actFile - actual file to check for equality
	 */
	private void checkFiles(String expFile, String actFile) {
		try {
			Scanner expScanner = new Scanner(new FileInputStream(expFile));
			Scanner actScanner = new Scanner(new FileInputStream(actFile));

			while (expScanner.hasNextLine() && actScanner.hasNextLine()) {
				String exp = expScanner.nextLine();
				String act = actScanner.nextLine();
				assertEquals(exp, act);
			}
			if (expScanner.hasNextLine()) {
				fail("The expected results expect another line " + expScanner.nextLine());
			}
			if (actScanner.hasNextLine()) {
				fail("The actual results has an extra, unexpected line: " + actScanner.nextLine());
			}

			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
