package com.hexaware.main;

import com.hexaware.dao.VirtualArtGalleryServiceImpl;
import com.hexaware.dao.VirtualArtGallerydao;
import com.hexaware.entity.Artist;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import com.hexaware.entity.User;
import com.hexaware.exception.ArtWorkNotFoundException;
import com.hexaware.exception.ArtistNotFoundException;
import com.hexaware.exception.GalleryIdNotFoundException;
import com.hexaware.exception.UserNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * The main class for the Virtual Art Gallery application.
 * This class serves as the entry point for the program and contains
 * the main method for user interaction with the application.
 *
 * @version 1.0
 * @since 2023-01-01
 */
public class MainModule {
  /**
 * Scanner object for reading user input throughout the application.
 */
  private static Scanner scanner = new Scanner(System.in);
  
  /**
 * Service implementation to interact with the Virtual Art Gallery functionalities.
 */
  private static VirtualArtGalleryServiceImpl virtualArtGalleryServiceImpl = 
      new VirtualArtGalleryServiceImpl();
  
  /**
 * Data access object for managing interactions with the virtual art gallery's data.
 */
  private static VirtualArtGallerydao virtualArtGallerydao = new VirtualArtGallerydao();
    
  /**
   * The main method for the Virtual Art Gallery application.
   * Displays a welcome message and a menu of categories (Artist, Artwork, User, Gallery, Exit).
   * Utilizes a loop to continuously prompt the user for their choice until they choose to exit.
   * The method uses switch-case statements to execute the corresponding category's options
   * based on the user's input. The available categories include Artist, Artwork, User, Gallery, 
   * and Exit.
   *
   * @param args The command line arguments (not used in this application).
   * @throws ArtWorkNotFoundException If an issue occurs related to artwork not found.
   */
  public static void main(String[] args) throws ArtWorkNotFoundException {
    while (true) {
      System.out.println("Welcome to the Virtual Art Gallery");
      System.out.println("1. Artist");
      System.out.println("2. Artwork");
      System.out.println("3. User");
      System.out.println("4. Gallery");
      System.out.println("0. Exit");
      System.out.println("Enter your choice: ");
      int categoryChoice = scanner.nextInt();
      scanner.nextLine();

      switch (categoryChoice) {
        case 1:
          artistOptions();
          break;
        case 2:
          artworkOptions();
          break;
        case 3:
          userOptions();
          break;
        case 4:
          galleryOptions();
          break;
        case 0:
          System.out.println("Exiting the program.");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    }
  }
    
  /**
 * Displays a menu of options related to artists and prompts the user to choose an action.
 * The method runs in a loop, allowing the user to perform various actions related to artists
 * until the user chooses to go back to the main menu or exit the program.
 * The available options include adding an artist, returning to the main menu, 
 * and exiting the program.
 * The method uses switch-case statements to execute the chosen action based on the user's input.
 */
  private static void artistOptions() {
    while (true) {
      System.out.println("Artist Options:");
      System.out.println("1. Add Artist");
      System.out.println("2. Back to Main Menu");
      System.out.println("0. Exit");
      System.out.println("Enter your choice: ");
      int artistChoice = scanner.nextInt();
      scanner.nextLine();

      switch (artistChoice) {
        case 1:
          addArtist();
          break;
        case 2:
          return; 
        case 0:
          System.out.println("Exiting the program.");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    }
  }

  /**
   * Displays a menu of options related to artists and prompts the user to choose an action.
   * The method runs in a loop, allowing the user to perform various actions related to artists
   * until the user chooses to go back to the main menu or exit the program.
   * The available options include adding an artist, returning to the main menu, 
   * and exiting the program.
   * The method uses switch-case statements to execute the chosen action based on the user's input.
   *
   * @param scanner The {@code Scanner} object for reading user input throughout the application.
   */
  private static void artworkOptions() throws ArtWorkNotFoundException {
    while (true) {
      System.out.println("Artwork Options:");
      System.out.println("1. Add Artwork");
      System.out.println("2. Update Artwork");
      System.out.println("3. Remove Artwork");
      System.out.println("4. Get Artwork by ID");
      System.out.println("5. Add Artwork to User Favourites");
      System.out.println("6. Search Artwork by keyword");
      System.out.println("7. Back to Main Menu");
      System.out.println("0. Exit");
      System.out.println("Enter your choice: ");
      int artworkChoice = scanner.nextInt();
      scanner.nextLine();

      switch (artworkChoice) {
        case 1:
          addArtwork();
          break;
        case 2:
          updateArtwork();
          break;
        case 3:
          removeArtwork();
          break;
        case 4:
          getArtworkById();
          break;
        case 5:
          addArtworkToUserFavourites();
          break;
        case 6:
          searchArtworkbykeyword();
          break;
        case 7:
          return; 
        case 0:
          System.out.println("Exiting the program.");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    }
  }

  /**
   * Provides a menu for user-related options.
   * The user can choose from the following options:
   * 1. Create User: Prompts the user to enter details for a new user 
   * and adds it to the Virtual Art Gallery.
   * 2. Display User's Favorite Artworks: Prompts the user to enter their User ID 
   * and displays a list of their favorite artworks.
   * 3. Remove Artwork from User Favorites: Prompts the user to enter their User ID 
   * and Artwork ID to remove an artwork from their favorites.
   * 4. Back to Main Menu: Exits the user options and returns to the main menu.
   * 0. Exit: Exits the program.
   * Uses a switch statement to handle the user's choice and calls the 
   * corresponding method for each option.
   *
   * @param scanner The {@code Scanner} object for reading user input throughout the application.
   */
  private static void userOptions() {
    while (true) {
      System.out.println("User Options:");
      System.out.println("1. Create User");
      System.out.println("2. Display User's Favorite Artworks");
      System.out.println("3. Remove Artwork from User Favourite");
      System.out.println("4. Back to Main Menu");
      System.out.println("0. Exit");
      System.out.println("Enter your choice: ");
      int userChoice = scanner.nextInt();
      scanner.nextLine();

      switch (userChoice) {
        case 1:
          addUser();
          break;
        case 2:
          getUserFavoriteArtworks();
          break;
        case 3:
          removeUserFavoriteArtworks();
          break;
        case 4:
          return; 
        case 0:
          System.out.println("Exiting the program.");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    }
  }
  /**
   * Provides a menu for gallery-related options.
   * The user can choose from the following options:
   * 1. Create Gallery: Prompts the user to enter details for a new gallery 
   * and adds it to the Virtual Art Gallery.
   * 2. Add Artist to Gallery: Prompts the user to enter Gallery ID and Artist ID 
   * to add an artist to a specific gallery.
   * 3. Remove Artist from Gallery: Prompts the user to enter Gallery ID 
   * to remove an artist from a specific gallery.
   * 4. Back to Main Menu: Exits the gallery options and returns to the main menu.
   * 0. Exit: Exits the program.
   * Uses a switch statement to handle the user's choice and calls the 
   * corresponding method for each option.
   *
   * @param scanner The {@code Scanner} object for reading user input throughout the application.
   */
  
  private static void galleryOptions() {
    while (true) {
      System.out.println("Gallery Options:");
      System.out.println("1. Create Gallery");
      System.out.println("2. Add Artist to Gallery");
      System.out.println("3. Remove Artist from Gallery");
      System.out.println("4. Back to Main Menu");
      System.out.println("0. Exit");
      System.out.println("Enter your choice: ");
      int galleryChoice = scanner.nextInt();
      scanner.nextLine();

      switch (galleryChoice) {
        case 1:
          createGallery();
          break;
        case 2:
          addArtistToGallery();
          break;
        case 3:
          removeArtistFromGallery();
          break;
        case 4:
          return; 
        case 0:
          System.out.println("Exiting the program.");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    }
  }

  /**
   * Prompts the user to enter details for a new artist and 
   * adds the artist to the Virtual Art Gallery.
   * The user is prompted to enter the following details:
   * - Artist Id
   * - Artist Name
   * - Artist Biography
   * - Artist Nationality
   * - Artist Website
   * - Artist Contact Information
   * - Artist Birth Date
   * Validates if the entered Artist Id already exists and throws an exception if it does.
   * Creates a new {@code Artist} object with the entered details 
   * and adds it to the Virtual Art Gallery.
   *
   * @throws ArtistNotFoundException if the entered Artist Id already exists in the gallery.
   */
  
  private static void addArtist() {
    try {
      System.out.println("Enter Artist Id: ");
      int artistId = scanner.nextInt();
      scanner.nextLine(); 
      if (virtualArtGallerydao.artistIdExists(artistId)) {
        throw new ArtistNotFoundException("Artist with ID " + artistId + " already exists. " 
          + "Please choose a different ID.");
    
      }

      System.out.println("Enter Artist Name: ");
      String name = scanner.nextLine();

      System.out.println("Enter Artist Biography: ");
      String biography = scanner.nextLine();

      System.out.println("Enter Artist Nationality: ");
      String nationality = scanner.nextLine();

      System.out.println("Enter Artist Website: ");
      String website = scanner.nextLine();

      System.out.println("Enter Artist Contact Information: ");
      String contactInformation = scanner.nextLine();
    
      System.out.println("Enter Artist Birth Date: ");
      String birthDate = scanner.nextLine();
      Date birthdate = parseDate(birthDate);
       
      Artist artist = new Artist(name, biography, nationality, website, contactInformation,
          birthdate, artistId);
      virtualArtGalleryServiceImpl.addArtist(artist);
    } catch (ArtistNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * Prompts the user to enter details for a new artwork and 
   * adds the artwork to the Virtual Art Gallery.
   * The user is prompted to enter the following details:
   * - Artwork Id
   * - Artist Id
   * - Artwork Title
   * - Artwork Description
   * - Artwork Creation Date
   * - Artwork Medium
   * - Image URL
   * Validates if the entered Artwork Id already exists and throws an exception if it does.
   * Validates if the entered Artist Id exists and throws an exception if it doesn't.
   * Creates a new {@code Artwork} object with the entered details 
   * and adds it to the Virtual Art Gallery.
   *
   * @throws ArtWorkNotFoundException if the entered Artwork Id already exists in the gallery.
   * @throws ArtistNotFoundException if the entered Artist Id does not exist in the gallery.
   */
  
  private static void addArtwork() {
    try {
      System.out.println("Enter Artwork Id: ");
      int artworkId = scanner.nextInt();
      scanner.nextLine();

      if (virtualArtGallerydao.artworkIdExists(artworkId)) {
        throw new ArtWorkNotFoundException("Artwork with ID " + artworkId 
        + " already exist.");
      }

      System.out.println("Enter Artist Id: ");
      int artistId = scanner.nextInt();
      scanner.nextLine();
      
      if (!virtualArtGallerydao.artistIdExists(artistId)) {
        throw new ArtistNotFoundException("Artist with ID " + artistId + " does not exists. " 
              + "Please choose a different ID.");
        
      }

      System.out.println("Enter Artwork Title: ");
      String title = scanner.nextLine();

      System.out.println("Enter Artwork Description: ");
      String description = scanner.nextLine();

      System.out.println("Enter Artwork CreationDate (YYYY-MM-DD): ");
      String creationDateStr = scanner.nextLine();

      Date creationDate = parseDate(creationDateStr);

      System.out.println("Enter Artwork Medium: ");
      String medium = scanner.nextLine();

      System.out.println("Enter Image URL: ");
      String imageUrl = scanner.nextLine();

      Artwork artwork = new Artwork(artworkId, title, description, creationDate, medium, 
            imageUrl, artistId);
      virtualArtGalleryServiceImpl.addArtwork(artwork);
    } catch (ArtWorkNotFoundException | ArtistNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * Prompts the user to enter details for updating an existing artwork in the Virtual Art Gallery.
   * The user is prompted to enter the Artwork Id to be updated and the updated details:
   * - Updated Artwork Title
   * - Updated Artwork Description
   * - Updated Artwork Medium
   * - Updated Image URL
   * Validates if the entered Artwork Id exists and throws an exception if it doesn't.
   * Updates the specified artwork with the entered details in the Virtual Art Gallery.
   *
   * @throws ArtWorkNotFoundException if the entered Artwork Id does not exist in the gallery.
   */
  private static void updateArtwork() {
    try {
      System.out.println("Enter Artwork Id to update: ");
      int artWorkid = scanner.nextInt();
      scanner.nextLine();
    
      if (!virtualArtGallerydao.artworkIdExists(artWorkid)) {
        throw new ArtWorkNotFoundException("Artwork with ID " + artWorkid 
        + " does not exist.");
      }
    
      System.out.println("Update Artist Title: ");
      String title = scanner.nextLine();
    
      System.out.println("Update Artwork Description: ");
      String description = scanner.nextLine();
    
      System.out.println("Update Artwork Medium: ");
      String medium = scanner.nextLine();

      System.out.println("Update Image URL: ");
      String imageUrl = scanner.nextLine();
         
      virtualArtGalleryServiceImpl.updateArtwork(artWorkid, title, description,
           medium, imageUrl);
    } catch (ArtWorkNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
  /**
   * Prompts the user to enter the Artwork ID for removing an artwork from the Virtual Art Gallery.
   * Validates if the entered Artwork ID exists in the gallery.
   * Removes the specified artwork from the Virtual Art Gallery.
   *
   * @param artWorkId The ID of the artwork to be removed.
   */
  
  private static void removeArtwork() {
    System.out.println("Enter Artwork ID to remove:");
    int artWorkiD = scanner.nextInt();
    virtualArtGalleryServiceImpl.removeArtwork(artWorkiD); 
        
  }
    
  /**
   * Prompts the user to enter the Artwork ID for retrieving 
   * details of an artwork from the Virtual Art Gallery.
   * Validates if the entered Artwork ID exists in the gallery.
   * Retrieves and displays details of the specified artwork.
   *
   * @param artWorkId The ID of the artwork for which details are to be retrieved.
   * @throws ArtWorkNotFoundException If the specified artwork ID 
   *     does not exist in the Virtual Art Gallery.
   */ 
  private static void getArtworkById() throws ArtWorkNotFoundException {
    try {
      System.out.println("Enter Artwork ID to get details:");
      int artWorkiD = scanner.nextInt();
      if (!virtualArtGallerydao.artworkIdExists(artWorkiD)) {
        throw new ArtWorkNotFoundException("Artwork with ID " + artWorkiD + " does not exist.");
      }
    
      virtualArtGalleryServiceImpl.getArtworkById(artWorkiD);

    } catch (ArtWorkNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
    
  /**
   * Prompts the user to enter the User ID and Artwork ID 
   * for adding an artwork to the user's favorites.
   * Validates if the entered User ID and Artwork ID exist in the Virtual Art Gallery.
   * Adds the specified artwork to the user's list of favorite artworks.
   *
   * @param userId The ID of the user for whom the artwork is to be added to favorites.
   * @param artworkId The ID of the artwork to be added to the user's favorites.
   */
  private static void addArtworkToUserFavourites() {
    try {
      System.out.println("Enter UserId:");
      int userId = scanner.nextInt();
    
      if (!virtualArtGallerydao.userIdExists(userId)) {
        throw new UserNotFoundException("User with ID " + userId + " does not exist.");
      }

      System.out.println("Enter Artwork Id:");
      int artworkId = scanner.nextInt();
    
      if (!virtualArtGallerydao.artworkIdExists(artworkId)) {
        throw new ArtWorkNotFoundException("Artwork with ID " + artworkId + " does not exist.");
      }
   
      virtualArtGalleryServiceImpl.addArtworktoUserFav(userId, artworkId);

      System.out.println("Artwork added to user's favorites successfully.");
    } catch (ArtWorkNotFoundException | UserNotFoundException  e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Prompts the user to enter a keyword for searching artworks.
   * Calls the Virtual Art Gallery service to search for artworks based on the provided keyword.
   *
   * @param keyword The keyword to be used for searching artworks.
   */
  private static void searchArtworkbykeyword() {
    System.out.println("Enter a keyword to search for artworks:");
    String keyword = scanner.nextLine();
    virtualArtGalleryServiceImpl.searchArtworks(keyword);
  }
    
  /**
   * Prompts the user to enter details for creating a new user.
   * Calls the Virtual Art Gallery service to create a new user based on the provided details.
   *
   * @param userId The ID of the user to be created.
   * @param userName The username of the user.
   * @param password The password of the user.
   * @param email The email address of the user.
   * @param firstName The first name of the user.
   * @param lastName The last name of the user.
   * @param dateOfBirth The date of birth of the user in the format (YYYY-MM-DD).
   * @param profilePicture The URL or path of the user's profile picture.
   */
  private static void addUser() {
    try {
      System.out.println("Enter User Id: ");
      int userId = scanner.nextInt(); 
      scanner.nextLine();
    
      if (virtualArtGallerydao.userIdExists(userId)) {
        throw new UserNotFoundException("User with ID " + userId + " already exist.");
      }

      System.out.println("Enter UserName: ");
      String userName = scanner.nextLine();

      System.out.println("Enter Password: ");
      String password = scanner.nextLine();

      System.out.println("Enter Email: ");
      String email = scanner.nextLine();

      System.out.println("Enter First Name: ");
      String firstName = scanner.nextLine();

      System.out.println("Enter Last Name: ");
      String lastName = scanner.nextLine();
    
      System.out.println("Enter Date of Birth (YYYY-MM-DD): ");
      String dateofBirth = scanner.nextLine();

      Date date = parseDate(dateofBirth);
    
      System.out.println("Upload Profile picture: ");
      String profilePicture = scanner.nextLine();

      User user = new User(userId, userName, password, email, firstName, lastName, date, 
          profilePicture);

      virtualArtGalleryServiceImpl.createUser(user);
    } catch (UserNotFoundException  e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Parses the given date string in the format "yyyy-MM-dd" 
   * and returns a {@code java.sql.Date} object.
   *
   * @param dateStr The date string to be parsed.
   * @return A {@code java.sql.Date} object representing the parsed date, or {@code null} if the
   *         provided date string is in an invalid format.
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
   * Retrieves the list of favorite artwork IDs for a user.
   *
   * @param userId The ID of the user.
   * @throws UserNotFoundException If no user is found with the given ID or no favorite artworks
   *                                are found for the user.
   */
  private static void getUserFavoriteArtworks() {
    try {
      System.out.println("Enter User ID to get favorite artworks:");
      int userId = scanner.nextInt();
      List<Integer> favoriteArtworkIds = 
            virtualArtGalleryServiceImpl.getUserFavoriteArtworks(userId);

      if (favoriteArtworkIds.isEmpty()) {
        throw new UserNotFoundException("No User found/fav artworks found for the given user.");
      }

      System.out.println("User " + userId + " favorite artwork IDs: " + favoriteArtworkIds);
    } catch (UserNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Removes an artwork from the list of favorite artworks for a user.
   *
   * @param userId    The ID of the user.
   * @param artworkId The ID of the artwork to be removed from the user's favorites.
   * @throws UserNotFoundException If no user is found with the given ID.
   */
  private static void removeUserFavoriteArtworks() {
    try {
      System.out.println("Enter the User Id:");
      int userId = scanner.nextInt();
    
      if (!virtualArtGallerydao.userIdExists(userId)) {
        throw new UserNotFoundException("User with ID " + userId + " does not exist.");
      }

      System.out.println("Enter the Artwork Id:");
      int artworkId = scanner.nextInt();
      virtualArtGalleryServiceImpl.removeArtworkFromFavorite(userId, artworkId);
    } catch (UserNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
    
  /**
   * Creates a new gallery in the virtual art gallery.
   *
   * @param galleryId   The ID of the gallery.
   * @param name        The name of the gallery.
   * @param description The description of the gallery.
   * @param location    The location of the gallery.
   * @param curatorId   The ID of the curator artist.
   * @param openingHoursStr The opening hours of the gallery in HH:mm format.
   * @throws GalleryIdNotFoundException If a gallery with the given ID already exists.
   * @throws ArtistNotFoundException    If no artist is found with the given curator ID.
   */
  private static void createGallery() {
    try {
      System.out.println("Enter Gallery Id: ");
      int galleryiD = scanner.nextInt();
      scanner.nextLine();

      if (virtualArtGallerydao.galleryIdExists(galleryiD)) {
        throw new GalleryIdNotFoundException("Gallery with ID " + galleryiD + " already exists. "
             + "Please choose a different ID.");
      }

      System.out.println("Enter Gallery Name: ");
      String name = scanner.nextLine();

      System.out.println("Enter Gallery description: ");
      String description = scanner.nextLine();

      System.out.println("Enter Gallery Location: ");
      String location = scanner.nextLine();

      System.out.println("Enter Curator/Artist Id: ");
      int curator = scanner.nextInt();
    
      if (virtualArtGallerydao.artistIdExists(curator)) {
        throw new ArtistNotFoundException("Artist with ID " + curator + " already exists. " 
              + "Please choose a different ID.");
        
      }

      System.out.println("Enter Opening hours in HH:mm format: ");
      scanner.nextLine();
      String openingHoursStr = scanner.nextLine();

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

      LocalTime openingHours = null;

      try {
        openingHours = LocalTime.parse(openingHoursStr, formatter);
      } catch (Exception e) {
        System.out.println("Invalid time format. Please enter time in HH:mm format.");
        return;
      }

      Gallery gallery = new Gallery(galleryiD, name, description, location, curator, openingHours);
      virtualArtGalleryServiceImpl.createGallery(gallery);
    } catch (ArtistNotFoundException | GalleryIdNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
  /**
   * Removes an artist from a gallery in the virtual art gallery.
   *
   * @param galleryId The ID of the gallery.
   */
  
  private static void removeArtistFromGallery() {
    System.out.println("Enter Gallery Id: ");
    int galleryid = scanner.nextInt();
    virtualArtGalleryServiceImpl.removeArtistFromGallery(galleryid);
  }

  /**
   * Adds an artist to a gallery in the virtual art gallery.
   *
   * @param galleryId The ID of the gallery.
   * @param curatorId The ID of the curator artist.
   */
  private static void addArtistToGallery() {
    System.out.println("Enter Gallery Id: ");
    int galleryId = scanner.nextInt();
    System.out.println("Enter Curator/Artist Id: ");
    int curatorId = scanner.nextInt();
    virtualArtGalleryServiceImpl.addArtistToGallery(galleryId, curatorId);
  }

}