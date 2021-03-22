/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

import edu.ncsu.csc216.hloj.model.lists.SortedList;

/**
 * Order creates a new order with a customer and a unique number. It allows for
 * adding or removing menu items, as well as formatting the fields for display
 * and comparing one order to another for alphabetical order
 * 
 * @author Claire Davis
 * @author Ashten Herr
 *
 */
public class Order implements Comparable<Order> {

	/** the number of the order **/
	private int number;

	/** the customer making the order */
	private Customer customer;

	/** the items the customer is ordering */
	private SortedList<OrderItem> items;

	/**
	 * the constructor for order, creates a new order with a number and a customer
	 * 
	 * 
	 * @param num the unique number of the order
	 * @param c   the customer that is making the order
	 * @throws ModelException if the number is less than 1
	 */
	public Order(int num, Customer c) throws ModelException {
		if (num < 1) {
			throw new ModelException("Order numbers must be larger than zero");
		}
		
		if (c == null) {
			throw new ModelException();
		}
		
		customer = c;
		number = num;
		items = new SortedList<OrderItem>();
	}

	/**
	 * given a menu item, searched through the order and finds where the menu item
	 * is in that order, if it is there at all
	 * 
	 * @param m the menu item to search for
	 * @return the index of the menu item
	 */
	private int getOrderItemIndexForMenuItem(MenuItem m) {
		int i = 0;
		if (items != null && !items.isEmpty()) {
			for (OrderItem o : items) {
				if (m.equals(o.getMenuItem())) {
					return i;
				}
				i++;
			}
		}
		return -1;
	}

	/**
	 * the method for adding an item to the menu
	 * 
	 * @param m the menu item to add to the order
	 */
	public void addMenuItem(MenuItem m) {

		int spot = getOrderItemIndexForMenuItem(m);

		if (spot >= 0) {
			try {
				items.get(spot).setQuantity(items.get(spot).getQuantity() + 1);
			} catch (ModelException e) {
				throw new IllegalArgumentException("Can't add item.");
			}
		} else {
			items.add(new OrderItem(m));
		}
		

	}

	/**
	 * this method removes a menu item from the order
	 * 
	 * @param m the menu item to remove
	 */
	public void removeMenuItem(MenuItem m) {

		int spot = getOrderItemIndexForMenuItem(m);

		if (spot >= 0 && items.get(spot).getQuantity() > 1) {
			try {
				items.get(spot).setQuantity(items.get(spot).getQuantity() - 1);
			} catch (ModelException e) {
				throw new IllegalArgumentException("Can't change quantity");
			}
		} else if (spot >= 0 && items.get(spot).getQuantity() == 1) {
			items.remove(spot);
		}
	}

	/**
	 * the getter for the number of the order
	 * 
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * the getter for the customer that made the order
	 * 
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * the getter for the items in the order
	 * 
	 * @return the order items in the order
	 */
	public OrderItem[] getItems() {

		OrderItem[] temp = new OrderItem[items.size()];
		for (int i = 0; i < items.size(); i++) {
			temp[i] = items.get(i);
		}
	
		return temp;

	}

	/**
	 * the getter for the total price of the items in the order
	 * 
	 * @return a double of the total price of the items in the order
	 */
	public double getTotal() {
		double total = 0;
		if (items != null && !items.isEmpty()) {
			for (OrderItem item : items) {			
				total += item.getMenuItem().getPrice() * item.getQuantity();
			}
		}
		return total;
	}

	/**
	 * this method formats the information stored in Order and returns it to the
	 * client for use in a gui
	 */
	@Override
	public String toString() {
		String total = "";
		if ((getTotal() * 10) % 1 == 0) {
			total = String.format("%,.1f", getTotal());
		} else {
			total = String.format("%,.2f", getTotal());
		}
		
		
		
		return "#" + Integer.toString(getNumber()) + " for " + getCustomer().getFirstName() + " "
				+ getCustomer().getLastName() + " - Total: $" + total;
	}

	@Override
	public int compareTo(Order o) {
		if (this.equals(o)) {
			return 0;
		}
		return this.getNumber() - o.getNumber();
	}

}
