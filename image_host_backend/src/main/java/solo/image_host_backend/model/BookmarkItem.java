package solo.image_host_backend.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookmark_item")
public class BookmarkItem {

  @EmbeddedId
  private BookmarkIdKey key;
  
  protected BookmarkItem() {}

  public BookmarkItem(BookmarkIdKey aKey)
  {
    key = aKey;
  }

  public BookmarkIdKey getBookmarkIdKey() {
    return key;
  }

  @Embeddable
  public static class BookmarkIdKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Account userWhoBookmarked;

    @ManyToOne
    @JoinColumn(name = "bookmarked_thread")
    private Thread bookmarkedThread;

    protected BookmarkIdKey() {
      super();
    }

    public BookmarkIdKey(Account aUser, Thread aThread) {
      this.userWhoBookmarked = aUser;
      this.bookmarkedThread = aThread;
    }

    public Account getUserWhoBookmarkedAccount() {
      return userWhoBookmarked;
    }

    public Thread getBookmarkedThread() {
      return bookmarkedThread;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.getUserWhoBookmarkedAccount().getUserID(), this.getBookmarkedThread().getThreadID());
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof BookmarkIdKey)) {
        return false;
      }

      BookmarkIdKey validatingBookmark = (BookmarkIdKey) o;
      
      if (this.getUserWhoBookmarkedAccount().getUserID() == validatingBookmark.getUserWhoBookmarkedAccount().getUserID() && this.getBookmarkedThread().getThreadID() == validatingBookmark.getBookmarkedThread().getThreadID()) {
        return true;
      } else {
        return false;
      }
    }
    

  }
 

}