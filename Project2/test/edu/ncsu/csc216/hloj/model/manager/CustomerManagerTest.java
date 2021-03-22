/**
 * 
 */
package edu.ncsu.csc216.hloj.model.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.ModelException;

/**
 * Tests the Customer Manager Class.
 * 
 * @author Ashten Herr
 * @author Claire
 */
public class CustomerManagerTest {

	/**
	 * Test method for getInstance method.
	 */
	@Test
	public void testGetInstance() {
		CustomerManager c = CustomerManager.getInstance();
		assertNotNull(c);
	}

	/**
	 * Test method for addCusomter()
	 */
	@Test
	public void testAddCustomer() {
		CustomerManager c = null;
		c = CustomerManager.getInstance();
		c.removeAllCustomers();
		assertNotNull(c);
		Customer c0;
		Customer c1;
		Customer c2;
		Customer c3;
		try {
			c0 = new Customer("Ashten", "Herr", "agherr");
			c1 = new Customer("John", "Doe", "jdoe");
			c2 = new Customer("Alex", "Fro", "abro");
			c3 = new Customer("Ashten", "Herr", "agherr");

			c.addCustomer(c0);
			assertEquals(c0, c.getCustomers()[0]);

			c.addCustomer(c1);
			assertEquals(c1, c.getCustomers()[0]);
			assertEquals(c0, c.getCustomers()[1]);

			c.addCustomer(c2);
			assertEquals(c1, c.getCustomers()[0]);
			assertEquals(c2, c.getCustomers()[1]);
			assertEquals(c0, c.getCustomers()[2]);
			
			try {
				c.addCustomer(c3);
				fail();
			} catch (ModelException e) {
				assertEquals(3, c.getCustomers().length);
			}

		} catch (ModelException e) {
			fail();
		}

	}

	/**
	 * Test method for getCustomerInt
	 */
	@Test
	public void testGetCustomerInt() {
		CustomerManager c = null;
		c = CustomerManager.getInstance();
		c.removeAllCustomers();
		assertNotNull(c);
		Customer c0;
		Customer c1;
		Customer c2;
		try {
			c0 = new Customer("Ashten", "Herr", "agherr");
			c1 = new Customer("John", "Doe", "jdoe");
			c2 = new Customer("Alex", "Fro", "abro");

			c.addCustomer(c0);
			assertEquals(c0, c.getCustomers()[0]);

			c.addCustomer(c1);
			assertEquals(c1, c.getCustomers()[0]);
			assertEquals(c0, c.getCustomers()[1]);

			c.addCustomer(c2);
			assertEquals(c1, c.getCustomers()[0]);
			assertEquals(c2, c.getCustomers()[1]);
			assertEquals(c0, c.getCustomers()[2]);

			assertEquals(c0, c.getCustomer(2));
			assertEquals(c1, c.getCustomer(0));
			assertEquals(c2, c.getCustomer(1));

		} catch (ModelException e) {
			fail();
		}

	}

	/**
	 * Test method for getCustomer(String)
	 */
	@Test
	public void testGetCustomerString() {
		CustomerManager c = null;
		c = CustomerManager.getInstance();
		c.removeAllCustomers();
		assertNotNull(c);
		Customer c0 = null;
		Customer c1 = null;
		Customer c2 = null;
		try {
			c0 = new Customer("Ashten", "Herr", "agherr");
			c1 = new Customer("John", "Doe", "jdoe");
			c2 = new Customer("Alex", "Fro", "abro");

			c.addCustomer(c0);
			c.addCustomer(c1);
			c.addCustomer(c2);

			assertEquals(c0, c.getCustomer("agherr"));
			assertEquals(c1, c.getCustomer("jdoe"));
			assertEquals(c2, c.getCustomer("abro"));

		} catch (ModelException e) {
			fail();
		}
	}

	/**
	 * Test method for removeCustomer
	 */
	@Test
	public void testRemoveCustomer() {
		CustomerManager c = null;
		c = CustomerManager.getInstance();
		c.removeAllCustomers();
		assertNotNull(c);
		Customer c0 = null;
		Customer c1 = null;
		Customer c2 = null;
		try {
			c0 = new Customer("Ashten", "Herr", "agherr");
			c1 = new Customer("John", "Doe", "jdoe");
			c2 = new Customer("Alex", "Fro", "abro");

			c.addCustomer(c0);
			assertEquals(c0, c.getCustomers()[0]);

			c.addCustomer(c1);
			assertEquals(c1, c.getCustomers()[0]);
			assertEquals(c0, c.getCustomers()[1]);

			c.addCustomer(c2);
			assertEquals(c1, c.getCustomers()[0]);
			assertEquals(c2, c.getCustomers()[1]);
			assertEquals(c0, c.getCustomers()[2]);

			c.removeCustomer(c2);
			assertEquals(c1, c.getCustomers()[0]);
			assertEquals(c0, c.getCustomers()[1]);

			c.removeCustomer(c0);
			assertEquals(c1, c.getCustomers()[0]);

			c.removeCustomer(c1);
			assertEquals(0, c.getCustomers().length);

		} catch (ModelException e) {
			fail();
		}

		try {
			c.removeCustomer(c1);
			fail();
		} catch (ModelException e) {
			assertEquals(0, c.getCustomers().length);
		}
	}

	/**
	 * Test method for editCustomer
	 */
	@Test
	public void testEditCustomer() {
		CustomerManager c = null;
		c = CustomerManager.getInstance();
		c.removeAllCustomers();
		assertNotNull(c);
		Customer c0 = null;
		Customer c1 = null;
		Customer c2 = null;
		Customer c3 = null;
		
		try {
			c0 = new Customer("Ashten", "Herr", "agherr");
			c1 = new Customer("John", "Doe", "jdoe");
			c2 = new Customer("Alex", "Fro", "abro");
			c3 = new Customer("Test", "Test", "test");

			c.addCustomer(c0);
			c.addCustomer(c1);
			c.addCustomer(c2);
			
			c.editCustomer(0, c3);
			
			Customer[] customer = c.getCustomers();
			
			assertEquals(c2, customer[0]);
			assertEquals(c0, customer[1]);
			assertEquals(c3, customer[2]);
			
		} catch (ModelException e) {
			fail();
		}
	}

	/**
	 * Test method for removeAllCustomers
	 */
	@Test
	public void testRemoveAllCustomers() {
		CustomerManager c = null;
		c = CustomerManager.getInstance();
		c.removeAllCustomers();
		assertNotNull(c);
		Customer c0 = null;
		Customer c1 = null;
		Customer c2 = null;
		try {
			c0 = new Customer("Ashten", "Herr", "agherr");
			c1 = new Customer("John", "Doe", "jdoe");
			c2 = new Customer("Alex", "Fro", "abro");

			c.addCustomer(c0);
			c.addCustomer(c1);
			c.addCustomer(c2);
			
			c.removeAllCustomers();
			
			assertEquals(0, c.getCustomers().length);
		} catch (ModelException e) {
			fail();
		}
	}

}
