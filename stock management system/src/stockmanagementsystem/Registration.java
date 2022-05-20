package stockmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration 
{
	//This class is used to register the shopkeepers details
	static String shopName,userName,password,userMailid,userMobilenumber;
	public void validation(ArrayList<String> shopNameList,ArrayList <String> userNameList,ArrayList <String> userMailList,ArrayList<String> userMobileNumberList)
    {
		
    	System.out.println("*************************");
    	boolean flag=true;
    	Scanner registrationscanner=new Scanner(System.in);
    	System.out.println("enter the shop name:");
    	shopName=registrationscanner.nextLine();
    	flag=true;
        while(flag)
    	{
    		System.out.println("enter the username:");
    		userName=registrationscanner.next();
    		String usernameFormat="^[A-Za-z]\\w{5,29}$";
	   	    Pattern usernamePattern=Pattern.compile(usernameFormat);
	   	    Matcher usernameMatches=usernamePattern.matcher(userName);
	   	    if(!usernameMatches.matches())
	   	    {
	   		   System.out.println("Invalid username!!");
	   		   System.out.println("*********************************************************************************");
	   		   System.out.println("A username is considered valid if all the following constraints are satisfied:\r\n"
	   		   		+ "The username consists of 6 to 30 characters inclusive. If the username\r\n"
	   		   		+ "consists of less than 6 or greater than 30 characters, then it is an invalid username.\r\n"
	   		   		+ "The username can only contain alphanumeric characters and underscores (_)."
	   		   		+ " Alphanumeric characters describe the character set consisting of lowercase characters [a – z], uppercase characters [A – Z], and digits [0 – 9].\r\n"
	   		   		+ "The first character of the username must be an alphabetic character, i.e., either lowercase character\r\n"
	   		   		+ "[a – z] or uppercase character [A – Z].");
	   		 System.out.println("*********************************************************************************");
	   		   flag=true;
	   	    }
	   	    else
	   	    {
	   	    	flag= false;
	   	    	for(int index=0;index<userNameList.size();index++)
	    		{
	    			if(userNameList.get(index).equals(userName))
	    			{
	    				System.out.println("username already exist!!");
	    				flag=true;
		    		    break;
	    				
	    			}
	    		}
	   	    }
    	}
    	if(flag==false)
    	{
    		do
    		{
    			System.out.println("enter password:");
    			password=registrationscanner.next();
    			String passwordformat="^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#!$%^&()+=*])"+ "(?=\\S+$).{8,20}$";
    		    Pattern passwordpattern=Pattern.compile(passwordformat);
    		    Matcher passwordmatches=passwordpattern.matcher(password);
    		    if(!passwordmatches.matches())
    		    {
    		    	 System.out.println("Invalid Password!!");
    		    	 System.out.println("*********************************************************************************");
    		    	 System.out.println("A password is considered valid if all the following constraints are satisfied:\r\n"
    		    	 		+ "It contains at least 8 characters and at most 20 characters.\r\n"
    		    	 		+ "It contains at least one digit.\r\n"
    		    	 		+ "It contains at least one upper case alphabet.\r\n"
    		    	 		+ "It contains at least one lower case alphabet.\r\n"
    		    	 		+ "It contains at least one special character which includes !@#$%&*()-+=^.\r\n"
    		    	 		+ "It doesn’t contain any white space.");
    		    	 System.out.println("*********************************************************************************");
    		    	 flag=true;
    		    }
    		    else
    		    {
    		    	     System.out.println("Confirm password!!");
    		        	 String confirmpassword=registrationscanner.next();
    		        	 if(!(password.equals(confirmpassword)))
    		        	 {
    		        		 System.out.println("Password doesn't match try again!!");
    		        		 System.out.println("***********************************");
    		        		 flag=true;
    		        	 }
    		        	 else
    		        	 {
    		        		 flag=false;
    		        	 }
    		    }
    		}
    		while(flag);
    	}
    	if(flag==false)
    	{
    		do
    		{
    			System.out.println("Enter mailId:");
    		    userMailid=registrationscanner.next();
    	        String mailidformat="^[A-Za-z0-9+_.-]+@(.+)$";
    	        Pattern mailidpattern=Pattern.compile(mailidformat);
    	        Matcher mailidmatches=mailidpattern.matcher(userMailid);
    	        if(!mailidmatches.matches())
    	        {
    	       	 System.out.println("Invalid mail id!!");
    	       	 System.out.println("*************************************************************");
    	       	 System.out.println("A-Z characters are allowed\r\n"
    	       	 		+ "a-z characters are allowed\r\n"
    	       	 		+ "0-9 numbers are allowed\r\n"
    	       	 		+ "Additionally email can contain dot(.), underscore(_), and dash(-).\r\n"
    	       	 		+ "The remaining characters are not allowed.");
    	       	 System.out.println("*************************************************************");
    	       	 flag =true;
    	        }
    	        else
    	        {
    	        	 
    	        	 flag=false;
    	        }
    		}
    		while(flag);
    	}
    	if(flag==false)
    	{
    		do
    		{
    			System.out.println("Enter mobilenumber:");
    			userMobilenumber=registrationscanner.next();
    			if(userMobilenumber.length()!=10||userMobilenumber.charAt(0)=='0'||userMobilenumber.matches("^[a-zA-z]"))
    			{
    				System.out.println("Enter valid 10 digit mobile number!!");
    				flag=true;
    			}
    			else
    			{
    				flag=false;
    			    registration(shopName,userName,password,userMailid,userMobilenumber);
    			}
    		}
    		while(flag);
    	}
   }
	public static void registration(String shopName,String userName, String password, String userMailid,String userMobilenumber)
	{
		    Shopkeeper.shopNameList.add(shopName);
       	    Shopkeeper.shopKeepersNameList.add(userName);
       	    Shopkeeper.setShopkeepersPasswordList(password);
            Shopkeeper.shopKeepersMailList.add(userMailid);
            Shopkeeper.shopKeepersMobileNoList.add(userMobilenumber);
		    System.out.println("Your account was created successfully!!");
            System.out.println("***************************************");
	}

}
