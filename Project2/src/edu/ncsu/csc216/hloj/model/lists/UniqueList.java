/**
 * 
 */
package edu.ncsu.csc216.hloj.model.lists;

import java.util.AbstractList;

/**
 * this class creates a list that extends Abstract List. It allows for adding
 * and removing elements, as well as retrieving the size and elements at a given
 * index.
 * 
 * 
 * @author Claire Davis
 * @author Ashten Herr
 *
 * @param <E> the objects that the list holds
 */
public class UniqueList<E> extends AbstractList<E> {
	/** a constant value for initializing the list size **/
	private static final int INIT_CAPACITY = 10;

	/** an array of type E **/
	private E[] list;

	/** the size of the list **/
	private int size;

	/**
	 * The constructor of ArrayList, creates a new ArrayList and initializes it to
	 * the constant for initial size, 10
	 */
	public UniqueList() {
		this(INIT_CAPACITY);
	}

	/**
	 * The constructor of ArrayList, creates a new ArrayList and initializes it to
	 * the given parameter
	 * 
	 * @param cap the initial capacity of the list
	 */
	@SuppressWarnings("unchecked")
	public UniqueList(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("Capacity can't be less than one.");
		}
		list = (E[]) (new Object[cap]);
		size = 0;
	}

	/**
	 * this method returns the element at the inputed index
	 * 
	 * @param index the index of the element to find
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 */
	@Override
	public E get(int index) {
		validateIndex(index);
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return list[index];
	}

	/**
	 * size returns the size of the array list
	 * 
	 * @return size the size of the array
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * add adds an element to the array list at the given index
	 * 
	 * @param idx the index specifying where to add the element
	 * @param e   the element to add to the array
	 * 
	 * @throws NullPointerException      Thrown if the element is null
	 * @throws IndexOutOfBoundsException if the index is not in between 0 and size
	 * @throws IllegalArgumentException  if the element being added is a duplicate
	 */
	@Override
	public void add(int idx, E e) {

		// Error checking
		if (e == null) {
			throw new NullPointerException();
		}

		if (idx < 0 || idx > size()) {
			throw new IndexOutOfBoundsException();
		}

		for (E element : list) {
			if (e.equals(element)) {
				throw new IllegalArgumentException();
			}
		}

		if (size == list.length) {
			increaseCapacity();
		}

		// Adding element to list
		int i;
		for (i = size; i > idx; i--) {
			list[i] = list[i - 1];
		}
		list[i] = e;
		size++;
	}

	/**
	 * set takes a element and replaces the current element at the index specified
	 * and returns the original element
	 * 
	 * @param e the element to insert into the list
	 * 
	 * @return boolean if the element was added successfully
	 * 
	 * @throws IllegalArgumentException if the element being added is invalid
	 */
	@Override
	public boolean add(E e) {
		add(size, e);
		return true;
	}

	/**
	 * remove removes the element at the specified index and decreases the size by
	 * one, then returns the deleted element
	 * 
	 * @param idx the index that holds the element to delete
	 * 
	 * @return E the deleted element
	 * 
	 * @throws IndexOutOfBoundsException if the specified index is out of bounds
	 */
	@Override
	public E remove(int idx) {

		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException();
		}

		E save = list[idx];
		int i;
		for (i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[i] = null;
		size--;

		return save;
	}

	/**
	 * this private method causes the array to double in size if it reaches capacity
	 */
	@SuppressWarnings("unchecked")
	private void increaseCapacity() {
		E[] temp = (E[]) (new Object[size * 2]);
		for (int i = 0; i < size; i++) {
			temp[i] = list[i];
		}
		list = temp;
	}

	/**
	 * this method checks if the given index is valid
	 * 
	 * @param idx the index to validate
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 * @throws IllegalArgumentException  if the index is null
	 */
	private void validateIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

}
