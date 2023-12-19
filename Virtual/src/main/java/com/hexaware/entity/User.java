package com.hexaware.entity;

import java.sql.Date;

/**
 * The `User` class represents a user entity in the virtual art gallery system.
 * It encapsulates information such as user details, including ID, username, password,
 * email, first name, last name, date of birth, and profile picture.
 */
public class User {

  private int userId;
  private String username;
  private String password;
  private String email;
  private String firstName;
  private String lastName;
  private Date dateofBirth;
  private String profilePicture;


  /**
 * Default constructor for the `User` class.
 */
  public User() {
  }
  
  /**
 * Parameterized constructor for the `User` class.
 *
 * @param userId         The unique identifier for the user.
 * @param userName       The username of the user.
 * @param password       The password associated with the user.
 * @param email          The email address of the user.
 * @param firstName     The first name of the user.
 * @param lastName      The last name of the user.
 * @param dateofBirth  The date of birth of the user.
 * @param profilepicture The profile picture URL or path of the user.
 */
  public User(int userId, String userName, String password, String email,
      String firstName, String lastName, Date dateofBirth,
      String profilepicture) {
    super();
    this.userId = userId;
    this.username = userName;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateofBirth = dateofBirth;
    this.profilePicture = profilepicture;
  }

  /**
   * Gets the user ID.
   *
   * @return The user ID.
   */
  public int getUserId() {
    return userId;
  }
  
  /**
   * Sets the user ID.
   *
   * @param userId1 The user ID to set.
   */
  public void setUserId(int userId1) {
    userId = userId1;
  }
  /**
   * Gets the username.
   *
   * @return The username.
   */
  
  public String getUserName() {
    return username;
  }
  /**
   * Sets the username.
   *
   * @param userName The username to set.
   */
  
  public void setUserName(String userName) {
    username = userName;
  }
  
  /**
   * Gets the password.
   *
   * @return The password.
   */
  public String getPassword() {
    return password;
  }
  
  /**
   * Sets the password.
   *
   * @param password1 The password to set.
   */
  public void setPassword(String password1) {
    password = password1;
  }
  
  /**
   * Gets the email address.
   *
   * @return The email address.
   */
  public String getEmail() {
    return email;
  }
  
  /**
   * Sets the email address.
   *
   * @param email1 The email address to set.
   */
  public void setEmail(String email1) {
    email = email1;
  }
  
  /**
   * Gets the first name.
   *
   * @return The first name.
   */
  public String getFirst_Name() {
    return firstName;
  }
  
  /**
   * Sets the first name.
   *
   * @param firstName1 The first name to set.
   */
  public void setFirst_Name(String firstName1) {
    firstName = firstName1;
  }
  /**
   * Gets the last name.
   *
   * @return The last name.
   */
  
  public String getLast_Name() {
    return lastName;
  }
  /**
   * Sets the last name.
   *
   * @param lastName1 The last name to set.
   */
  
  public void setLast_Name(String lastName1) {
    lastName = lastName1;
  }
  /**
   * Gets the date of birth.
   *
   * @return The date of birth.
   */
  
  public Date getDate_of_Birth() {
    return dateofBirth;
  }
  /**
   * Sets the date of birth.
   *
   * @param dateofBirth1 The date of birth to set.
   */
  
  public void setDate_of_Birth(Date dateofBirth1) {
    dateofBirth = dateofBirth1;
  }
  /**
   * Gets the profile picture URL or path.
   *
   * @return The profile picture URL or path.
   */
  
  public String getProfile_Picture() {
    return profilePicture;
  }
  /**
   * Sets the profile picture URL or path.
   *
   * @param profilePicture1 The profile picture URL or path to set.
   */
  
  public void setProfile_Picture(String profilePicture1) {
    profilePicture = profilePicture1;
  }
  
  @Override
  public String toString() {
    return "User [UserId=" + userId + ", Username=" + username + ", "
      + "Password=" + password + ", Email=" + email
      + ", First_Name=" + firstName + ", Last_Name=" + lastName 
      + ", Date_of_Birth=" + dateofBirth
      + ", Profile_Picture=" + profilePicture + "]";
  }
}
