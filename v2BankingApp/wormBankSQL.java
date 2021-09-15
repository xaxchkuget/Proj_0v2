package v2BankingApp;
import java.sql.*;

public class wormBankSQL {

		public static Connection connection() {
			
			final String url = "jdbc:sqlite:C:\\Users\\T3st\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";
			Connection conn = null;
			
			try 
			{
				// db parameters
				
				conn = DriverManager.getConnection(url);
				
				System.out.println("\n==========================================================================================\n"+
								   "Connection to The Worm has been established."+  
								   "\n==========================================================================================\n");
				
			}catch (SQLException e) {
					System.out.println(e.getMessage());
			 }

			public static Connection getConnection()
		    {
		        return conn;
		    }
		
		
		
		}
		
		
}
