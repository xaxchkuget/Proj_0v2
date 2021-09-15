package v2BankingApp;
import java.sql.*;
import java.util.List;

public interface wBAccountsDAO {

		public void getALLAccounts(Connection conn);
					
		public Double getBalance(Connection conn, Long accountnumber);
		public void updateBalance(Connection conn,  Long accountnumber, Double Ammount);
		public void setupAccount(Connection conn,  Long accountnumber, Double Ammount, List<Array> users);


}
