/**
 * 
 */
package edu.ncsu.csc216.hloj.model.manager;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.ModelException;
import edu.ncsu.csc216.hloj.model.Order;
import edu.ncsu.csc216.hloj.model.lists.SortedList;

/**
 * OrderManager manages all of the orders for HowlLotOfJava through a SortedList
 * list of orders.
 * 
 * @author Ashten Herr
 * @author Claire Davis
 */
public class OrderManager {

  /** Current instance of OrderManager */
  private static OrderManager instance;
  /** List of orders being managed */
  private SortedList<Order> orders;
  /** Last order number (highest) in the SortedList of orders */
  private int lastOrderNumber;
  /** Maximum number of orders a single customer can have at a time */
  private static final int MAX_ORDERS_PER_CUSTOMER = 3;

  /**
   * private constructor for OrderManager
   */
  private OrderManager() {
    orders = new SortedList<Order>();
    setLastOrderNumber(0);
  }

  /**
   * Returns current instance of OrderManager, if null then the constructor is
   * called to create new instance.
   * 
   * @return - OrderManager Instance
   */
  public static OrderManager getInstance() {
    if (instance == null) {
      instance = new OrderManager();
    }
    return instance;
  }

  /**
   * Returns the last order number of all of the order numbers.
   * 
   * @return - last order number in order list
   */
  public int getLastOrderNumber() {
    return lastOrderNumber;
  }

  /**
   * Sets the last order number.
   * 
   * @param lastOrderNumber - order number to set last order number to
   */
  public void setLastOrderNumber(int lastOrderNumber) {
    this.lastOrderNumber = lastOrderNumber;
  }

  /**
   * Returns the customers next order to be processed.
   * 
   * @param c - customer whose order is being retrieved
   * @return - customers next order
   * @throws ModelException if the customer is invalid
   */
  public Order getNextOrder(Customer c) throws ModelException {
    if (c == null) {
      return null;
    }
    if (getOrdersByCustomer(c).length >= MAX_ORDERS_PER_CUSTOMER) {
      throw new ModelException("A customer cannot have more than 3 open orders");
    }

    Order o = new Order(lastOrderNumber + 1, c);

    setLastOrderNumber(lastOrderNumber + 1);

    return o;

  }

  /**
   * Places an order into the sorted list of orders.
   * 
   * @param o - order being placed
   * @throws ModelException if the order is invalid
   */
  public void placeOrder(Order o) throws ModelException {
    if (getOrdersByCustomer(o.getCustomer()).length >= MAX_ORDERS_PER_CUSTOMER) {
      throw new ModelException("A customer cannot have more than 3 open orders.");
    } else if (o.getItems().length < 1) {
      throw new ModelException("Orders can only be placed if they contain at least one item.");
    }

    if (o.getNumber() > getLastOrderNumber()) {
      throw new ModelException();
    }

    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getNumber() == o.getNumber()) {
        throw new ModelException();
      }
    }

    orders.add(o);

  }

  /**
   * Returns an array of orders.
   * 
   * @return array of orders
   */
  public Order[] getOrders() {
    Order[] orderArray = new Order[orders.size()];
    for (int i = 0; i < orders.size(); i++) {
      orderArray[i] = orders.get(i);
    }
    return orderArray;
  }

  /**
   * getOrdersByCustomer() returns an array of orders that a single customer has.
   * 
   * @param c - customer whose orders are being returned
   * @return - array of orders from the specific customer
   */
  public Order[] getOrdersByCustomer(Customer c) {
    int orderCount = 0;
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getCustomer().equals(c)) {
        orderCount++;
      }
    }

    Order[] orderArray = new Order[orderCount];
    int currentOrderSpot = 0;
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getCustomer().equals(c)) {
        orderArray[currentOrderSpot] = orders.get(i);
        currentOrderSpot++;
      }
    }

    return orderArray;

  }

  /**
   * Returns an order at a specific index
   * 
   * @param idx - index of order
   * @return - order at specified index
   */
  public Order getOrder(int idx) {
    return orders.get(idx);
  }

  /**
   * Cancels an order by removing it from the orders list.
   * 
   * @param o - order being cancelled (removed)
   * @throws ModelException if the order does not exist
   */
  public void cancelOrder(Order o) throws ModelException {
    boolean flag = false;
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).equals(o)) {
        orders.remove(i);
        flag = true;
      }
    }

    if (!flag) {
      throw new ModelException("Order does not exist");
    }
  }

  /**
   * Fulfills order removing it from the orders list.
   * 
   * @param o - order being fulfilled.
   * @throws ModelException if the order is invalid
   */
  public void fulfillOrder(Order o) throws ModelException {
    if (orders.size() == 0) {
      throw new ModelException("Order does not exist");
    }


      if (orders.get(0).equals(o)) {
        orders.remove(0);
      } else {
        throw new ModelException("Orders must be fulfilled in the order in which they were placed");
      }

  }

  /**
   * Removes all of the orders clearing the system.
   */
  public void removeAllOrders() {
    orders = new SortedList<Order>();
    setLastOrderNumber(0);
  }
}
