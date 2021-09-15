package v2BankingApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class TestFilesBuilder {

//			static Map<String,v2WormBankUsers> wormBankuserList;

		public static void TestFIlesBUILDER() {

			try{
				v2WormBankUsers a = new v2WormBankUsers("xaxchkuget","7357","xaxch@worm.net","chris","dixon","admin","00000000");
				v2WormBankUsers b = new v2WormBankUsers("b","1111","test1@worm.net","first1","last1","admin","00000001");
				v2WormBankUsers c = new v2WormBankUsers("c","1111","test2@worm.net","first2","last2","employee","00000002");
				v2WormBankUsers d = new v2WormBankUsers("d","1111","test3@worm.net","first3","last3","customer","00000003");
				v2WormBankUsers e = new v2WormBankUsers("e","1111","test4@worm.net","first4","last4","customer","00000004");
				v2WormBankUsers f = new v2WormBankUsers("f","1111","test5@worm.net","first5","last5","customer","00000005");
				v2WormBankUsers g = new v2WormBankUsers("g","1111","test6@worm.net","first6","last6","customer","00000006");
				v2WormBankUsers h = new v2WormBankUsers("h","1111","test7@worm.net","first7","last7","customer","00000007");
				v2WormBankUsers i = new v2WormBankUsers("i","1111","test8@worm.net","first8","last8","customer","00000008");
				v2WormBankUsers j = new v2WormBankUsers("j","1111","test9@worm.net","first9","last9","customer","00000009");
				v2WormBankUsers k = new v2WormBankUsers("k","1111","test10@worm.net","first10","last10","customer","00000010");

				Map<String,v2WormBankUsers> testwormBankuserList = new HashMap<>();
				testwormBankuserList.put(a.getAccountDetails(0),a);
				testwormBankuserList.put(b.getAccountDetails(0),b);
				testwormBankuserList.put(c.getAccountDetails(0),c);
				testwormBankuserList.put(d.getAccountDetails(0),d);
				testwormBankuserList.put(e.getAccountDetails(0),e);
				testwormBankuserList.put(f.getAccountDetails(0),f);
				testwormBankuserList.put(g.getAccountDetails(0),g);
				testwormBankuserList.put(h.getAccountDetails(0),h);
				testwormBankuserList.put(i.getAccountDetails(0),i);
				testwormBankuserList.put(j.getAccountDetails(0),j);			
				testwormBankuserList.put(k.getAccountDetails(0),k);



		         FileOutputStream fileOut = new FileOutputStream("C:\\Users\\T3st\\eclipse-workspace\\revatureJava27\\src\\v2bankingApp\\v2WormAccountslist.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(testwormBankuserList);
		         out.close();
		         fileOut.close();
		         System.out.printf("Serialized data is saved in v2WormAccountslist.ser\n");
			         
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
			}

		
		
		public static void FileBuilder(Map<String,v2WormBankUsers> wormAccountList,v2WormBankUsers newUser) {

			try{

				wormAccountList.put(newUser.getAccountUserName(), newUser);


		         FileOutputStream fileOut = new FileOutputStream("C:\\Users\\T3st\\eclipse-workspace\\revatureJava27\\src\\v2bankingApp\\v2WormAccountslist.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(wormAccountList);
		         out.close();
		         fileOut.close();
		         System.out.printf("User account saved\n");
			         
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
			}
}
