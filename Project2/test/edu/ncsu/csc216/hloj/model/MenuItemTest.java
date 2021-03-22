/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the MenuItem Classs
 * 
 * @author Ashten Herr
 * @author Claire Davis
 */
public class MenuItemTest {
  
  /** string for type 1 */
  private String type1 = "type1";

  /** string for  name 1 */
  private String name1 = "name1";

  /** double for price 1 */
  private double price1 = 1.1;
  
  /** String of menu item 1 */
  private String menuItem1 = "(" + type1 + ") " + name1 + " - " + "$" + price1;

  /** string for type 2 */
  private String type2 = "type2";

  /** string for name 2 */
  private String name2 = "name2";

  /** double for price 2 */
  private double price2 = 2.0;

	/**
	 * Test method for the constructor
	 */
  @Test
	public void testMenuItem() {
		MenuItem m = null;
		
		// valid menu item
		try {
      m = new MenuItem(type1, name1, price1);
      assertEquals(type1, m.getType());
      assertEquals(name1, m.getName());
      assertEquals(Double.toString(price1), Double.toString(m.getPrice()));
    } catch (ModelException e) {
      fail("Customer was not created");
    }
    
    //invalid menu items
    try {
      m = new MenuItem("", name2, price2);
      fail("Menu item was created");
    } catch (ModelException e) {
      assertEquals(type1, m.getType());
      assertEquals(name1, m.getName());
      assertEquals(Double.toString(price1), Double.toString(m.getPrice()));
    }
    
    try {
      m = new MenuItem(type2, "", price2);
      fail("Menu item was created");
    } catch (ModelException e) {
      assertEquals(type1, m.getType());
      assertEquals(name1, m.getName());
      assertEquals(Double.toString(price1), Double.toString(m.getPrice()));
    }
    
    try {
      m = new MenuItem(type2, name2, 0);
      fail("Menu item was created");
    } catch (ModelException e) {
      assertEquals(type1, m.getType());
      assertEquals(name1, m.getName());
      assertEquals(Double.toString(price1), Double.toString(m.getPrice()));
    }
    
    try {
      m = new MenuItem(null, name2, price2);
      fail("Menu item was created");
    } catch (ModelException e) {
      assertEquals(type1, m.getType());
      assertEquals(name1, m.getName());
      assertEquals(Double.toString(price1), Double.toString(m.getPrice()));
    }
    
    try {
      m = new MenuItem(type2, null, price2);
      fail("Menu item was created");
    } catch (ModelException e) {
      assertEquals(type1, m.getType());
      assertEquals(name1, m.getName());
      assertEquals(Double.toString(price1), Double.toString(m.getPrice()));
    }
    
    try {
      m = new MenuItem(type2, name2, -1.0);
      fail("Menu item was created");
    } catch (ModelException e) {
      assertEquals(type1, m.getType());
      assertEquals(name1, m.getName());
      assertEquals(Double.toString(price1), Double.toString(m.getPrice()));
    }
	}

	/**
	 * Test method for toString
	 */
	@Test
	public void testToString() {
	  MenuItem m = null;
	  try {
      m = new MenuItem(type1, name1, price1);
      assertEquals(menuItem1, m.toString());
    } catch (ModelException e) {
      fail("Menu item was not created");
    }
	}

	/**
	 * Test method for compareTo
	 */
	@Test
	public void testCompareTo() {
	  MenuItem m1 = null;
    MenuItem m1Copy = null;
    MenuItem m2 = null;
    MenuItem m3 = null;
    
    try {
      m1 = new MenuItem(type1, name1, price1);
      m1Copy = new MenuItem(type1, name1, price1);
      m2 = new MenuItem(type1, name2, price2);
      m3 = new MenuItem(type2, name1, price2);
    } catch (ModelException e) {
      fail("Menu item was not created");
    }
    
    assertEquals(0, m1.compareTo(m1));
    assertEquals(0, m1Copy.compareTo(m1));
    assertEquals(0, m1.compareTo(m1Copy));
    assertEquals(0, m1.compareTo(m2));
    assertEquals(0, m2.compareTo(m1));
    assertNotSame(m1.compareTo(m3), 0);
    assertNotSame(m3.compareTo(m1), 0);
	}

}
