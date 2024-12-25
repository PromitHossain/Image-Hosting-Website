package solo.image_host_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class BookmarkItem {

   //-----------------------------------------
  private Account user;

  @Column(name = "bookmarked_thread")
  private Thread bookmarkedThread;
   //-----------------------------------------

  protected BookmarkItem() {}

  public BookmarkItem(Account aUser, Thread aBookmarkedThread)
  {
    if (!setUser(aUser))
    {
      throw new RuntimeException("Unable to create BookmarkItem due to aUser. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setBookmarkedThread(aBookmarkedThread))
    {
      throw new RuntimeException("Unable to create BookmarkItem due to aBookmarkedThread. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Account getUser()
  {
    return user;
  }
  
  public Thread getBookmarkedThread()
  {
    return bookmarkedThread;
  }
  
  public boolean setUser(Account aNewUser)
  {
    boolean wasSet = false;
    if (aNewUser != null)
    {
      user = aNewUser;
      wasSet = true;
    }
    return wasSet;
  }
  
  public boolean setBookmarkedThread(Thread aNewBookmarkedThread)
  {
    boolean wasSet = false;
    if (aNewBookmarkedThread != null)
    {
      bookmarkedThread = aNewBookmarkedThread;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    user = null;
    bookmarkedThread = null;
  }

}