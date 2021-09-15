package v2BankingApp;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class v2Authentications {
		
	

		
		public static int MenuInputValidator(Scanner userInput,int validchoices) {
			int userChoice=0;
			int exitcondition=1;
			int loop =0;

			
			while(exitcondition!=0) {
				try 
				{
					userChoice = userInput.nextInt();
					userInput.nextLine();
					loop++;
					if(loop>=3 & (userChoice >=validchoices | userChoice<=0)) 
					{
						System.out.println("Too many attempts.");
						System.exit(1);
		
					}else if(userChoice >validchoices | userChoice<=0)
					{
						System.out.println("Please input a valid digit, (1-"+validchoices+")."+"\nattempts remaining:"+(3-loop)+  "\n==========================================================================================\n");
					}else
					{
						
						System.out.println("One Moment.");
						return userChoice;
					}
		
				
				}catch(InputMismatchException e) 
				{	loop++;
					userInput.nextLine();
					System.out.println("Please enter a Digit.\n"+"\nattempts remaining:"+(3-loop)+  "\n==========================================================================================\n");
					if(loop>=3) 
					{
						System.out.println("Too many attempts.");
						System.exit(1);

					}
				}
			}
			return userChoice;

		}

		public static String UserNameAuthenticator(Scanner userinput,Connection conn, wBUserDAO wbuserDao) throws InputMismatchException {
			String userChoice=null;
			int exitcondition=1;
			int loop =0;

			
			while(exitcondition!=0) {
				try {
					
					userChoice = userinput.nextLine();
					
					String tmp = wbuserDao.getwBUsername(conn, userChoice);
					
					if(loop>=3){
					
					System.out.println("Too Many attempts. The Worm is Very disspleased, but you can try again later.\n");
					
					System.exit(1);
					
					}else if( tmp!=null ) {
						
						System.out.println("Match found.");
						exitcondition = 0;
						return userChoice;
						
					}else {
						
						System.out.println("Something strange happened try again please.");
						
					}
	
				}catch(InputMismatchException e){
					loop++;
					System.out.println("How did you manage to not input a valid input, that should be possible .The Worm is honestly impressed "+"\nattempts remaining:"+(3-loop)
							+  "\n==========================================================================================\n");
				}catch(NullPointerException e) {
					
					System.out.println("The username '"+userChoice+"' did not match anything in the system."+"\nattempts remaining:"+(3-loop));

				}
			}
			return userChoice;
		}
		
		public static boolean UserPasswordAuthenticator(Scanner userinput,String validatedusername, Connection conn, wBUserDAO wbuserDao) throws  InputMismatchException {
			String userChoice=null;
			int exitcondition=1;
			int loop =0;

			
			while(exitcondition!=0) {
				try {
					
					v2Menus.loginPasswordPrompt();

					userChoice = userinput.nextLine();
					
					String tmp2 = wbuserDao.getwBUserpassword(conn, validatedusername);

					if(loop>=3){
					
					System.out.println("Too Many attempts. The Worm is Very disspleased, but you can try again later.\n");
					
					System.exit(1);
					
					}else if( tmp2.equals(userChoice)  ) {
						
						System.out.println("Correct password for User:"+validatedusername+".");
						loop=0;
						return true;
		
					}else {
						
						System.out.println("That password did not match our records for user '"+validatedusername+". Please try again."+"\nattempts remaining:"+(3-loop));
					}
	
				}catch(InputMismatchException e){
					
					loop++;
					System.out.println("How did you manage to not input a valid input, that should be possible .The Worm is honestly impressed "+"\nattempts remaining:"+(3-loop)
							+  "\n==========================================================================================\n");
				}catch(NullPointerException e) {
					
					System.out.println("The username '"+userChoice+"' did not match anything in the system."+"\nattempts remaining:"+(3-loop));

				}
			}
			System.out.println("shouldnt come here.\n");
			
			return false;			
		}
		
		public static String stringInputAuthenticator(Scanner userinput, String appropriateField,int minlength, int maxlength) throws  InputMismatchException {
			String userChoice=null;
			int exitcondition=1;
			int loop =0;

			
			while(exitcondition!=0) {
				try {
					userChoice = userinput.nextLine();
	
					if(loop>=3){
					
					System.out.println("Too Many attempts. The Worm is disspleased.\n");
					
					}else if(userChoice==null) {
						
						System.out.println("You need to enter a something. "+appropriateField+" cant be blank.");
					
					}else if( userChoice!=null & userChoice.length()>= minlength & userChoice.length()<= maxlength ) {
						
						System.out.println("Entered value was:"+userChoice+".");
						return userChoice;
		
					}else {
						
						System.out.println("The entry: "+userChoice+" did not meet parameters ( minlength: "+minlength+" maxlength: "+maxlength+") for "+ appropriateField+"\n");
					}
	
				}catch(InputMismatchException e){
					
					loop++;
					System.out.println("How did you manage to not input a valid input, that should be possible .The Worm is honestly impressed "+"\nattempts remaining:"+(3-loop)
							+  "\n==========================================================================================\n");
				}
				
			}
			System.out.println("shouldnt come here ever.\n");
			
			return userChoice;			
		}
		
		public static Double doubleInputAuthenticator(Scanner userinput){
			Double userChoice=null;
			int exitcondition=1;
			int loop =0;

			
			while(exitcondition!=0) {
				try {
					userChoice = userinput.nextDouble();
					userinput.nextLine();
					
					if(loop>=3){
					
					System.out.println("Too Many attempts. The Worm is disspleased.\n");
					
					}else if(userChoice<0.0) {
						
						System.out.println("You should know better than to enter negative values. The Worm is dissapointed. ");
					
					}else if(userChoice==0.0) {
						
						System.out.println("Canceling. The Worm approves.");
						exitcondition=0;
					}else if( userChoice>100000.00  ) {
						
						System.out.println("The Worm has seen what will happen, and asks for your sake that you consider an ammount less than 100000.00.");
		
					}else {
						System.out.println("The Worm Likes this ammount.");
						return userChoice;
					}
				}catch(InputMismatchException e){
					if(loop>=3){
						userinput.nextLine();
						System.out.println("Too Many attempts. The Worm is disspleased.\n");
						System.exit(1);
					}else {
					loop++;
					System.out.println("Please enter a valid number ammount "+"\nattempts remaining:"+(3-loop)
							+  "\n==========================================================================================\n");
					}
				}
				
			}
			System.out.println("shouldnt come here ever.\n");
			
			return userChoice;			
		}
		
		public static Long accnumberInputAuthenticator(Scanner userinput,int length){
			Long userChoice=null;
			int exitcondition=1;
			int loop =0;

			
			while(exitcondition!=0) {
				try {
					userChoice = userinput.nextLong();
					userinput.nextLine();
					
					if(loop>=3){
					
					System.out.println("Too Many attempts. The Worm is disspleased.\n");
					
					}else if( userChoice!=null & userChoice.toString().length()== length ) {
						
						System.out.println("Looks good. ");
						return userChoice;
					}
				}catch(InputMismatchException e){
					
					loop++;
					System.out.println("Please enter a valid Account Number "+"\nattempts remaining:"+(3-loop)
							+  "\n==========================================================================================\n");
				}
				
			}
			System.out.println("shouldnt come here ever.\n");
			
			return userChoice;			
		}
		
		public static String newUserNameAuthenticator(Scanner userinput) throws InputMismatchException {
			String userChoice=null;
			int exitcondition=1;
			int loop =0;

			
			while(exitcondition!=0) {
				try {
					
					loop++;
					userChoice = userinput.nextLine();
					
					if(loop>=3){
					
					System.out.println("Too Many attempts. The Worm is disspleased, but you can try again later.\n");
					
					System.exit(1);
					
					}else if( WormBank.wormAccountList.get(userChoice)!=null ) {
						
						System.out.println("Sorry, this username is already in use. Please try a different username."+"\nattempts remaining:"+(3-loop));
						
					}else if(WormBank.wormAccountList.get(userChoice)==null){
						
						System.out.println("The username '"+userChoice+"' is available and will be used for this application.");
						exitcondition = 0;
						return userChoice;
							
					}else {
						
						System.out.println("Something strange happened try again please."+"\nattempts remaining:"+(3-loop));
						
					}
	
				}catch(InputMismatchException e){
					loop++;
					System.out.println("How did you manage to not input a valid input, that should be possible .The Worm is honestly impressed "+"\nattempts remaining:"+(3-loop)
							+  "\n==========================================================================================\n");
				}
			}
			return userChoice;
		}
		
//		=============================================================================old trash code++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		
		
		

//		static int loop=0;
//			public static boolean UserNameAuthenticator(Scanner userinput) throws InputMismatchException {
//				loop++;
//				String userChoice=null;
//				try {
//					
//					userChoice = userinput.nextLine();
//					
//					if(loop>=3){
//					
//					System.out.println("Too Many attempts. The Worm is Very disspleased, but you can try again later.\n");
//					
//					System.exit(1);
//					
//					}else if( WormBank.wormAccountList.get(userChoice)!=null ) {
//						
//						System.out.println("Match found.");
//						loop=0;
//						return true;
//						
//					}else if(WormBank.wormAccountList.get(userChoice)==null){
//						
//						System.out.println("The username '"+userChoice+"' did not match anything in the system."+"\nattempts remaining:"+(3-loop));
//						
//						UserNameAuthenticator(userinput);
//							
//					}else {
//						
//						System.out.println("Something bad happened try again please.");
//						UserNameAuthenticator(userinput);
//						
//					}
	//
//				}catch(InputMismatchException e){
//					
//					System.out.println("Ouch ");
//					UserNameAuthenticator(userinput);
//				}
//				
//				return false;
//				
//			}
	//
//			
//			public static boolean UserPasswordAuthenticator(Scanner userinput,String validatedusername) throws  InputMismatchException {
//				loop++;
//				String userChoice=null;
	//
//				try {
//					
//					userChoice = userinput.nextLine();
	//
//					if(loop>=3){
//					
//					System.out.println("Too Many attempts. The Worm is Very disspleased, but you can try again later.\n");
//					
//					System.exit(1);
//					
//					}else if( WormBank.wormAccountList.get(validatedusername).getAccountPassword().equals(userChoice) ) {
//						
//						System.out.println("Correct password for User:"+validatedusername+".");
//						loop=0;
//						return true;
	//	
//					}else {
//						
//						System.out.println("That password did not match our records for user '"+validatedusername+". Please try again."+"\nattempts remaining:"+(3-loop));
//						UserPasswordAuthenticator(userinput, validatedusername);
//					}
	//
//				}catch(InputMismatchException e){
//					
//					System.out.println("Ouch ");
//					UserPasswordAuthenticator(userinput, validatedusername);
//				}
//				
//				return false;
//				
//			}
//			
//			
//			public static String RegisterUsernameAuthenticator(Scanner userinput) throws InputMismatchException {
//				loop++;
//				String userChoice=null;
	//
//				try {
//					userChoice = userinput.nextLine();
//					if(loop>=3){
//					
//					System.out.println("Too Many attempts. The Worm is Very disspleased, but you can try again later.\n");
//					
//					System.exit(1);
//					
//						
//					}else if(WormBank.wormAccountList.get(userChoice)!=null){
//						
//						System.out.println("The username '"+userChoice+"' Is already registered please use another username."+"\nattempts remaining:"+(3-loop));
//						
//						RegisterUsernameAuthenticator(userinput);
//							
//					}else if(WormBank.wormAccountList.get(userChoice)==null){
//						loop=0;
	//
//						System.out.println("The username '"+userChoice+"' Is available. Logging.");
//												
//					}else {
//						
//						System.out.println("Whatever you tried to pull, Remember the Worm is watching! So lets Try this again.");
//						RegisterUsernameAuthenticator(userinput);
//						
//					}
	//
//				}catch(InputMismatchException e){
//					
//					System.out.println("Whatever you tried to pull, Remember the Worm is watching! So lets Try this again.");
//					RegisterUsernameAuthenticator(userinput);
//				}
//				
//				return userChoice;
//				
//			}
//			
//			
//			public static String GenericUserDataRegistrationAuthentication(Scanner userinput) throws InputMismatchException {
//				loop++;
//				String userChoice=null;
	//
//				try {
//					userChoice = userinput.nextLine();
	//
//					if(loop>=3){
//					
//					System.out.println("Too Many attempts. The Worm is Very disspleased, but you can try again later.\n");
//					
//					System.exit(1);
//					
//							
//					}else {
//						loop=0;
//						//This block does nothing and is supposed to do nothing.....because it can do nothing it doesnt have a pencil.
//					}
	//
//				}catch(InputMismatchException e){
//					
//					System.out.println("Whatever you tried to pull, Remember the Worm is watching! So lets Try this again.");
//					GenericUserDataRegistrationAuthentication(userinput);
//				}
//				
//				return userChoice;
//				
//			}
//			
//			public static String ConfirmationResponse(Scanner userinput) throws  InputMismatchException {
//				loop++;
//				String userChoice=null;
	//
//				try {
//					
//					userChoice = userinput.nextLine();
	//
//					if(loop>=3){
//					
//					System.out.println("Too Many attempts. The Worm is Very disspleased, but you can try again later.\n");
//					
//					System.exit(1);
//					
//					}else if( userChoice.equals("y") ) {
//						
//						loop=0;
//						return userChoice;
	//	
//					}else if(userChoice.equals("n")) { 
//						
//						System.out.println("Ok no worrys we can start over!");
//						
//					}else {
//						System.out.println("Im sorry i didn't understand! Please Type y for yes or n for no");
//						ConfirmationResponse(userinput);
//					}
	//
//				}catch(InputMismatchException e){
//					
//					System.out.println("Ouch ");
//					ConfirmationResponse(userinput);
//				}
//				
//				return "n";
//				
//			}
		
		
		
		
}