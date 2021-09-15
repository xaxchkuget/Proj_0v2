package v2BankingApp;
import java.sql.*;

import java.util.List;

public interface wBUserDAO {
	
	public List<wBUser> getALLuserwBUser(Connection conn);
	public List<wBUser> getALLemployeewBUser(Connection conn);
	public List<wBUser> getALLcustomerwBUser(Connection conn);
	public List<wBUser> getALLpendingwBUser(Connection conn);
			
	public String getwBUsername(Connection conn, String username);
	public String getwBUserpassword(Connection conn, String username);


	
	public Long getwBAccnum(Connection conn, String username);

	
	boolean sqluserverification(Connection conn, String username);
	boolean sqluserverification(Connection conn, String username, String expected);

	
	public void updatewBUserpassword(Connection conn, String password, String username);
	public void updatewBUseremail(Connection conn, String email, String username);
	public void updatewBUserfirstname(Connection conn, String firstname, String username);
	public void updatewBUserlastname(Connection conn, String lastname, String username);
	public void updatewBUserusertype(Connection conn, String usertype, String username);
	public Long updatewBUseraccountnumber(Connection conn, String username);
	public Long updatewBUserjointaccountnumber(Connection conn, String username);

	public void createuser(Connection conn, String username, String password, String email, String firstname, String lastname, String usertype, Long accountnumber);

}
