package solo.image_host_backend.model;

import java.time.LocalDate;

public class Like {
  private LocalDate dateOfLike;

  public Like(LocalDate aDateOfLike)
  {
    dateOfLike = aDateOfLike;
  }

  public boolean setDateOfLike(LocalDate aDateOfLike)
  {
    boolean wasSet = false;
    dateOfLike = aDateOfLike;
    wasSet = true;
    return wasSet;
  }

  public LocalDate getDateOfLike()
  {
    return dateOfLike;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfLike" + "=" + (getDateOfLike() != null ? !getDateOfLike().equals(this)  ? getDateOfLike().toString().replaceAll("  ","    ") : "this" : "null");
  }
}