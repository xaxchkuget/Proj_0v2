package v2BankingApp;

import java.sql.Connection;
import java.util.Scanner;

public abstract class v2MenuLogic {
	
	public static String MainMenuLogic (Scanner userInput, int previousinput,Connection conn, wBUserDAO wbuserDao){
			String userChoice=null;
		
			switch(previousinput) {
			
				case 1: System.out.println("Taking you to the Admin Login screen.\n"
						+  "==========================================================================================\n");
					
					v2Menus.loginuserNamePrompt();
					userChoice = v2Authentications.UserNameAuthenticator(userInput, conn, wbuserDao);
					return userChoice;

				case 2: System.out.println("Taking you to the Employee Login screen.\n"
						+  "==========================================================================================\n");
					
					v2Menus.loginuserNamePrompt();
					userChoice = v2Authentications.UserNameAuthenticator(userInput, conn, wbuserDao);
					return userChoice;
				
				case 3: System.out.println("Taking you to the Customer Login screen.\n"
						+  "==========================================================================================\n");

					v2Menus.loginuserNamePrompt();
					userChoice = v2Authentications.UserNameAuthenticator(userInput, conn, wbuserDao);
					return userChoice;
				
				case 4: System.out.println("Taking you to the New Customer menu."
						+  "==========================================================================================\n");
					userChoice = "NewCustomer";
					return userChoice;
				
				case 5: System.out.println("Come Again some time! And remember the worm loves you, "
										  +"and because it always has...\n It Always will.");
						System.exit(0);
						
				default:
					System.out.println("Sorry something strange happened and the app needs to close.");
					System.exit(0);
				}

		return userChoice;
	}

	public static void adminMenuLogic (Scanner userInput, int previousinput, int menuvalidchoicecount4,int menuvalidchoicecount2,Connection conn, wBUserDAO wbuserDao ){
	
		while(true) 
		{
			
		
			v2Menus.showadminMenu();
			previousinput = v2Authentications.MenuInputValidator(userInput, menuvalidchoicecount4);

			switch(previousinput) 
			{
		
				case 1: 
					
					v2MenuLogic.reviewCustomerLogic(userInput, previousinput, conn,  wbuserDao);
					break;
				case 2: 
					
					v2MenuLogic.reviewEmployeeLogic(userInput, previousinput, conn,  wbuserDao);
					break;
	
				case 3:
					
					System.out.println("Taking you to the Applications screen.\n"
					+  "==========================================================================================\n");
					wbuserDao.getALLpendingwBUser(conn);
					
					break;
	
				case 4: 
					
					System.out.println("Logging out."
					+  "==========================================================================================\n");
					System.exit(0);
						
				default:
					System.out.println("Sorry something strange happened and the app needs to close.");
					System.exit(0);
			}
		}
	}
	
	public static void reviewCustomerLogic (Scanner userInput, int previousinput,Connection conn, wBUserDAO wbuserDao){
		boolean goback=true;

		while( goback==true ) 
		{

			
					v2Menus.showReviewCustomerAccounts();
					previousinput = v2Authentications.MenuInputValidator(userInput, 4);

			switch(previousinput) 
			{
		
				case 1: 
					
					v2Menus.showdisplayAccounts();
					wbuserDao.getALLcustomerwBUser(conn);
					break;
				case 2: 
					
					v2MenuLogic.adminEditingMenuLogic(userInput, previousinput, conn,  wbuserDao);

					break;
	
				case 3:
					
					goback=false;
					break;
	
				case 4: 
					
					System.out.println("Logging out."
					+  "==========================================================================================\n");
					System.exit(0);

						
				default:
					System.out.println("Sorry something strange happened and the app needs to close.");
					System.exit(0);
			}
		}
	}
	
	public static void reviewEmployeeLogic (Scanner userInput, int previousinput,Connection conn, wBUserDAO wbuserDao){
		boolean goback=true;
		
		while( goback==true )
		{
					v2Menus.showReviewEmployeeAccounts();
					previousinput = v2Authentications.MenuInputValidator(userInput, 4);

			switch(previousinput) 
			{
		
				case 1: 
					
					v2Menus.showdisplayAccounts();
					// TODO Display all customer Accounts
					break;
				case 2: 
					
					v2MenuLogic.adminEditingMenuLogic(userInput, previousinput, conn,  wbuserDao);

					break;
	
				case 3:
					goback=false;
					break;
	
				case 4: 
					
					System.out.println("Logging out."
					+  "==========================================================================================\n");
					System.exit(0);

						
				default:
					System.out.println("Sorry something strange happened and the app needs to close.");
					System.exit(0);
			}
		}
	}
	
	public static void employeeMenuLogic (Scanner userInput, int previousinput,Connection conn, wBUserDAO wbuserDao){
		
		while(true) 
		{
			
		
			v2Menus.showemployeeMenu();
			previousinput = v2Authentications.MenuInputValidator(userInput, 3);

			switch(previousinput) 
			{
		
				case 1: 
					
					v2MenuLogic.reviewCustomerLogic(userInput, previousinput, conn,  wbuserDao);
					break;
	
				case 2:
					
					System.out.println("Taking you to the Applications screen.\n"
					+  "==========================================================================================\n");
	
					v2Menus.loginuserNamePrompt();
					break;
	
					
					
				case 3: 
					
					System.out.println("Logging out."
					+  "==========================================================================================\n");
					System.exit(0);
						
				default:
					System.out.println("Sorry something strange happened and the app needs to close.");
					System.exit(0);
			}
		}
	}
	
	public static void adminEditingMenuLogic (Scanner userInput, int previousinput,Connection conn, wBUserDAO wbuserDao){
		boolean goback=true;
		String updatestring=null;
		String editeduser;
		
		while(goback==true) 
		{
			
		
			v2Menus.showeditusernameprompt();
			editeduser = v2Authentications.UserNameAuthenticator(userInput, conn, wbuserDao);
			v2Menus.showeditAccountMenu();

			previousinput = v2Authentications.MenuInputValidator(userInput, 7);

			switch(previousinput) 
			{

				case 1: 
					
					//TODO Save SQL
					goback=false;
					break;
			
				case 2: 

					v2Menus.showeditingPasswordMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser)==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "Password", 4, 8);
					wbuserDao.updatewBUserpassword(conn, updatestring, editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}
					break;
	
				case 3: 
					v2Menus.showeditingFirstnameMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser)==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "First Name", 1, 13);
					wbuserDao.updatewBUserfirstname(conn, updatestring, editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}

					break;
	
				case 4: 
					v2Menus.showeditingLastnameMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser)==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "Last Name", 1, 13);
					wbuserDao.updatewBUserlastname(conn, updatestring, editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}

					break;
					
				case 5: 
					v2Menus.showeditingEmailMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser)==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "Email", 5, 50);
					wbuserDao.updatewBUseremail(conn, updatestring, editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}
					break;
					
				case 6: 
					v2Menus.showeeditingUsertypeMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser)==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "User type", 4, 8);
					wbuserDao.updatewBUserusertype(conn, "customer", editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}
					break;
					
				case 7: 
					System.out.println("Logging out."
					+  "==========================================================================================\n");
					System.exit(0);	

				default:
					System.out.println("Sorry something strange happened and the app needs to close.");
					System.exit(0);
			}
		}
	}
	
	public static void employeeEditingMenuLogic (Scanner userInput, int previousinput,Connection conn, wBUserDAO wbuserDao){
		boolean goback=true;
		String updatestring=null;
		String editeduser;
		
		while(goback==true) 
		{
			
		
			v2Menus.showeditusernameprompt();
			editeduser = v2Authentications.UserNameAuthenticator(userInput, conn, wbuserDao);
			v2Menus.showeditAccountMenu();

			previousinput = v2Authentications.MenuInputValidator(userInput, 7);

			switch(previousinput) 
			{

				case 1: 
					
					//TODO Save SQL
					goback=false;
					break;
			
				case 2: 

					v2Menus.showeditingPasswordMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser, "customer")==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "Password", 4, 8);
					wbuserDao.updatewBUserpassword(conn, updatestring, editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}
					break;
	
				case 3: 
					v2Menus.showeditingFirstnameMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser, "customer")==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "First Name", 1, 13);
					wbuserDao.updatewBUserfirstname(conn, updatestring, editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}

					break;
	
				case 4: 
					v2Menus.showeditingLastnameMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser, "customer")==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "Last Name", 1, 13);
					wbuserDao.updatewBUserlastname(conn, updatestring, editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}

					break;
					
				case 5: 
					v2Menus.showeditingEmailMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser, "customer")==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "Email", 5, 50);
					wbuserDao.updatewBUseremail(conn, updatestring, editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}
					break;
					
				case 6: 
					v2Menus.showeeditingUsertypeMenu(editeduser);
					if(wbuserDao.sqluserverification(conn, editeduser, "pending")==true) 
					{
					updatestring = v2Authentications.stringInputAuthenticator(userInput, "User type", 4, 8);
					wbuserDao.updatewBUserusertype(conn, "customer", editeduser);
					} else {
						
						System.out.println("Remember The Worm is always watching, you dont have permission to do this.");

					}
					break;
					
				case 7: 
					System.out.println("Logging out."
					+  "==========================================================================================\n");
					System.exit(0);	

				default:
					System.out.println("Sorry something strange happened and the app needs to close.");
					System.exit(0);
			}
		}
	}
	
	
	public static void custemerMenuLogic (Scanner userInput, int previousinput,Connection conn, wBAccountsDAO wbaccountsdao, String username, wBUserDAO wbuserDao, WBTransactionsDAO wbtransactionsdao) {
		
		
		
		while(true) 
		{
			
		
			v2Menus.showCustomerMenu();
			previousinput = v2Authentications.MenuInputValidator(userInput, 5);

			switch(previousinput) 
			{
		
				case 1: 
					
					Double tempwithd = v2MenuLogic.withDrawLogic( userInput, username);
					Long acc = wbuserDao.getwBAccnum(conn, username);
					Double currentbalance1 = wbaccountsdao.getBalance(conn, acc);
					wbaccountsdao.updateBalance( conn, acc, tempwithd-currentbalance1);
					wbtransactionsdao.generateWithdraw(conn, acc, tempwithd);
					break;
				case 2: 
					
					Double tmpdep = v2MenuLogic.depositLogic( userInput, username);
					Long acc2 = wbuserDao.getwBAccnum(conn, username);
					Double currentbalance2 = wbaccountsdao.getBalance(conn, acc2);
					System.out.println();
					wbaccountsdao.updateBalance( conn, acc2, tmpdep+currentbalance2);
					wbtransactionsdao.generateDeposit(conn, acc2, tmpdep);				
					break;
	
					
				case 3: 
					
					
					Long acc3 = wbuserDao.getwBAccnum(conn, username);
					v2Menus.showWormtransfer1();
					v2Authentications.accnumberInputAuthenticator(userInput, 9);
					Long placeholder = v2Authentications.accnumberInputAuthenticator(userInput, 9);
					v2Menus.showWormtransfer2();
					Double ammnt = v2Authentications.doubleInputAuthenticator(userInput);
					wbtransactionsdao.generateTransferOut(conn, acc3, ammnt);
					wbtransactionsdao.generateTransferIn(conn, placeholder, ammnt);

					break;
					
				case 4:
					
					System.out.println("Sorry we do not Allow customers to chaing their details at this time\n."
							+  "Please ask an employee for help if there are details you need to change."
							+  "==========================================================================================\n");

					break;
	
				case 5: 
					
					System.out.println("Logging out."
					+  "==========================================================================================\n");
					System.exit(0);
						
				default:
					System.out.println("Sorry something strange happened and the app needs to close.");
					System.exit(0);
			}
		}	
	}

	public static Double withDrawLogic(Scanner userInput,String username){
		
		Double tmp;
		v2Menus.showWomrwithdraw();
		tmp = v2Authentications.doubleInputAuthenticator(userInput);
		return tmp;
	}
	
	public static Double depositLogic(Scanner userInput, String Username){
		Double tmp;
		v2Menus.showWormdeposit();
		tmp = v2Authentications.doubleInputAuthenticator(userInput);
		return tmp;

	}
	

	
	public static void newCustomerMenuLogic(Scanner userInput, int previousinput,Connection conn, wBUserDAO wbuserDao) {
				String tmpUser1=null;
				String tmppassword1=null;	
				String tmpemail1=null;
				String tmpfirstname1=null;
				String tmplastname1=null;
				String tmpusertype1="customer";
				Long tmpaccountnumber1=null;
				String tmpUser2=null;
				String tmppassword2=null;	
				String tmpemail2=null;
				String tmpfirstname2=null;
				String tmplastname2=null;
				String tmpusertype2="customer";
				Long tmpaccountnumber2=null;

				
			v2Menus.showNewCustomerMenu();
			previousinput = v2Authentications.MenuInputValidator(userInput, 3);
			
			switch(previousinput)
			{

				case 1:

					v2Menus.shownewloginuserNamePrompt();
					try
					{

						tmpUser1 = v2Authentications.newUserNameAuthenticator(userInput);

						if (tmpUser1!=null)
						{
							v2Menus.showeditingPasswordMenu(tmpUser1);
							tmppassword1 = v2Authentications.stringInputAuthenticator(userInput, "Password", 4, 8);
	
			
							v2Menus.showeditingFirstnameMenu(tmpUser1);
							tmpfirstname1 = v2Authentications.stringInputAuthenticator(userInput, "First Name", 1, 13);
	
			
							v2Menus.showeditingLastnameMenu(tmpUser1);
							tmplastname1 = v2Authentications.stringInputAuthenticator(userInput, "Last Name", 1, 13);
	
							
							v2Menus.showeditingEmailMenu(tmpUser1);
							tmpemail1 = v2Authentications.stringInputAuthenticator(userInput, "Email", 5, 50);
							
							tmpaccountnumber1 = wbuserDao.updatewBUseraccountnumber(conn, tmpUser1);
							wbuserDao.createuser(conn, tmpUser1, tmppassword1, tmpemail1, tmpfirstname1, tmplastname1, tmpusertype1, tmpaccountnumber1);
						}else
							{
							
								System.out.println("Sorry something strange happened and the app needs to close.");
								System.exit(1);
							
							}
					}catch(NullPointerException e){
						
						System.out.println("Sorry something strange happened and the app needs to close.");
						System.exit(1);
					}
					
					//TODO SQL SAVE NEW USER
					
				case 2:
					
					//TODO apply for joint account
					v2Menus.shownewloginuserNamePrompt();							
					System.out.println("for first User.");
					try
					{
						tmpUser2 = v2Authentications.newUserNameAuthenticator(userInput);
						if (tmpUser2!=null)
						{
							v2Menus.showeditingPasswordMenu(tmpUser1);
							tmppassword2 = v2Authentications.stringInputAuthenticator(userInput, "Password", 4, 8);
							//TODO Save SQL
	
			
							v2Menus.showeditingFirstnameMenu(tmpUser1);
							tmpfirstname2 = v2Authentications.stringInputAuthenticator(userInput, "First Name", 1, 13);
							//TODO Save SQL
	
			
							v2Menus.showeditingLastnameMenu(tmpUser1);
							tmplastname2 = v2Authentications.stringInputAuthenticator(userInput, "Last Name", 1, 13);
							//TODO Save SQL
	
							
							v2Menus.showeditingEmailMenu(tmpUser1);
							tmpemail2 = v2Authentications.stringInputAuthenticator(userInput, "Email", 5, 50);
							
							
							tmpaccountnumber2 = wbuserDao.updatewBUseraccountnumber(conn, tmpUser2);
							wbuserDao.createuser(conn, tmpUser2, tmppassword2, tmpemail2, tmpfirstname2, tmplastname2, tmpusertype2, tmpaccountnumber2);
						}else
							{
							
								System.out.println("Sorry something strange happened and the app needs to close.");
								System.exit(1);
							
							}
					
					
					
					//TODO
					
					v2Menus.shownewloginuserNamePrompt();
					System.out.println("for second User.");

					tmpUser2 = v2Authentications.newUserNameAuthenticator(userInput);
					if (tmpUser2!=null)
					{
						v2Menus.showeditingPasswordMenu(tmpUser2);
						tmppassword2 = v2Authentications.stringInputAuthenticator(userInput, "Password", 4, 8);
						//TODO Save SQL

		
						v2Menus.showeditingFirstnameMenu(tmpUser2);
						tmpfirstname2 = v2Authentications.stringInputAuthenticator(userInput, "First Name", 1, 13);
						//TODO Save SQL

		
						v2Menus.showeditingLastnameMenu(tmpUser2);
						tmplastname2 = v2Authentications.stringInputAuthenticator(userInput, "Last Name", 1, 13);
						//TODO Save SQL

						
						v2Menus.showeditingEmailMenu(tmpUser2);
						tmpemail1 = v2Authentications.stringInputAuthenticator(userInput, "Email", 5, 50);
						
						
						
					}else
						{
						
							System.out.println("Sorry something strange happened and the app needs to close.");
							System.exit(1);

						
						}
					}catch(NullPointerException e) {
							
							System.out.println("Sorry something strange happened and the app needs to close.");
							System.exit(1);
						}
					
					
				case 3:
					
					System.out.println("Come Again some time! And remember the worm loves you, "
									  +"and because it always has...\n It Always will."
									  +"==========================================================================================\n");
					
					System.exit(0);
			
			

			}

			
			
			
			
	}
	

	
}