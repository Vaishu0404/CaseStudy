package com.hexaware.dao;

import com.hexaware.entity.Artist;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import com.hexaware.entity.User;
import java.util.List;

/**
 * The {@code IVirtualArtGallery} interface outlines the methods that must be implemented
 * by any class aiming to provide functionality for managing a virtual art gallery.
 *
 * @version 1.0
 * @since 2023-01-01
 */
public interface IvirtualArtGallery {
  /**
 * Adds an artwork to the virtual art gallery.
 *
 * @param artwork The {@code Artwork} object representing the artwork to be added.
 * @return {@code true} if the artwork is successfully added, {@code false} otherwise.
 */
   
  boolean addArtwork(Artwork artwork); 
  /**
   * Adds an artist to the virtual art gallery.
   *
   * @param artist The {@code Artist} object representing the artist to be added.
   */
  
  void addArtist(Artist artist);
  
  /**
   * Updates the details of an existing artwork in the virtual art gallery.
   *
   * @param artworkId The ID of the artwork to be updated.
   * @param title The updated title of the artwork.
   * @param description The updated description of the artwork.
   * @param medium The updated medium of the artwork.
   * @param imageUrl The updated image URL of the artwork.
   */

  public void updateArtwork(int artworkId, String title, String description,
       String medium, String imageUrl);

  /**
   * Removes an artwork from the virtual art gallery.
   *
   * @param artworkId The ID of the artwork to be removed.
   * @return {@code true} if the artwork is successfully removed, {@code false} otherwise.
   */
  boolean removeArtwork(int artworkId);
  
  /**
   * Retrieves an artwork from the virtual art gallery based on its ID.
   *
   * @param artworkId The ID of the artwork to be retrieved.
   * @return The {@code Artwork} object representing the retrieved artwork.
   */
  Artwork getArtworkById(int artworkId);
  /**
   * Searches for artworks in the virtual art gallery based on a keyword.
   *
   * @param keyword The keyword to be used for searching.
   * @return A list of {@code Artwork} objects matching the search criteria.
   */

  List<Artwork> searchArtworks(String keyword);
  /**
   * Adds an artwork to the list of favorite artworks for a user.
   *
   * @param userId The ID of the user.
   * @param artworkId The ID of the artwork to be added to the user's favorites.
   * @return {@code true} if the artwork is successfully added to the 
   *     favorites, {@code false} otherwise.
   */

  boolean addArtworkToFavorite(int userId, int artworkId);
  
  /**
   * Removes an artwork from the list of favorite artworks for a user.
   *
   * @param userId The ID of the user.
   * @param artworkId The ID of the artwork to be removed from the user's favorites.
   * @return {@code true} if the artwork is successfully removed 
   *     from the favorites, {@code false} otherwise.
   */

  boolean removeArtworkFromFavorite(int userId, int artworkId);
  
  /**
   * Retrieves the list of favorite artwork IDs for a user.
   *
   * @param userId The ID of the user.
   * @return A list of artwork IDs representing the user's favorite artworks.
   */

  List<Integer> getUserFavoriteArtworks(int userId);
  /**
   * Creates a new user in the virtual art gallery.
   *
   * @param user The {@code User} object representing the user to be created.
   */

  void createUser(User user);
  /**
   * Adds an artwork to the list of favorite artworks for a user.
   *
   * @param userId The ID of the user.
   * @param artworkId The ID of the artwork to be added to the user's favorites.
   */
  
  void addArtworktoUserFav(int userId, int artworkId);
  /**
   * Creates a new gallery in the virtual art gallery.
   *
   * @param gallery The {@code Gallery} object representing the gallery to be created.
   */
  
  void createGallery(Gallery gallery);

  /**
   * Removes an artist from a gallery in the virtual art gallery.
   *
   * @param galleryid The ID of the gallery.
   */
  void removeArtistFromGallery(int galleryid);
  /**
   * Adds an artist to a gallery in the virtual art gallery.
   *
   * @param galleryId The ID of the gallery.
   * @param curatorId The ID of the curator artist.
   */

  void addArtistToGallery(int galleryId, int curatorId);   
}
