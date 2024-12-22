package solo.image_host_backend.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 52 "model.ump"
// line 141 "model.ump"
public class Tag
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tag Attributes
  private int tagID;
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tag(int aTagID, String aName)
  {
    tagID = aTagID;
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTagID(int aTagID)
  {
    boolean wasSet = false;
    tagID = aTagID;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public int getTagID()
  {
    return tagID;
  }

  public String getName()
  {
    return name;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "tagID" + ":" + getTagID()+ "," +
            "name" + ":" + getName()+ "]";
  }
}