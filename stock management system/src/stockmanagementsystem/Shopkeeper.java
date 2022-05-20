package stockmanagementsystem;
import java.util.ArrayList;
import java.util.Scanner;
public class Shopkeeper 
{
	/*
	 * This class is used to register and login by the shopkeeper
	 */
	static ArrayList <String> shopNameList=new ArrayList<>(); //This array list contains the shopkeepers shop name
	static ArrayList <String> shopKeepersNameList= new ArrayList<>();//This array list contains the shopkeeper's user name
	private static ArrayList<String> shopKeepersPasswordList=new ArrayList<>();//This array list contains the shopkeeper's password
	static ArrayList <String> shopKeepersMailList=new ArrayList<>();//This array list contains the shopkeeper's mail id
	static ArrayList <String> shopKeepersMobileNoList=new  ArrayList<>();
	public static ArrayList<String> getShopkeepersPasswordList()
	{
		return shopKeepersPasswordList;
	}
	public static void setShopkeepersPasswordList(String password) 
	{
		shopKeepersPasswordList.add(password);
	}
	public Shopkeeper()
	{
        Registration registration=new Registration();
		boolean flag=true;
		do
		{
			System.out.println("*************************************************************");
			System.out.println("press 1 for signup, 2 for login, 3 for exit:");
			Scanner choiceScanner=new Scanner(System.in);
			int choice=choiceScanner.nextInt();
			switch(choice)
			{
			  case 1:
				  registration.validation(shopNameList,shopKeepersNameList,shopKeepersMailList,shopKeepersMobileNoList);
				  break;
			  case 2:
				   login(shopKeepersNameList,shopNameList);
			       break;
			  case 3:
				  flag=false;
				  break;
			  default:
				System.out.println("wrong choice!!");
				break;
			}
		}
		while(flag);
	}
	public static void login(ArrayList <String> usernameList, ArrayList<String> shopNameList)
	{
		 ArrayList<String> passwordList=new ArrayList<>();
		 String userName = null,shopName=null;
		 Scanner loginScanner=new Scanner(System.in);
		 System.out.println("*************************");
		
         int index=0;
         boolean flag=true;
         while(flag)
         {
        	 System.out.println("enter the shop name:");
             shopName=loginScanner.nextLine();
        	 for(index=0;index<shopNameList.size();index++)
             {
            	 if(shopNameList.get(index).equals(shopName))
            	 {
            		 flag=false;
            		 boolean flag1=true;
            		 while(flag1)
            		 {
            			 System.out.println("enter the user name:");
            			 userName=loginScanner.next();
            			 if(userName.equals(usernameList.get(index)))
            			 {
            				 flag1=false;
            			 }
            			 else
            			 {
            				 System.out.println("user name does not exist!!");
            				 flag1=true;
            			 }
            		 }
            		 break;
            	 }
             }
             if(flag==true)
             {
            	 System.out.println("shop name does not exist!!");
             }
         }
         flag=true;
         passwordList=Shopkeeper.getShopkeepersPasswordList();
         int count=3;
         while(flag==true&& count!=0)
         {
        	 System.out.println("enter the password:");
			 String password=loginScanner.next();
			 if(passwordList.get(index).equals(password))
			 {
				System.out.println("LOGIN SUCCESSFUL!!");
  				if(Home.choice==2)
  				{
  					showShopkeepersMenu(userName,shopName);
  				}
				 flag=false;
			 }
			 else
			 {
				 System.out.println("password incorrect!!");
				 count--;
				 if(count!=0)
				 {
					 System.out.println("still you have "+count+" attempt to enter password!!");
				 }
				 if(count==0)
				 {
					 System.out.println("Your account was locked!!");
					 flag=false;
					 break;
				 }
				 flag=true;
			 }
         }    
	}
	static int choice;
	public static void showShopkeepersMenu(String userName,String shopName)
	{
		        
		        Scanner choiceScanner=new Scanner(System.in);
				boolean flag=true;
				for(int index=0;index<Shopkeeper.shopKeepersNameList.size();index++)
				{
					if(Shopkeeper.shopKeepersNameList.get(index).equals(userName))
					{
						System.out.println("****************welcome to "+Shopkeeper.shopNameList.get(index)+"****************");
						break;
					}
				}
				System.out.println("welcome mr."+userName);
				do
				{
					
					System.out.println("****************************************************************************************************************************");
					System.out.println("press 1 for add stock, 2 for sell product, 3 for update stock, 4 for display stock, 5 for display sales details, 6 for logout ");
					choice=choiceScanner.nextInt();
					switch(choice)
					{
					case 1:
						Stock.addStock(userName);
						break;
					case 2:
						Sales.sell(userName,shopName);
						break;
					case 3:
						Stock.updateStock(userName);
						break;
					case 4:
						Stock.displayStock(userName);
						break;
					case 5:
//						Sales.displaySales(userName);
						break;
					case 6:
						flag=false;
						break;
				    default:
				    	System.out.println("wrong choice!!");
				    	break;
					}
				}
				while(flag);
	}
	

}
