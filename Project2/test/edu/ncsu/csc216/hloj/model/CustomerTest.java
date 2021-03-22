/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Customer class.
 * 
 * @author Ashten Herr
 * @author Claire Davis
 *
 */
public class CustomerTest {

  /** string for first name */
  private String fName1 = "fname";

  /** string for last name */
  private String lName1 = "lname";

  /** string for id */
  private String id1 = "id";
  
  /** String of customer 1 */
  private String customer1 = fName1 + " " + lName1 + " (" + id1 + ")";

  /** string for first name 2 */
  private String fName2 = "fname2";

  /** string for last name 2 */
  private String lName2 = "lname2";

  /** string for id 2 */
  private String id2 = "id2";

  /**
   * test method for Customer
   */
  @Test
  public void testCustomer() {
    Customer c = null;
    // valid customer
    try {
      c = new Customer(fName1, lName1, id1);
      assertEquals(fName1, c.getFirstName());
      assertEquals(lName1, c.getLastName());
      assertEquals(id1, c.getId());
    } catch (ModelException e) {
      fail("Customer was not created");
    }
    
    //invalid customer
    try {
      c = new Customer("", lName2, id2);
      fail("Customer was created");
    } catch (ModelException e) {
      assertEquals(fName1, c.getFirstName());
      assertEquals(lName1, c.getLastName());
      assertEquals(id1, c.getId());
    }
    
    try {
      c = new Customer(fName2, "", id2);
      fail("Customer was created");
    } catch (ModelException e) {
      assertEquals(fName1, c.getFirstName());
      assertEquals(lName1, c.getLastName());
      assertEquals(id1, c.getId());
    }
    
    try {
      c = new Customer(fName2, lName2, "");
      fail("Customer was created");
    } catch (ModelException e) {
      assertEquals(fName1, c.getFirstName());
      assertEquals(lName1, c.getLastName());
      assertEquals(id1, c.getId());
    }
    
    try {
      c = new Customer(null, lName2, id2);
      fail("Customer was created");
    } catch (ModelException e) {
      assertEquals(fName1, c.getFirstName());
      assertEquals(lName1, c.getLastName());
      assertEquals(id1, c.getId());
    }
    
    try {
      c = new Customer(fName2, null, id2);
      fail("Customer was created");
    } catch (ModelException e) {
      assertEquals(fName1, c.getFirstName());
      assertEquals(lName1, c.getLastName());
      assertEquals(id1, c.getId());
    }
    
    try {
      c = new Customer(fName2, lName2, null);
      fail("Customer was created");
    } catch (ModelException e) {
      assertEquals(fName1, c.getFirstName());
      assertEquals(lName1, c.getLastName());
      assertEquals(id1, c.getId());
    }
    
    

  }

  /**
   * Test method for toString
   */
  @Test
  public void testToString() {
    Customer c = null;
    // valid customer
    try {
      c = new Customer(fName1, lName1, id1);
      assertEquals(fName1, c.getFirstName());
      assertEquals(lName1, c.getLastName());
      assertEquals(id1, c.getId());
      assertEquals(customer1, c.toString());
    } catch (ModelException e) {
      fail("Customer was not created");
    }
    
    
  }

  /**
   * Test method for compareTo
   */
  @Test
  public void testCompareTo() {
    Customer c1 = null;
    Customer c1Copy = null;
    Customer c2 = null;
    Customer c3 = null;
    
    try {
      c1 = new Customer(fName1, lName1, id1);
      c1Copy = new Customer(fName1, lName1, id1);
      c2 = new Customer(fName2, lName1, id2);
      c3 = new Customer(fName1, lName2, id2);
    } catch (ModelException e) {
      fail("Customer was not created");
    }
    
    assertEquals(0, c1.compareTo(c1));
    assertEquals(0, c1Copy.compareTo(c1));
    assertEquals(0, c1.compareTo(c1Copy));
    assertNotSame(0, c1.compareTo(c2));
    assertNotSame(0, c2.compareTo(c1));
    assertNotSame(0, c1.compareTo(c3));
    assertNotSame(0, c3.compareTo(c1));
    
  }
  


}
