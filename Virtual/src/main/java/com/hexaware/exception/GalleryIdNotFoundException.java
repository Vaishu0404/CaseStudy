package com.hexaware.exception;

/**
 * The `GalleryIdNotFoundException` class is a custom exception that 
 * is thrown when a gallery is not found.
 * This exception extends the base `Exception` class.
 */

public class GalleryIdNotFoundException extends Exception {
  /**
 * Constructs a `GalleryIdNotFoundException` with the specified detail message.
 *
 * @param message The detail message explaining the exception.
 */
  public GalleryIdNotFoundException(String message) {
    super(message);
  }
  /**
   * Returns a string representation of the `GalleryIdNotFoundException`.
   *
   * @return The string representation indicating the type of exception.
   */
  
  @Override
  public String toString() {
    return "GalleryIdNotFoundException";
  }
}