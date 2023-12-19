package com.hexaware.entity;

import java.time.LocalTime;

/**
 * The `Gallery` class represents an art gallery in the Virtual Art Gallery application.
 * Each gallery has a unique identifier (GalleryID), a name, description, location,
 * curator identifier (Curator), and opening hours.
 */

public class Gallery {
  private int galleryId;
  private String name;
  private String description;
  private String location;
  private int curator;
  private LocalTime openingHours;
  
  /**
* Default constructor for the Gallery class.
*/
  public Gallery() {
  }
  
  /**
 * Parameterized constructor to initialize the Gallery object with specific values.
 *
 * @param galleryId     Unique identifier for the gallery.
 * @param name          Name of the gallery.
 * @param description   Description of the gallery.
 * @param location      Location of the gallery.
 * @param curator       Identifier of the curator associated with the gallery.
 * @param openingHours Opening hours of the gallery represented as LocalTime.
 */
  public Gallery(int galleryId, String name, String description, String location, int curator,
            LocalTime openingHours) {
    super();
    this.galleryId = galleryId;
    this.name = name;
    this.description = description;
    this.location = location;
    this.curator = curator;
    this.openingHours = openingHours;
  }

  /**
 * Getter method for retrieving the unique identifier of the gallery.
 *
 * @return The unique identifier of the gallery.
 */
  public int getGalleryId() {
    return galleryId;
  }
  
  /**
 * Setter method for setting the unique identifier of the gallery.
 *
 * @param galleryId1 The unique identifier to set.
 */
  public void setGalleryId(int galleryId1) {
    galleryId = galleryId1;
  }
  
  /**
 * Getter method for retrieving the name of the gallery.
 *
 * @return The name of the gallery.
 */
  public String getName() {
    return name;
  }

  /**
 * Setter method for setting the name of the gallery.
 *
 * @param name1 The name to set.
 */
  public void setName(String name1) {
    name = name1;
  }
  
  /**
 * Getter method for retrieving the description of the gallery.
 *
 * @return The description of the gallery.
 */
  public String getDescription() {
    return description;
  }
  
  /**
 * Setter method for setting the description of the gallery.
 *
 * @param description1 The description to set.
 */
  public void setDescription(String description1) {
    description = description1;
  }
  
  /**
 * Getter method for retrieving the location of the gallery.
 *
 * @return The location of the gallery.
 */
  public String getLocation() {
    return location;
  }
  
  /**
 * Setter method for setting the location of the gallery.
 *
 * @param location1 The location to set.
 */
  public void setLocation(String location1) {
    location = location1;
  }
  
  /**
 * Getter method for retrieving the curator identifier associated with the gallery.
 *
 * @return The curator identifier.
 */
  public int getCurator() {
    return curator;
  }
  
  /**
 * Setter method for setting the curator identifier associated with the gallery.
 *
 * @param curator1 The curator identifier to set.
 */
  public void setCurator(int curator1) {
    curator = curator1;
  }
  
  /**
 * Getter method for retrieving the opening hours of the gallery.
 *
 * @return The opening hours of the gallery as LocalTime.
 */
  public LocalTime getOpening_Hours() {
    return openingHours;
  }
  
  /**
 * Setter method for setting the opening hours of the gallery.
 *
 * @param openingHours1 The opening hours to set as LocalTime.
 */
  public void setOpening_Hours(LocalTime openingHours1) {
    openingHours = openingHours1;
  }
  
  /**
 * String representation of the Gallery object.
 *
 * @return A string representation of the Gallery object.
 */
  @Override
   public String toString() {
    return "Gallery [GalleryID=" + galleryId + ", Name=" + name + ", Description=" 
      + description + ", Location="
      + location + ", Curator=" + curator + ", Opening_Hours=" + openingHours + "]";
  }
}
