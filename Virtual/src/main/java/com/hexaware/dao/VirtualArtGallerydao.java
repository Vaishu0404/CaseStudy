package com.hexaware.dao;

import com.hexaware.entity.Artist;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import com.hexaware.entity.User;
import com.hexaware.util.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The `VirtualArtGallerydao` class provides data access 
 * functionality for the Virtual Art Gallery system.
 * It includes methods for inserting, updating, and retrieving 
 * artwork, artist, user, and gallery information
 * from the underlying database.
 */
public class VirtualArtGallerydao {
  /**
 * Inserts artwork details into the database.
 *
 * @param artwork The artwork object to be inserted.
 */
  Connection connection;
  Statement statement;
  PreparedStatement preparedStatement;
  ResultSet resultSet;
  /**
   * Inserts artwork details into the database.
   *
   * @param artwork The artwork object to be inserted.
   */
  
  public void insertArtwork(Artwork artwork) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement("INSERT INTO artwork "
      + "VALUES (?, ?, ?, ?, ?, ?, ?)");
      
      preparedStatement.setInt(1, artwork.getArtworkId());
      preparedStatement.setString(2, artwork.getTitle());
      preparedStatement.setString(3, artwork.getDescription());
      preparedStatement.setDate(4, artwork.getCreation_Date());
      preparedStatement.setString(5, artwork.getMedium());
      preparedStatement.setString(6, artwork.getImageUrl());
      preparedStatement.setInt(7, artwork.getArtistId());

      preparedStatement.executeUpdate();
      System.out.println("Artwork Details Inserted Successfully");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
 * Inserts artist details into the database.
 *
 * @param artist The artist object to be inserted.
 */
  
  public void insertArtist(Artist artist) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
                     "INSERT INTO artist VALUES (?, ?, ?, ?, ?, ?, ?)");

      preparedStatement.setInt(1, artist.getArtistId());
      preparedStatement.setString(2, artist.getName());
      preparedStatement.setString(3, artist.getBiography());
      preparedStatement.setDate(4, artist.getBirthDate());
      preparedStatement.setString(5, artist.getNationality());
      preparedStatement.setString(6, artist.getWebsite());
      preparedStatement.setString(7, artist.getContactInformation());

      preparedStatement.executeUpdate();
      System.out.println("Artist Details Inserted Successfully");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
 * Updates artwork details in the database.
 *
 * @param artworkId   The ID of the artwork to be updated.
 * @param title       The new title of the artwork.
 * @param description The new description of the artwork.
 * @param medium      The new medium of the artwork.
 * @param imageUrl    The new image URL of the artwork.
 */
  public void updateArtwork(int artworkId, String title, String description, 
      String medium, String imageUrl) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
                     "UPDATE artwork SET title=?, description=?, "
                     + "medium=?, imageurl=? WHERE artworkid=?");

      preparedStatement.setString(1, title);
      preparedStatement.setString(2, description);
      preparedStatement.setString(3, medium);
      preparedStatement.setString(4, imageUrl);
      preparedStatement.setInt(5, artworkId);

      preparedStatement.executeUpdate();
      System.out.println("Artwork Details Updated Successfully");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
 * Removes artwork from the database based on its ID.
 *
 * @param artworkId The ID of the artwork to be removed.
 */
  public void removeArtwork(int artworkId) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
                     "DELETE FROM artwork WHERE artworkId=?");

      preparedStatement.setInt(1, artworkId);
      int rowsDeleted = preparedStatement.executeUpdate();

      if (rowsDeleted > 0) {
        System.out.println("Artwork with ID " + artworkId + " removed successfully");
      } else {
        System.out.println("No artwork found with ID " + artworkId);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
 * Retrieves artwork details from the database based on its ID.
 *
 * @param artworkId The ID of the artwork to be retrieved.
 * @return An Artwork object containing the details of the retrieved artwork.
 */

  public Artwork getArtwork(int artworkId) {
    Artwork artwork = null;
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
                     "SELECT * FROM artwork WHERE artworkId=?"); 

      preparedStatement.setInt(1, artworkId);
      try (ResultSet rs = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
            
          artwork = new Artwork();
          artwork.setArtworkId(resultSet.getInt("artworkId"));
          artwork.setTitle(resultSet.getString("title"));
          artwork.setDescription(resultSet.getString("description"));
          artwork.setCreation_Date(resultSet.getDate("creationDate"));
          artwork.setMedium(resultSet.getString("medium"));
          artwork.setImageUrl(resultSet.getString("imageurl"));
          artwork.setArtistId(resultSet.getInt("artistid"));
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return artwork;
  }

  /**
 * Inserts user details into the database.
 *
 * @param user The user object to be inserted.
 */
  public void createuser(User user) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
                     "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setInt(1, user.getUserId());
      preparedStatement.setString(2, user.getUserName());
      preparedStatement.setString(3, user.getPassword());
      preparedStatement.setString(4, user.getEmail());
      preparedStatement.setString(5, user.getFirst_Name());
      preparedStatement.setString(6, user.getLast_Name());
      preparedStatement.setDate(7, user.getDate_of_Birth());
      preparedStatement.setString(8, user.getProfile_Picture());
            
      preparedStatement.executeUpdate();
      System.out.println("User Details Inserted Successfully");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
 * Retrieves a list of artwork IDs that are favorites for a given user.
 *
 * @param userId The ID of the user.
 * @return A List of Integer containing artwork IDs.
 */
  
  public List<Integer> getUserfavArtworkId(int userId) {
    List<Integer> favoriteArtworkIds = new ArrayList<>();
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
                     "SELECT artworkid FROM user_favorite_artwork WHERE userid=?"); 
      preparedStatement.setInt(1, userId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          int artworkid = resultSet.getInt("artworkid");
          favoriteArtworkIds.add(artworkid);
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return favoriteArtworkIds;
  }
  /**
 * Adds artwork to a user's favorites in the database.
 *
 * @param userId    The ID of the user.
 * @param artworkId The ID of the artwork to be added to favorites.
 */
  
  public void addArtworkToUserFavourites(int userId, int artworkId) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
             "INSERT INTO user_favorite_artwork (UserID, ArtworkID) VALUES (?, ?)");

      preparedStatement.setInt(1, userId);
      preparedStatement.setInt(2, artworkId);

      int rowsAffected = preparedStatement.executeUpdate();
      if (rowsAffected > 0) {
        System.out.println("Artwork added to user's favorites successfully.");
      } else {
        System.out.println("Failed to add artwork to user's favorites.");
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
    }
  }

  /**
 * Removes artwork from a user's favorites in the database.
 *
 * @param userId    The ID of the user.
 * @param artworkId The ID of the artwork to be removed from favorites.
 */
  
  public void removeArtworkFromFavorite(int userId, int artworkId) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
            "DELETE from user_favorite_artwork "
            + "where userid=? and artworkid=?");

      preparedStatement.setInt(1, userId);
      preparedStatement.setInt(2, artworkId);
      
      int rowsAffected = preparedStatement.executeUpdate();
      if (rowsAffected > 0) {
        System.out.println("Artwork deleted from user's favorites successfully.");
      } else {
        System.out.println("Failed to delete artwork from user's favorites.");
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
    }
  }

  /**
 * Creates a new gallery in the database.
 *
 * @param gallery The Gallery object to be inserted.
 */
  
  public void createGallery(Gallery gallery) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
      "INSERT INTO gallery (galleryid, name, description,"
      + " location, curatorid, openinghours) " 
      +
      "VALUES (?, ?, ?, ?, ?, ?)");
      
      preparedStatement.setInt(1, gallery.getGalleryId());
      preparedStatement.setString(2, gallery.getName());
      preparedStatement.setString(3, gallery.getDescription());
      preparedStatement.setString(4, gallery.getLocation());
      preparedStatement.setInt(5, gallery.getCurator());
      preparedStatement.setTime(6, Time.valueOf(gallery.getOpening_Hours()));
      
      int rowsAffected = preparedStatement.executeUpdate();
      if (rowsAffected > 0) {
        System.out.println("Gallery created successfully.");
      } else {
        System.out.println("Failed to create gallery.");
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
    }
  }
  /**
 * Checks if a gallery with the given ID exists in the database.
 *
 * @param galleryId The ID of the gallery.
 * @return True if the gallery exists, false otherwise.
 */

  public boolean galleryIdExists(int galleryId) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement("SELECT galleryid FROM "
      + "gallery WHERE galleryid = ?");
      preparedStatement.setInt(1, galleryId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        return resultSet.next(); 
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
      return false; 
    }
  }
  /**
  * Removes an artist from a gallery in the database.
  *
  * @param galleryid The ID of the gallery.
  */
  
  public void removeArtistFromGallery(int galleryid) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
      "UPDATE gallery SET curatorid = null WHERE galleryid = ?");

      preparedStatement.setInt(1, galleryid);

      int rowsAffected = preparedStatement.executeUpdate();
      if (rowsAffected > 0) {
        System.out.println("Artist removed from the gallery successfully.");
      } else {
        System.out.println("No matching records found. Gallery with ID " 
            + galleryid + " might not exist.");
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  /**
  * Adds an artist to a gallery in the database.
  *
  * @param galleryid The ID of the gallery.
  * @param curatorid The ID of the curator/artist.
  */
  
  public void addArtistToGallery(int galleryid, int curatorid) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
      "UPDATE gallery SET curatorid = ? WHERE galleryid = ?");

      preparedStatement.setInt(1, curatorid);
      preparedStatement.setInt(2, galleryid);

      int rowsAffected = preparedStatement.executeUpdate();
      if (rowsAffected > 0) {
        System.out.println("CuratorId updated for Gallery with ID " + galleryid);
      } else {
        System.out.println("No matching records found. "
            + "Gallery with ID " + galleryid + " might not exist.");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
  * Checks if an artist with the given ID exists in the database.
  *
  * @param artistId The ID of the artist.
  * @return True if the artist exists, false otherwise.
  */

  public boolean artistIdExists(int artistId) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement("SELECT artistID FROM "
      + "artist WHERE artistID = ?");
      preparedStatement.setInt(1, artistId);
      
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        return resultSet.next(); 
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
      return false; 
    }
  }
  /**
  * Checks if an artwork with the given ID exists in the database.
  *
  * @param artworkId The ID of the artwork.
  * @return True if the artwork exists, false otherwise.
  */
   
  public boolean artworkIdExists(int artworkId) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement("SELECT artworkID FROM"
      + " artwork WHERE artworkID = ?");
      preparedStatement.setInt(1, artworkId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        return resultSet.next(); 
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
      return false; 
    }
  }

  /**
  * Searches for artworks in the database based on a keyword.
  *
  * @param keyword The keyword to search for in the title or description of artworks.
  * @return A List of Artwork objects containing the matching artworks.
  */
  
  public List<Artwork> searchArtworkByKeyword(String keyword) {
    List<Artwork> matchingArtworks = new ArrayList<>();
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement(
      "SELECT * FROM artwork WHERE title LIKE ? OR description LIKE ?");

      preparedStatement.setString(1, "%" + keyword + "%");
      preparedStatement.setString(2, "%" + keyword + "%");

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          Artwork artwork = new Artwork();
          artwork.setArtworkId(resultSet.getInt("artworkId"));
          artwork.setTitle(resultSet.getString("title"));
          artwork.setDescription(resultSet.getString("description"));
          artwork.setCreation_Date(resultSet.getDate("creationDate"));
          artwork.setMedium(resultSet.getString("medium"));
          artwork.setImageUrl(resultSet.getString("imageurl"));
          artwork.setArtistId(resultSet.getInt("artistid"));

          matchingArtworks.add(artwork);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
    }
    return matchingArtworks;
  }
  
  /**
  * Checks if an user with the given ID exists in the database.
  *
  * @param userId The ID of the user.
  * @return True if the user exists, false otherwise.
  */
  public boolean userIdExists(int userId) {
    try {
      connection = Dbconnection.getConnection();
      preparedStatement = connection.prepareStatement("SELECT userID FROM"
      + " user WHERE userID = ?");
      preparedStatement.setInt(1, userId);
      
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        return resultSet.next(); 
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
      return false; 
    }
  }

  /**
   * Retrieves a gallery from the database based on the specified gallery ID.
   *
   * @param galleryId The unique identifier of the gallery to retrieve.
   * @return A `Gallery` object representing the gallery with the specified ID,
   *         or `null` if no gallery is found.
   */
  public Gallery getGalleryById(int galleryId) {
    Gallery gallery = null;
    Connection connection = null;
    try {
      connection = Dbconnection.getConnection();
      PreparedStatement ps = connection.prepareStatement("SELECT * FROM gallery "
          + "WHERE galleryId = ?");

      ps.setInt(1, galleryId);

      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          int id = rs.getInt("galleryId");
          String name = rs.getString("galleryName");
          String description = rs.getString("galleryDescription");
          String location = rs.getString("galleryLocation");
          LocalTime openingHours = rs.getTime("openingHours").toLocalTime();
          gallery = new Gallery(id, name, description, location, 1, openingHours);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace(); 
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace(); 
        }
      }
    }
    return gallery;
  }

}
