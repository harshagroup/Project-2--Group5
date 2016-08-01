package invoice.beans;

public class Client {
	private int number;
	private String name;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String contact;
	private String invoiceFreq;
	private String billingTerms;
	private String invoiceGrouping;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getInvoiceFreq() {
		return invoiceFreq;
	}
	public void setInvoiceFreq(String invoiceFreq) {
		this.invoiceFreq = invoiceFreq;
	}
	public String getBillingTerms() {
		return billingTerms;
	}
	public void setBillingTerms(String billingTerms) {
		this.billingTerms = billingTerms;
	}
	public String getInvoiceGrouping() {
		return invoiceGrouping;
	}
	public void setInvoiceGrouping(String invoiceGrouping) {
		this.invoiceGrouping = invoiceGrouping;
	}

}
