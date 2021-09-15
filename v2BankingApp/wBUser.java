package v2BankingApp;

public class wBUser {

	private String username;
	private String password;	
	private String email;
	private String firstname;
	private String lastname;
	private String usertype;
	private Double accountnumber;
	
	
	
	wBUser (String username, String password, String email, String firstname, String lastname, String usertype, Double accountnumber) {
		this.setUsername(username);
		this.setPassword(password);	
		this.setEmail(email);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setUsertype(usertype);
		this.setAccountnumber(accountnumber);
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getUsertype() {
		return usertype;
	}



	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}



	public Double getAccountnumber() {
		return accountnumber;
	}



	public void setAccountnumber(Double accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	
	

}	

