package com.hexaware.dao;

import com.hexaware.entity.Artist;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import com.hexaware.entity.User;
import java.util.List;

/**
 * The `VirtualArtGalleryServiceImpl` class implements the `IVirtualArtGallery` interface
 * and provides the functionality to manage a virtual art gallery.
 */
public class VirtualArtGalleryServiceImpl implements IvirtualArtGallery {
  VirtualArtGallerydao virtualartgallerydao = new VirtualArtGallerydao();
  
  /**
   * Adds an artwork to the virtual art gallery.
   *
   * @param artwork The artwork to be added.
   * @return True if the addition is successful, false otherwise.
   */
  @Override
    public boolean addArtwork(Artwork artwork)  {
    virtualartgallerydao.insertArtwork(artwork);
    return false;
  }

  /**
   * Adds an artist to the virtual art gallery.
   *
   * @param artist The artist to be added.
   */
  @Override
    public void addArtist(Artist artist) {
    virtualartgallerydao.insertArtist(artist);
  }
    
  /**
   * Updates the details of an existing artwork in the virtual art gallery.
   *
   * @param artworkId   The ID of the artwork to be updated.
   * @param title       The updated title of the artwork.
   * @param description The updated description of the artwork.
   * @param medium      The updated medium of the artwork.
   * @param imageUrl    The updated image URL of the artwork.
   */
  @Override
    public void updateArtwork(int artworkId, String title, String description, 
       String medium, String imageUrl) {
    virtualartgallerydao.updateArtwork(artworkId, title, description, medium, imageUrl);
  }

  /**
   * Removes an artwork from the virtual art gallery.
   *
   * @param artworkId The ID of the artwork to be removed.
   * @return True if the removal is successful, false otherwise.
   */
  @Override
    public boolean removeArtwork(int artworkId) {
    virtualartgallerydao.removeArtwork(artworkId);
    return false;
  } 
    
  /**
   * Retrieves an artwork from the virtual art gallery by its ID.
   *
   * @param artworkId The ID of the artwork to be retrieved.
   * @return The artwork object if found, null otherwise.
   */
  @Override
    public Artwork getArtworkById(int artworkId) {
    Artwork artwork = virtualartgallerydao.getArtwork(artworkId);

    if (artwork != null) {
      System.out.println("Artwork Details:");
      System.out.println("Artwork ID: " + artwork.getArtworkId());
      System.out.println("Title: " + artwork.getTitle());
      System.out.println("Description: " + artwork.getDescription());
      System.out.println("Creation Date: " + artwork.getCreation_Date());
      System.out.println("Medium: " + artwork.getMedium());
      System.out.println("Image URL: " + artwork.getImageUrl());
      System.out.println("Artist ID: " + artwork.getArtistId());
      System.out.println("---------------------------------");
    } else {
      System.out.println("Artwork with ID " + artworkId + " not found.");
    }

    return artwork;
  }


  /**
   * Searches for artworks in the virtual art gallery based on a keyword.
   *
   * @param keyword The keyword to search for in artwork titles and descriptions.
   * @return A list of artworks matching the keyword.
   */
  @Override
  public List<Artwork> searchArtworks(String keyword) {
    List<Artwork> matchingArtworks = virtualartgallerydao.searchArtworkByKeyword(keyword);

    if (!matchingArtworks.isEmpty()) {
      System.out.println("Artworks containing the keyword '" + keyword + "':");
      for (Artwork artwork : matchingArtworks) {
        System.out.println(artwork);
      }
    } else {
      System.out.println("No artworks found containing the keyword '" + keyword + "'.");
    }
    return matchingArtworks;
  }

  /**
   * Adds an artwork to the list of favorites for a user.
   *
   * @param userId    The ID of the user adding the artwork to favorites.
   * @param artworkId The ID of the artwork to be added to favorites.
   * @return True if the addition is successful, false otherwise.
   */
  @Override
    public boolean addArtworkToFavorite(int userId, int artworkId) {
    return false;
  }

  /**
   * Removes an artwork from the list of favorites for a user.
   *
   * @param userId    The ID of the user removing the artwork from favorites.
   * @param artworkId The ID of the artwork to be removed from favorites.
   * @return True if the removal is successful, false otherwise.
   */
  @Override
    public boolean removeArtworkFromFavorite(int userId, int artworkId) {
    virtualartgallerydao.removeArtworkFromFavorite(userId, artworkId);
    return false;
  }
    
  /**
   * Retrieves the list of favorite artwork IDs for a user.
   *
   * @param userId The ID of the user.
   * @return A list of artwork IDs that are favorites for the user.
   */
  @Override
    public List<Integer> getUserFavoriteArtworks(int userId) {
    return virtualartgallerydao.getUserfavArtworkId(userId);
  }

  /**
   * Creates a new user in the virtual art gallery.
   *
   * @param user The user object representing the new user.
   */
  @Override
    public void createUser(User user) {
    virtualartgallerydao.createuser(user);
  }

  /**
   * Adds an artwork to the list of favorites for a user.
   *
   * @param userId    The ID of the user adding the artwork to favorites.
   * @param artworkId The ID of the artwork to be added to favorites.
   */
  @Override
    public void addArtworktoUserFav(int userId, int artworkId) {
    virtualartgallerydao.addArtworkToUserFavourites(userId, artworkId);
  }

  /**
   * Creates a new gallery in the virtual art gallery.
   *
   * @param gallery The gallery object representing the new gallery.
   */
  @Override
    public void createGallery(Gallery gallery) {
    virtualartgallerydao.createGallery(gallery);
  }

  /**
   * Removes an artist from a gallery in the virtual art gallery.
   *
   * @param galleryid The ID of the gallery from which the artist is to be removed.
   */
  @Override
    public void removeArtistFromGallery(int galleryid) {
    virtualartgallerydao.removeArtistFromGallery(galleryid);
  }

  /**
   * Adds an artist to a gallery in the virtual art gallery.
   *
   * @param galleryId The ID of the gallery to which the artist is to be added.
   * @param curatorId The ID of the curator/artist to be added to the gallery.
   */
  @Override
    public void addArtistToGallery(int galleryId, int curatorId) {
    virtualartgallerydao.addArtistToGallery(galleryId, curatorId);
  }
}
