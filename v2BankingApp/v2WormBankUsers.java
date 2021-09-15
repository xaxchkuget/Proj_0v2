package v2BankingApp;
import java.io.Serializable;

public class v2WormBankUsers implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private String[] accountDetails = new String[7];
		
		
		public v2WormBankUsers(String username, String password,String email, String firstname, String lastname, String usertype, String accountnumber) {
			
			this.accountDetails[0]= username;
			this.accountDetails[1]= password;	
			this.accountDetails[2]= email;
			this.accountDetails[3]= firstname;
			this.accountDetails[4]= lastname;
			this.accountDetails[5]= usertype;
			this.accountDetails[6]= accountnumber;

		}
		
		public v2WormBankUsers(String[] args) {
					
					this.accountDetails[0]= args[0];
					this.accountDetails[1]= args[1];	
					this.accountDetails[2]= args[2];
					this.accountDetails[3]= args[3];
					this.accountDetails[4]= args[4];
					this.accountDetails[5]= args[5];
					this.accountDetails[6]= args[6];

		}

		public String toString(){
			return this.accountDetails[0]+","+this.accountDetails[1]+","+this.accountDetails[2]+","+this.accountDetails[3]+","+this.accountDetails[4]+","+this.accountDetails[5]+","+this.accountDetails[6]+"\n";
		}

		public String getAccountDetails(int Item) {
			return this.accountDetails[Item];
			}
		
		public String getAccountUserName() {
			return this.accountDetails[0];
			}
		
		public String getAccountPassword() {
			return this.accountDetails[1];
			}
		
		public String getAccountEmail() {
			return this.accountDetails[2];
			}
		
		public String getAccountFirstName() {
			return this.accountDetails[3];
			}
		
		public String getAccountLastName() {
			return this.accountDetails[4];
			}
		
		public String getAccountUserType() {
			return this.accountDetails[5];
			}
		
		public String getAccountAccountNumber() {
			return this.accountDetails[6];
			}
		
		public void setAccountDetailusername(String accountDetail) {
			this.accountDetails[0] = accountDetail;
		}
		

		public void setAccountDetailpassword(String accountDetail) {
			this.accountDetails[1] = accountDetail;
		}
		
		
		public void setAccountDetailemail(String accountDetail) {
			this.accountDetails[2] = accountDetail;
		}
		
		public void setAccountDetailfirstname(String accountDetail) {
			this.accountDetails[3] = accountDetail;
		}
		
		public void setAccountDetaillastname(String accountDetail) {
			this.accountDetails[4] = accountDetail;
		}
		
		public void setAccountDetailusertype(String accountDetail) {
			this.accountDetails[5] = accountDetail;
		}
		
		public void setAccountDetailaccountnumber(String accountDetail) {
			this.accountDetails[6] = accountDetail;
		}
		
		
		
}

	
	

