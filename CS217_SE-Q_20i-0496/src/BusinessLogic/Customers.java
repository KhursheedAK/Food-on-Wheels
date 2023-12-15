package BusinessLogic;
/*
 * By: 													OOP Final Semester Project: Food On Wheels
 * Khursheed Alam Khan --> 20i-0496
 * Muhammad Abdullah   --> 20i-2311
 * 
 * Section: SE-Q
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customers 
{
	
	Scanner in = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);
	File obj=new File("cartitem.txt");  // Cart Item name
	File obj2=new File("cartprice.txt");  // Cart Item Price
	File obj3=new File("bill.txt");    // Bill
	
	// attributes
	
	protected String name;
	protected String address;
	protected int id;
	protected String phone;
	protected String password;
	
	private static boolean c = false;     // boolean for cash on delivery. (Cash on delivery yes = true, Cash on delivery no = fasle)
	
	protected ArrayList<Integer> newID = new ArrayList<Integer>(30);
	protected ArrayList<String> newPassword = new ArrayList<String>(30);
	
	protected ArrayList<String> customerName = new ArrayList<String>(30);
	protected ArrayList<String> customerAddress = new ArrayList<String>(30);
	
	protected ArrayList<String> phone1 = new ArrayList<String>(30);
	
	
	
	// Association of newRestaurant class
	newRestaurant res = new newRestaurant();  
	
	

	

	// getters and setters
	public static boolean isC() {
		return c;
	}





	public static void setC(boolean c) {
		Customers.c = c;
	}





	public ArrayList<Integer> getNewID() {
		return newID;
	}





	
	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public newRestaurant getRes() {
		return res;
	}





	public void setRes(newRestaurant res) {
		this.res = res;
	}





	public ArrayList<String> getCustomername() {
		return customerName;
	}





	public void setCustomername(ArrayList<String> customername) {
		this.customerName = customername;
	}





	public ArrayList<String> getCustomerAddress() {
		return customerAddress;
	}





	public void setCustomerAddress(ArrayList<String> customerAddress) {
		this.customerAddress = customerAddress;
	}





	public ArrayList<String> getPhone1() {
		return phone1;
	}





	public void setPhone1(ArrayList<String> phone1) {
		this.phone1 = phone1;
	}





	public void setNewpassword(ArrayList<String> newPassword) {
		this.newPassword = newPassword;
	}





	public void setNewID(ArrayList<Integer> newID) {
		this.newID = newID;
	}


	
	public void setPassword(ArrayList<String> newPassword) {
		this.newPassword = newPassword;
	}
	

	
	public ArrayList<String> getNewpassword() {
		return newPassword;
	}


	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	
	public Scanner getIn() {
		return in;
	}





	public void setIn(Scanner in) {
		this.in = in;
	}





	public Scanner getSc() {
		return sc;
	}





	public void setSc(Scanner sc) {
		this.sc = sc;
	}





	public ArrayList<String> getNewPassword() {
		return newPassword;
	}





	public void setNewPassword(ArrayList<String> newPassword) {
		this.newPassword = newPassword;
	}





	public ArrayList<String> getCustomerName() {
		return customerName;
	}





	public void setCustomerName(ArrayList<String> customerName) {
		this.customerName = customerName;
	}


	// end of getter and setter

	
	// default constructor
	public Customers(newRestaurant res)
	{
		this.res=res;
	}

	// Parameterized constructor
	protected Customers(String name, int id, String address, String phone, String password, newRestaurant res)
	{
		this.address=address;
		this.name=name;;
		this.id=id;
		this.phone=phone;
		this.password=password;
		this.res=res;
		
	}
	
	
	
	
																			// Methods
	
	// Check Food Order
	public void checkFoodOrder() 
	{
		try
		{
			System.out.println("Following food orders placed: ");
			System.out.println();
			for(int i=0; i<res.cart.size();i++)
			{
				System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   By: "+customerName.get(i)+"  |   Address: "+customerAddress.get(i)+"  |  Phone: "+phone1.get(i));
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
	}
	
	
	
	
	// Cash on Delivery
	public boolean cashOnDelivery()
	{
		try
		{
			System.out.println("Do you want to pay cash on delivery");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = in.nextInt();
			if(choice==1)
			{
				System.out.println("Cash on Delivery selected...");
				return true;
			}
			else if(choice == 2)
			{ 
				System.out.println("Cash with Credit card selected");
				return false;
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
		return false;
	}
	
	
	
	// Check Out
	public boolean checkOut() throws IOException
	{
		try
		{
			int sum=0;
			int total=0;
			FileWriter f=new FileWriter(obj,false);
			FileWriter f1=new FileWriter(obj2,false);
			FileWriter f3=new FileWriter(obj3,false);
			for(int i=0;i<res.cart.size();i++)
			{
				System.out.println("Slot "+i+"  |  Name:  "+res.cart.get(i)+"  |  Price:  RS."+res.cartprice.get(i));
				
				String r=String.valueOf(res.cartprice.get(i));
				
				sum = sum + res.cartprice.get(i);
				total=sum;
				r=String.valueOf(total);
				f.write(res.cart.get(i)+" ");
				f1.write(r+"\n");
				
				
			}
			System.out.println("Your total bill is: Rs."+total);
			if(total==0)
			{
				
			}
			
			else if(total!=0)
			{
				System.out.println("Bill Number: "+res.getBillNumber());
				System.out.println("Order Number: "+res.getOrderNumber());
				f3.write(res.getBillNumber()+"  |  ");
				f3.write(res.getOrderNumber());
				System.out.println();
			}
			
			System.out.println("Do you want to checkout: ");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice=in.nextInt();
			
			if(choice==1)
			{
				System.out.println("Checked Out...");
				f1.close();
				f.close();
				f3.close();
				return true;
			}
			
			else 
			{
				System.out.println("Not Checked out...");
				return false;
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
		return false;
	}
	
	
	
	// Cancel Order
	public boolean cancelOrder()
	{
		try
		{
			System.out.println("You have placed order for the following items: ");
			for(int i=0; i<res.cart.size();i++)
			{
				System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |  ");
			}
			System.out.println();
			System.out.println("Do you want to cancel order?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = in.nextInt();
			if(choice==1)
			{
				System.out.println("Order Cancelled...");
				res.cart.clear();
				res.cartprice.clear();
				return false;
			}
			else 
			{
				System.out.println("Order not cancelled");
				return true;
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
		return false;
	}
	
	
	
	// Place Order
	public boolean placeOrder()
	{
		try
		{
			System.out.println("You have the following items in the cart: ");
			for(int i=0; i<res.cart.size();i++)
			{
				System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |  ");
			}
			System.out.println();
			System.out.println("Do you want to place order?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = in.nextInt();
			if(choice==1)
			{
				System.out.println("Order Placed...");
				newRestaurant.setQ(true);
				return newRestaurant.isQ();
			}
			else
			{
				System.out.println("Cancelled");
				return false;
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
		return false;
	}
	
	
	
	// Add to cart
	public void addToCart() throws FileNotFoundException 
	{
		try
		{
			int choice;
			System.out.println("Do you want to add items from previously stored food in our save files (through file handling): ");
			System.out.println("1. Load Food");
			System.out.println("2. Do not Load food");
			choice = in.nextInt();
			if(choice==1)
			{
				orderhistory();
			}
			
			else
			{	
				System.out.println("look at menu");
			
				for (int i = 0; i < res.menu.size();i++) 
			      { 		      
			          System.out.println("Slot "+i+"  |  Name:  "+res.menu.get(i)+"  |  Price:  Rs."+res.price1.get(i)+"  |  "); 		
			      }
				
				
					System.out.println("Adding items to cart...");
					do {
						int i=0;
						System.out.println("select item with respect to number");
						int item=in.nextInt();
						res.cart.add(res.menu.get(item));
						res.cartprice.add(res.price1.get(item));
						System.out.println("Items added "+res.cart.get(i)+" RS."+res.cartprice.get(i));
						System.out.println();
						System.out.println("Do you want to add more");
						System.out.println("1. Continue");
						System.out.println("2. Exit");
						choice=in.nextInt();
						while(choice< 1 || choice > 2)
						{
							System.out.println("Wrong input");
							System.out.println("Enter choice again: ");
							choice=sc.nextInt();
						}
					}while(choice != 2);
				
				System.out.println("Items added successfully to the cart");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Input MismatchException ");
		}
	}
	
	
	
	// View Food
	public void viewFood() throws FileNotFoundException 
	{
		try
		{
				System.out.println("food details");
				for (int i = 0; i < res.menu.size();i++) 
			      { 		      
			          System.out.println("Slot "+i+"  |  "  +res.menu.get(i)+  "  | Rs.  "+res.price1.get(i)+"  |  "); 		
			          
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
	}
	
	
	
	// Update cart
	public void updateCart() 
	{
		
		try
		{
			System.out.println("1. Add");
			System.out.println("2. Remove");
			System.out.println("3. Modify");
			for (int i = 0; i < res.menu.size();i++) 
		      { 		      
		          System.out.println(i+" " +res.menu.get(i)); 		
		          System.out.println(i+" "+res.price1.get(i));
		      }
			int up=in.nextInt();
			if(up==1) {
				System.out.println("enter item number");
				int item=in.nextInt();
				res.cart.add(res.menu.get(item));
				res.cartprice.add(res.price1.get(item));
			}
			else if(up==2) {
				System.out.println("enter item number");
				int item=in.nextInt();
				res.cart.remove(res.menu.get(item));
				res.cartprice.remove(res.price1.get(item));
			}
			else if(up==3) {
				System.out.println("enter item you want to update");
				int item=in.nextInt();
				System.out.println("enter item to add");
				int update=in.nextInt();
				res.cart.set(item, res.menu.get(update));
				res.cartprice.set(item, res.price1.get(update));
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
	}
	
	
	
	// Check Food delivery Status
	public void checkFoodDeliveryStatus() 
	{
		
		System.out.println("your order status is "+newRestaurant.getStatus());
		if(newRestaurant.isP()==true && newRestaurant.isX() == true)
		{
			feedback();
			newRestaurant.setP(false);
		}
		
	}
	
	
	// Give FeedBack
	public void feedback() 
	{
		System.out.println("GIVE The restaurant rating from 1-5");
		newRestaurant.setA(in.nextInt());
		
			if(newRestaurant.getA()==0)
			{
				System.out.println(newRestaurant.getA()+" star");
				System.out.println("No Feedback!!!!");
			}
			
			else if(newRestaurant.getA()==1)
			{
				System.out.println(newRestaurant.getA()+" stars");
				System.out.println("Food quality is so bad, ugh");
			}
			
			else if(newRestaurant.getA()==2)
			{
				System.out.println(newRestaurant.getA()+" stars");
				System.out.println("You need to add varity of food please");
			}
			
			else if(newRestaurant.getA()==3)
			{
				System.out.println(newRestaurant.getA()+" stars");
				System.out.println("It was neither good nor bad. Just normal to be honest");
			}
			
			else if(newRestaurant.getA()==4)
			{
				System.out.println(newRestaurant.getA()+" stars");
				System.out.println("I really liked the taste of your food");
			}
			
			else if(newRestaurant.getA()==5)
			{
				System.out.println(newRestaurant.getA()+" stars");
				System.out.println("Wow, best restaruant in the history of my life. Very good chefs");
			}
			else 
			{
				System.out.println("wrong input");
			}
	}
	
	
	public void orderhistory() throws FileNotFoundException 
	{
		try
		{
			System.out.println("your order history is ");
			Scanner Read=new Scanner(obj);   // Cart Item name
			Scanner read1=new Scanner(obj2);  // Cart Item Price
			Scanner read2=new Scanner(obj3);  // Bill
			
			if(obj.exists()==true)
			{
				if(obj.canRead()==true)
				{
					while(Read.hasNext()) {
						String data=Read.nextLine();
						res.cart.add(data);
						System.out.println("items: "+data);
						
					}
				}
				else
					System.out.println("File Unreadable");
			}
			else
			{
				System.out.println(obj+" file does not exist...");
			}
			//_______________________________________________________
			
			if(obj2.exists()==true)
			{
				if(obj2.canRead()==true)
				{		
					while(read1.hasNextBigInteger()) {
				    int data1 = read1.nextInt();
					res.cartprice.add(data1);
					System.out.println("price: "+data1);
					
					System.out.println("adding items from orderhistory");
					}
				}
				else
					System.out.println("File Unreadable");
			}
			else if(obj2.exists()==false)
			{
				System.out.println(obj2+" file does not exist...");
			}
			
			//_________________________________________________________
			
			if(obj3.exists()==true)
			{
				if(obj3.canRead())
				{
					while(read2.hasNext()) {
						int data2=read2.nextInt();
						System.out.println("Order number : "+data2);
					}
				}
				
				else
					System.out.println("File Unreadable");
			}
			
			else if(obj3.exists()==false)
			{
				System.out.println(obj3+" file does not exist");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("We could not find your file...");
		}
		catch(IndexOutOfBoundsException e) 
		{
			System.out.println("IndexOutOfBoundsException");
		}
		catch(InputMismatchException e)
		{
			System.out.println("");
		}
		
	}
	
								// Functions Defined here for Customers are as Follows
	
												    // Customer Options
											/*public  abstract void viewFood();
											public abstract void addToCart();
											public abstract boolean placeOrder();
											public abstract boolean cancelOrder();
											public abstract void updateCart();
											public abstract boolean checkOut();
											public abstract boolean cashOnDelivery();
											public abstract void foodDeliveryStatus();
											public abstract void checkFoodDeliveryStatus();
											public abstract void feedback();
											*/
}
