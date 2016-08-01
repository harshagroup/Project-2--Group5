package invoice.beans;

public class Employee {
	private String name;
	private String title;
	private String role;
	private int billrate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getBillrate() {
		return billrate;
	}
	public void setBillrate(int billrate) {
		this.billrate = billrate;
	}
}
