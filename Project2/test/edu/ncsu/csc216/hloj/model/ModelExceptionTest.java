/**
 * 
 */
package edu.ncsu.csc216.hloj.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the ModelException class.
 * 
 * @author Claire Davis
 * @author Ashten Herr
 */
public class ModelExceptionTest {

  /**
   * Test method for the constructor
   */
  @Test
  public void testModelException() {
    ModelException me = new ModelException("Custom Exception Message");
    assertEquals("Custom Exception Message", me.getMessage());
  }

  /**
   * Test method for the custom exception constructor
   */
  @Test
  public void testModelExceptionString() {
    ModelException me = new ModelException();
    assertEquals("Model Exception", me.getMessage());
  }

}
