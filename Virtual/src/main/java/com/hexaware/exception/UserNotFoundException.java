package com.hexaware.exception;

/**
 * The `UserNotFoundException` class is a custom exception that is thrown when a user is not found.
 * This exception extends the base `Exception` class.
 */

public class UserNotFoundException extends Exception {
  /**
 * Constructs a `UserNotFoundException` with the specified detail message.
 *
 * @param message The detail message explaining the exception.
 */
  public UserNotFoundException(String message) {
    super(message);
  }
  /**
   * Returns a string representation of the `UserNotFoundException`.
   *
   * @return The string representation indicating the type of exception.
   */
  
  @Override
  public String toString() {
    return "UserNotFoundException";
  }
}