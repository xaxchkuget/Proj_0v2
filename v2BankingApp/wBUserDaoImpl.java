package v2BankingApp;
import java.util.List;
import java.sql.*;


public class wBUserDaoImpl implements wBUserDAO {
	
	private static String selectallactive = "SELECT * FROM WBUsers WHERE usertype!='pending';";
	private static String selectemployees = "SELECT * FROM WBUsers WHERE usertype='employee';";
	private static String selectcustomers = "SELECT * FROM WBUsers WHERE usertype='customer';";
	private static String selectpending = "SELECT * FROM WBUsers WHERE usertype='pending';";
	private static String verification = "SELECT usertype FROM WBUsers WHERE username=?;";
	private static String singleton = "SELECT * FROM WBUsers WHERE username=?;";
	private static String updatefirst = "UPDATE WBUsers SET 'First'= ? WHERE username=?;";
	private static String updatepass = "UPDATE WBUsers SET 'Password'= ? WHERE username=?;";
	private static String updatelast = "UPDATE WBUsers SET 'Last'= ? WHERE username=?;";
	private static String updateemail = "UPDATE WBUsers SET 'Email'= ? WHERE username=?;";
	private static String updatetype = "UPDATE WBUsers SET 'Usertype'= ? WHERE username=?;";
	private static String accountnumber="SELECT MAX(Accountnumber) FROM WBUsers";
	private static String insertsingleton = "INSERT INTO WBUsers VALUES (?,?,?,?,?,?,?);";
	private static String getpassword = "SELECT Password FROM WBUsers WHERE username=?;";
	private static String getusername = "SELECT Username FROM WBUsers WHERE username=?;";
	
//	static Connection conn= DatabaseConnection.getConnection();

	
	public static void sqlprintlist(Connection conn, String Q) {
		try {
		PreparedStatement ps=conn.prepareStatement(Q);
		ResultSet rs1=ps.executeQuery();
	
		
			while(rs1.next())
			{
				
				System.out.println(rs1.getString("Username")+"\t"+rs1.getString("Password")+"\t"+rs1.getString("Email")+"\t"+
				
								   rs1.getString("First")+"\t"+rs1.getString("Last")+"\t"+rs1.getString("Usertype")+"\t"+
				
								   rs1.getInt("Accountnumber"));
								
			}
		}catch(SQLException e) {
					System.out.println(e.getMessage());
			 }
	}

	@Override
	public List<wBUser> getALLuserwBUser(Connection conn) {
		wBUserDaoImpl.sqlprintlist(conn, selectallactive);
		return null;
	}


	@Override
	public List<wBUser> getALLemployeewBUser(Connection conn) {
		wBUserDaoImpl.sqlprintlist(conn, selectemployees);
		return null;
	}


	@Override
	public List<wBUser> getALLcustomerwBUser(Connection conn) {
		wBUserDaoImpl.sqlprintlist(conn, selectcustomers);
		return null;
	}


	@Override
	public List<wBUser> getALLpendingwBUser(Connection conn) {
		wBUserDaoImpl.sqlprintlist(conn, selectpending);
		return null;
	}

	@Override
	public boolean sqluserverification(Connection conn, String username, String expected) {
		boolean verified=false;
		try {

			PreparedStatement ps=conn.prepareStatement(verification);// prevents sql injection
			ps.setString(1, username);
		
			ResultSet rs=ps.executeQuery();
			

			verified = rs.getString(1).equals(expected);
					

			}catch(SQLException e) {
						System.out.println(e.getMessage());
				 }
		
		
		return verified;
	}


	@Override
	public String getwBUsername(Connection conn, String username) {
		String tmp=null;
		try {
			PreparedStatement ps=conn.prepareStatement(getusername);
			ps.setString(1, username);
		
			ResultSet rs=ps.executeQuery();
	
			tmp = rs.getString(1);
			}catch(SQLException e) {
						System.out.println(e.getMessage());
//						e.printStackTrace();
			}		
		return tmp;
	}
	
	@Override
	public String getwBUserpassword(Connection conn, String username) {
		String tmp=null;
		try {
			PreparedStatement ps=conn.prepareStatement(getpassword);
			ps.setString(1, username);
		
			ResultSet rs=ps.executeQuery();
	
			tmp = rs.getString(1);
			}catch(SQLException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();

			}		
		return tmp;
	}

	@Override
	public Long getwBAccnum(Connection conn, String username) {
		Long tmp=null;
		try {
			PreparedStatement ps=conn.prepareStatement(singleton);
			ps.setString(1, username);
		
			ResultSet rs=ps.executeQuery();
			System.out.println(rs.getString(1));
	
			tmp =  rs.getLong("Accountnumber");
	
			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}		
		;
		return tmp;
	}
	
	
	@Override
	public void updatewBUserpassword(Connection conn, String password, String username) {
		try {
			
		PreparedStatement ps=conn.prepareStatement(updatepass);
		ps.setString(1, password);
		ps.setString(2, username);

		ps.executeUpdate();


		}catch(SQLException e) {
					System.out.println(e.getMessage());
		}		
		
	}

	@Override
	public void updatewBUseremail(Connection conn, String email, String username) {
		try {
			
			PreparedStatement ps=conn.prepareStatement(updateemail);
			ps.setString(1, email);
			ps.setString(2, username);

			ps.executeUpdate();


			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}				
	}

	@Override
	public void updatewBUserfirstname(Connection conn, String firstname, String username) {
		try {
			
			PreparedStatement ps=conn.prepareStatement(updatefirst);
			ps.setString(1, firstname);
			ps.setString(2, username);

			ps.executeUpdate();


			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}				
	}

	@Override
	public void updatewBUserlastname(Connection conn, String lastname, String username) {
		try {
			
			PreparedStatement ps=conn.prepareStatement(updatelast);
			ps.setString(1, lastname);
			ps.setString(2, username);

			ps.executeUpdate();


			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}				
	}

	@Override
	public void updatewBUserusertype(Connection conn, String usertype, String username) {
		try {
			
			PreparedStatement ps=conn.prepareStatement(updatetype);
			ps.setString(1, usertype);
			ps.setString(2, username);

			ps.executeUpdate();


			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}				
	}

	@Override
	public Long updatewBUseraccountnumber(Connection conn, String username) {
		Long tmp =(long) 100000000;
		try {
			
			PreparedStatement ps=conn.prepareStatement(accountnumber);
			ResultSet rs=ps.executeQuery();
			tmp = Long.parseLong(rs.toString());
			tmp++;
		
			return tmp;
			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}	
		return tmp;

	}

	@Override
	public Long updatewBUserjointaccountnumber(Connection conn, String username) {
		Long tmp =(long) 100000000;

		try {
			
			PreparedStatement ps=conn.prepareStatement(accountnumber);
			ResultSet rs=ps.executeQuery();
			tmp = Long.parseLong(rs.toString());
		
			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}				
		return tmp;
	}

	@Override
	public void createuser(Connection conn, String username, String password, String email, String firstname,
			String lastname, String usertype, Long accountnumber) {
		try {

			PreparedStatement ps=conn.prepareStatement(insertsingleton);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, firstname);
			ps.setString(5, lastname);
			ps.setString(6, usertype);
			ps.setLong(7, accountnumber);
			ps.executeUpdate();


			}catch(SQLException e) {
						System.out.println(e.getMessage());
			}						
	}

	@Override
	public boolean sqluserverification(Connection conn, String username) {	
		
		return true;
	}
}
