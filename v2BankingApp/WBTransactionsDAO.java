package v2BankingApp;
import java.sql.*;

public interface WBTransactionsDAO {
	
	public void getALLTransactions(Connection conn);
	
	public void generateTransferIn(Connection conn, Long Accountnumber,Double Ammount);
	public void generateTransferOut(Connection conn, Long Accountnumber, Double Ammount);
	public void generateWithdraw(Connection conn, Long Accountnumber, Double Ammount);
	public void generateDeposit(Connection conn, Long Accountnumber, Double Ammount);


}
