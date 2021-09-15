package v2BankingApp;

import java.util.List;

public interface UserDAO {

	
	void updateUser(v2WormBankUsers c);
	
	void deleteUser(v2WormBankUsers c);
	
	List<v2WormBankUsers> getAllUsers();
	
	List<v2WormBankUsers> getAllAdmins();
	
	List<v2WormBankUsers> getAllEmployees();
	
	v2WormBankUsers getUserByUsername(String Username);
	
	v2WormBankUsers getUserByAccountNumber(String AccountNumber);
	
	v2WormBankUsers getUserByEmail(String Email);
			
	
	
	
}



