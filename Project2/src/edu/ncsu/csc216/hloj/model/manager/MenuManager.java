/**
 * 
 */
package edu.ncsu.csc216.hloj.model.manager;

import edu.ncsu.csc216.hloj.model.MenuItem;
import edu.ncsu.csc216.hloj.model.ModelException;
import edu.ncsu.csc216.hloj.model.lists.SortedList;

/**
 * MenuManager manages the menu of the Howl Lot of Java coffee shop. Menu items
 * can be added, removed, and edited. Class can pass menu information of
 * specific menu items or the full menu.
 * 
 * @author Ashten Herr
 * @author Claire Davis
 */
public class MenuManager {

	/** Instance of menu manager */
	private static MenuManager instance;

	/** Sorted List storing all of the menu items. */
	private SortedList<MenuItem> menu;

	/**
	 * MenuManager private constructor
	 */
	private MenuManager() {
		menu = new SortedList<MenuItem>();
	}

	/**
	 * Get instance manages the singleton of MenuManager. Returns current instance,
	 * if null creates a new MenuManager.
	 * 
	 * @return - MenuManager instance
	 */
	public static MenuManager getInstance() {
		if (instance == null) {
			instance = new MenuManager();
		}
		return instance;
	}

	/**
	 * Adds a menu item to the menu.
	 * 
	 * @param menuItem - menu item being added
	 */
	public void addMenuItem(MenuItem menuItem) {
		menu.add(menuItem);
	}

	/**
	 * Returns an array of menu items which represent the full menu.
	 * 
	 * @return menu as an array of menu items
	 */
	public MenuItem[] getMenuItems() {
		MenuItem[] menuItems = new MenuItem[menu.size()];
		for (int i = 0; i < menu.size(); i++) {
			menuItems[i] = menu.get(i);
		}
		return menuItems;

	}

	/**
	 * Returns the menu item at a specific index.
	 * 
	 * @param idx - index of menu item
	 * @return - menu item at the specified index
	 */
	public MenuItem getMenuItem(int idx) {
		return menu.get(idx);
	}

	/**
	 * Edits a menu item at a current index by replacing it with a new item.
	 * 
	 * @param idx  - index of menu item being edited
	 * @param item - Edited version of menu item replacing index
	 */
	public void editMenuItem(int idx, MenuItem item) {
		menu.remove(idx);
		menu.add(item);
	}

	/**
	 * Removes menu item at a specific index.
	 * 
	 * @param idx - index of menu item
	 * @throws ModelException if the menu item is invalid
	 */
	public void removeMenuItem(int idx) throws ModelException {

		OrderManager o = OrderManager.getInstance();

		for (int i = 0; i < o.getOrders().length; i++) {
			for (int j = 0; j < o.getOrders()[i].getItems().length; j++) {
				if (menu.get(idx).equals(o.getOrders()[i].getItems()[j].getMenuItem())) {
					throw new ModelException("Cannot delete a menu item that is part of an open order");
				}
			}
		}

		menu.remove(idx);
	}

	/**
	 * Removes all menu items clearing the menu.
	 */
	public void removeAllMenuItems() {
		menu = new SortedList<MenuItem>();
	}

}
