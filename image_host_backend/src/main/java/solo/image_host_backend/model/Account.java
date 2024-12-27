package solo.image_host_backend.model;

import java.time.LocalDate;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Account {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private int userID;
  
  @Column(columnDefinition = "VARCHAR(50) UNIQUE NOT NULL")
  private String username;
  
  @Column(columnDefinition = "VARCHAR(50) NOT NULL")
  private String password;

  // results in DATE only in SQL (no time)
  @Column(name = "creation_date")
  private LocalDate creationDate;

  protected Account() {}

  public Account(String aUsername, String aPassword, LocalDate aDateOfCreation)
  {
    username = aUsername;
    password = aPassword;
    creationDate = aDateOfCreation;
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

  public boolean setCreationDate(LocalDate aDateOfCreation)
  {
    boolean wasSet = false;
    creationDate = aDateOfCreation;
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

  public int getUserID() {
    return userID;
  }

  public LocalDate getCreationDate()
  {
    return creationDate;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfCreation" + "=" + (getCreationDate() != null ? !getCreationDate().equals(this)  ? getCreationDate().toString().replaceAll("  ","    ") : "this" : "null");
  }
}