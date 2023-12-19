package com.hexaware.entity;

import java.sql.Date;

/**
 * The `Artist` class represents an artist in the virtual art gallery system.
 */
public class Artist {
  private int artistId;
  private String name;
  private String biography;
  private String nationality;
  private String website;
  private String contactInformation;
  private Date birthDate;

/**
* Default constructor for the `Artist` class.
*/public Artist() {
  }

  /**
* Parameterized constructor for the `Artist` class.
*
* @param name               The name of the artist.
* @param biography          The biography of the artist.
* @param nationality        The nationality of the artist.
* @param website            The artist's website.
* @param contactInformation The contact information of the artist.
* @param birthDate          The birth date of the artist.
* @param artistId           The ID of the artist.
*/
  public Artist(String name, String biography, String nationality, String website, 
      String contactInformation,
      Date birthDate, int artistId) {
    this.name = name;
    this.biography = biography;
    this.nationality = nationality;
    this.website = website;
    this.contactInformation = contactInformation;
    this.birthDate = birthDate;
    this.artistId = artistId;
  }

  /**
 * Get the ID of the artist.
 *
 * @return The artist ID.
 */ 
  public int getArtistId() {
    return artistId;
  }

  /**
* Set the ID of the artist.
*
* @param artistId The artist ID to set.
*/
  public void setArtistId(int artistId) {
    this.artistId = artistId;
  }

  /**
* Get the name of the artist.
*
* @return The name of the artist.
*/
  public String getName() {
    return name;
  }
  /**
* Set the name of the artist.
*
* @param name The name to set for the artist.
*/
  
  public void setName(String name) {
    this.name = name;
  }
  
  /**
* Get the biography of the artist.
*
* @return The biography of the artist.
*/
  
  public String getBiography() {
    return biography;
  }
  /**
* Set the biography of the artist.
*
* @param biography The biography to set for the artist.
*/
  
  public void setBiography(String biography) {
    this.biography = biography;
  }

  /**
 * Get the nationality of the artist.
 *
 * @return The nationality of the artist.
 */
  public String getNationality() {
    return nationality;
  }

  /**
 * Set the nationality of the artist.
 *
 * @param nationality The nationality to set for the artist.
 */
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  /**
 * Get the website of the artist.
 *
 * @return The website of the artist.
 */
  public String getWebsite() {
    return website;
  }

  /**
 * Set the website of the artist.
 *
 * @param website The website to set for the artist.
 */
  public void setWebsite(String website) {
    this.website = website;
  }

  /**
 * Get the contact information of the artist.
 *
 * @return The contact information of the artist.
 */
  public String getContactInformation() {
    return contactInformation;
  }

  /**
 * Set the contact information of the artist.
 *
 * @param contactInformation The contact information to set for the artist.
 */
  public void setContactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
  }

  /**
 * Get the birth date of the artist.
 *
 * @return The birth date of the artist.
 */
  public Date getBirthDate() {
    return birthDate;
  }

  /**
 * Set the birth date of the artist.
 *
 * @param birthDate The birth date to set for the artist.
 */
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
  
  /**
* Override of the `toString` method to provide a string representation of the
* `Artist` object.
*
* @return A string representation of the `Artist` object.
*/
  @Override
  public String toString() {
    return "Artist [Name=" + name + ", Biography=" + biography + ", Nationality=" 
      +
        nationality + ", Website="
      + website + ", ContactInformation=" + contactInformation + ", BirthDate=" 
      +
        birthDate + ", artistId="
      + artistId + "]";
  }
}
