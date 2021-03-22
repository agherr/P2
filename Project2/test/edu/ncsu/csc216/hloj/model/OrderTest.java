/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test method for order
 * 
 * @author Claire Davis
 * @author Ashten Herr
 *
 */
public class OrderTest {

	/**
	 * Test method for order constructor
	 */
	@Test
	public void testOrder() {
		Customer c;
		Order order;
		try {
			c = new Customer("Ashten", "Herr", "agherr");
			order = new Order(1, c);
			assertEquals(1, order.getNumber());
			assertEquals(c, order.getCustomer());
		} catch (ModelException e) {
			fail();
		}

	}

	/**
	 * Test method for addMenuItem
	 */
	@Test
	public void testAddMenuItem() {
		Customer c;
		MenuItem m;
		MenuItem m1;
		MenuItem m2;
		Order order;
		try {
			m = new MenuItem("Tea", "Ice Tea", 1);
			m1 = new MenuItem("Coffee", "Black Coffee", 3);
			m2 = new MenuItem("Tea", "Hot Tea", 2);
			c = new Customer("Ashten", "Herr", "agherr");
			order = new Order(1, c);
			assertEquals(1, order.getNumber());
			assertEquals(c, order.getCustomer());

			order.addMenuItem(m);

			order.addMenuItem(m1);

			order.addMenuItem(m2);
			order.addMenuItem(m2);
			order.addMenuItem(m2);

			OrderItem[] orders = order.getItems();

			assertEquals("Black Coffee", orders[0].getMenuItem().getName());
			assertEquals("Ice Tea", orders[1].getMenuItem().getName());
			assertEquals("Hot Tea", orders[2].getMenuItem().getName());

		} catch (ModelException e) {
			fail();
		}

	}

	/**
	 * Test method for removeMenuItem()
	 */
	@Test
	public void testRemoveMenuItem() {
		Customer c;
		MenuItem m, m2;
		Order order;
		try {
			m = new MenuItem("Tea", "Ice Tea", 1);
			m2 = new MenuItem("Coffee", "Iced Coffee", 2.5);
			c = new Customer("Ashten", "Herr", "agherr");
			order = new Order(1, c);
			assertEquals(1, order.getNumber());
			assertEquals(c, order.getCustomer());

			order.addMenuItem(m);
			order.addMenuItem(m);
			order.addMenuItem(m2);

			
			
			
			assertEquals("Ice Tea", order.getItems()[1].getMenuItem().getName());
			assertEquals(2, order.getItems().length);
			assertEquals(1, order.getItems()[0].getQuantity());
			assertEquals(2, order.getItems()[1].getQuantity());

			order.removeMenuItem(m);
			assertEquals(2, order.getItems().length);
			assertEquals(1, order.getItems()[1].getQuantity());

			order.removeMenuItem(m2);
			assertEquals(1, order.getItems().length);
			assertEquals(1, order.getItems()[0].getQuantity());

			order.removeMenuItem(m);

		} catch (ModelException e) {
			fail();
		}

	}

	/**
	 * Test method for getTotal
	 */
	@Test
	public void testGetTotal() {
		Customer c;
		MenuItem m;
		MenuItem m1;
		MenuItem m2;
		Order order;
		try {
			m = new MenuItem("Tea", "Ice Tea", 1);
			m1 = new MenuItem("Coffee", "Black Coffee", 3);
			m2 = new MenuItem("Tea", "Hot Tea", 2);
			c = new Customer("Ashten", "Herr", "agherr");
			order = new Order(1, c);
			assertEquals(1, order.getNumber());
			assertEquals(c, order.getCustomer());

			order.addMenuItem(m);
			assertEquals(1, order.getTotal(), 0);

			order.addMenuItem(m1);
			assertEquals(4, order.getTotal(), 0);

			order.addMenuItem(m2);
			order.addMenuItem(m2);
			order.addMenuItem(m2);
			assertEquals(10, order.getTotal(), 0);

		} catch (ModelException e) {
			fail();
		}
	}

	/**
	 * Test method for toString
	 */
	@Test
	public void testToString() {
		Customer c;
		MenuItem m;
		MenuItem m1;
		MenuItem m2;
		Order order;
		try {
			m = new MenuItem("Tea", "Ice Tea", 1);
			m1 = new MenuItem("Coffee", "Black Coffee", 3);
			m2 = new MenuItem("Tea", "Hot Tea", 2);
			c = new Customer("Ashten", "Herr", "agherr");
			order = new Order(1, c);
			assertEquals(1, order.getNumber());
			assertEquals(c, order.getCustomer());

			order.addMenuItem(m);
			assertEquals(1, order.getTotal(), 0);

			order.addMenuItem(m1);
			assertEquals(4, order.getTotal(), 0);

			order.addMenuItem(m2);
			order.addMenuItem(m2);
			order.addMenuItem(m2);
			
			String s = order.toString();
			
			assertEquals("#1 for Ashten Herr - Total: $10.0", s);
		} catch (ModelException e) {
			fail();
		}
	}

	/**
	 * Test method for compareTo
	 */
	@Test
	public void testCompareTo() {
		Customer c;
		Order order;
		Order order2;
		try {
			c = new Customer("Ashten", "Herr", "agherr");
		
			order = new Order(1, c);
			
			order2 = new Order(2, c);
			
			
			assertEquals(1, order2.compareTo(order));
			assertEquals(-1, order.compareTo(order2));
			
		} catch (ModelException e) {
			fail();
		}
	}

}
