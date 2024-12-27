package solo.image_host_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {

  @Id
  @GeneratedValue
  @Column(name = "tag_id")
  private int tagID;

  @Column(name = "tag_name")
  private String tagName;

  protected Tag() {}

  public Tag(String aTagName)
  {
   tagName = aTagName;

  }

  public boolean setTagID(int aTagID)
  {
    boolean wasSet = false;
    tagID = aTagID;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aTagName)
  {
    boolean wasSet = false;
   tagName = aTagName;

    wasSet = true;
    return wasSet;
  }

  public int getTagID()
  {
    return tagID;
  }

  public String getName()
  {
    return tagName;
  }

  public void delete() {}


  public String toString()
  {
    return super.toString() + "["+
            "tagID" + ":" + getTagID()+ "," +
             "tagName" + ":" + getName() + "]";
  }
}