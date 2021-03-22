/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

/**
 * This class is a custom checked exception that deals with when business rules
 * are broken.
 * 
 * @author Claire Davis
 *
 */
public class ModelException extends Exception {

	/** The value 1 stored into a long primitive type */
	private static final long serialVersionUID = 1L;

	/**
	 * This constructor sets up the default error messages
	 */
	public ModelException() {
		this("Model Exception");
	}

	/**
	 * This constructor calls the exception class with a custom error message
	 * 
	 * @param message The custom error message
	 */
	public ModelException(String message) {
		super(message);
	}
}
