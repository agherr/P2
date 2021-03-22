/**
 * 
 */
package edu.ncsu.csc216.hloj.model.lists;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.ModelException;

/**
 * This is the test class for Sorted List
 * 
 * @author Claire Davis
 * @author Ashten Herr
 *
 */
public class SortedListTest {

	/**
	 * Test method for size
	 */
	@Test
	public void testSize() {
		SortedList<Customer> s = new SortedList<Customer>();
		assertEquals(0, s.size());

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

		assertTrue(s.add(c1));
		assertEquals(1, s.size());

		assertTrue(s.add(c2));
		assertEquals(2, s.size());

		assertTrue(s.add(c3));
		assertEquals(3, s.size());

	}

	/**
	 * Test method for SortedList
	 */
	@Test
	public void testSortedList() {
		SortedList<Customer> s = new SortedList<Customer>();
		assertEquals(0, s.size());
	}

	/**
	 * Test method for addE
	 */
	@Test
	public void testAddE() {
		SortedList<Customer> s = new SortedList<Customer>();
		assertEquals(0, s.size());

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

		// Add in order (to the end)
		assertTrue(s.add(c1));
		assertTrue(s.add(c2));
		assertTrue(s.add(c3));

		assertEquals(c1, s.get(0));
		assertEquals(c2, s.get(1));
		assertEquals(c3, s.get(2));

		// Add to the front
		assertTrue(s.add(c4));

		assertEquals(c4, s.get(0));
		assertEquals(c1, s.get(1));
		assertEquals(c2, s.get(2));
		assertEquals(c3, s.get(3));

		// Add to the front
		assertTrue(s.add(c5));

		assertEquals(c4, s.get(0));
		assertEquals(c1, s.get(1));
		assertEquals(c2, s.get(2));
		assertEquals(c5, s.get(3));
		assertEquals(c3, s.get(4));

	}
	

	/**
	 * Test method for removeInt
	 */
	@Test
	public void testRemoveInt() {
		
		SortedList<Customer> s = new SortedList<Customer>();
		assertEquals(0, s.size());

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

		// Add in order (to the end)
		assertTrue(s.add(c1));
		assertTrue(s.add(c2));
		assertTrue(s.add(c3));
		
		//Remove from the middle
		s.remove(1);
		
		assertEquals(c1, s.get(0));
		assertEquals(c3, s.get(1));
		
		//Remove from the end
		s.remove(1);
		assertEquals(c1, s.get(0));
		
		//Remove from the front
		s.remove(0);
		assertEquals(0, s.size());
		
		try  {
			s.remove(1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, s.size());
		}
		
	}

}
