package stockmanagementsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sales 
{
	static ArrayList<String> Customernamelist=new ArrayList<>();
	static ArrayList<String> Customermobilenumberlist=new ArrayList<>();
	static ArrayList<String> Soldproductid=new ArrayList<>();
	static ArrayList<String> Productname=new ArrayList<>();
	static ArrayList<String> ProductQuantity=new ArrayList<>();
	static ArrayList<String> Productprice=new ArrayList<>();
	static ArrayList<String> Soldon=new ArrayList<>();
	public static void sellProduct(String userName, String shopName)
	{
	   boolean flag=true;
	   while(flag)
	   {
		   System.out.println("press 1 to display stock, 2 to sell product,3 to exit");
		   int choice;
		   Scanner choicescanner=new Scanner(System.in);
		   choice=choicescanner.nextInt();  
		   switch(choice)
		   {
		   case 1:
			   Stock.displayStock(userName);
			   break;
		   case 2:
			   sell(userName,shopName);
			   break;
		   case 3:
			   flag=false;
			   break;
		   default:
			   System.out.println("wrong choice!!!");
			   break;
		   }
	   }
	  
	}
	public static void sell(String userName, String shopName)
	{
		String productId = null, productPrice;
		int productQuantity;
		boolean flag=true,flag1=false;
		System.out.println("****selling product****");
		Scanner sellingscanner=new Scanner(System.in);
		int index=0;
		while(flag)
		{
			System.out.println("enter product id:");
			productId=sellingscanner.next();
			for(index=0;index<Stock.productIdList.size();index++)
			{
				if(Stock.productIdList.get(index).equals(productId) && Stock.shopKeeperNameList.get(index).equals(userName))
				{
					flag1=true;
					flag=false;
					break;
				}
			}
			if(flag1==false)
			{
				System.out.println("product id does not exist!!");
				flag=true;
			}
		}
		flag=true;
		while(flag)
		{
			System.out.println("enter product quantity which you going to buy:");
			productQuantity=sellingscanner.nextInt();
			if(productQuantity>Integer.parseInt(Stock.productQuantityList.get(index)))
			{
				System.out.println("only "+Stock.productQuantityList.get(index)+"products available");
				System.out.println("please enter quantity according to product quantity");
				flag=true;
			}
			else
			{
				generateBill(userName,productId,productQuantity);
				flag=false;
			}
			
		}
	}
	public static void generateBill(String userName,String productId, int productQuantity)
	{
		String Customername = null,Customermobilenumber = null;
		Scanner billingScanner=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("enter customer name:");
			Customername=billingScanner.next();
			if(Customername.matches("^[0-9]"))
			{
				System.out.println("enter customer name in alphabets only!!");
				flag=true;
			}
			else
			{
				flag=false;
			}
		}
		flag=true;
		while(flag)
		{
			System.out.println("enter mobile number:");
			Customermobilenumber=billingScanner.next();
			if(Customermobilenumber.length()!=10||Customermobilenumber.charAt(0)=='0'||Customermobilenumber.matches("^[a-zA-z]"))
			{
				System.out.println("please enter valid mobile number!!");
				flag=true;
			}
			else
			{
				flag=false;
			}
		}		
		int index=0;
		for(index=0;index<Stock.productIdList.size();index++)
		{
			if(productId.equals(Stock.productIdList.get(index)) && userName.equals(Stock.shopKeeperNameList.get(index)))
			{
				int quantity=Integer.parseInt(Stock.productQuantityList.get(index))-productQuantity;
				Stock.productQuantityList.set(index,String.valueOf(quantity));
				break;
			}
		}
		Customernamelist.add(Customername);
		Customermobilenumberlist.add(Customermobilenumber);
		Soldproductid.add(Stock.productIdList.get(index));
		Productname.add(Stock.productNameList.get(index));
		ProductQuantity.add(String.valueOf(productQuantity));
		Productprice.add(Stock.productPriceList.get(index));
		Soldon.add(Date());
	}
	private static String Date() 
	{
	    Date date=new Date();
		return date.toString();
	}
//	public static void displaySales(String userName)
//	{
//		if()
//		
//	}
	

}
