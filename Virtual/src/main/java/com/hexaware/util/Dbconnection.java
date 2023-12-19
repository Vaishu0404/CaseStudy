package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The {@code DbConnection} class provides a utility method to 
 * establish a connection to the database.
 * It reads database configuration details from a properties file named "db.properties."
 *
 * @version 1.0
 * @since 2023-01-01
 */
public class Dbconnection {
  /**
     * Represents a static {@code Connection} object that holds the database connection.
     */
  static Connection connection;
  /**
   * Retrieves a connection to the database using the configuration details from "db.properties."
   *
   * @return A {@code Connection} object representing the connection to the database.
   */
  
  public static Connection getConnection() {
    String fileName = "db.properties";
    Properties props = new Properties();
    FileInputStream fis = null;
    
    try {
      fis = new FileInputStream(fileName);
      props.load(fis);
      String url = props.getProperty("db.url");
      String un = props.getProperty("db.username");
      String pwd = props.getProperty("db.password");
      
      //System.out.println(url + un + pwd);
      connection = DriverManager.getConnection(url, un, pwd);
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
    return connection;
  }
  /**
   * The main method of the class. It prints the result of the {@link #getConnection()} method.
   *
   * @param args The command-line arguments passed to the program (not used in this example).
   */
  
  public static void main(String[] args) {
    System.out.println(getConnection());
  }

}
