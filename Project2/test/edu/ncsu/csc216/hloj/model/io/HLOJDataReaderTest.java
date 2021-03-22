/**
 * 
 */
package edu.ncsu.csc216.hloj.model.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.hloj.model.manager.CustomerManager;
import edu.ncsu.csc216.hloj.model.manager.MenuManager;
import edu.ncsu.csc216.hloj.model.manager.OrderManager;

/**
 * this is the test class for the data reader
 * 
 * @author Claire Davis
 *
 */
public class HLOJDataReaderTest {
  
  /** Valid system file **/
  final String data1 = "test-files/data1.txt";
  
  /*
  1500
  # Sarah,Heckman,sesmith5
  # James,Tetterton,jctetter
  # Ignacio X.,Dominguez,ignacioxd
  * T1,Tea,Chai Latte,3
  * C1,Coffee,Large Coffee,2.5
  * P1,Pastries,Donut,2.0
  - 1500,jctetter,T1,T1,P1
  - 152,sesmith5,P1,C1,P1,T1,P1
  - 151,ignacioxd,T1
  */


/**
   * Test method for readData
   */
  @Test
  public void testReadData() {
    
    
    HLOJDataReader.readData(data1);
    CustomerManager c = CustomerManager.getInstance();
    MenuManager m = MenuManager.getInstance();
    OrderManager o = OrderManager.getInstance();
    
    assertEquals(Integer.toString(1500), Integer.toString(o.getLastOrderNumber()));
    
    assertEquals(3, c.getCustomers().length);
    assertEquals("Ignacio X. Dominguez (ignacioxd)", c.getCustomer(0).toString());
    assertEquals("Sarah Heckman (sesmith5)", c.getCustomer(1).toString());
    assertEquals("James Tetterton (jctetter)", c.getCustomer(2).toString());
    
    assertEquals(3, m.getMenuItems().length);
    assertEquals("(Coffee) Large Coffee - $2.5", m.getMenuItem(0).toString());
    assertEquals("(Pastries) Donut - $2.0", m.getMenuItem(1).toString());
    assertEquals("(Tea) Chai Latte - $3.0", m.getMenuItem(2).toString());
    
    assertEquals(3, o.getOrders().length);
    
    
    assertEquals(11.5, o.getOrder(1).getTotal(), 0);
    
    
    o.removeAllOrders();
    c.removeAllCustomers();
    m.removeAllMenuItems();
	  
	
    
    HLOJDataReader.readData("test-files/data11.txt");
    
    
    
    
  }

}
