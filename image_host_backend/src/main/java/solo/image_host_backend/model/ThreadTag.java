package solo.image_host_backend.model;

public class ThreadTag
{

  private Thread taggedThread;
  private Tag selectedTag;

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