package stockmanagementsystem;
import java.util.Scanner;
public class Productsvalidation 
{
	/*
	 * This class is used to validate the product id which entered by the shopkeepers with the help of productIdvalidation and this is used to validate product details in ProductDetailsValidation class 
	 */
	public static boolean productIdValidation(String userName,String productId,String productName, String productModel, String productQuantity, String productPrice) 
	{
		Scanner validationScanner=new Scanner(System.in);
		boolean flag=true, flag1=false;
		while(flag)
		{
			System.out.println("enter the product id:");
			productId=validationScanner.next();
			if(productId.matches("[a-zA-Z]+"))
			{
				System.out.println("enter only numbers in product id:");
				flag=true;
			}
			else
			{
				for(int i=0;i<Stock.productIdList.size();i++)
				{
					if(Stock.productIdList.get(i).equals(productId)&&Stock.shopKeeperNameList.get(i).equals(userName))
					{
						flag1=true;
						System.out.println("product id already exist:");
						System.out.println("Try another!!");
						break;
					}
				}
				if(flag1==true)
				{
					flag=true;
					flag1=false;
				}
				else
				{
					flag=false;
				}
			}
		}
		if(flag==false)
		{
			if(Shopkeeper.choice==1)
			{
				Stock.productId=productId;
			}
		    productDetailsValidation(productName, productModel, productQuantity, productPrice);
		}
        return false;
	}
	public static boolean productDetailsValidation(String productName, String productModel, String productQuantity, String productPrice)
	{
		Scanner validationScanner=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("enter the product name:");
			productName=validationScanner.nextLine();
			if(!(productName.matches("[a-z' 'A-Z]+")))
			{
				System.out.println("enter only characters in product name!!");
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
			System.out.println("enter the product model:");
			productModel=validationScanner.nextLine();
			if(!(productModel.matches("[a-z' '0-9]+")))
			{
				System.out.println("enter valid product model!!");
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
			System.out.println("enter the product quantity:");
			productQuantity=validationScanner.next();
			if(productQuantity.matches("[a-zA-Z]+") || productQuantity.charAt(0)=='0')
			{
				System.out.println("enter product quantity only in numbers and not starts in 0");
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
				System.out.println("enter the product Price:");
				productPrice=validationScanner.next();
				if(productPrice.matches("[a-zA-Z]+")|| productPrice.charAt(0)=='0')
				{
					System.out.println("enter only numbers and not starts with 0 in price!!");
					flag=true;
				}
				else
				{
					flag=false;
				}
		}
		if(flag==false)
		{
			if(Shopkeeper.choice==1)
			{	
				Stock.productModel=productModel;
				Stock.productName=productName;
				Stock.productQuantity=productQuantity;
				Stock.productPrice=productPrice;
			}
			else if(Shopkeeper.choice==3)
			{
				Stock.productModel=productModel;
				Stock.productName=productName;
				Stock.productPrice=productPrice;
				Stock.productQuantity=productQuantity;
			}
		}
		return true;
	}
	public static boolean updateValidation(String productId)
	{
		Scanner validationScanner=new Scanner(System.in);
		boolean flag=true, flag1=false;
		while(flag)
		{
			System.out.println("enter the product id:");
			productId=validationScanner.next();
			if(productId.matches("[a-zA-Z]+"))
			{
				System.out.println("enter only numbers in product id:");
				flag=true;
			}
			else
			{
				for(int index=0;index<Stock.productIdList.size();index++)
				{
					if((Stock.productIdList.get(index).equals(productId)))
					{
						flag1=true;
						break;
					}
				}
				if(flag1==true)
				{
					flag=false;
					flag1=false;
				}
				else
				{
					System.out.println("product id does not exist!!");
					System.out.println("If you want to continue updation press 1 otherwise any key");
					char choice=validationScanner.next().charAt(0);
					if(choice=='1')
					{
						flag=true;
					}
					else
					{
						break;
					}
					
				}
			}
		}
		if(flag==false)
		{
			Stock.productId=productId;
			return true;
		}
		return false;
	}

}
