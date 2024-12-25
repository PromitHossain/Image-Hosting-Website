package solo.image_host_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Image
{

  @Id
  @GeneratedValue
  private int imageID;
  private String imageURL;

   //-----------------------------------------
   // will handle threads without images in service layer
  @OneToOne(optional=true)
  private Thread attachedThread;
   //-----------------------------------------


  protected Image() {}

  public Image(int aImageID, Thread aAttachedThread)
  {
    imageID = aImageID;
    if (!setAttachedThread(aAttachedThread))
    {
      throw new RuntimeException("Unable to create Image due to aAttachedThread. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public boolean setImageID(int aImageID)
  {
    boolean wasSet = false;
    imageID = aImageID;
    wasSet = true;
    return wasSet;
  }

  public int getImageID()
  {
    return imageID;
  }

  public Thread getAttachedThread()
  {
    return attachedThread;
  }
  
  public boolean setAttachedThread(Thread aNewAttachedThread)
  {
    boolean wasSet = false;
    if (aNewAttachedThread != null)
    {
      attachedThread = aNewAttachedThread;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    attachedThread = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "imageID" + ":" + getImageID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "attachedThread = "+(getAttachedThread()!=null?Integer.toHexString(System.identityHashCode(getAttachedThread())):"null");
  }
}