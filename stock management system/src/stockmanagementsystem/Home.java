package stockmanagementsystem;
import java.util.Scanner;
public class Home 
{
	/*
	 * This class acts as a home page
	 */
    public static int choice;
	public  Home() 
    {
	   Scanner choiceScanner=new Scanner(System.in);
	   boolean flag=true;
	   do
       {
		 System.out.println("**************************************************************");
		 System.out.println("WELCOME TO MK'S STOCK MANAGEMENT SYSTEM FOR MOBILE SHOP!!");
		 System.out.println("**************************************************************");
         System.out.println("press 1 admin, 2 for shopkeeper, 3 for exit:");
         choice=choiceScanner.nextInt();
         switch(choice)
         {
           case 1:
        	   new Admin();
               break;
           case 2:
        	   new Shopkeeper();
               break;
           case 3:
        	   flag=false;
        	   System.out.println("***************WELCOME AGAIN!!*************");
        	   break;
           default:
           	System.out.println("wrong choice: ");
           	break;
         }  
       }
       while(flag);
    }
}
