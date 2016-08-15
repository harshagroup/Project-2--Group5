package invoice.beans;

public class ApproveHours {
	private int developerhoursid;
	private int projectnumber;
	private String developername;
	private String workdate;
	private int workhours;
	private String approvestatus;
	public int getDeveloperhoursid() {
		return developerhoursid;
	}
	public void setDeveloperhoursid(int developerhoursid) {
		this.developerhoursid = developerhoursid;
	}
	public int getProjectnumber() {
		return projectnumber;
	}
	public void setProjectnumber(int projectnumber) {
		this.projectnumber = projectnumber;
	}
	public String getDevelopername() {
		return developername;
	}
	public void setDevelopername(String developername) {
		this.developername = developername;
	}
	public String getWorkdate() {
		return workdate;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public int getWorkhours() {
		return workhours;
	}
	public void setWorkhours(int workhours) {
		this.workhours = workhours;
	}
	public String getApprovestatus() {
		return approvestatus;
	}
	public void setApprovestatus(String approvestatus) {
		this.approvestatus = approvestatus;
	}
}
