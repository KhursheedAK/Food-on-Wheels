package BusinessLogic;
/*
 * By: 													OOP Final Semester Project: Food On Wheels
 * Khursheed Alam Khan --> 20i-0496
 * Muhammad Abdullah   --> 20i-2311
 * 
 * Section: SE-Q
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.sun.tools.javac.Main;

public class Admin 
{
	 Scanner sc=new Scanner(System.in);
	 Scanner in = new Scanner(System.in);
	 File f2=new File("restaurantname.txt");
	 File f=new File("accountid.txt");
	 File f1=new File("accountpassword.txt");
	 newRestaurant res = new newRestaurant();	// Association of newRestaurnat class
	 Customers cus=new Customers(res);			// Association of customer class
	 Rider rider = new Rider(res, cus);			// Association of rider class
	 
	 
	 
	 protected ArrayList<String> name = new ArrayList<String>(30);
	 protected ArrayList<Integer> ID = new ArrayList<Integer>(30);
	 protected ArrayList<String> password = new ArrayList<String>(30);
	 
	 
	 // default constructor
	 Admin()
	{
		
	}
	 
	// Parameterized constructor
	public Admin(Customers cus, Rider rider, newRestaurant res)
	{
		this.cus=cus;
		this.rider=rider;
		this.res=res;
	}
	
	
	// getters and setters
	
	public ArrayList<String> getName() 
	{
		return name;
	}

	public void setName(ArrayList<String> name) 
	{
		this.name = name;
	}

	public ArrayList<Integer> getID() 
	{
		return ID;
	}

	public void setID(ArrayList<Integer> iD) 
	{
		ID = iD;
	}

	public ArrayList<String> getPassword()
	{
		return password;
	}

	public void setPassword(ArrayList<String> password) 
	{
		this.password = password;
	}
	
	// end of getter and setter
	

	
																// Methods
	
	// Manage riders
	public void manageRiders() 
	{
		try
		{
			// Used Iterator before for loop, but we preferred For Loop at the end
			
			/*Iterator<Integer> i = rider.newID.iterator();
			Iterator<String> i1 = rider.ridername.iterator();
			Iterator<String> i2 = rider.rideraddress.iterator();
			Iterator<String> i3 = rider.newpassword.iterator();
			
			while(i.hasNext() && i1.hasNext() && i2.hasNext() && i3.hasNext())
			{
				System.out.println("ID: "+ i.next());
				System.out.println("Name: "+i1.next());
				System.out.println("Address: "+i2.next());
				i3.next();
				System.out.println();
				System.out.println("Do you want to remove");
				System.out.println("1. Yes");
				System.out.println("2. NO");
				int n = in.nextInt();
				if(n==1)
				{	
					i.remove();
					i1.remove();
					i2.remove();
					i3.remove();
					System.out.println("The Rider has been removed");
				}
				else
					System.out.println("Nothing Removed...");
			}
			*/
				
				System.out.println("Diplaying all riders");
				for(int i=0;i<rider.rideraddress.size();i++) 
				{
					System.out.println("slot ="+i);
					System.out.println("riders address="+rider.rideraddress.get(i));
					System.out.println("riders name ="+rider.ridername.get(i));
					System.out.println("riders id="+rider.newID.get(i));
					System.out.println();
				}
				
				System.out.println("Do you want to remove: ");
				System.out.println("1. Yes");
				System.out.println("2. NO");
				int n = in.nextInt();
				if(n==1)
				{	
					System.out.println("select slot to be removed");
					int r=in.nextInt();
					rider.rideraddress.remove(r);
					rider.ridername.remove(r);
					rider.newpassword.remove(r);
					rider.newID.remove(r);
					System.out.println("The Rider has been removed");
				}
				else
					System.out.println("Nothing Removed...");
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
	

	// Manage customers
	public void manageCustomers() 
	{
		try
		{
				if(Rider.isK()==true)
				{	
					System.out.println("Diplaying all customers");
					for(int i=0;i<cus.customerAddress.size() || i< cus.customerName.size() || i<cus.newID.size() || i<cus.phone1.size();i++) 
					{
						System.out.println("slot ="+i);
						System.out.println("customers address="+this.cus.customerAddress.get(i));
						System.out.println("customers name ="+this.cus.customerName.get(i));
						System.out.println("customers id="+this.cus.newID.get(i));
						System.out.println("customers phone="+this.cus.phone1.get(i));
						System.out.println();
					}
					
					System.out.println("Do you want to remove: ");
					System.out.println("1. Yes");
					System.out.println("2. NO");
					int n = in.nextInt();
					
					if(n==1)
					{	
						System.out.println("select slot to be removed");
						int r=in.nextInt();
						cus.customerAddress.remove(r);
						cus.customerName.remove(r);
						cus.newID.remove(r);
						cus.phone1.remove(r);
						System.out.println("The Customer has been removed");
					}
					else
						System.out.println("Nothing Removed...");
				}
				
				else if(Rider.isK()==false)
				{
					System.out.println("The following customer(s) did not pay for the food: ");
					for(int i=0;i<cus.customerAddress.size();i++) 
					{
						System.out.println("slot ="+i);
						System.out.println("customers address="+this.cus.customerAddress.get(i));
						System.out.println("customers name ="+this.cus.customerName.get(i));
						System.out.println("customers id="+this.cus.newID.get(i));
						System.out.println("customers phone="+this.cus.phone1.get(i));
						System.out.println();
					}
					
					System.out.println("Do you want to remove: ");
					System.out.println("1. Yes");
					System.out.println("2. NO");
					int n = in.nextInt();
					
					if(n==1)
					{	
						System.out.println("select slot to be removed");
						int r=in.nextInt();
						cus.customerAddress.remove(r);
						cus.customerName.remove(r);
						cus.newID.remove(r);
						cus.phone1.remove(r);
						System.out.println("The Customer has been removed");
					}
					else
						System.out.println("Nothing Removed...");
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
	
	
	// manage Restaurant
	public void manageRestaurants() 
	{
		try
		{
					
					System.out.println("Displaying all Restaurants");
					for(int i=0;i<res.getNewpassword().size();i++)
					{
						System.out.println("slot = "+i);
						System.out.println("Restaurant name = "+res.restaurantname.get(i));
						System.out.println("Restaurant ID = "+res.newID.get(i));
						System.out.println();
						
					}
					
					System.out.println("Do you want to remove: ");
					System.out.println("1. Yes");
					System.out.println("2. NO");
					int n = in.nextInt();
					
					if(n==1)
					{
						System.out.println("Select slot to be removed");
						int r = in.nextInt();
						res.restaurantname.remove(r);
						res.newID.remove(r);
						System.out.println("The restaurant has been removed");
					}
					else
						System.out.println("Nothing Removed...");
						
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
	
	
	// update food
	public void updateFood()
	{
		try
		{
			System.out.println("select item you want to update by using coressponding number");
			if(res.menu==null) 
			{
				System.out.println("no items present");
			}
			else 
			{
					for (int i = 0; i < res.menu.size();i++) 
				      { 		      
				          System.out.println(i+" " +res.menu.get(i)); 		
				      } 
					System.out.println("enter number");
					
					int update=in.nextInt();
					System.out.println("enter name of item");
					String newname=sc.next();
					System.out.println("enter price");
					int newprice=in.nextInt();
					res.menu.set(update, newname);
					res.price1.set(update, newprice);
					System.out.println("item updated");
					for (int i = 0; i < res.menu.size();i++) 
				      { 		      
				          System.out.println(i+" " +res.menu.get(i)); 		
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
	
	
	// delete food
	public void deleteFood() 
	{
		try
		{
			System.out.println("select item you want to delete by using coressponding number");
			if(res.menu==null) {
				System.out.println("no items present");
			}
			else {
					for (int i = 0; i < res.menu.size();i++) 
				      { 		      
				          System.out.println(i+" " +res.menu.get(i)); 		
				      } 
					System.out.println("enter number");
					int delete=in.nextInt();
					res.menu.remove(delete);
					res.price1.remove(delete);
					System.out.println("item removed");
					for (int i = 0; i < res.menu.size();i++) 
				      { 		      
				          System.out.println(i+" " +res.menu.get(i)); 		
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
	
	
	
	// Manage food order details
		public void manageFoodOrder()
		{
			try
			{
				System.out.println("The following order has been placed by the customer: ");
				for(int i=0; i<res.cart.size();i++)
				{
					System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |  Bill number: "+res.getBillNumber()+"  |  Order number: "+res.getOrderNumber()+"  |  Customer name: "+cus.customerName.get(i)+"  |  Customer address: "+cus.customerAddress+"  |  Customer phone: "+cus.phone1.get(i));
				}
				System.out.println();
				System.out.println("Do you want to cancel his order?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int choice = in.nextInt();
				if(choice==1)
				{
					System.out.println("Order Cancelled...");
					res.cart.clear();
					res.cartprice.clear();
					res.setBillNumber(res.billNumber+res.num++);
					res.setOrderNumber(res.orderNumber+res.num++);
					
				}
				else 
				{
					System.out.println("Order not cancelled");
					
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
		
		// Manage payment details
		public void managePaymentDetails()
		{
			try
			{
				System.out.println("1. View Customer who chose Cash on Delivery");
				System.out.println("2. View Customer who chose Credit card to pay");
				System.out.println("Choose your option: ");
				int choice = in.nextInt();
				if(choice==1)
				{
					if(Customers.isC()==true)
					{
						System.out.println("Following customer agreed to pay cash on delivery: ");
						for(int i=0; i<res.cart.size();i++)
						{
							System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   Bill Number: "+res.getBillNumber()+"  |  Order Number: "+res.getOrderNumber()+"  |  Customer Name: "+cus.customerName.get(0)+"  |   Address: "+cus.customerAddress.get(0)+"  |  Phone: "+cus.phone1.get(0));
						}
					}
					else if(Customers.isC()==false)
					{
						System.out.println("No customer chose to pay cash on delivery...");
					}

				}
				
				else if(choice == 2)
				{
					if(Customers.isC()==false)
					{
						System.out.println("Following customer paid using credit card: ");
						for(int i=0; i<res.cart.size();i++)
						{
							System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   Bill Number: "+res.getBillNumber()+"  |  Order Number: "+res.getOrderNumber()+"  |  Customer Name: "+cus.customerName.get(0)+"  |   Address: "+cus.customerAddress.get(0)+"  |  Phone: "+cus.phone1.get(0));
						}
					}
					else if(Customers.isC()==true)
					{
						System.out.println("No customer chose to pay using credit card...");
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
		}
	
		
		
		
				// Manage food order details for customers greater than 1
				public void manageFoodOrder2()
				{
					try
					{
						System.out.println("The following order has been placed by the customer: ");
						for(int i=0; i<res.cart.size();i++)
						{
							System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |  Bill number: "+res.getBillNumber()+"  |  Order number: "+res.getOrderNumber()+"  |  Customer name: "+cus.customerName.get(i)+"  |  Customer address: "+cus.customerAddress+"  |  Customer phone: "+cus.phone1.get(i));
						}
						System.out.println();
						System.out.println("Do you want to cancel his order?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						int choice = in.nextInt();
						if(choice==1)
						{
							System.out.println("Order Cancelled...");
							res.cart.clear();
							res.cartprice.clear();
							res.setBillNumber(res.billNumber+res.num++);
							res.setOrderNumber(res.orderNumber+res.num++);
							
						}
						else 
						{
							System.out.println("Order not cancelled");
							
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
				
				// Manage payment details for customers greater than 1
				public void managePaymentDetails2()
				{
					try
					{
						System.out.println("1. View Customer who chose Cash on Delivery");
						System.out.println("2. View Customer who chose Credit card to pay");
						System.out.println("Choose your option: ");
						int choice = in.nextInt();
						if(choice==1)
						{
							if(Customers.isC()==true)
							{
								System.out.println("Following customer agreed to pay cash on delivery: ");
								for(int i=0; i<res.cart.size();i++)
								{
									System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   Bill Number: "+res.getBillNumber()+"  |  Order Number: "+res.getOrderNumber()+"  |  Customer Name: "+cus.customerName.get(i)+"  |   Address: "+cus.customerAddress.get(i)+"  |  Phone: "+cus.phone1.get(i));
								}
							}
							else if(Customers.isC()==false)
							{
								System.out.println("No customer chose to pay cash on delivery...");
							}

						}
						
						else if(choice == 2)
						{
							if(Customers.isC()==false)
							{
								System.out.println("Following customer paid using credit card: ");
								for(int i=0; i<res.cart.size();i++)
								{
									System.out.println("Slot "+i+"  |  Name: "+res.cart.get(i)+"  |  RS."+res.cartprice.get(i)+"  |   Bill Number: "+res.getBillNumber()+"  |  Order Number: "+res.getOrderNumber()+"  |  Customer Name: "+cus.customerName.get(i)+"  |   Address: "+cus.customerAddress.get(i)+"  |  Phone: "+cus.phone1.get(i));
								}
							}
							else if(Customers.isC()==true)
							{
								System.out.println("No customer chose to pay using credit card...");
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
				}
		
				
				// Approval Function
				public void approval() throws IOException 
				{
					try
					{
						System.out.println("accounts to be approved");
						Scanner read=new Scanner(f);
						Scanner read1=new Scanner(f1);
						Scanner read2=new Scanner(f2);
						
						int data=read.nextInt();
						String data1=read1.nextLine();
						String data2=read2.nextLine();
					  
							
						System.out.println("Do you approve the following accounts: ");
						System.out.println();
						System.out.println("Restaurant name: "+data2);
						System.out.println("ID: "+data);
						System.out.println("password: "+data1);
						System.out.println();
						
						System.out.println("1. Apporve the accounts");
						System.out.println("2. Disapprove the accounts");
						int i=sc.nextInt();
						System.out.println();
						if(i==1) 
						{
							res.newpassword.add(data1);
							res.newID.add(data);
							res.restaurantname.add(data2);
							
							System.out.println("Accounts approved");
							read.close();
							read1.close();
							read2.close();
						
						}
						else 
						{
							System.out.println("Account Disapproved...");
							f.delete();
							f1.delete();
							f2.delete();
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
					catch(NoSuchElementException e)
					{
						System.out.println("Account is empty !!!");
					}
				}
		
}
