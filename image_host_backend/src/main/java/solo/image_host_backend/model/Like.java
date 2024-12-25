package solo.image_host_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Like
{
  @Column(name = "like_date")
  private LocalDate dateOfLike;
  
   //-----------------------------------------
  @ManyToOne
  @Column(name = "user_who_liked")
  private Account userWhoLiked;

  @ManyToOne
  @Column(name = "liked_thread")
  private Thread likedThread;
   //-----------------------------------------

  protected Like() {}

  public Like(LocalDate aDateOfLike, Account aUserWhoLiked, Thread aLikedThread)
  {
    dateOfLike = aDateOfLike;
    if (!setUserWhoLiked(aUserWhoLiked))
    {
      throw new RuntimeException("Unable to create Like due to aUserWhoLiked. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setLikedThread(aLikedThread))
    {
      throw new RuntimeException("Unable to create Like due to aLikedThread. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public boolean setDateOfLike(LocalDate aDateOfLike)
  {
    boolean wasSet = false;
    dateOfLike = aDateOfLike;
    wasSet = true;
    return wasSet;
  }

  public LocalDate getDateOfLike()
  {
    return dateOfLike;
  }
  
  public Account getUserWhoLiked()
  {
    return userWhoLiked;
  }
  
  public Thread getLikedThread()
  {
    return likedThread;
  }
  
  public boolean setUserWhoLiked(Account aNewUserWhoLiked)
  {
    boolean wasSet = false;
    if (aNewUserWhoLiked != null)
    {
      userWhoLiked = aNewUserWhoLiked;
      wasSet = true;
    }
    return wasSet;
  }
  
  public boolean setLikedThread(Thread aNewLikedThread)
  {
    boolean wasSet = false;
    if (aNewLikedThread != null)
    {
      likedThread = aNewLikedThread;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    userWhoLiked = null;
    likedThread = null;
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfLike" + "=" + (getDateOfLike() != null ? !getDateOfLike().equals(this)  ? getDateOfLike().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "userWhoLiked = "+(getUserWhoLiked()!=null?Integer.toHexString(System.identityHashCode(getUserWhoLiked())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "likedThread = "+(getLikedThread()!=null?Integer.toHexString(System.identityHashCode(getLikedThread())):"null");
  }
}