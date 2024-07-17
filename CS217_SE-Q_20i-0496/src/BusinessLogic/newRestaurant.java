package BusinessLogic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class newRestaurant extends Restaurant {

	private static String status="order placed"; // Status of food that can be manipulated by restaurant and rider for customer to view
	
	private static int a=0;          // variable that has a range from 0-5 for customers to give feedback to the restaurant after successful delivery
	
	private static boolean p=false;  // boolean to see status of rider if the order has been delivered or not. (Rider status Order delivered p = true, Rider status Order rejected p =false);
	
	private static boolean q=false;  // boolean to see if order is placed by the customer or not. (Customer places order q = true, Customer cancels order q = false);
	
	private static boolean x = true; // boolean for rider to accept or reject order. (Accepted order x = true, Rejected order x = false)
	
	
	Scanner sc = new Scanner(System.in); // Strings
    Scanner in = new Scanner(System.in); // Integer
	
    int num=0;
    // default constructor
	public newRestaurant() 
	{
		
	}
	
	// Parameterized constructor
	public newRestaurant(String name, int id, String password)
	{
		super(name, id, password);
		
		
	}
	
	
	
	
	// getters and setters
	
	
	public static String getStatus() {
		return status;
	}
	
	

	public static void setStatus(String status) {
		newRestaurant.status = status;
	}
	

	public static int getA() {
		return a;
	}
	
	

	public static void setA(int a) {
		newRestaurant.a = a;
	}
	
	

	public static boolean isP() {
		return p;
	}
	
	

	public static void setP(boolean p) {
		newRestaurant.p = p;
	}
	
	

	public static boolean isQ() {
		return q;
	}
	
	

	public static void setQ(boolean q) {
		newRestaurant.q = q;
	}
	
	

	public static boolean isX() {
		return x;
	}
	
	

	public static void setX(boolean x) {
		newRestaurant.x = x;
	}
	
	
	// end of getter and setter
	
	
	
	
	
															// Methods
					
	

	// Add food
	public void addFood() 
	{
		try
		{
			System.out.println("enter the number of food items you want to add");
			int a=in.nextInt();
			if(a>15) {
				System.out.println("too many items");
			}
			else {
					for(int i=0;i<a;i++) 
					{
						System.out.println("enter your item name");
						String name=sc.nextLine();
						menu.add(name);
						System.out.println("enter its price");
						int p=in.nextInt();
						price1.add(p);
					}
				}
			System.out.println("Food items added successfully...");
		}
		catch(IndexOutOfBoundsException e) 
		{
			System.out.println("IndexOutOfBoundsException");
		}
		catch(InputMismatchException e)
		{
			System.out.println("InputMismatchException");
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException");
		}
	}
	
	
	// Calculate bill
	public void Bill()
	{
		try
		{
			int sum=0;
			int total=0;
			
				System.out.println("Calculating Bill...");
				for(int i=0;i<cart.size();i++)
				{
					System.out.println("Slot "+i+"  |  Name:  "+cart.get(i)+"  |  Price:  RS."+cartprice.get(i));
					sum = sum + cartprice.get(i);
					total=sum;
				}
				System.out.println("Your total bill is: Rs."+total);
				
				if(total==0)
				{	
					System.out.println("Bill Number: ");
					System.out.println("Order Number: ");
				}
				
				else if(total !=0)
				{
					
						super.setBillNumber(super.billNumber);
						super.setOrderNumber(super.orderNumber);
						
						System.out.println("Bill Number: "+super.getBillNumber());
						System.out.println("Order Number: "+super.getOrderNumber());
						
					
				
				}
				
		
		}
		catch(IndexOutOfBoundsException e) 
		{
			System.out.println("IndexOutOfBoundsException");
		}
		catch(InputMismatchException e)
		{
			System.out.println("InputMismatchException");
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException");
		}
		
	}
	
	
	
	// Delete food
	public void deleteFood() 
	{
		try
		{
			if(menu.size()==0) {
				System.out.println("no items present");
			}
			
			
			else {
					System.out.println("select item you want to delete by using coressponding number");
					for (int i = 0; i < menu.size();i++) 
				      { 		      
				          System.out.println(i+" " +menu.get(i)); 		
				      } 
					System.out.println("enter number");
					int delete=in.nextInt();
					menu.remove(delete);
					price1.remove(delete);
					System.out.println("item removed");
					for (int i = 0; i < menu.size();i++) 
				      { 		      
				          System.out.println(i+" " +menu.get(i)); 		
				      }
				}
		}
		catch(IndexOutOfBoundsException e) 
		{
			System.out.println("IndexOutOfBoundsException");
		}
		catch(InputMismatchException e)
		{
			System.out.println("InputMismatchException");
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException");
		}
	}
	
	
	// Update food
	public void updateFood() 
	{
		try
		{
			System.out.println("1. Update food");
			System.out.println("2. Delete food");
			System.out.println("Choose your option:");
			int choice = in.nextInt();
			System.out.println();
			if(choice==1)
			{
				
					if(menu==null) 
					{
						System.out.println("no items present");
					}
					
					else 
					{
						System.out.println("select item you want to update by using coressponding number");
							for (int i = 0; i < menu.size();i++) 
						      { 		      
						          System.out.println(i+" " +menu.get(i)); 		
						      } 
							System.out.println("enter number");
							
							int update=in.nextInt();
							System.out.println("enter name of item");
							String newname=sc.next();
							System.out.println("enter price");
							int newprice=in.nextInt();
							menu.set(update, newname);
							price1.set(update, newprice);
							System.out.println("item updated");
							for (int i = 0; i < menu.size();i++) 
						      { 		      
						          System.out.println(i+" " +menu.get(i)); 		
						      }
						}
			}
			
			else if(choice ==2)
			{
				deleteFood();
			}
			
			else
				System.out.println("Wrong input");
		}
		catch(IndexOutOfBoundsException e) 
		{
			System.out.println("IndexOutOfBoundsException");
		}
		catch(InputMismatchException e)
		{
			System.out.println("InputMismatchException");
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException");
		}
	}
	
	
	
	// Delivery status
	public void deliveryStatus()
	{
		System.out.println("your order status is "+status);
	}
	
	
	
	// Food delivery status
	public void foodDeliveryStatus() 
	{
		try
		{
			System.out.println("enter currunt dilevery status");
			System.out.println("press 1 for order recieved");
			System.out.println("press 2 for preparing food");
			System.out.println("press 3 to order out for dilevery");
			int input=sc.nextInt();
			if(input==1) {
				status="order recieved";
			}
			else if(input==2){
				status="preparing food";
			}
			else if(input==3) {
				status="order out for dilevery";
			}
			else {
				System.out.println("wrong input");
			}
		}
		catch(IndexOutOfBoundsException e) 
		{
			System.out.println("IndexOutOfBoundsException");
		}
		catch(InputMismatchException e)
		{
			System.out.println("InputMismatchException");
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException");
		}
	}

	
	//  Reveal food delivery status to customer
	public void checkFoodDeliveryStatus() 
	{
		System.out.println("your order status is "+status);
	}

	// Check food order
	public void checkFoodOrder() 
	{
		try
		{
			if (q==true)
			{
				System.out.println("Following food orders placed: ");
				System.out.println();
				for(int i=0; i<cart.size();i++)
				{
					System.out.println("Slot "+i+"  |  Name: "+cart.get(i)+"  |  RS."+cartprice.get(i)+"  | ");
				}
			}
		}
		catch(IndexOutOfBoundsException e) 
		{
			System.out.println("IndexOutOfBoundsException");
		}
		catch(InputMismatchException e)
		{
			System.out.println("InputMismatchException");
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException");
		}
	}
	
	
	// Check feedback
	public boolean feedback() 
	{
		if(a==0)
		{
			System.out.println(a+" star");
			System.out.println("No Feedback!!!!");
			return false;
			
		}
		
			if(a==1)
			{
				System.out.println(a+" stars");
				System.out.println("Food quality is so bad, ugh");
				return true;
			}
			
			else if(a==2)
			{
				System.out.println(a+" stars");
				System.out.println("You need to add varity of food please");
				return true;
			}
			
			else if(a==3)
			{
				System.out.println(a+" stars");
				System.out.println("It was neither good nor bad. Just normal to be honest");
				return true;
			}
			
			else if(a==4)
			{
				System.out.println(a+" stars");
				System.out.println("I really liked the taste of your food");
				return true;
			}
			
			else if(a==5)
			{
				System.out.println(a+" stars");
				System.out.println("Wow, best restaruant in the history of my life. Very good chefs");
				return true;
			}
			else 
			{
				System.out.println("wrong input");
			}
			return false;
	}
	
	// view all food in menu
	public void viewMenuFood()
	{
		System.out.println("The restaurant has the following foods in the menu:");
		
		if(menu.size() == 0)
		{
			System.out.println("Menu is Empty...");
		}
		else
		{
			for (int i = 0; i < menu.size();i++) 
		      { 		      
		          System.out.println("Slot "+i+"  |  "  +menu.get(i)+  "  | Rs.  "+price1.get(i)+"  |  "); 		
		          
		      }
		}
	}
}
