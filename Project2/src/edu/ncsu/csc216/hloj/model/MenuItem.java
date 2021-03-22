/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

/**
 * Menu Item stores the items that make up the menu. Each menu item has a name, type, 
 * and price. It also has a toString to format the data for displaying in the GUI.
 * Finally, it has a compare to method so that the items can be added in alphabetical
 * order by type then name.
 * 
 * @author Ashten Herr
 * @author Claire Davis
 *
 */
public class MenuItem implements Comparable<MenuItem> {

  
  /** the type of the menu item **/
  private String type;
  
  /** the name of the menu item **/
  private String name;
  
  /** the price of the menu item **/
  private double price;

  /**
   * The constructor for Menu Item. It takes two strings and a double and makes 
   * a new menu item object.
   * 
   * @param type the type of the item
   * @param name the name of the item
   * @param price the price of the item
   * @throws ModelException if any of the parameters are invalid
   */
  public MenuItem(String type, String name, double price) throws ModelException {
    setType(type);
    setName(name);
    setPrice(price);
  }

  /**
   * getter for type
   * 
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * setter for type
   * 
   * @param type the type to set
   * @throws ModelException if the type is empty
   */
  public void setType(String type) throws ModelException {
    if (type == null || "".equals(type.trim())) {
      throw new ModelException("The type of the menu item cannot be empty");
    }
    this.type = type.trim();
  }

  /**
   * getter for name
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * setter for name
   * 
   * @param name the name to set
   * @throws ModelException if the name is empty
   */
  public void setName(String name) throws ModelException {
    if (name == null || "".equals(name.trim())) {
      throw new ModelException("The name of the menu item cannot be empty");
    }
    this.name = name.trim();
  }

  /**
   * getter for price
   * 
   * @return the price
   * 
   */
  public double getPrice() {
    return price;
  }

  /**
   * setter for price
   * 
   * @param price the price to set
   * @throws ModelException if the price is empty or less than zero
   * 
   */
  public void setPrice(double price) throws ModelException {
    if (price <= 0) {
      throw new ModelException("The price of the menu item must be greater than zero");
    }
    this.price = price;
  }

  /**
   * this method formats the fields in the menu item and returns them to the client
   * usually for display in the gui
   * 
   */
  @Override
  public String toString() {
    return "(" + type + ") " + name + " - " + "$" + price;
  }
  
  /**
   * this method takes two menu items and compares them to determine order
   * of display in the GUI
   * 
   * @param m the menu item to compare
   * @return the int representation of how similar the two objects are
   */
  @Override
  public int compareTo(MenuItem m) {
    if (this.equals(m)) {
      return 0;
    }
    if (this.getType().compareToIgnoreCase(m.getType()) != 0) {
      return this.getType().compareToIgnoreCase(m.getType());
    
    } 
    
    return 0;
  }
  
}
