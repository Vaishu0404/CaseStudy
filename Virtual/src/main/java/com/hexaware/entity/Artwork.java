package com.hexaware.entity;

import java.sql.Date;

/**
 * Represents an artwork in the Virtual Art Gallery.
 * An artwork has various attributes such as ID, title, description, creation date,
 * medium, image URL, and the associated artist.
 */
public class Artwork {
  private int artworkId;
  private String title;
  private String description;
  private Date creationDate;
  private String medium;
  private String imageUrl;
  private int artistId;  
  private Artist artist; 
    
  /**
 * Default constructor for creating an empty Artwork object.
 */
  public Artwork() {
  }
    
  /**
 * Parameterized constructor for creating an Artwork object with specified attributes.
 *
 * @param artworkId     The unique identifier for the artwork.
 * @param title         The title of the artwork.
 * @param description   The description of the artwork.
 * @param creationDate The creation date of the artwork.
 * @param medium        The medium of the artwork.
 * @param imageUrl      The URL of the image representing the artwork.
 * @param artistId      The ID of the artist associated with the artwork.
 */
  public Artwork(int artworkId, String title, String description, Date creationDate, String medium,
                   String imageUrl, int artistId) {
    super();
    this.artworkId = artworkId;
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
    this.medium = medium;
    this.imageUrl = imageUrl;
    this.artistId = artistId;
  }
    

  /**
 * Getter for the ArtworkId.
 *
 * @return The unique identifier for the artwork.
 */
  public int getArtworkId() {
    return artworkId;
  }

  /**
 * Setter for the ArtworkId.
 *
 * @param artworkId1 The unique identifier for the artwork.
 */
  public void setArtworkId(int artworkId1) {
    artworkId = artworkId1;
  }

  /**
 * Getter for the Title.
 *
 * @return The title of the artwork.
 */
  public String getTitle() {
    return title;
  }

  /**
 * Setter for the Title.
 *
 * @param title1 The title of the artwork.
 */
  public void setTitle(String title1) {
    title = title1;
  }

  /**
 * Getter for the Description.
 *
 * @return The description of the artwork.
 */
  public String getDescription() {
    return description;
  }

  /**
 * Setter for the Description.
 *
 * @param description1 The description of the artwork.
 */
  public void setDescription(String description1) {
    description = description1;
  }

  /**
 * Getter for the Creation_Date.
 *
 * @return The creation date of the artwork.
 */
  public Date getCreation_Date() {
    return creationDate;
  }

  /**
 * Setter for the Creation_Date.
 *
 * @param creationDate1 The creation date of the artwork.
 */
  public void setCreation_Date(Date creationDate1) {
    creationDate = creationDate1;
  }

  /**
 * Getter for the Medium.
 *
 * @return The medium of the artwork.
 */
  public String getMedium() {
    return medium;
  }

  /**
 * Setter for the Medium.
 *
 * @param medium1 The medium of the artwork.
 */
  public void setMedium(String medium1) {
    medium = medium1;
  }

  /**
 * Getter for the ImageUrl.
 *
 * @return The URL of the image representing the artwork.
 */
  public String getImageUrl() {
    return imageUrl;
  }

  /**
 * Setter for the ImageUrl.
 *
 * @param imageUrl1 The URL of the image representing the artwork.
 */
  public void setImageUrl(String imageUrl1) {
    imageUrl = imageUrl1;
  }

  /**
 * Getter for the artistId.
 *
 * @return The ID of the artist associated with the artwork.
 */
  public int getArtistId() {
    return artistId;
  }

  /**
 * Setter for the artistId.
 *
 * @param artistId The ID of the artist associated with the artwork.
 */
  public void setArtistId(int artistId) {
    this.artistId = artistId;
  }

  /**
 * Getter for the artist.
 *
 * @return The Artist object representing the artist associated with the artwork.
 */
  public Artist getArtist() {
    return artist;
  }

  /**
 * Setter for the artist.
 *
 * @param artist The Artist object representing the artist associated with the artwork.
 */
  public void setArtist(Artist artist) {
    this.artist = artist;
    this.artistId = artist.getArtistId();  
  }

  /**
* Override of the `toString` method to provide a string representation of the
* `Artwork` object.
*
* @return A string representation of the `Artwork` object.
*/
  @Override
    public String toString() {
    return "Artwork [ArtworkId=" + artworkId + ", Title=" + title + ", Description=" + description
       + ", Creation_Date=" + creationDate + ", Medium=" + medium + ", ImageUrl=" + imageUrl
                + ", ArtistId=" + artistId + "]";
  }
}
