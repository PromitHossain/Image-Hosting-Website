package solo.image_host_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "thread_tag")
public class ThreadTag
{

  //-----------------------------------------
  @ManyToOne
  @JoinColumn(name = "thread_id", referencedColumnName = "thread_id")
  private Thread taggedThread;

  @ManyToOne
  @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
  private Tag selectedTag;
   //-----------------------------------------

  protected ThreadTag() {}

  public ThreadTag(Thread aTaggedThread, Tag aSelectedTag)
  {
    if (!setTaggedThread(aTaggedThread))
    {
      throw new RuntimeException("Unable to create ThreadTag due to aTaggedThread. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setSelectedTag(aSelectedTag))
    {
      throw new RuntimeException("Unable to create ThreadTag due to aSelectedTag. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Thread getTaggedThread()
  {
    return taggedThread;
  }
  
  public Tag getSelectedTag()
  {
    return selectedTag;
  }
  
  public boolean setTaggedThread(Thread aNewTaggedThread)
  {
    boolean wasSet = false;
    if (aNewTaggedThread != null)
    {
      taggedThread = aNewTaggedThread;
      wasSet = true;
    }
    return wasSet;
  }
  
  public boolean setSelectedTag(Tag aNewSelectedTag)
  {
    boolean wasSet = false;
    if (aNewSelectedTag != null)
    {
      selectedTag = aNewSelectedTag;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    taggedThread = null;
    selectedTag = null;
  }

}