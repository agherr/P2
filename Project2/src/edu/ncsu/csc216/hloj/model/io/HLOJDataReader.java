/**
 * 
 */
package edu.ncsu.csc216.hloj.model.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.hloj.model.Customer;
import edu.ncsu.csc216.hloj.model.MenuItem;
import edu.ncsu.csc216.hloj.model.ModelException;
import edu.ncsu.csc216.hloj.model.Order;
import edu.ncsu.csc216.hloj.model.lists.UniqueList;
import edu.ncsu.csc216.hloj.model.manager.CustomerManager;
import edu.ncsu.csc216.hloj.model.manager.MenuManager;
import edu.ncsu.csc216.hloj.model.manager.OrderManager;

/**
 * This class handles the file input. It takes a file name and reads in the data
 * and separates it into orders, customers, menu items, order items, and the
 * managers for each of these objects.
 * 
 * @author Claire Davis
 *
 */
public class HLOJDataReader {

	/**
	 * this method takes the file name and reads it out into its corresponding
	 * objects
	 * 
	 * @param filename the name of the file to read in
	 * @throws IllegalArgumentException if the file is unable to be loaded or if there are errors
	 */
	public static void readData(String filename) {
		Scanner fileReader;
		String bigString = "";

		try {
			fileReader = new Scanner(new FileInputStream(filename));
		} catch (IOException e) {
			throw new IllegalArgumentException("File " + filename + " does not exist");
		}
		OrderManager o = OrderManager.getInstance();

		int lastOrderNumber = 0;

		try {
			lastOrderNumber = fileReader.nextInt();
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException("Unable to load file");
		}
		o.setLastOrderNumber(lastOrderNumber);

		while (fileReader.hasNextLine()) {
			bigString = bigString + fileReader.nextLine() + "\n";
		}
		if (bigString.indexOf("#") != -1) {
			processCustomer(bigString);
		} else if (bigString.indexOf("*") != -1) {
			processMenu(bigString.substring(bigString.indexOf("*")));
		}

	}

	/**
	 * This method formats the customers
	 * 
	 * @param bigString the string that holds the file information
	 */
	private static void processCustomer(String bigString) {

		// Format the string to stop at menu items,
		String customers;
		if (bigString.indexOf("*") != -1) {
			customers = bigString.substring(0, bigString.indexOf("*"));
		} else {
			customers = bigString;
		}

		CustomerManager c = CustomerManager.getInstance();
		String firstName;
		String lastName;
		String id;

		Scanner cScanner = new Scanner(customers);

		while (cScanner.useDelimiter("\\r?\\n?[#]").hasNext()) {
			Scanner parts = new Scanner(cScanner.useDelimiter("\\r?\\n?[#]").next()).useDelimiter("[,\\r\\n]");

			try {
				firstName = parts.next();
				lastName = parts.next();
				id = parts.next();

				try {
					Customer customer = new Customer(firstName, lastName, id);
					if (customer != null) {
						c.addCustomer(customer);
					}
				} catch (ModelException e) {
					// nothing happens, we dont create a customer
				}

			} catch (NoSuchElementException e) {
				// nothing happens, we dont create a customer
			}

		}

		cScanner.close();
		if (bigString.indexOf("*") != -1) {
			processMenu(bigString.substring(bigString.indexOf("*")));
		}
	}

	/**
	 * this method takes the string information and pulls out the menu items and
	 * matches the ids to the menu items
	 * 
	 * @param mediumString the string that holds the data
	 */
	private static void processMenu(String mediumString) {
		MenuManager m = MenuManager.getInstance();

		UniqueList<String> identifier = new UniqueList<String>();
		UniqueList<MenuItem> arrItem = new UniqueList<MenuItem>();
		String menu;
		if (mediumString.indexOf("-") != -1) {
			menu = mediumString.substring(0, mediumString.indexOf("-"));
		} else {
			menu = mediumString;
		}

		String id;
		String type;
		String name;
		String price;
		int i = 0;

		Scanner mScanner = new Scanner(menu);

		while (mScanner.useDelimiter("\\r?\\n?[*]").hasNext()) {
			Scanner parts = new Scanner(mScanner.useDelimiter("\\r?\\n?[*]").next()).useDelimiter("[,\\r\\n]");
			try {
				id = parts.next().trim();
				type = parts.next().trim();
				name = parts.next().trim();
				price = parts.next().trim();

				try {
					MenuItem item = new MenuItem(type, name, Double.valueOf(price));
					identifier.add(id);
					arrItem.add(item);
					m.addMenuItem(arrItem.get(i));
					i++;
				} catch (ModelException e) {
					// nothing happens
				} catch (IllegalArgumentException e) {
					//If the item can't be added skip it
				}

			} catch (NoSuchElementException e) {
				// nothing happens, we dont create a new menu item
			}
		}

		mScanner.close();
		if (mediumString.indexOf("-") != -1) {
			processOrders(mediumString.substring(mediumString.indexOf("-")), identifier, arrItem);
		}

	}

	/**
	 * this method takes the file information and the menu items and their ids and
	 * created the order items
	 * 
	 * @param smallString the string that holds the rest of the information
	 * @param identifiers the string array of the ids of the menu items
	 * @param arrItem     the menu item array of the menu items
	 */
	private static void processOrders(String smallString, UniqueList<String> identifiers,
			UniqueList<MenuItem> arrItem) {

		OrderManager o = OrderManager.getInstance();
		CustomerManager c = CustomerManager.getInstance();

		String oNum;
		String id;
		Order newOrder;
		String identifier;

		Scanner oScanner = new Scanner(smallString);

		while (oScanner.useDelimiter("\\r?\\n?[-]").hasNext()) {
			Scanner parts = new Scanner(oScanner.useDelimiter("\\r?\\n?[-]").next()).useDelimiter("[,\\r\\n]");

			try {
				oNum = parts.next().trim();
				id = parts.next().trim();
				
				int orderNumber = Integer.valueOf(oNum);
				
				boolean flag = true;
				
				try {
					
					newOrder = new Order(orderNumber, c.getCustomer(id));

					while (parts.hasNext()) {
						
						if (!flag) {
							throw new IllegalArgumentException();
						}

						identifier = parts.next().trim();
						int index = 0;
						
						
						
						for (String i : identifiers) {
							if (i != null && i.equals(identifier)) {
								newOrder.addMenuItem(arrItem.get(index));
								flag = true;
								break;
							}
							flag = false;
							index++;
						}
					}

					o.placeOrder(newOrder);

				} catch (ModelException e) {
					// do nothing
				}
				

			} catch (NoSuchElementException e) {
				// nothing happens, we dont create a new menu item
			} catch (NumberFormatException e) {
				//skip order (order number couldn't be processed correctly)
			} catch (IllegalArgumentException e) {
				//Skip order
			}
		}

		oScanner.close();
	}
}