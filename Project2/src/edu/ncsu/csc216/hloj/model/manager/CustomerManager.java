/**
 * 
 */
package edu.ncsu.csc216.hloj.model.manager;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.ModelException;
import edu.ncsu.csc216.hloj.model.lists.SortedList;

/**
 * CustomerManager manages the SortedList of customers for the coffee shop,
 * Customers can be added/removed/edited. Can pass a display array.
 * 
 * 
 * @author Claire Davis
 * @author Ashten Herr
 */
public class CustomerManager {
	
	/** Instance of CustomerManager */
	private static CustomerManager instance;

	/**
	 * Sorted List of customers.
	 */
	private SortedList<Customer> customers;

	private CustomerManager() {
		customers = new SortedList<Customer>();
	}

	/**
	 * getInstance class returns the current instance of CustomerManager, if null
	 * then a new CustomerManager is created.
	 * 
	 * @return the current instance of CustomerManager
	 */
	public static CustomerManager getInstance() {
		if (instance == null) {
			instance = new CustomerManager();
		} 
		return instance;
	}

	/**
	 * Adds a customer to the customers sorted list.
	 * 
	 * @param customer - customer being added.
	 * @throws ModelException if the customer is invalid
	 */
	public void addCustomer(Customer customer) throws ModelException {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(customer.getId())) {
				throw new ModelException("A customer with this id already exists");
			}
		}
		customers.add(customer);
	}

	/**
	 * Returns customer at specified index.
	 * 
	 * @param idx - index of customer
	 * @return - The customer at specified index
	 */
	public Customer getCustomer(int idx) {	
		return customers.get(idx);
	}

	/**
	 * Returns a String array of customers.
	 * 
	 * @return String Array of customers.
	 */
	public Customer[] getCustomers() {
		Customer[] customerArray = new Customer[customers.size()];
		for (int i = 0; i < customers.size(); i++) {
			customerArray[i] = customers.get(i);
		}
		return customerArray;
	}

	/**
	 * Returns a customer with a specific id. Searches through sorted list looking
	 * for a matching id.
	 * 
	 * @param id - id value of the Customer
	 * @return - customer with specified id
	 */
	public Customer getCustomer(String id) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(id)) {
				return customers.get(i);
			}
		}
		return null;
	}

	/**
	 * Removes a customer from the customers Sorted List.
	 * 
	 * @param customer - customer being removed
	 * @throws ModelException if the customer is invalid
	 */
	public void removeCustomer(Customer customer) throws ModelException {
		if (OrderManager.getInstance().getOrdersByCustomer(customer).length != 0) {
			throw new ModelException("Cannot remove a customer with open orders");
		}
		Boolean flag = false;
		for (int i = 0; i < customers.size(); i++) {
			if (customer.equals(customers.get(i))) {
				customers.remove(i);
				flag = true;
			}
		}
		
		if(!flag) {
			throw new ModelException("Customer does not exist.");	
		}
	}

	/**
	 * Edits a current customer at a certain index.
	 * 
	 * @param idx    - index of customer being edited
	 * @param customer - customer replacement to edit the customer
	 * @throws ModelException if the customer is invalid
	 */
	public void editCustomer(int idx, Customer customer) throws ModelException {
		
		//check for duplicate (other than edited customer)
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(customer.getId()) && i != idx) {
				throw new ModelException("A customer with this id already exists");
			}
		}
		
		customers.remove(idx);
		
		customers.add(customer);
	}

	/**
	 * removes all of the customers in the customers list (resetting the Sorted
	 * List)
	 */
	public void removeAllCustomers() {
		customers = new SortedList<Customer>();
	}

}
