package v2BankingApp;


public abstract class v2Menus{
	
	static String tmp=null;

	private static String mainMenu= "Hello, and welcome to 'The Bank of the Worm'. Please make a selection:\n"
			+  "==========================================================================================\n"
			+  "1: Admin Login\n"
			+  "2: Employee Login\n"
			+  "3: Returning Customer\n"
			+  "4: New Customer\n"
			+  "5: Logout\n"
			+  "==========================================================================================\n";
	
	private static String ExitMenu= "Are you sure you want to Exit the application?\n";
	
	private static String adminMenu= "Spread the warmth of the Worms Love.\n"
			+  "==========================================================================================\n"
			+  "1: Review customer Accounts\n"
			+  "2: Review employee Accounts\n"
			+  "3: Review Applications\n"
			+  "4: Logout\n"
			+  "==========================================================================================\n";
	
	
	private static String ReviewcustomerAccounts= "==========================================================================================\n"
			+  "1: Display All customer accounts\n"
			+  "2: Edit customer Account\n"
			+  "3: Go back\n"
			+  "4: Logout\n"
			+  "==========================================================================================\n";
	
	private static String ReviewEmployeeAccounts= "==========================================================================================\n"
			+  "1: Display All employee accounts\n"
			+  "2: Edit employee Account\n"
			+  "3: Go back\n"
			+  "4: Logout\n"
			+  "==========================================================================================\n";
	
	private static String displayAccounts= "==========================================================================================\n"
			+  "1: Go back\n"
			+  "2: Logout\n"
			+  "==========================================================================================\n"
			+  "Username\t"+"\t"+"Password\t"+"\t"+"Email\t"+"\t"+"First Name\t"+"\t"+"Lastname\t"+"\t"+"Account Number"
			+  "\n==========================================================================================\n";
	
	private static String editusernameprompt= "==========================================================================================\n"
			+  "Enter the Username of the User account you wish to edit.\n"
			+  "==========================================================================================\n";
	
	private static String editCustomerAccounts= "==========================================================================================\n"
			+  "1: Go back\n"
			+  "2: Logout\n"
			+  "==========================================================================================\n";
	
	
	private static String editAccount = "==========================================================================================\n"
			+  "1: Go back\n"
			+  "2: Edit Password\n"
			+  "3: Edit First name\n"
			+  "4: Edit Last name\n"
			+  "5: Edit Email\n"
			+  "6: Edit User type\n"
			+  "8: Logout\n"
			+  "==========================================================================================\n";
	
	
	private static String editingPasswordMenu = "==========================================================================================\n"
			+  "Please enter a new password for user:\t";
			
			
	private static String wormbankEOL = "\n==========================================================================================\n";
	
	private static String editingFirstnameMenu = "==========================================================================================\n"
			+  "1: Go back\n"
			+  "2: Logout\n"
			+  "==========================================================================================\n";
	
	private static String editingLastnameMenu = "==========================================================================================\n"
			+  "1: Go back\n"
			+  "2: Logout\n"
			+  "==========================================================================================\n";
	
	private static String editingEmailMenu = "==========================================================================================\n"
			+  "1: Go back\n"
			+  "2: Logout\n"
			+  "==========================================================================================\n";
	
	
	private static String editingUsertypeMenu = "==========================================================================================\n"
			+  "1: Go back\n"
			+  "2: Logout\n"
			+  "==========================================================================================\n";
	
	
	private static String editingAccountnumberMenu = "==========================================================================================\n"
			+  "1: Go back\n"
			+  "2: Logout\n"
			+  "==========================================================================================\n";
	
	
	
	
//	========================================================================================================================================================
	
	
	private static String employeeMenu= "The Worm is Ever present, and ever watching.\n"
			+  "====================================================================\n"
			+  "1: Review customer Accounts\n"
			+  "2: Review Applications\n"
			+  "3: Logout\n"
	        +  "==========================================================================================\n";
	
	private static String applications= "The Worm is welcoming.\n"
			+  "====================================================================\n"
			+  "1: Go back\n"
			+  "2: Edit Applications\n"
	        +  "==========================================================================================\n";
	
	
	private static String customerMenu= "What may we help you with today?:\n"
								+  "==========================================================================================\n"
								+  "1: Make a withdrawal\n"
								+  "2: Make a deposit\n"
								+  "3: Transfer funds \n"
								+  "4: Edit account details\n"
								+  "5: Cancel\n"
								+  "==========================================================================================\n";
	
	private static String newCustomerMenu= "Welcome to 'The Bank of the Worm'. What may we help you with today?:\n"
								+  "==========================================================================================\n"
								+  "1: Apply for Account\n"
								+  "2: Apply for a joint account\n"
								+  "3: Cancel\n"
								+  "==========================================================================================\n";
	
	private static String loginuserNamePrompt= "==========================================================================================\n"
			+"Please enter your Username\n";
	
	private static String newloginuserNamePrompt= "==========================================================================================\n"
			+"Please enter your desired Username\n";
	
	
	private static String loginPasswordPrompt= "==========================================================================================\n"
											+  "Please enter your Password\n"
											+  "==========================================================================================\n";
	
	private static String Womrwithdrawl=
			   "==========================================================================================\n"
			+  "Enter the desired ammount to withdraw.\n"
			+  "To Cancel enter 0\n"
			+  "==========================================================================================\n";
	
	private static String Wormdeposit= 
			   "==========================================================================================\n"
			+  "Enter the desired ammount to deposit.\n"
			+  "To Cancel enter 0\n"
			+  "==========================================================================================\n";
	
	private static String Wormtransfer1= 
			   "==========================================================================================\n"
			+  "please enter the 9 digit account number you wish to transfer to.\n"
			+  "==========================================================================================\n";
	
	private static String Wormtransfer2= 
			   "==========================================================================================\n"
			+  "please enter the desired ammount to transfer.\n"
			+  "To Cancel enter 0\n"
			+  "==========================================================================================\n";
	
	public static void showWomrwithdraw() {
		System.out.print(Womrwithdrawl);
	}
	
	public static void showWormdeposit() {
		System.out.print(Wormdeposit);
	}
	
	public static void showWormtransfer1() {
		System.out.print(Wormtransfer1);
	}
	
	public static void showWormtransfer2() {
		System.out.print(Wormtransfer2);
	}
	
	
	public static void showMainMenu() {
		System.out.print(mainMenu);
	}
	
	public static void showExitmenu() {
		System.out.print(ExitMenu);
	}
	
	public static void showadminMenu() {
		System.out.print(adminMenu);
	}

	public static void showemployeeMenu() {
		System.out.print(employeeMenu);
	}
	
	public static void showCustomerMenu() {
		System.out.print(customerMenu);
	}
	
	public static void showNewCustomerMenu() {
		System.out.print(newCustomerMenu);
	}

	public static void loginuserNamePrompt() {
		System.out.print(loginuserNamePrompt);
	}

	public static void shownewloginuserNamePrompt() {
		System.out.print(newloginuserNamePrompt);
	}
	
	public static void loginPasswordPrompt() {
		System.out.print(loginPasswordPrompt);
	}
	
	public static void showdisplayAccounts() {
		System.out.print(displayAccounts);
	}
	
	public static void showReviewCustomerAccounts() {
		System.out.print(ReviewcustomerAccounts);
	}
	
	public static void showeditusernameprompt() {
		System.out.print(editusernameprompt);
	}
	
	public static void showEditCustomerAccounts() {
		System.out.print(editCustomerAccounts);
	}

	public static void showReviewEmployeeAccounts() {
		System.out.print(ReviewEmployeeAccounts);
	}
	
	public static void showeditAccountMenu() {
		System.out.print(editAccount);
	}
	
	public static void showeditingPasswordMenu(String tmp) {
		System.out.print(editingPasswordMenu+tmp+wormbankEOL);
	}
	
	public static void showeditingFirstnameMenu(String tmp) {
		System.out.print(editingFirstnameMenu+tmp+wormbankEOL);
	}
	
	public static void showeditingLastnameMenu(String tmp) {
		System.out.print(editingLastnameMenu+tmp+wormbankEOL);
	}
	
	public static void showeditingEmailMenu(String tmp) {
		System.out.print(editingEmailMenu+tmp+wormbankEOL);
	}
	
	public static void showeeditingUsertypeMenu(String tmp) {
		System.out.print(editingUsertypeMenu+tmp+wormbankEOL);
	}
	
	public static void showeditingAccountnumberMenu(String tmp) {
		System.out.print(editingAccountnumberMenu+tmp+wormbankEOL);
	}

	public static void getApplications() {
		System.out.print(applications);
	}

	
}

