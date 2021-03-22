/**
 * 
 */
package edu.ncsu.csc216.hloj.model.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.MenuItem;
import edu.ncsu.csc216.hloj.model.ModelException;
import edu.ncsu.csc216.hloj.model.Order;

/**
 * Test class for OrderManager
 * 
 * @author Ashten Herr
 * @author Claire
 */
public class OrderManagerTest {

	/**
	 * Test method for getInstance()
	 */
	@Test
	public void testGetInstance() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
	}

	/**
	 * Test method for setLastOrderNumber()
	 */
	@Test
	public void testSetLastOrderNumber() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
		
		o.removeAllOrders();
		
		o.setLastOrderNumber(0);

		assertEquals(0, o.getLastOrderNumber());

		Customer c = null;
		MenuItem m = null;

		try {
			c = new Customer("Ashten", "Herr", "agherr");
			m = new MenuItem("Coffee", "Black Coffee", 2);

			Order order = o.getNextOrder(c);

			order.addMenuItem(m);
			o.placeOrder(order);

			assertEquals(1, o.getLastOrderNumber());
			
			o.setLastOrderNumber(5);
			
			assertEquals(5, o.getLastOrderNumber());

		} catch (ModelException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for getNextOrder()
	 */
	@Test
	public void testGetNextOrder() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
		o.removeAllOrders();
		o.setLastOrderNumber(0);

		assertEquals(0, o.getLastOrderNumber());

		Customer c = null;
		MenuItem m = null;

		try {
			c = new Customer("Ashten", "Herr", "agherr");
			m = new MenuItem("Coffee", "Black Coffee", 2);

			Order order = o.getNextOrder(c);
			assertEquals(0, order.getItems().length);

			order.addMenuItem(m);
			o.placeOrder(order);

			assertEquals(1, o.getLastOrderNumber());

		} catch (ModelException e) {
			fail();
		}
	}

	/**
	 * Test method for placeOrder()
	 */
	@Test
	public void testPlaceOrder() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
		o.removeAllOrders();
		o.setLastOrderNumber(0);

		assertEquals(0, o.getLastOrderNumber());

		Customer c = null;
		MenuItem m = null;

		try {
			c = new Customer("Ashten", "Herr", "agherr");
			m = new MenuItem("Coffee", "Black Coffee", 2);

			Order order1 = o.getNextOrder(c);

			order1.addMenuItem(m);
			o.placeOrder(order1);

			Order order2 = o.getNextOrder(c);

			order2.addMenuItem(m);
			o.placeOrder(order2);

			Order order3 = o.getNextOrder(c);

			order3.addMenuItem(m);
			o.placeOrder(order3);
			
			assertEquals(order1, o.getOrder(0));
			assertEquals(order2, o.getOrder(1));
			assertEquals(order3, o.getOrder(2));
			

		} catch (ModelException e) {
			e.printStackTrace();
			fail();
		}

		try {

			Order order4 = o.getNextOrder(c);

			order4.addMenuItem(m);
			o.placeOrder(order4);
			fail();
		} catch (ModelException e) {
			assertEquals(3, o.getOrdersByCustomer(c).length);
		}
	}

	/**
	 * Test method for getOrders
	 */
	@Test
	public void testGetOrders() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
		o.removeAllOrders();
		o.setLastOrderNumber(0);

		assertEquals(0, o.getLastOrderNumber());

		Customer c = null;
		MenuItem m = null;

		try {
			c = new Customer("Ashten", "Herr", "agherr");
			m = new MenuItem("Coffee", "Black Coffee", 2);

			Order order1 = o.getNextOrder(c);

			order1.addMenuItem(m);
			o.placeOrder(order1);

			Order order2 = o.getNextOrder(c);

			order2.addMenuItem(m);
			o.placeOrder(order2);

			Order order3 = o.getNextOrder(c);

			order3.addMenuItem(m);
			o.placeOrder(order3);

			Order[] list = o.getOrders();

			// check the orders are in the correct order from the array

			assertEquals(order1, list[0]);
			assertEquals(order2, list[1]);
			assertEquals(order3, list[2]);

		} catch (ModelException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for getOrdersByCustomer
	 */
	@Test
	public void testGetOrdersByCustomer() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
		o.removeAllOrders();
		o.setLastOrderNumber(0);

		assertEquals(0, o.getLastOrderNumber());

		Customer c = null;
		Customer c1 = null;
		MenuItem m = null;

		try {
			//Set objects
			c = new Customer("Ashten", "Herr", "agherr");
			c1 = new Customer("Test", "Test", "Test");
			
			m = new MenuItem("Coffee", "Black Coffee", 2);
			
			//Assign orders to different customers

			Order order1 = o.getNextOrder(c);

			order1.addMenuItem(m);
			o.placeOrder(order1);

			Order order2 = o.getNextOrder(c);

			order2.addMenuItem(m);
			o.placeOrder(order2);

			Order order3 = o.getNextOrder(c);

			order3.addMenuItem(m);
			o.placeOrder(order3);

			Order order4 = o.getNextOrder(c1);

			order4.addMenuItem(m);
			o.placeOrder(order4);
			
			//Check each customers array
			
			Order[] listOne = o.getOrdersByCustomer(c);
			
			Order[] listTwo = o.getOrdersByCustomer(c1);

			assertEquals(3, o.getOrdersByCustomer(c).length);
			assertEquals(order1, listOne[0]);
			assertEquals(order2, listOne[1]);
			assertEquals(order3, listOne[2]);
			
			assertEquals(1, o.getOrdersByCustomer(c1).length);
			assertEquals(order4, listTwo[0]);
			

		} catch (ModelException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for cancelOrder
	 */
	@Test
	public void testCancelOrder() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
		o.removeAllOrders();
		o.setLastOrderNumber(0);

		assertEquals(0, o.getLastOrderNumber());

		Customer c = null;
		MenuItem m = null;

		try {
			c = new Customer("Ashten", "Herr", "agherr");
			m = new MenuItem("Coffee", "Black Coffee", 2);

			Order order1 = o.getNextOrder(c);

			order1.addMenuItem(m);
			o.placeOrder(order1);

			assertEquals(1, o.getOrders().length);

			o.cancelOrder(order1);

			// check that the order was removed from the lists

			assertEquals(0, o.getOrders().length);

		} catch (ModelException e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * Test method for fulfillOrder
	 */
	@Test
	public void testFulfillOrder() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
		o.removeAllOrders();
		o.setLastOrderNumber(0);

		assertEquals(0, o.getLastOrderNumber());

		Customer c = null;
		MenuItem m = null;

		try {
			c = new Customer("Ashten", "Herr", "agherr");
			m = new MenuItem("Coffee", "Black Coffee", 2);

			Order order1 = o.getNextOrder(c);

			order1.addMenuItem(m);
			o.placeOrder(order1);

			Order order2 = o.getNextOrder(c);

			order2.addMenuItem(m);
			o.placeOrder(order2);

			try {
				o.fulfillOrder(order2);
				fail();
			} catch (ModelException e) {
				assertEquals(2, o.getOrders().length);
			}

			o.fulfillOrder(order1);

			assertEquals(1, o.getOrders().length);

		} catch (ModelException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for removeAllOrders()
	 */
	@Test
	public void testRemoveAllOrders() {
		OrderManager o = null;
		o = OrderManager.getInstance();
		assertNotNull(o);
		o.removeAllOrders();
		o.setLastOrderNumber(0);

		assertEquals(0, o.getLastOrderNumber());

		Customer c = null;
		MenuItem m = null;

		try {
			c = new Customer("Ashten", "Herr", "agherr");
			m = new MenuItem("Coffee", "Black Coffee", 2);

			Order order1 = o.getNextOrder(c);

			order1.addMenuItem(m);
			o.placeOrder(order1);

			Order order2 = o.getNextOrder(c);

			order2.addMenuItem(m);
			o.placeOrder(order2);

			Order order3 = o.getNextOrder(c);

			order3.addMenuItem(m);
			o.placeOrder(order3);
			
			assertEquals(3, o.getOrders().length);
			
			o.removeAllOrders();
			
			assertEquals(0, o.getOrders().length);
			

		} catch (ModelException e) {
			e.printStackTrace();
			fail();
		}
	}

}
