package com.hexaware.test;

import static org.junit.Assert.*;

import com.hexaware.dao.VirtualArtGalleryServiceImpl;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;
import org.junit.Test;

/**
 * The `VirtualArtGalleryTest` class contains JUnit tests for 
 * the `VirtualArtGalleryServiceImpl` class
 * to verify the functionality of adding, updating, and removing 
 * artworks, as well as creating galleries.
 */

public class VirtualArtGalleryTest {
  VirtualArtGalleryServiceImpl virtualArtGalleryServiceImpl = 
      new VirtualArtGalleryServiceImpl();

  /**
  * Test case for adding an artwork to the virtual art gallery.
  */
  @Test
  public void testAddArtwork() {
    int artworkId = 657;
    String title = "Sunset";
    String description = "Beautiful painting of a sunset";
    String medium = "Oil";
    String imageUrl = "sunset.jpg";
    String datestr = "2023-12-12";
    int artistId = 1;
    Date date = parseDate(datestr);
    Artwork artwork = new Artwork(artworkId, title, description, date, medium, imageUrl, 
            artistId);
    virtualArtGalleryServiceImpl.addArtwork(artwork);

    
  }

  /**
   * Test case for adding a new gallery to the virtual art gallery service.
   */
  @Test
  public void testAddGallery() {
    Gallery gallery = new Gallery(657, "Modern Art Gallery", "Contemporary art collection", 
        "Downtown", 1, LocalTime.parse("09:00"));
    virtualArtGalleryServiceImpl.createGallery(gallery);
  }
  /**
   * Parses a date string in the "yyyy-MM-dd" format and returns a Date object.
   *
   * @param dateStr The date string to be parsed.
   * @return A Date object representing the parsed date.
   */
  
  private static Date parseDate(String dateStr) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      java.util.Date parsedDate = dateFormat.parse(dateStr);
      return new Date(parsedDate.getTime());
    } catch (ParseException e) {
      System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
      return null; 
    }
  }
  /**
   * Test case for updating artwork information in the virtual art gallery service.
   */
  
  @Test
  public void testUpdateArtwork() {
    int artworkId = 657;
    String title = "Sunset";
    String description = "Beautiful painting of a sunset";
    String datestr = "2023-12-12";
    String medium = "Oil";
    String imageUrl = "sunset.jpg";
    int artistId = 1;
    Date date = parseDate1(datestr);

    Artwork artwork = new Artwork(artworkId, title, description, date, medium, imageUrl, artistId);
    virtualArtGalleryServiceImpl.updateArtwork(artworkId, "Updated Sunset",
        "Updated description", "Watercolor", "updated_sunset.jpg");
  }

  /**
   * Test case for removing an artwork from the virtual art gallery service.
   */
  @Test
  public void testremoveArtwork() {
    int artworkId = 0;
    String title = "Sunset";
    String description = "Beautiful painting of a sunset";
    String datestr = "2023-12-12";
    String medium = "Oil";
    String imageUrl = "sunset.jpg";
    int artistId = 1;
    Date date = parseDate1(datestr);

    Artwork artwork = new Artwork(artworkId, title, description, date, medium, imageUrl, artistId);
    virtualArtGalleryServiceImpl.removeArtwork(0);

  }
  
  /**
   * Test case for searching artworks in the virtual art gallery service.
   */
  @Test
  public void testSearchArtworks() {
    List<Artwork> searchResults = virtualArtGalleryServiceImpl.searchArtworks("amazon");

      
  }
  
  /**
   * Parses a date string in the "yyyy-MM-dd" format and returns a Date object.
   *
   * @param dateStr The date string to be parsed.
   * @return A Date object representing the parsed date.
   */
  private static Date parseDate1(String dateStr) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      java.util.Date parsedDate = dateFormat.parse(dateStr);
      return new Date(parsedDate.getTime());
    } catch (ParseException e) {
      System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
      return null; 
    }
  }
}