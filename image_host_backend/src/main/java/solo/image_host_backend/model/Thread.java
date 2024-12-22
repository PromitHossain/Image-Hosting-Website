package solo.image_host_backend.model;

import java.time.LocalDate;

public class Thread
{

  
  public enum ApprovalStatus { Pending, Approved }

  private int threadID;
  private LocalDate dateOfPost;
  private LocalDate dateOfApproval;
  private int likeCount;
  private ApprovalStatus currentApprocalStatus;

  public Thread(int aThreadID, LocalDate aDateOfPost, LocalDate aDateOfApproval, int aLikeCount, ApprovalStatus aCurrentApprocalStatus)
  {
    threadID = aThreadID;
    dateOfPost = aDateOfPost;
    dateOfApproval = aDateOfApproval;
    likeCount = aLikeCount;
    currentApprocalStatus = aCurrentApprocalStatus;
  }

  public boolean setThreadID(int aThreadID)
  {
    boolean wasSet = false;
    threadID = aThreadID;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfPost(LocalDate aDateOfPost)
  {
    boolean wasSet = false;
    dateOfPost = aDateOfPost;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfApproval(LocalDate aDateOfApproval)
  {
    boolean wasSet = false;
    dateOfApproval = aDateOfApproval;
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

  public boolean setCurrentApprocalStatus(ApprovalStatus aCurrentApprocalStatus)
  {
    boolean wasSet = false;
    currentApprocalStatus = aCurrentApprocalStatus;
    wasSet = true;
    return wasSet;
  }

  public int getThreadID()
  {
    return threadID;
  }

  public LocalDate getDateOfPost()
  {
    return dateOfPost;
  }

  public LocalDate getDateOfApproval()
  {
    return dateOfApproval;
  }

  public int getLikeCount()
  {
    return likeCount;
  }

  public ApprovalStatus getCurrentApprocalStatus()
  {
    return currentApprocalStatus;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "threadID" + ":" + getThreadID()+ "," +
            "likeCount" + ":" + getLikeCount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfPost" + "=" + (getDateOfPost() != null ? !getDateOfPost().equals(this)  ? getDateOfPost().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfApproval" + "=" + (getDateOfApproval() != null ? !getDateOfApproval().equals(this)  ? getDateOfApproval().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentApprocalStatus" + "=" + (getCurrentApprocalStatus() != null ? !getCurrentApprocalStatus().equals(this)  ? getCurrentApprocalStatus().toString().replaceAll("  ","    ") : "this" : "null");
  }
}