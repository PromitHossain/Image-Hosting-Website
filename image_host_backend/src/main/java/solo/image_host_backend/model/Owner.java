package solo.image_host_backend.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Owner extends Account
{

  protected Owner() {}

  public Owner(String aUsername, String aPassword, LocalDate aDateOfCreation)
  {
    super(aUsername, aPassword, aDateOfCreation);
  }

  public void delete()
  {
    super.delete();
  }

}