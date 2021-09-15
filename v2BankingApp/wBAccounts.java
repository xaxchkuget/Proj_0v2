package v2BankingApp;

import java.lang.reflect.Array;
import java.util.List;

public class wBAccounts {

		private Long accountnumber;
		private Double balance;
		private List<Array> users;

		
		
		wBAccounts (Long accountnumber, Double balance, String[] users) {
			this.setaccountnumber(accountnumber);
			this.setbalance(balance);	
		}



		public Long getaccountnumber() {
			return accountnumber;
		}



		public void setaccountnumber(Long accountnumber) {
			this.accountnumber = accountnumber;
		}



		public Double getbalance() {
			return balance;
		}



		public void setbalance(Double balance) {
			this.balance = balance;
		}





		public void setUsers(List<Array> users) {
			this.users = users;
		}


}	

