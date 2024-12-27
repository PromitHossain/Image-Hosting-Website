package solo.image_host_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "account_thread")
public class Like
{
  @Column(name = "like_date")
  private LocalDate likeDate;
  
  //-----------------------------------------
  @EmbeddedId
  private LikeId key;
   //-----------------------------------------

  protected Like() {}

  public Like(LikeId aKey, LocalDate aLikeDate, Account aUserWhoLiked, Thread aLikedThread)
  {
    key = aKey;
    likeDate = aLikeDate;
    
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

  @Embeddable
  public static class LikeId implements Serializable {
    @ManyToOne
    @Column(name = "user_id")
    private Account userWhoLiked;

    @ManyToOne
    @Column(name = "thread_id")
    private Thread likedThread;

    public LikeId() {
      super();
    }

    public LikeId(Account userWhoLiked, Thread likedThread) {
      this.userWhoLiked = userWhoLiked;
      this.likedThread = likedThread;
    }

    public Account getUserWhoLikedAccount() {
      return userWhoLiked;
    }

    public Thread getLikedThread() {
      return likedThread;
    }

    @Override 
    public int hashCode() {
      return Objects.hash(this.getUserWhoLikedAccount().getUserID(), this.getLikedThread().getThreadID());
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof LikeId)) {
        return false;
      }

      LikeId validatingLike = (LikeId) o;
      
      if (this.getUserWhoLikedAccount().getUserID() == validatingLike.getUserWhoLikedAccount().getUserID() && this.getLikedThread().getThreadID() == validatingLike.likedThread.getThreadID()) {
        return true;
      } else {
        return false;
      }
    }


  }
}