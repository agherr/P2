/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for OrderItem
 * 
 * @author Claire Davis
 *
 */
public class OrderItemTest {
  
  
  // variables for menu items
  /** string for name */
  private String name1 = "name1";
  
  /** string for type */
  private String type1 = "type1";
  
  /** double for price */
  private double price1 = 1.0;
  
  /** string for name */
  private String name2 = "name2";
  
  /** string for type */
  private String type2 = "type2";
  
  /** double for price */
  private double price2 = 2.0;
  

  /**
   * Test method for OrderItem
   */
  @Test
  public void testOrderItem() {
    OrderItem o = null;
    MenuItem m = null;
    
    try {
      m = new MenuItem(type1, name1, price1);
      o = new OrderItem(m);
      assertEquals(m, o.getMenuItem());
    } catch (ModelException e) {
      fail();
    }
    
  }

  /**
   * Test method for setQuantity
   */
  @Test
  public void testSetQuantity() {
    OrderItem o = null;
    MenuItem m = null;
    
    try {
      m = new MenuItem(type1, name1, price1);
      o = new OrderItem(m);
    } catch (ModelException e) {
      fail();
    }
    
    try {
      o.setQuantity(2);
    } catch (ModelException e) {
      fail();
    }
    assertEquals(2, o.getQuantity());
      
    try {
      o.setQuantity(0);
    } catch (ModelException e) {
      assertEquals(2, o.getQuantity());
    }
    
    
  }

  /**
   * Test method for compareTo
   */
  @Test
  public void testCompareTo() {
    OrderItem o1 = null;
    OrderItem o1Copy = null;
    OrderItem o2 = null;
    MenuItem m1 = null;
    MenuItem m2 = null;
    
    try {
      m1 = new MenuItem(type1, name1, price1);
      m2 = new MenuItem(type2, name2, price2);
      o1 = new OrderItem(m1);
      o1Copy = new OrderItem(m1);
      o2 = new OrderItem(m2);
    } catch (ModelException e) {
      fail("Item was not created");
    }
    
    assertEquals(0, o1.compareTo(o1));
    assertEquals(0, o1Copy.compareTo(o1));
    assertEquals(0, o1.compareTo(o1Copy));
    assertNotSame(0, o1.compareTo(o2));
    assertNotSame(0, o2.compareTo(o1));

  }

}
