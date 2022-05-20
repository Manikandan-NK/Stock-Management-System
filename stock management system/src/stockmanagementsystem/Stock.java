package stockmanagementsystem;
import java.util.ArrayList;
import java.util.Date;
public class Stock 
{
	/*
	 * This class is used to display the stock details by using displayStock method
	 */
	   
	    static ArrayList<String> shopKeeperNameList=new ArrayList<>();
		static ArrayList<String> productIdList=new ArrayList<>();
		static ArrayList<String> productNameList=new ArrayList<>();
		static ArrayList<String> productModelList=new ArrayList<>();
		static ArrayList<String> productPriceList=new ArrayList<>();
		static ArrayList<String> productQuantityList=new ArrayList<>();
		static ArrayList<String> productAddedOnList=new ArrayList<>();
		static String productId=null;
		static String productName = null;
		static String productModel = null;
		static String productQuantity = null;
	    static String productPrice = null;
	    static String productAddedOn=null;
		public static void addStock(String userName)
		{
			
			System.out.println("welcome mr."+userName);
			Productsvalidation.productIdValidation(userName,productId,productName, productModel, productQuantity, productPrice);
			productAddedOn = Date();
			boolean flag=false;
			for(int index=0;index<Stock.productIdList.size();index++)
			{
				if(Stock.productIdList.get(index).equals(productId)&&Stock.shopKeeperNameList.get(index).equals(userName))
				{
					System.out.println("product already exist!!");
					flag=true;
					break;
				}
			}
			if(flag==false)
			{
				    
				    Stock.shopKeeperNameList.add(userName);
				    Stock.productIdList.add(productId);
					Stock.productNameList.add(productName);
					Stock.productModelList.add(productModel);
					Stock.productPriceList.add(productPrice);
					Stock.productQuantityList.add(productQuantity);
					Stock.productAddedOnList.add(productAddedOn);
					System.out.println("Productsvalidation added successfully!!");
			}
			else
			{
				Stock.updateStock(userName);
			}
			
		}
		
		private static String Date() 
		{
		    Date date=new Date();
			return date.toString();
		}
		public static void updateStock(String userName)
		{
			System.out.println("welcome mr."+userName);
			if(Productsvalidation.updateValidation(productId))
			{
				if(Productsvalidation.productDetailsValidation(productName, productModel, productQuantity, productPrice))
				{
					for(int index=0;index<Stock.productIdList.size();index++)
					{
						if(Stock.productIdList.get(index).equals(productId)&&Stock.shopKeeperNameList.get(index).equals(userName))
						{
							
							Stock.productNameList.set(index,productName);
							Stock.productModelList.set(index, productModel);
							Stock.productQuantityList.set(index,productQuantity);
							Stock.productPriceList.set(index, productPrice);
							System.out.println("successfully updated!!");
							break;
						}
					}
				}
			}
			else
			{
				System.out.println("updation failed");
			}
			
		}
	public static boolean displayStock(String username)
	{
		if(productNameList.size()==0)
		{
			System.out.println("***************************************************");
			System.out.println("There is no products entered: please enter products");
			System.out.println("***************************************************");
			return false;
		}
		else
		{
			System.out.println("*************************************************************STOCK DETAILS****************************************************************");
			for(int index=0;index<productNameList.size();index++)
			{
				if(shopKeeperNameList.get(index).equals(username))
				{
					System.out.println("Shopkeeper Name:"+shopKeeperNameList.get(index)+" | "+"Product Id: "+productIdList.get(index)+" | "+"Product Name: "+productNameList.get(index)+" | "+" product Model: "+productModelList.get(index)+" | "+" product Quantity: "+productQuantityList.get(index)+" | "+" product Price: "+productPriceList.get(index)+" | "+"product Addedon: "+productAddedOnList.get(index));

				}
			}
			System.out.println("*****************************************************************************************************************************************");
		}
		return true;
	}
	

}
