package v2BankingApp;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class WBAccountsDaoimpl implements wBAccountsDAO{
	private static String selectall = "SELECT * FROM WBAccounts;";
	private static String singleton = "SELECT * FROM WBAccounts WHERE Accounnumber=?;";
	private static String updatebalance = "UPDATE WBAccounts "
										  + "SET 'balance'= ?"
										  + "WHERE Accountnumber=?;";
	private static String setupAccount = "INSERT INTO WBAccounts VALUES (?,?,?);";
	private static String getbalance = "SELECT Balance FROM WBAccounts WHERE Accountnumber=?;";

	

	@Override
	public void getALLAccounts(Connection conn) {
		try {
			PreparedStatement ps=conn.prepareStatement(selectall);
			ResultSet rs=ps.executeQuery();
		
			
				while(rs.next())
				{
					
					System.out.println(rs.getString("Accountnumber")+"\t"+rs.getString("Balance")+"\t"+rs.getString("Users"));
									
				}
			}catch(SQLException e) {
						System.out.println(e.getMessage());
				 }
	}


	@Override
	public Double getBalance(Connection conn, Long accountnumber) {
		Double balance=null;
		try {
					
					PreparedStatement ps=conn.prepareStatement(getbalance);
					System.out.println(accountnumber);
					ps.setDouble(1, accountnumber);
					ResultSet rs=ps.executeQuery();
					balance = rs.getDouble("Balance");
		
					}catch(SQLException e) {
								System.out.println(e.getMessage());
					}		
		return balance;
	}

	@Override
	public void updateBalance(Connection conn, Long accountnumber, Double Ammount) {
		// TODO Auto-generated method stub
		try {
			
		PreparedStatement ps=conn.prepareStatement(updatebalance);
		ps.setDouble(1, Ammount);
		ps.setLong(2, accountnumber);

		ps.executeUpdate();


		}catch(SQLException e) {
					System.out.println(e.getMessage());
		}		
	}





	@Override
	public void setupAccount(Connection conn,  Long accountnumber, Double Ammount, List<Array> users) {
		try {
			
			PreparedStatement ps=conn.prepareStatement(setupAccount);
			ps.setLong(1, accountnumber);
			ps.setDouble(2, 0);
			ps.setArray(3, (Array) users);

			ps.executeUpdate();


			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}		
	}

}
