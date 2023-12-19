package com.hexaware.exception;

/**
 * The `ArtistNotFoundException` class is a custom exception that 
 * is thrown when an artwork is not found.
 * This exception extends the base `Exception` class.
 */

public class ArtistNotFoundException extends Exception {
  /**
 * Constructs an `ArtWorkNotFoundException` with the specified detail message.
 *
 * @param message The detail message explaining the exception.
 */
  public ArtistNotFoundException(String message) {
    super(message);
  }
  /**
* Returns a string representation of the `ArtWorkNotFoundException`.
*
* @return The string representation indicating the type of exception.
*/
  
  @Override
  public String toString() {
    return "ArtistNotFoundException";
  }
}