/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

/**
 * this class created objects from menu items that will be stored in the orders. It
 * sets the quantity of the item and allows the client to return the menu item.
 * 
 * @author Claire Davis
 * @author Ashten Herr
 *
 */
public class OrderItem implements Comparable<OrderItem> {

  /** the number of order items **/
  private int quantity;
  
  /** the menu item stored in the order*/
  private MenuItem menuItem;
  
  /**
   * the constructor for the class, this created a new order item out of the given
   * menu item
   * 
   * @param m the menu item to make into an order item
   */
  public OrderItem(MenuItem m) {
    menuItem = m;
		try {
      setQuantity(1);
    } catch (ModelException e) {
      // do nothing
    }

  }

  /**
   * the getter for the quantity
   * 
   * @return the quantity
   */
  public int getQuantity() {
    
    return quantity;
  }

  /**
   * the setter for the quantity
   * 
   * @param quantity the quantity to set
   * @throws ModelException if the quantity is less than zero.
   */
  public void setQuantity(int quantity) throws ModelException {
    if (quantity < 1) {
      throw new ModelException("The quantity of an item in an order has to be greater than zero");
    }
    this.quantity = quantity;
  }
  
  /**
   * the method that returns the menu item stored in the order item 
   * 
   * @return the menu item
   */
  public MenuItem getMenuItem() {
    return menuItem;
  }
  
  /**
   * this method compares two OrderItems alphabetically
   * 
   * @param o the order item to compare
   * @return the int different between the two order items
   */
  @Override
  public int compareTo(OrderItem o) {
    if (this.equals(o)) {
      return 0;
    }
    if (this.getMenuItem().compareTo(o.getMenuItem()) != 0) {
      return this.getMenuItem().compareTo(o.getMenuItem());
    
    } else {
      return 0;
    }
  }
  
  
  
}
