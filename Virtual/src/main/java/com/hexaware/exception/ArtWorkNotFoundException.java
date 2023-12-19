package com.hexaware.exception;

/**
 * The {@code ArtWorkNotFoundException} class is a custom exception that 
 * is thrown when an artwork is not found. This exception extends the base {@code Exception} class.
 *
 * @version 1.0
 * @since 2023-01-01
 */
public class ArtWorkNotFoundException extends Exception {
  /**
  * The detail message explaining the exception.
  */
  String message;
  /**
   * Constructs an {@code ArtWorkNotFoundException} with the specified detail message.
   *
   * @param message The detail message explaining the exception.
   */
  
  public ArtWorkNotFoundException(String message) {
    super(message);
    this.message = message;
    
  }
  /**
   * Returns a string representation of this {@code ArtWorkNotFoundException} object.
   *
   * @return A string representation of this object, including the detail message.
   */
  
  @Override
   public String toString() {
    return "ArtWorkNotFoundException [message=" + message + "]";
  }
}