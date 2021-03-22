/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

/**
 * This class creates a customer object. It holds the first and last name of the 
 * customer and give them a unique id. Additionally, it has a method to format
 * the fields as a string to pass to the display and it has a method to compare 
 * two customers alphabetically by last name, then first name.
 * 
 * @author Claire Davis
 * @author Ashten Herr
 *
 */
public class Customer implements Comparable<Customer> {
  
  /** the first name of the customer **/
  private String firstName;
  
  /** the last name of the customer **/
  private String lastName;
  
  /** the unique id of the customer **/
  private String id;

  /**
   * the constructor for Customer sets a new customer given the parameters
   * 
   * @param firstName the first name of the customer 
   * @param lastName the last name of the customer
   * @param id the unique id of the customer
   * @throws ModelException if any of the parameters are invalid
   */
  public Customer(String firstName, String lastName, String id) throws ModelException {
    setFirstName(firstName);
    setLastName(lastName);
    setId(id);
  }

  /**
   * this method returns the customers first name
   * 
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * set first name sets the first name as the given parameter
   * 
   * @param firstName the firstName to set
   * @throws ModelException if the parameter is empty
   */
  public void setFirstName(String firstName) throws ModelException {
    if (firstName == null || "".equals(firstName.trim())) {
      throw new ModelException("The first name of the customer cannot be empty");
    }
    this.firstName = firstName.trim();
  }

  /**
   * this method returns the customers last name
   * 
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * set last name takes the parameter given and sets the last name
   * 
   * @param lastName the lastName to set
   * @throws ModelException if the parameter is empty
   */
  public void setLastName(String lastName) throws ModelException {
    if (lastName == null || "".equals(lastName.trim())) {
      throw new ModelException("The last name of the customer cannot be empty");
    }
    this.lastName = lastName.trim();
  }

  /**
   * this method returns the id of the customer
   * 
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * this method sets the id as the given parameter
   * 
   * @param id the id to set
   * @throws ModelException if the parameter is empty
   */
  public void setId(String id) throws ModelException {
    if (id == null || "".equals(id.trim())) {
      throw new ModelException("The id of the customer cannot be empty");
    }
    this.id = id.trim();
  }

  /**
   * toString takes the fields in customer and returns them in a string format
   * able to be used in the GUI
   */
  @Override
  public String toString() {
    return firstName + " " + lastName + " (" + id + ")";
  }
  
  /**
   * this method takes a customer object and compares it to another customer 
   * object. It returns how different they are in terms of an integer 
   * 
   * @param c the customer to compare 
   * @return int how different the customer is to the compared customer
   */
  @Override
  public int compareTo(Customer c) {
    if (this.equals(c)) {
      return 0;
    }
    if (this.getLastName().compareToIgnoreCase(c.getLastName()) != 0) {
      return this.getLastName().compareToIgnoreCase(c.getLastName());
    
    }
    
    else if (this.getFirstName().compareToIgnoreCase(c.getFirstName()) != 0) {
      return this.getFirstName().compareToIgnoreCase(c.getFirstName());
    }
    
    else {
      return 0;
    }
  }
  
  

}
