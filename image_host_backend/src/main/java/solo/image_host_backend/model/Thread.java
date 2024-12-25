package solo.image_host_backend.model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Thread
{

  public enum ApprovalStatus { Pending, Approved }

  @Id
  @GeneratedValue
  private int threadID;

  @Column(name = "post_date")
  private LocalDate postDate;
  
  @Column(name = "approval_date")
  private LocalDate approvalDate;
  
  private int likeCount;
  
  @Column(name = "current_approval_status")
  private ApprovalStatus currentApprovalStatus;
  
   //-----------------------------------------
  @ManyToOne
  @Column(name = "thread_poster")
  private Account threadPoster;
   //-----------------------------------------

  protected Thread() {}

  public Thread(int aThreadID, LocalDate aPostDate, LocalDate anApprovalDate, int aLikeCount, ApprovalStatus aCurrentApprovalStatus, Account aThreadPoster)
  {
    threadID = aThreadID;
    postDate = aPostDate;
    approvalDate = anApprovalDate;
    likeCount = aLikeCount;
    currentApprovalStatus = aCurrentApprovalStatus;
    if (!setThreadPoster(aThreadPoster))
    {
      throw new RuntimeException("Unable to create Thread due to aThreadPoster. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public boolean setThreadID(int aThreadID)
  {
    boolean wasSet = false;
    threadID = aThreadID;
    wasSet = true;
    return wasSet;
  }

  public boolean setPostDate(LocalDate aPostDate)
  {
    boolean wasSet = false;
    postDate = aPostDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setApprovalDate(LocalDate aDateOfApproval)
  {
    boolean wasSet = false;
    approvalDate = aDateOfApproval;
    wasSet = true;
    return wasSet;
  }

  public boolean setLikeCount(int aLikeCount)
  {
    boolean wasSet = false;
    likeCount = aLikeCount;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentApprovalStatus(ApprovalStatus aCurrentApprocalStatus)
  {
    boolean wasSet = false;
    currentApprovalStatus = aCurrentApprocalStatus;
    wasSet = true;
    return wasSet;
  }

  public int getThreadID()
  {
    return threadID;
  }

  public LocalDate getPostDate()
  {
    return postDate;
  }

  public LocalDate getApprovalDate()
  {
    return approvalDate;
  }

  public int getLikeCount()
  {
    return likeCount;
  }

  public ApprovalStatus getCurrentApprovalStatus()
  {
    return currentApprovalStatus;
  }
  /* Code from template association_GetOne */
  public Account getThreadPoster()
  {
    return threadPoster;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setThreadPoster(Account aNewThreadPoster)
  {
    boolean wasSet = false;
    if (aNewThreadPoster != null)
    {
      threadPoster = aNewThreadPoster;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    threadPoster = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "threadID" + ":" + getThreadID()+ "," +
            "likeCount" + ":" + getLikeCount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfPost" + "=" + (getPostDate() != null ? !getPostDate().equals(this)  ? getPostDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfApproval" + "=" + (getApprovalDate() != null ? !getApprovalDate().equals(this)  ? getApprovalDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentApprocalStatus" + "=" + (getCurrentApprovalStatus() != null ? !getCurrentApprovalStatus().equals(this)  ? getCurrentApprovalStatus().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "threadPoster = "+(getThreadPoster()!=null?Integer.toHexString(System.identityHashCode(getThreadPoster())):"null");
  }
}