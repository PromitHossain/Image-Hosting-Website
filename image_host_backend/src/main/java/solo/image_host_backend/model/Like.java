package solo.image_host_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "like")
public class Like {
  @Column(name = "like_date")
  private LocalDate likeDate;
  
  //-----------------------------------------
  @EmbeddedId
  private LikeIdKey key;
  //-----------------------------------------

  protected Like() {}

  public Like(LikeIdKey aKey, LocalDate aLikeDate)
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

  public LikeIdKey getLikeIdKey() {
    return key;
  }

  @Embeddable
  public static class LikeIdKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Account userWhoLiked;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread likedThread;

    protected LikeIdKey() {
      super();
    }

    public LikeIdKey(Account aUser, Thread aThread) {
      this.userWhoLiked = aUser;
      this.likedThread = aThread;
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
      if (!(o instanceof LikeIdKey)) {
        return false;
      }

      LikeIdKey validatingLike = (LikeIdKey) o;
      
      if (this.getUserWhoLikedAccount().getUserID() == validatingLike.getUserWhoLikedAccount().getUserID() && this.getLikedThread().getThreadID() == validatingLike.likedThread.getThreadID()) {
        return true;
      } else {
        return false;
      }
    }


  }
}