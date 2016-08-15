package invoice.beans;

public class Invoice {
	private String invoicenumber;
	private String clientnumber;
	private String projectnumber;
	private String invoicedate;
	private String amount;
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
