package solo.image_host_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "account_thread")
public class Like
{
  @Column(name = "like_date")
  private LocalDate likeDate;
  
  //-----------------------------------------
  @EmbeddedId
  private Key key;



  @ManyToOne
  @Column(name = "user_who_liked")
  private Account userWhoLiked;

  @ManyToOne
  @Column(name = "liked_thread")
  private Thread likedThread;
   //-----------------------------------------

  protected Like() {}

  public Like(Key aKey, LocalDate aLikeDate, Account aUserWhoLiked, Thread aLikedThread)
  {
    key = aKey;
    likeDate = aLikeDate;
    if (!setUserWhoLiked(aUserWhoLiked))
    {
      throw new RuntimeException("Unable to create Like due to aUserWhoLiked. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setLikedThread(aLikedThread))
    {
      throw new RuntimeException("Unable to create Like due to aLikedThread. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public boolean setLikeDate(LocalDate aLikeDate)
  {
    boolean wasSet = false;
    likeDate = aLikeDate;
    wasSet = true;
    return wasSet;
  }

  public LocalDate getLikeDate()
  {
    return likeDate;
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
            "  " + "likeDate" + "=" + (getLikeDate() != null ? !getLikeDate().equals(this)  ? getLikeDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "userWhoLiked = "+(getUserWhoLiked()!=null?Integer.toHexString(System.identityHashCode(getUserWhoLiked())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "likedThread = "+(getLikedThread()!=null?Integer.toHexString(System.identityHashCode(getLikedThread())):"null");
  }

  @Embeddable
  public static class Key implements Serializable {
    @ManyToOne
    @Column(name = "user_id")
    private Account userWhoLiked;

    @ManyToOne
    @Column(name = "thread_id")
    private Thread likedThread;

    public Key() {
      super();
    }

    public Key(Account userWhoLiked, Thread likedThread) {
      this.userWhoLiked = userWhoLiked;
      this.likedThread = likedThread;
    }

    public Account getUserWhoLikedAccount() {
      return userWhoLiked;
    }

    public Thread getLikedThread() {
      return likedThread;
    }
  }
}