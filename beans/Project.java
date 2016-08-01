package invoice.beans;

public class Project {
	private String client;
	private int projectNumber;
	private String projectName;
	private String stateDate;
	private String endDate;
	private String status;
	private String projectManager;
	private String clientContact;
	private Double budget;
	public int getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStateDate() {
		return stateDate;
	}
	public void setStateDate(String stateDate) {
		this.stateDate = stateDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getClientContact() {
		return clientContact;
	}
	public void setClientContact(String clientContact) {
		this.clientContact = clientContact;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
}
