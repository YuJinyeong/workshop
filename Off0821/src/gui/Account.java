package gui;

public class Account {
	private String number;
	private String Uname;
	private String Aname;
	private String total;
	private String otp;
	private String description;

	public Account() {
	}

	public Account(String number, String uname, String aname, String total, String otp, String description) {
		super();
		this.number = number;
		Uname = uname;
		Aname = aname;
		this.total = total;
		this.otp = otp;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", Uname=" + Uname + ", Aname=" + Aname + ", total=" + total + ", otp="
				+ otp + ", description=" + description + "]";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
}
