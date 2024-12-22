package solo.image_host_backend.model;

import java.time.LocalDate;

public class Owner extends Account {


  public Owner(String aUsername, String aPassword, LocalDate aDateOfCreation)
  {
    super(aUsername, aPassword, aDateOfCreation);
  }

  public void delete()
  {
    super.delete();
  }

}