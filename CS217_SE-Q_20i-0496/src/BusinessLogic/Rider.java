package BusinessLogic;
/*
 * By: 													OOP Final Semester Project: Food On Wheels
 * Khursheed Alam Khan --> 20i-0496
 * Muhammad Abdullah   --> 20i-2311
 * 
 * Section: SE-Q
 */


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Rider

{
	
	private static boolean k = false; // boolean to check if customer paid the cash or not. (Customer paid cash k = true, Customer refused to pay case k = false)
	
	
	Scanner in = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);

	
	 newRestaurant res = new newRestaurant();  // Association of newRestaurant
	 Customers c = new Customers(res);		  // Association of Customers
	
	 
	 
	// attributes
	protected String name;
	protected int id;
	protected String password;
	protected String phone;
	protected String address;
	
	protected ArrayList<String> ridername = new ArrayList<String>(30);
	protected ArrayList<String> rideraddress = new ArrayList<String>(30);
	
	protected ArrayList<String> newpassword = new ArrayList<String>(30);
	protected ArrayList<Integer> newID = new ArrayList<Integer>(30);
	
	
	
	// getters and setters
	public ArrayList<String> getRidername() {
		return ridername;
	}
	
	
	public void setRidername(ArrayList<String> ridername) {
		this.ridername = ridername;
	}
	
	
	public ArrayList<String> getRideraddress() {
		return rideraddress;
	}
	
	
	public void setRideraddress(ArrayList<String> rideraddress) {
		this.rideraddress = rideraddress;
	}
	
	
	public ArrayList<String> getNewpassword() {
		return newpassword;
	}
	
	
	public void setNewpassword(ArrayList<String> newpassword) {
		this.newpassword = newpassword;
	}
	
	
	public ArrayList<Integer> getNewID() {
		return newID;
	}
	
	

	public void setNewID(ArrayList<Integer> newID) {
		this.newID = newID;
	}
	
	
	public String getName() 
	{
		return name;
	}
	
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	public String getPhone() 
	{
		return phone;
	}
	
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	

	public static boolean isK() {
		return k;
	}


	public static void setK(boolean k) {
		Rider.k = k;
	}
	
	
	// end of getters and setters
	
		
		
	
	
	public Rider(newRestaurant res, Customers c)
	{
		this.res=res;
		this.c=c;
	}
	
	// Parameterized constructor
	Rider(String name, int id, String phone, String address, newRestaurant res, Customers c)
	{
		this.name=name;
		this.id=id;
		this.phone=phone;
		this.address=address;
		this.res=res;
		this.c=c;
	}
	
																// Methods
																				
	// Rider status
	public boolean statusRider() 
	{
		try
		{
			System.out.println("status order");
			System.out.println("press 1 for dilevering");
			System.out.println("press 2 for in the area be ready");
			System.out.println("press 3 for order dilevered");
			int input=sc.nextInt();
			if(input==1) 
			{
				newRestaurant.setStatus("dilevering");
				return false;
			}
			else if(input==2)
			{
				newRestaurant.setStatus("In your area be ready");
				return false;
			}
			else if(input==3) 
			{
				newRestaurant.setStatus("order dilevered");
				
				for(int i=0; i<res.cart.size();i++)
				{
					res.cart.clear();
					res.cartprice.clear();
					res.setBillNumber(res.billNumber+res.num++);
					res.setOrderNumber(res.orderNumber+res.num++);
				}
				newRestaurant.setP(true);
				return newRestaurant.isP();
			}
			else 
			{
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
		return false;
	}
	
	
	// Check food order
	public void viewFoodOrder() 
	{
		try
		{
			System.out.println("Following food orders placed: ");
			System.out.println();
			for(int i=0; i<res.cart.size();i++)
			{
				System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   Bill Number: "+res.getBillNumber()+"  |  Order Number: "+res.getOrderNumber()+"  |  Customer Name: "+c.customerName.get(0)+"  |   Address: "+c.customerAddress.get(0)+"  |  Phone: "+c.phone1.get(0));
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
	
	
	// Accept or reject food order
	public boolean orderAccept() 
	{
		try
		{
			System.out.println("Following food orders placed: ");
			System.out.println();
			for(int i=0; i<res.cart.size();i++)
			{
				System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   Bill Number: "+res.getBillNumber()+"  |  Order Number: "+res.getOrderNumber()+"  |  Customer Name: "+c.customerName.get(0)+"  |   Address: "+c.customerAddress.get(0)+"  |  Phone: "+c.phone1.get(0));
			}
			
			System.out.println("Do you want to Accept Order");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = in.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Followings items order request Accepted: ");
				
					System.out.println("Slot "+"  |  Name: "+res.cart+"  |  RS."+res.cartprice);
				
				newRestaurant.setX(true);
				
				return newRestaurant.isX();
				
			}
			else 
			{
				System.out.println("Order Accept request Cancelled...");
				newRestaurant.setStatus("Order Rejected by rider !!!");
				newRestaurant.setX(false);
				
			
				
					res.cart.clear();
					res.cartprice.clear();
					res.setBillNumber(res.billNumber+res.num++);
					res.setOrderNumber(res.orderNumber+res.num++);
					
				
				
				return newRestaurant.isX();
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
		return false;
	}
	
	
	// Cash Collection Update
	public boolean cashCollectionUpdate() 
	{
		try
		{
			System.out.println("1. Customer Paid Cash");
			System.out.println("2. Customer did not pay cash");
			System.out.println("Choose the option: ");
			int option = in.nextInt();
			
			if(option == 1)
			{
				System.out.println("Thank you for your purchase");
				setK(true);
				return isK();
			}
			
			else
			{
				System.out.println("Customer never paid for the item");
				setK(false);
				return isK();
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
		return false;
	}
		
	
	
	
	// Check food order for customers more than 1
		public void viewFoodOrder2() 
		{
			try
			{
				System.out.println("Following food orders placed: ");
				System.out.println();
				for(int i=0; i<res.cart.size();i++)
				{
					System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   Bill Number: "+res.getBillNumber()+"  |  Order Number: "+res.getOrderNumber()+"  |  Customer Name: "+c.customerName.get(i)+"  |   Address: "+c.customerAddress.get(i)+"  |  Phone: "+c.phone1.get(i));
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
		
		
		// Accept or reject food order for customers more than 1
		public boolean orderAccept2() 
		{
			try
			{
				System.out.println("Following food orders placed: ");
				System.out.println();
				for(int i=0; i<res.cart.size();i++)
				{
					System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   Bill Number: "+res.getBillNumber()+"  |  Order Number: "+res.getOrderNumber()+"  |  Customer Name: "+c.customerName.get(i)+"  |   Address: "+c.customerAddress.get(i)+"  |  Phone: "+c.phone1.get(i));
				}
				
				System.out.println("Do you want to Accept Order");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int choice = in.nextInt();
				
				if(choice == 1)
				{
					System.out.println("Followings items order request Accepted: ");
					for(int i=0; i<res.cart.size();i++)
					{
						System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i));
					}
					newRestaurant.setX(true);
					
					return newRestaurant.isX();
					
				}
				else 
				{
					System.out.println("Order Accept request Cancelled...");
					newRestaurant.setStatus("Order Rejected by rider !!!");
					newRestaurant.setX(false);
					
					for(int i=0; i<res.cart.size();i++)
					{
						res.cart.remove(i);
						res.cartprice.remove(i);
						res.setBillNumber(res.billNumber+res.num++);
						res.setOrderNumber(res.orderNumber+res.num++);
						
					}
					
					return newRestaurant.isX();
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
			return false;
		}
	
	
	
	

	
	// Rider Options
		/*
		public abstract void viewOrder();
		public abstract boolean orderAccept();
		public abstract boolean cashCollectionUpdate();
		public abstract void statusRider();
		*/

}
