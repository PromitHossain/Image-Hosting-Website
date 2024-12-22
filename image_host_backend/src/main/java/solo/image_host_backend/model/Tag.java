package solo.image_host_backend.model;

public class Tag {
private int tagID;
private String name;
 
public Tag(int aTagID, String aName) {
    tagID = aTagID;
    name = aName;
}

public boolean setTagID(int aTagID) {
    boolean wasSet = false;
    tagID = aTagID;
    wasSet = true;
    return wasSet;
}

public boolean setName(String aName) {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
}

public int getTagID() {
    return tagID;
}

public String getName() {
    return name;
}

public void delete() {}

public String toString() {
    return super.toString() + "["+
    "tagID" + ":" + getTagID()+ "," +
    "name" + ":" + getName()+ "]";
}
}