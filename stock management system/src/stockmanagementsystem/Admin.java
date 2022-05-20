package stockmanagementsystem;
import java.util.Scanner;
public class Admin 
{
	/*
	 * This class used for Admin login and call the Admin operations when login succeed
	 */
	public Admin()
	{
		String adminName="SMSADMIN";
		String adminPassword="ADMIN@123!#$%143^";
		boolean flag=true;
		do
		{
			System.out.println("******************************************************************");
			System.out.println("press 1 for  login, 2 for exit:");
			Scanner choiceScanner=new Scanner(System.in); 
			int choice=choiceScanner.nextInt();
			switch(choice)
			{
			  case 1:
				  System.out.println("enter username:");
				  String userName=choiceScanner.next();
				  if(userName.equals(adminName))
				  {
				     System.out.println("enter password:");
				     String password=choiceScanner.next();
				     if(adminPassword.equals(password))
					 {
						  System.out.println("LOGIN SUCCESSFUL!!");
						  adminOperations();
					 }
					  else
					  {
						  System.out.println("INCORRECT PASSWORD!!");
					  }
				  }
				  else
				  {
					  System.out.println("INCORRECT USER NAME!!");
				  }
				  break;
			  case 2:
				  flag=false;
				  break;
			  default:
				System.out.println("wrong choice!!");
				break;
			}
		}
		while(flag);
	}
	public static void adminOperations() 
	{
		System.out.println("welcome admin!!");
		Scanner choiceScanner=new Scanner(System.in);
		boolean flag=true;
		int choice=0;
		do
		{
			System.out.println("press 1 for display approved shopkeepers, 2 for exit");
			choice=choiceScanner.nextInt();
			switch(choice)
			{
			case 1:
				displayshopkeepers();
				break;
			case 2:
				flag=false;
				break;
			default:
				System.out.println("wrong choice");
			}
		}
		while(flag);
		
	}
	public static void displayshopkeepers()
	{
		  System.out.println("******************************************************SHOP KEEPERS*******************************************************************************");
     	  if(Shopkeeper.shopKeepersNameList.size()==0)
     	  {
     		System.out.println("There is no approved shopkeepers ");
     	  }
     	  for(int index=0;index<Shopkeeper.shopKeepersNameList.size();index++)
          {
     		 System.out.println("FullName: "+ Shopkeeper.shopKeepersNameList.get(index) + " | Mail_ID: " +Shopkeeper.shopKeepersMailList.get(index)+" | "+"shop name"+Shopkeeper.shopNameList.get(index)
     		                   +" | "+"Contact no:"+Shopkeeper.shopKeepersMobileNoList.get(index));
          }
     	  System.out.println("*************************************************************************************************************************************************");
		
	}

	

}
