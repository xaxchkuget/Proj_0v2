package v2BankingApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class WBTransactionsDaoImpl implements WBTransactionsDAO {
		private static String selectall = "SELECT * FROM Transactions;";
		private static String create = "INSERT INTO Transactions (Ammount,'Type',Account) VALUES (?,?,?);";

	
		@Override
		public void getALLTransactions(Connection conn) {
			try {
				PreparedStatement ps=conn.prepareStatement(selectall);
				ResultSet rs=ps.executeQuery();
			
				
					while(rs.next())
					{
						
						System.out.println(rs.getString("Transaction_ID")+"\t"+rs.getString("Ammount")+"\t"+rs.getString("Type")+rs.getLong("Account"));
										
					}
				}catch(SQLException e) {
							System.out.println(e.getMessage());
					 }
		}
	
		@Override
		public void generateTransferIn(Connection conn, Long Accountnumber, Double Ammount) {
			try {
				
				PreparedStatement ps=conn.prepareStatement(create);
				ps.setDouble(1, Ammount);
				ps.setString(2, "Transfer In");
				ps.setLong(2, Accountnumber);

				ps.executeUpdate();


				}catch(SQLException e) {
							System.out.println(e.getMessage());
				}			
		}
	
		@Override
		public void generateTransferOut(Connection conn, Long Accountnumber, Double Ammount) {
			try {
				
				PreparedStatement ps=conn.prepareStatement(create);
				ps.setDouble(1, Ammount);
				ps.setString(2, "Transfer out");
				ps.setLong(2, Accountnumber);

				ps.executeUpdate();


				}catch(SQLException e) {
							System.out.println(e.getMessage());
				}				
		}
	
		@Override
		public void generateWithdraw(Connection conn, Long Accountnumber, Double Ammount) {
			try {
				
				PreparedStatement ps=conn.prepareStatement(create);
				ps.setDouble(1, Ammount);
				ps.setString(2, "Withdraw");
				ps.setLong(3, Accountnumber);

				ps.executeUpdate();


				}catch(SQLException e) {
							System.out.println(e.getMessage());
				}				
		}
	
		@Override
		public void generateDeposit(Connection conn, Long Accountnumber, Double Ammount) {
			try {
				
				PreparedStatement ps=conn.prepareStatement(create);
				ps.setDouble(1, Ammount);
				ps.setString(2, "deposit");
				ps.setLong(3, Accountnumber);

				ps.executeUpdate();


				}catch(SQLException e) {
							System.out.println(e.getMessage());
				            e.printStackTrace();

				}				
		}
		
		
		

}
