/**
 * 
 */
package edu.ncsu.csc216.hloj.model.lists;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.ModelException;

/**
 * Test class for Unique List
 * 
 * @author Claire Davis
 * @author Ashten Herr
 *
 */
public class UniqueListTest {

	/**
	 * Test method for size
	 */
	@Test
	public void testSize() {
		UniqueList<Customer> u = new UniqueList<Customer>();
		assertEquals(0, u.size());

	}

	/**
	 * Test method for unique List constructor
	 */
	@Test
	public void testUniqueList() {
		UniqueList<Customer> u = new UniqueList<Customer>();
		assertEquals(0, u.size());
		
		UniqueList<Customer> u2 = new UniqueList<Customer>(2);
		assertEquals(0, u2.size());
	}

	/**
	 * Test method for add()
	 */
	@Test
	public void testAddIntE() {
		UniqueList<Customer> u = new UniqueList<Customer>();
		assertEquals(0, u.size());
		
		Customer c1 = null;
		Customer c2 = null;
		Customer c3 = null;
		Customer c4 = null;
		Customer c5 = null;

		try {
			c1 = new Customer("Ashten", "Herr", "agherr");
			c2 = new Customer("Braxton", "Lippard", "blipp");
			c3 = new Customer("Zoe", "Zelch", "zelch");
			c4 = new Customer("Bruh", "Aname", "bame");
			c5 = new Customer("Test", "Test", "Test");
		} catch (ModelException e) {
			fail();
		}
		
		u.add(c1);
		u.add(c2);
		u.add(c3);
		
		assertEquals(c1, u.get(0));
		assertEquals(c2, u.get(1));
		assertEquals(c3, u.get(2));
		
		try {
			u.add(c1);		
		} catch (IllegalArgumentException e) {
			assertEquals(c1, u.get(0));
			assertEquals(c2, u.get(1));
			assertEquals(c3, u.get(2));
		}
		
		try {
			u.add(null);		
		} catch (NullPointerException e) {
			assertEquals(c1, u.get(0));
			assertEquals(c2, u.get(1));
			assertEquals(c3, u.get(2));
		}
		
		u.add(1, c4);
		assertEquals(c1, u.get(0));
		assertEquals(c4, u.get(1));
		assertEquals(c2, u.get(2));
		assertEquals(c3, u.get(3));
		
		u.add(0, c5);
		assertEquals(c5, u.get(0));
		assertEquals(c1, u.get(1));
		assertEquals(c4, u.get(2));
		assertEquals(c2, u.get(3));
		assertEquals(c3, u.get(4));
		
		//Check a list will increase in size automatically
		UniqueList<Customer> u2 = new UniqueList<Customer>(2);
		assertEquals(0, u2.size());
		
		u2.add(c1);
		u2.add(c2);
		u2.add(c3);
		u2.add(c4);
		u2.add(c5);
		
		assertEquals(5, u2.size());
		
		assertEquals(c1, u2.get(0));
		assertEquals(c2, u2.get(1));
		assertEquals(c3, u2.get(2));
		assertEquals(c4, u2.get(3));
		assertEquals(c5, u2.get(4));
		
		
	}

	/**
	 * Test method for removeInt
	 */
	@Test
	public void testRemoveInt() {
		UniqueList<Customer> u = new UniqueList<Customer>();
		assertEquals(0, u.size());
		
		Customer c1 = null;
		Customer c2 = null;
		Customer c3 = null;

		try {
			c1 = new Customer("Ashten", "Herr", "agherr");
			c2 = new Customer("Braxton", "Lippard", "blipp");
			c3 = new Customer("Zoe", "Zelch", "zelch");
		} catch (ModelException e) {
			fail();
		}
		
		u.add(c1);
		u.add(c2);
		u.add(c3);
		
		assertEquals(c1, u.get(0));
		assertEquals(c2, u.get(1));
		assertEquals(c3, u.get(2));
		
		u.remove(1);
		assertEquals(c1, u.get(0));
		assertEquals(c3, u.get(1));
		
		u.remove(1);
		assertEquals(c1, u.get(0));
		
		u.remove(0);
		assertEquals(0, u.size());
		
	}

}
