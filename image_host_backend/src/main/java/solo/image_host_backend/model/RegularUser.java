package solo.image_host_backend.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class RegularUser extends Account
{
  public enum AccountStatus { Active, Archived }

  private AccountStatus accountStatus;

  protected RegularUser() {}

  public RegularUser(String aUsername, String aPassword, LocalDate aDateOfCreation, AccountStatus aAccountStatus)
  {
    super(aUsername, aPassword, aDateOfCreation);
    accountStatus = aAccountStatus;
  }

  public boolean setAccountStatus(AccountStatus aAccountStatus)
  {
    boolean wasSet = false;
    accountStatus = aAccountStatus;
    wasSet = true;
    return wasSet;
  }

  public AccountStatus getAccountStatus()
  {
    return accountStatus;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "accountStatus" + "=" + (getAccountStatus() != null ? !getAccountStatus().equals(this)  ? getAccountStatus().toString().replaceAll("  ","    ") : "this" : "null");
  }
}