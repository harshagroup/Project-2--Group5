package invoice.beans;

public class DeveloperWork {
	private String project_number;
	private String developer_name;
	private String billrate;
	private String sumofworked_hours;
	public String getProject_number() {
		return project_number;
	}
	public void setProject_number(String project_number) {
		this.project_number = project_number;
	}
	public String getDeveloper_name() {
		return developer_name;
	}
	public void setDeveloper_name(String developer_name) {
		this.developer_name = developer_name;
	}
	public String getBillrate() {
		return billrate;
	}
	public void setBillrate(String billrate) {
		this.billrate = billrate;
	}
	public String getSumofworked_hours() {
		return sumofworked_hours;
	}
	public void setSumofworked_hours(String sumofworked_hours) {
		this.sumofworked_hours = sumofworked_hours;
	}
}
