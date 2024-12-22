package solo.image_host_backend.model;

import java.time.LocalDate;

public class Account {

  private String username;
  private String password;
  private LocalDate dateOfCreation;

  public Account(String aUsername, String aPassword, LocalDate aDateOfCreation)
  {
    username = aUsername;
    password = aPassword;
    dateOfCreation = aDateOfCreation;
  }

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfCreation(LocalDate aDateOfCreation)
  {
    boolean wasSet = false;
    dateOfCreation = aDateOfCreation;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public LocalDate getDateOfCreation()
  {
    return dateOfCreation;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfCreation" + "=" + (getDateOfCreation() != null ? !getDateOfCreation().equals(this)  ? getDateOfCreation().toString().replaceAll("  ","    ") : "this" : "null");
  }
}