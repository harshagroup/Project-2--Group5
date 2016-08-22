package invoice.beans;

public class Budget {
	private String clientname;
	private String projectname;
	private String actualmoney;
	private String paidmoney;
	private String willpaymoney;
	private String invoicenumber;
	private String invoicedate;
	private String clientnumber;
	private String projectnumber;
	public String getClientnumber() {
		return clientnumber;
	}
	public void setClientnumber(String clientnumber) {
		this.clientnumber = clientnumber;
	}
	public String getProjectnumber() {
		return projectnumber;
	}
	public void setProjectnumber(String projectnumber) {
		this.projectnumber = projectnumber;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getActualmoney() {
		return actualmoney;
	}
	public void setActualmoney(String actualmoney) {
		this.actualmoney = actualmoney;
	}
	public String getPaidmoney() {
		return paidmoney;
	}
	public void setPaidmoney(String paidmoney) {
		this.paidmoney = paidmoney;
	}
	public String getWillpaymoney() {
		return willpaymoney;
	}
	public void setWillpaymoney(String willpaymoney) {
		this.willpaymoney = willpaymoney;
	}	
}
