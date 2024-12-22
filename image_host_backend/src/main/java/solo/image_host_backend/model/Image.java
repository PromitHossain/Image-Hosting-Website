package solo.image_host_backend.model;

public class Image {

  private int imageID;

  public Image(int aImageID)
  {
    imageID = aImageID;
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

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "imageID" + ":" + getImageID()+ "]";
  }
}
