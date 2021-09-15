package v2BankingApp;

import java.util.Map;
import java.util.Scanner;
import java.sql.*;

public class WormBank {

	static Map<String,v2WormBankUsers> wormAccountList;
	static String dataUserLocation= "C:\\Users\\T3st\\eclipse-workspace\\revatureJava27\\src\\v2bankingApp\\v2WormAccountslist.ser";
	public static Scanner consolescanner= new Scanner(System.in);
	static String validusername;
	static int userintinput;
	static String[] tempUser;
	static String userstringresponse;
	static final int menuvalidchoicecount6=6;
	static final int menuvalidchoicecount5=5;
	static final int menuvalidchoicecount4=4;
	static final int menuvalidchoicecount3=3;
	static final int menuvalidchoicecount2=2;
//	static Connection wbconn;
	static boolean passwordvalidated;
	static boolean uservalidated;
	
	public static void main(String[] args) {
		
//		wbconn = wormBankSQL.connection();
		Connection wbconn= DatabaseConnection.getConnection();
		
		wBUserDAO wbuserDao = new wBUserDaoImpl();
		wBAccountsDAO wbAccountsDao = new WBAccountsDaoimpl();
		WBTransactionsDAO  wbtransactionsdao= new WBTransactionsDaoImpl();
		
								
		v2Menus.showMainMenu();
		userintinput=v2Authentications.MenuInputValidator(consolescanner,menuvalidchoicecount5);
		
		if(userintinput == 4) {
		
		}else {
			
			userstringresponse=v2MenuLogic.MainMenuLogic(consolescanner, userintinput,wbconn, wbuserDao);

			passwordvalidated = v2Authentications.UserPasswordAuthenticator(consolescanner, userstringresponse, wbconn, wbuserDao);
			
		}
			
		switch(userintinput)
		{
			case 1:
				
				uservalidated = wbuserDao.sqluserverification(wbconn, userstringresponse, "admin");
				if(uservalidated==true & passwordvalidated==true)		
				{
					v2MenuLogic.adminMenuLogic(consolescanner, userintinput, menuvalidchoicecount4, menuvalidchoicecount2, wbconn,  wbuserDao);
				}
				else
				{
					System.out.println("Did you think YOU could lie to THE Worm!?");
					System.exit(2);
				}
			case 2: 
				
				uservalidated = wbuserDao.sqluserverification(wbconn, userstringresponse, "employee");
				if(uservalidated==true & passwordvalidated==true)		
				{
					v2MenuLogic.employeeMenuLogic(consolescanner, userintinput, wbconn,  wbuserDao);
				}
				else
				{
					System.out.println("Did you think YOU could lie to THE Worm!!!?");
					System.exit(2);
				}				
				
		
		
			case 3:
				
				uservalidated = wbuserDao.sqluserverification(wbconn, userstringresponse, "customer");
				if(uservalidated==true & passwordvalidated==true)		
				{				
					v2MenuLogic.custemerMenuLogic(consolescanner, userintinput, wbconn,  wbAccountsDao, userstringresponse, wbuserDao, wbtransactionsdao);
				}else
				{
					System.out.println("Either you are not a customer, or your application has not finished processing yet.");
				}
				
				
			case 4: 
				
				v2MenuLogic.newCustomerMenuLogic(consolescanner, userintinput, wbconn, wbuserDao);
		
		}

	}
}