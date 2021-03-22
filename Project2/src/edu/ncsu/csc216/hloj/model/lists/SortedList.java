/**
 * 
 */
package edu.ncsu.csc216.hloj.model.lists;

import java.util.AbstractList;


/**
 * this class sets up a sorted list that extends linked list. It adds elements
 * in sorted order and maintains a sorted list. It has functions for add,
 * removing, and retrieving elements. It also allows the size of the list to be
 * gotten.
 * 
 * @author Claire Davis
 * @author Ashten Herr
 * 
 * @param <E> the object that the linked list contains
 *
 */
public class SortedList<E extends Comparable<E>> extends AbstractList<E> {

	/** this variable holds the size of the list */
	private int size;
	
	/** Represents the first list node of the sorted list*/
	private ListNode front;

	/**
	 * the constructor of the sorted list creates a new, empty list
	 */
	public SortedList() {
		this.front = null;
		this.size = 0;
	}

	/**
	 * add adds an element to the list in sorted order
	 * 
	 * @param object the object to add to the list
	 * @return boolean is the object was successfully added
	 * @throws IllegalArgumentException if the object is null
	 */
	public boolean add(E object) {
		if (object == null) {
			throw new IllegalArgumentException();
		}
		
		//Find the index to add at
		ListNode current = front;
		ListNode addedNode = new ListNode(object);
		int index = size;
		//First find the index which we should add the element.
		for (int i = 0; i < size; i++) {
			if (addedNode.data.compareTo(current.data) < 0) {
				index = i;
				break;
			}
			current = current.next;
		}
		
		//add the element at that specified index
		//set current back to the front of the list
	    current = front;

		if (index == 0) {
			addedNode.next = current;
			front = addedNode;
		} else {
			// Get to index to add element at.
			for (int i = 0; i < (index - 1); i++) {
				current = current.next;
			}

			addedNode.next = current.next;
			current.next = addedNode;
		}
		size++;
		return true;
		
	}

	/**
	 * this method removes the element at the given index
	 * 
	 * @param idx the index of the object to remove
	 * @return E the object that was removed
	 * @throws IllegalArgumentException if the index is invalid
	 */
	public E remove(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		}
		E value = null;
		if (idx == 0) {
			value = front.data;
			front = front.next;
		} else {
			ListNode current = front;
			for (int i = 0; i < idx - 1; i++) {
				current = current.next;
			}
			value = current.next.data;
			current.next = current.next.next;
		}
		size--;
		return value;
	}

	/**
	 * this method takes an index and returns the object found at that index
	 * 
	 * @param idx the index of the object to return
	 * @return E the object that was found at the index
	 * @throws IllegalArgumentException if the index is invalid
	 */
	public E get(int idx) {
		ListNode current = front;
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * this method returns the size of the list
	 * 
	 * @return size the size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * ListNode created individual nodes of a linked list. It holds both the data in
	 * the list and a reference pointing to the next node in the list
	 * 
	 * @author Claire Davis
	 *
	 */
	private class ListNode {

		/** the data stored in the list **/
		public E data;

		/** the reference to the next node **/
		public ListNode next;

		/**
		 * ListNode constructor makes a new node in a list and sets the data to the
		 * parameter
		 * 
		 * @param data the element to add to the node
		 */
		private ListNode(E data) {
			this(data, null);
		}

		/**
		 * ListNode constructor that makes a new node and sets the reference as pointing
		 * to another ListNode and the data as the element given as a parameter
		 * 
		 * @param data the element to add to the node
		 * @param next the node to reference in the current node
		 */
		private ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}

	}

}
