/**
 * 
 */
package edu.ncsu.csc216.hloj.model.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.hloj.model.MenuItem;
import edu.ncsu.csc216.hloj.model.ModelException;

/**
 * Tests the menuManagerClass.
 * 
 * @author Ashten Herr
 * @author Claire
 */
public class MenuManagerTest {

	/**
	 * Test method for getInstance
	 */
	@Test
	public void testGetInstance() {
		MenuManager m = null;
		m = MenuManager.getInstance();
		assertNotNull(m);
	}

	/**
	 * Test method for addMenuItem
	 */
	@Test
	public void testAddMenuItem() {
		MenuManager m = null;
		m = MenuManager.getInstance();
		m.removeAllMenuItems();
		
		MenuItem m0 = null;
		MenuItem m1 = null;
		MenuItem m2 = null;
		
		try {
			m0 = new MenuItem("Coffee", "Black Coffee", 2);
			m1 = new MenuItem("Tea", "Hot Tea", 3);
			m2 = new MenuItem("Tea", "Iced Tea", 4);
			
			m.addMenuItem(m0);
			assertEquals(1, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			
			m.addMenuItem(m1);
			assertEquals(2, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			
			m.addMenuItem(m2);
			assertEquals(3, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			assertEquals(m2, m.getMenuItem(2));
			
			
		} catch (ModelException e) {
			fail();
		}
		
		
		
	}
	
	/**
	 * Test method for getMenuItems()
	 */
	@Test
	public void testGetMenuItems() {
		MenuManager m = null;
		m = MenuManager.getInstance();
		m.removeAllMenuItems();
		
		MenuItem m0 = null;
		MenuItem m1 = null;
		MenuItem m2 = null;
		
		try {
			m0 = new MenuItem("Coffee", "Black Coffee", 2);
			m1 = new MenuItem("Tea", "Hot Tea", 3);
			m2 = new MenuItem("Tea", "Iced Tea", 4);
			
			m.addMenuItem(m0);
			assertEquals(1, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			
			m.addMenuItem(m1);
			assertEquals(2, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			
			m.addMenuItem(m2);
			assertEquals(3, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			assertEquals(m2, m.getMenuItem(2));
		} catch (ModelException e) {
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.hloj.model.manager.MenuManager#editMenuItem(int, edu.ncsu.csc216.hloj.model.MenuItem)}.
	 */
	@Test
	public void testEditMenuItem() {
		MenuManager m = null;
		m = MenuManager.getInstance();
		m.removeAllMenuItems();
		
		MenuItem m0 = null;
		MenuItem m1 = null;
		MenuItem m2 = null;
		MenuItem m3 = null;
		
		try {
			m0 = new MenuItem("Coffee", "Black Coffee", 2);
			m1 = new MenuItem("Tea", "Hot Tea", 3);
			m2 = new MenuItem("Tea", "Iced Tea", 4);
			m3 = new MenuItem("Test", "Test", 2);
			
			m.addMenuItem(m0);
			assertEquals(1, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			
			m.addMenuItem(m1);
			assertEquals(2, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			
			m.addMenuItem(m2);
			assertEquals(3, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			assertEquals(m2, m.getMenuItem(2));
			
			m.editMenuItem(1, m3);
			assertEquals(3, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m2, m.getMenuItem(1));
			assertEquals(m3, m.getMenuItem(2));
			
			
			
		} catch (ModelException e) {
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.hloj.model.manager.MenuManager#removeMenuItem(int)}.
	 */
	@Test
	public void testRemoveMenuItem() {
		MenuManager m = null;
		m = MenuManager.getInstance();
		m.removeAllMenuItems();
		
		MenuItem m0 = null;
		MenuItem m1 = null;
		MenuItem m2 = null;
		
		try {
			m0 = new MenuItem("Coffee", "Black Coffee", 2);
			m1 = new MenuItem("Tea", "Hot Tea", 3);
			m2 = new MenuItem("Tea", "Iced Tea", 4);
			
			m.addMenuItem(m0);
			assertEquals(1, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			
			m.addMenuItem(m1);
			assertEquals(2, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			
			m.addMenuItem(m2);
			assertEquals(3, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			assertEquals(m2, m.getMenuItem(2));
			
			m.removeMenuItem(1);
			assertEquals(2, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m2, m.getMenuItem(1));
			
			m.removeMenuItem(1);
			assertEquals(1, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			
			m.removeMenuItem(0);
			assertEquals(0, m.getMenuItems().length);
			
			
		} catch (ModelException e) {
			fail();
		}
	}

	/**
	 * Test method for removeAllMenuItems
	 */
	@Test
	public void testRemoveAllMenuItems() {
		MenuManager m = null;
		m = MenuManager.getInstance();
		m.removeAllMenuItems();
		
		MenuItem m0 = null;
		MenuItem m1 = null;
		MenuItem m2 = null;
		
		try {
			m0 = new MenuItem("Coffee", "Black Coffee", 2);
			m1 = new MenuItem("Tea", "Hot Tea", 3);
			m2 = new MenuItem("Tea", "Iced Tea", 4);
			
			m.addMenuItem(m0);
			assertEquals(1, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			
			m.addMenuItem(m1);
			assertEquals(2, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			
			m.addMenuItem(m2);
			assertEquals(3, m.getMenuItems().length);
			assertEquals(m0, m.getMenuItem(0));
			assertEquals(m1, m.getMenuItem(1));
			assertEquals(m2, m.getMenuItem(2));
			
			m.removeAllMenuItems();
			
			assertEquals(0, m.getMenuItems().length);
			
		} catch (ModelException e) {
			fail();
		}
	}

}
