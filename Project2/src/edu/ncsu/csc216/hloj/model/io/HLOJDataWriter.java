/**
 * 
 */
package edu.ncsu.csc216.hloj.model.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.MenuItem;
import edu.ncsu.csc216.hloj.model.Order;
import edu.ncsu.csc216.hloj.model.OrderItem;
import edu.ncsu.csc216.hloj.model.manager.CustomerManager;
import edu.ncsu.csc216.hloj.model.manager.MenuManager;
import edu.ncsu.csc216.hloj.model.manager.OrderManager;

/**
 * This class handles the file output. It takes a file name and uses the
 * toString function for the other objects and formats them and writes them to
 * the file designated by the parameter given in the only public method
 * 
 * @author Claire Davis
 *
 */
public class HLOJDataWriter {

  /**
   * this method takes a filename and formats the data stored in the system and
   * writes it to the file designated by the filename.
   * 
   * @param filename the name of the file where the data will be stored
   */
  public static void writeData(String filename) {

    PrintStream fileWriter;

    try {
      fileWriter = new PrintStream(new File(filename));
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to save file");
    }

    OrderManager o = OrderManager.getInstance();
    Order[] orders = o.getOrders();

    CustomerManager c = CustomerManager.getInstance();
    Customer[] customers = c.getCustomers();

    MenuManager m = MenuManager.getInstance();
    MenuItem[] menu = m.getMenuItems();
    String[] id = new String[menu.length];

    for (int i = 0; i < menu.length; i++) {
      id[i] = "MI" + Integer.toString(i);
    }

    // writes the last order number
    fileWriter.println(o.getLastOrderNumber());

    // writes the customer information
    for (Customer customer : customers) {
      fileWriter.println("# " + customer.getFirstName() + "," + customer.getLastName() + "," + customer.getId());
    }

    // writes the menu information
    for (int i = 0; i < menu.length; i++) {
      fileWriter.println("* " + id[i] + "," + menu[i].getType() + "," + menu[i].getName() + "," + menu[i].getPrice());
    }

    // writes the order information
    for (Order order : orders) {
      fileWriter.printf("- %s,%s", "" + Integer.toString(order.getNumber()), order.getCustomer().getId());

      for (OrderItem item : order.getItems()) {
        int i;
        for (i = item.getQuantity(); i > 0; i--) {
          fileWriter.printf(",%s", getIdentifier(item, menu, id));

        }
      }
      fileWriter.println();
    }

    fileWriter.close();
  }

  /**
   * this private method searches through the menu item list and matches the menu
   * item with the order item, then returns the id associated with the menu item
   * 
   * @param o    the order item
   * @param menu the array of menu items
   * @param id   the array of menu item ids
   * @return the id that matches the menu item that matches the order item
   */
  private static String getIdentifier(OrderItem o, MenuItem[] menu, String[] id) {
    int i = 0;
    for (MenuItem m : menu) {
      if (m.equals(o.getMenuItem())) {
        return id[i];
      }
      i++;
    }

    return null;
  }

}
