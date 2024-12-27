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
@Table(name = "thread_tag")
public class ThreadTag {

  @EmbeddedId
  ThreadTagIdKey key;

  protected ThreadTag() {}

  public ThreadTag(ThreadTagIdKey aKey) {
    key = aKey;
  }

  @Embeddable 
  public static class ThreadTagIdKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread taggedThread;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag selectedTag;

    protected ThreadTagIdKey() {
      super();
    }

    public ThreadTagIdKey(Thread aThread, Tag aTag) {
      this.selectedTag = aTag;
      this.taggedThread = aThread;
    }

    public Thread getTaggedThread() {
      return taggedThread;
    }

    public Tag getSelectedTag() {
      return selectedTag;
    }

    @Override 
    public int hashCode() {
      return Objects.hash(this.getTaggedThread(), this.getSelectedTag());
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof ThreadTagIdKey)) {
        return false;
      }

      ThreadTagIdKey validatingSelectedThreadTag = (ThreadTagIdKey) o;
      
      if (this.getTaggedThread().getThreadID() == validatingSelectedThreadTag.getTaggedThread().getThreadID() && this.getSelectedTag().getTagID() == validatingSelectedThreadTag.getSelectedTag().getTagID()) {
        return true;
      } else {
        return false;
      }
    } 

  }

  

}