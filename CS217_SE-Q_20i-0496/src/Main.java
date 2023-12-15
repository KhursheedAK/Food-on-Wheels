/*
 * By: 													OOP Final Semester Project: Food On Wheels
 * Khursheed Alam Khan --> 20i-0496
 * Muhammad Abdullah   --> 20i-2311
 * 
 * Section: SE-Q
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import BusinessLogic.Admin;
import BusinessLogic.Customers;
import BusinessLogic.Restaurant;
import BusinessLogic.Rider;
import BusinessLogic.newRestaurant;
import PresentationLayer.GraphicUI;
import PresentationLayer.InterFace;
public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		// interface object to show our LOGO for company
		InterFace gui = new InterFace();
		
		// interface to show simple UI
		GraphicUI ui = new GraphicUI();
		
		// restaurant object
		newRestaurant res1=new newRestaurant();
		
		// customer object
		Customers c=new Customers(res1);
		
		// rider object
		Rider r=new Rider(res1, c);
		
		// admin object
		Admin admin = new Admin(c, r, res1);
		
		Scanner keyboard = new Scanner(System.in);
	
		ArrayList<Restaurant> rest= new ArrayList<Restaurant>();
		
		// File Create
		File f=new File("accountid.txt");           // Restaurant ID
		File f1=new File("accountpassword.txt");   // Restaurant password
		File f2=new File("restaurantname.txt");   // Restaurant name
		
		// File Write
		FileWriter fw=new FileWriter(f,false);     // write ID	
		FileWriter fw1=new FileWriter(f1,false);   // write password	 
		FileWriter fw2=new FileWriter(f2,false);  // write name
		
		int choice;
		
		boolean q=false;   // boolean for place order. (place order YES q = true, place order NO q = false)
		boolean p=true;   // boolean for cancel order. (cancel order YES p = false, cancel order NO p = true)
		boolean x=true;  // boolean for checkout. (check out YES x = true, check out NO x = false)
		
		gui.myGUI();
		
		ui.main(args);
		
		
		
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("|            Welcome to Two Brother's Food on Wheels Restaurant         |");
		System.out.println("|                                                                       |");
		System.out.println("|                            Made By:                                   |");
		System.out.println("|                                                                       |");
		System.out.println("|                  . Khursheed Alam Khan 20i-0496                       |");
		System.out.println("|                  . Muhammad Abdullah   20i-2311                       |");
		System.out.println("|                                                                       |");
		System.out.println("|                                                                       |");
		System.out.println("|      *Note: Files are stored in the same directory of JAVA code       |");
		System.out.println("|                                                                       |");
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println("");
		
		
		try
		{
				do
				{
					
					choice=generalMenu(keyboard);
					
					if(choice==1) // Restaurant Menu
					{   
		
						
						do
						{
						
							choice = restaurantMenu(keyboard);
							
								if(choice == 1) // create account
								{
									
									// create function
									
									
									
									keyboard.nextLine();
								
									System.out.println("Enter restaurant name: " );
									String name = keyboard.nextLine();
									
									
									System.out.println("Enter your id" );
									int id = keyboard.nextInt();
									keyboard.nextLine();
									for(int i=0; i<res1.getNewID().size();i++)
									{
										if(res1.getNewID().get(i)==id)
										{
											while(res1.getNewID().get(i)==id)
											{
												System.out.println("ID already used !!!");
												System.out.println();
												System.out.println("Please pick a new ID:");
												id = keyboard.nextInt();
												keyboard.nextLine();
											}
										}
									}
									System.out.println("Enter Password: ");
									String password = keyboard.nextLine();
									
			
									newRestaurant res2=new newRestaurant(name,id,password);
									
									res1.getRestaurantname().add(name);
									res1.getNewID().add(id);
									
									rest.add(res2);
									String idw=String.valueOf(id);
									
									
									//
									f=new File("accountid.txt");
									f1=new File("accountpassword.txt");
									f2=new File("restaurantname.txt");
									fw=new FileWriter(f,false);	
									fw1=new FileWriter(f1,false);	
									fw2=new FileWriter(f2,false);
									//
									fw.write(idw);
									fw1.write(password);
									fw2.write(name);
									fw.close();
									fw1.close();
									fw2.close();
									//
									
									
									System.out.println("Restaurant Account sent to admin for approval... ");
									
									
										
								}
								
								else if(choice == 2) // login
								{
												
													// login function
									
									int option;
									
									System.out.println("Enter ID: ");
									int id = keyboard.nextInt();
									
									
								try {	
							
									if(res1.getNewID().contains(id)==true)
									{
										keyboard.nextLine();
										System.out.println("Enter password: ");
										String pass = keyboard.nextLine();
										if(res1.getNewpassword().contains(pass)==true) 
										{
											System.out.println("Restaurant Account found");
											
											do
											{	
												option=restaurantMenu2(keyboard);
												
												if(option == 1)
												{
													// Add Food
													res1.addFood();
												}
												
												else if(option == 2)
												{
													// Delete Food
													res1.updateFood();
												}
												
												else if(option == 3)
												{
													// Check Food Order
													res1.checkFoodOrder();
												}
												
												else if(option == 4)
												{
													// Update Food Delivery Status
													res1.foodDeliveryStatus();
												}
												
												else if(option == 5)
												{
													
													// Check Bill
													if (q==true && p==true && x==true)
													res1.Bill();
													
													else 
														System.out.println("No order placed...");
												}
												
												else if(option == 6)
												{
													// Feedback
													res1.feedback();
												}
												
												else if(option == 7)
												{
													// view menu food
													res1.viewMenuFood();
												}
												else if(option == 8)
												{
													// Return
												}
											}while(option != 8);
										}
										else if (res1.getNewpassword().contains(pass)==false) 
										{
											System.out.println("Password is incorrect !!!");
										}
								
									}
									
									else if(res1.getNewID().contains(id)==false)
									{
										System.out.println("No Account found with ID "+id);
									}
								}catch(IndexOutOfBoundsException e) 
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
								
						
								
									//when login successful
								
									
								}
								
								else if(choice == 3) // return
								{
									
								}
								
							}while(choice!=3);
						} // end of restaurant menu
							//______________________________________________________
							
					
					
					else if(choice == 2) // Customer Menu
					{
						do
						{
						
								choice = customerMenu(keyboard);
							
								if(choice == 1) // create account
								{
									
											// create account function
											keyboard.nextLine();
											System.out.println("enter name");
											String name=keyboard.nextLine();
											System.out.println("enter address");
											String address=keyboard.nextLine();
											
											System.out.println("Enter phone: ");
											String phone=keyboard.nextLine();
											
											System.out.println("enter id");
											int id=keyboard.nextInt();
											
											for(int i=0; i<c.getNewID().size();i++)
											{
												if(c.getNewID().get(i)==id)
												{
													while(c.getNewID().get(i)==id)
													{
														System.out.println("ID already used !!!");
														System.out.println();
														System.out.println("Please pick a new ID:");
														id = keyboard.nextInt();
														keyboard.nextLine();
													}
												}
											}
											
											
											System.out.println("enter password");
											String pass=keyboard.next();
										
											c.getNewID().add(id);
											c.getNewPassword().add(pass);
											c.getCustomerAddress().add(address);
											c.getCustomerName().add(name);
											c.getPhone1().add(phone);
									
											System.out.println("");
											System.out.println("Customer Account created");
								}
								
								else if(choice == 2) // login
								{
									boolean d= true;
									System.out.println("logging in");
									System.out.println("Enter your ID: ");
									int id = keyboard.nextInt();
									int option;
									try 
									{	
										if(c.getNewID().contains(id)==true)
										{
											keyboard.nextLine();
											System.out.println("enter password");
											String pass=keyboard.next();
											if(c.getNewPassword().contains(pass)==true) 
											{
												System.out.println("Customer Account found");
												System.out.println("");
												System.out.println("Select the restaurant by typing its ID: ");
												for(int i=0;i<rest.size();i++)
												{
													
													
													if(res1.getNewpassword().contains(pass))
													{
														System.out.println("Restaurant ID: "+res1.getNewID().get(i)+"  |   Restaurant Name: "+res1.getRestaurantname().get(i));
														d = false;
													}
													
													else
													{
														System.out.println("No restaurant exists !!!");
														d = true;
													}
												}
												
												if(d==false)
												{	
													option = keyboard.nextInt();
													if(res1.getNewID().contains(option))
													{	
														System.out.println("Restaurant with the ID "+option+" is selected");
														System.out.println();
														do
														{
															
																option=customerMenu2(keyboard);
																
																
																if(option == 1)
																{
																	// View Food
																	c.viewFood();
																}
																
																else if(option == 2)
																{
																	// Add to Cart
																	c.addToCart();
																}
																
																else if(option == 3)
																{
																	// Place Order
																	 q = c.placeOrder();
																	
																}
																
																else if(option == 4)
																{
																	// Cancel Order
																	if(q==true && p==true)
																		p=c.cancelOrder();
																	else
																		System.out.println("No order placed...");
																}
																
																else if(option == 5)
																{
																	// Update Cart
																	c.updateCart();
																}
																
																else if(option == 6)
																{
																	// Check Out
																	x=c.checkOut();
																}
																
																else if(option == 7)
																{
																	c.cashOnDelivery();
																}
																
																else if(option == 8)
																{
																	// Check Food Delivery Status
																	if(q==true)
																	{
																		c.checkFoodDeliveryStatus();
																	}
																	else
																		System.out.println("No order placed");
																}
																else if(option==9)
																{
																	c.orderhistory();	
																}
																
																else if(option == 10)
																{
																	// Return
																}
														}while(option!=10);
													}
													
													else
													{
														System.out.println("Wrong Input");
													}
												}
												
												else
												{
													System.out.println();
													System.out.println("No Restaurants Present !!!");
													System.out.println("Returning back to menu");
													System.out.println();
												}
											}
											else if (c.getNewPassword().contains(pass)==false) 
											{
												System.out.println("Password is incorrect !!!");
											}
									
										}
										
										else if(c.getNewID().contains(id)==false)
										{
											System.out.println("No Account found with ID "+id);
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
								
								else if(choice == 3 )
								{
									
								}
						}while(choice!=3);
					
					} //end of customer function
					
					
					//_____________________________________________________
					
					
					else if( choice == 3) // Rider menu
					{
						
						do
						{
							choice = riderMenu(keyboard);
						
								if(choice == 1)
								{
									
									
										// create account function
										
											System.out.println("enter name");
											String name=keyboard.next();
											keyboard.nextLine();
											System.out.println("enter address");
											String address=keyboard.nextLine();
											System.out.println("enter phone");
											String phone = keyboard.next();
											System.out.println("enter id");
											int id=keyboard.nextInt();
											
											for(int i=0; i<r.getNewID().size();i++)
											{
												if(r.getNewID().get(i)==id)
												{
													while(r.getNewID().get(i)==id)
													{
														System.out.println("ID already used !!!");
														System.out.println();
														System.out.println("Please pick a new ID:");
														id = keyboard.nextInt();
														keyboard.nextLine();
													}
												}
											}
											
											System.out.println("enter password");
											String pass=keyboard.next();
											r.getRideraddress().add(address);
											r.getRidername().add(name);
											r.getNewpassword().add(pass);
											r.getNewID().add(id);
											System.out.println("Rider Account created");
									
									
									
								}
								
								else if(choice == 2) // login
								{
									System.out.println("logging in");
									System.out.println("Enter your ID: ");
									int id = keyboard.nextInt();
									int option;
									try 
									{	
										if(r.getNewID().contains(id)==true)
										{
											keyboard.nextLine();
											System.out.println("enter password");
											String pass=keyboard.nextLine();
											if(r.getNewpassword().contains(pass)==true) 
											{
												System.out.println("Rider Account found");
												
												do
												{	
												
													option=riderMenu2(keyboard);
													
													if(option == 1)
													{
														// View Order
														if(c.getCustomerAddress().size()<=1)
														{
															r.viewFoodOrder();
														}
														
														else if(c.getCustomerAddress().size()>1)
														{
															r.viewFoodOrder2();
														}
														
													}
													
													else if(option == 2)
													{
														// Accept or Reject Delivery Order
														if(c.getCustomerAddress().size()<=1)
														{
															r.orderAccept();
														}
														
														else if(c.getCustomerAddress().size()>1 && c.getCustomerAddress().size()<=2)
														{
															r.orderAccept2();
														}
														
													}
													
													else if(option == 3)
													{
														// Update Food Delivery Status
														r.statusRider();
														
													}
													
													else if(option == 4)
													{
														// Cash Collection Update
														r.cashCollectionUpdate();
														
													}
													
													else if(option == 5)
													{
														// Return
													}
												
												}while(option!=5);
											}
											else if (r.getNewpassword().contains(pass)==false) 
											{
												System.out.println("Password is incorrect !!!");
											}
									
										}
										
										else if(r.getNewID().contains(id)==false)
										{
											System.out.println("No Account found with ID "+id);
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
								
								else if(choice == 3 )
								{
									
								}
					
						}while(choice!=3);
					
					} // end of rider function
					
					
					//_________________________________________________________
					
					else if( choice == 4 )     // Administrator Function
					{
						int option;
						
						do
						{
								option = adminMenu(keyboard);
							
								if(option == 1)
								{
									// create account function
									
									System.out.println("enter ID");
									int id=keyboard.nextInt();
									
									for(int i=0; i<admin.getID().size();i++)
									{
										if(admin.getID().get(i)==id)
										{
											while(admin.getID().get(i)==id)
											{
												System.out.println("ID already used !!!");
												System.out.println();
												System.out.println("Please pick a new ID:");
												id = keyboard.nextInt();
											
											}
										}
									}
									
									System.out.println("enter admin Name ");
									String name=keyboard.nextLine();
									keyboard.nextLine();
									System.out.println("enter Password");
									String password = keyboard.next();
	
									admin.getID().add(id);
									admin.getName().add(name);
									admin.getPassword().add(password);
									System.out.println("Admin Account created");
							
									
								}
							
								else if(option == 2) // login
								{
									System.out.println("logging in");
									System.out.println("Enter your ID: ");
									int id = keyboard.nextInt();

									try 
									{	
										if(admin.getID().contains(id)==true)
										{
											keyboard.nextLine();
											System.out.println("enter password");
											String pass=keyboard.nextLine();
											if(admin.getPassword().contains(pass)==true) 
											{
												System.out.println("Admin Account found");
												
												do
												{	
												
													option=adminMenu2(keyboard);
													
													if(option == 1)
													{
														// Manage Vendors
														admin.manageRestaurants();
													}

													else if(option == 2)
													{
														// Manage Vendors Products/Food
														System.out.println("1. Update Food");
														System.out.println("2. Delete Food");
														System.out.println("Choose your option: ");
														option = keyboard.nextInt();
														if(option == 1)
														{
															admin.updateFood();
														}
														else if(option == 2)
														{
															admin.deleteFood();
														}
														else
														{
															System.out.println("Wrong Input");
														}
													}

													else if(option == 3)
													{
														// Manage Customers
														admin.manageCustomers();
													}

													else if(option == 4)
													{
														// Manage Food Order Details
														if(c.getCustomerAddress().size()<=1)
														{
															admin.manageFoodOrder();
														}
														
														else if(c.getCustomerAddress().size()>1)
														{
															admin.manageFoodOrder2();
														}
													}

													else if(option == 5)
													{
														// Manage Payment Details
														if(c.getCustomerAddress().size()<=1)
														{
															admin.managePaymentDetails();
														}
														
														else if(c.getCustomerAddress().size()>1)
														{
															admin.managePaymentDetails2();
														}
															
													}

													else if(option == 6)
													{
														// Manage Riders
														admin.manageRiders();
													}

													else if(option == 7)
													{
														// Approve Account
														admin.approval();
													}

													
													else if(option == 8)
													{
														//return
													}

												
												}while(option!=8);
											}
											else if (admin.getPassword().contains(pass)==false) 
											{
												System.out.println("Password is incorrect !!!");
											}
									
										}
										
										else if(admin.getID().contains(id)==false)
										{
											System.out.println("No Account found with ID "+id);
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
								
								else if(option == 3)
								{
									//return
								}
								
					
						}while(option!=3);
					
					} // end of Administrator function
					
					//_________________________________________________________
					
					else if(choice == 5)
					{
						break; // Exit Program
					}
					
					
					
				}while(choice!=5);
				
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
	
		System.out.println();
		
		System.out.println("Thanks for using our Food on Wheels Project...");
		System.out.println("We hope to see you again. Take care. Bye!");
	}
	
	
	
	/*________________________________________________________________________________________________________________________________
	
									// General Functions
	
	__________________________________________________________________________________________________________________________________*/
	
	
	
	
	
	
	/*____________________________________________________________________________________
	 * 
	 *  Function for menu
	 *___________________________________________________________________________________
	 */
	
	
	

		//1 General menu
		public static int generalMenu(Scanner keyboard)
		{
			System.out.println("");
			System.out.println("	----Welcome to General menu----");
			System.out.println("	1.  Enter Restaurant Menu");
			System.out.println("	2.  Enter Customer Menu");
			System.out.println("	3.  Enter Rider Menu");
			System.out.println("	4.  Enter Admin Menu");
			System.out.println("	5.  Quit");
			System.out.println("");
			
			int choice;
			System.out.println("");
			
			do 
			{
				System.out.println("	Enter choice: ");
				choice = keyboard.nextInt();
				
			}while(choice < 1 || choice > 5);
		
			return choice;
		}
	
	//2 Admin menu
	public static int adminMenu2(Scanner keyboard)
	{
		System.out.println("");
		System.out.println("	----Admin menu----");
		System.out.println("	1.  Manage Vendors");
		System.out.println("	2.  Manage Vendors Products/Food");
		System.out.println("	3.  Manage Customers");
		System.out.println("	4.  Manage Food Order Details");
		System.out.println("	5.  Manage Payment Details");
		System.out.println("	6.  Manage Riders");
		System.out.println("	7.  Approval Function");
		System.out.println("	8.  Return");
		System.out.println("");
		
		int choice;
		System.out.println("");
		
		do 
		{
			System.out.println("	Enter choice: ");
			choice = keyboard.nextInt();
			
		}while(choice < 1 || choice > 8);
	
		return choice;
	}
	
	//3 Customer menu
		public static int customerMenu(Scanner keyboard)
		{
			System.out.println("");
			System.out.println("	----Customer menu----");
			System.out.println("	1.  Register/Create account");
			System.out.println("	2.  Login");
			System.out.println("	3.  return");
			System.out.println("");
			
			int choice;
			System.out.println("");
			
			do 
			{
				System.out.println("	Enter choice: ");
				choice = keyboard.nextInt();
				
			}while(choice < 1 || choice > 3);
		
			return choice;
		}
		
		//4 Customer menu 2
				public static int customerMenu2(Scanner keyboard)
				{
					System.out.println("");
					System.out.println("	1.  View Food Details");
					System.out.println("	2.  Add to Cart");
					System.out.println("	3.  Place Order");
					System.out.println("	4.  Cancel Order");
					System.out.println("	5.  Update Cart");
					System.out.println("	6.  Checkout");
					System.out.println("	7.  Pay Cash on Delivery");
					System.out.println("	8.  Check Food Delivery Status");
					System.out.println("	9.  Load items into the cart from the Order History stored in our files");
					System.out.println("	10.  return");
					System.out.println("");
					
					int choice;
					System.out.println("");
					
					do 
					{
						System.out.println("	Enter choice: ");
						choice = keyboard.nextInt();
						
					}while(choice < 1 || choice > 10);
				
					return choice;
				}
		
		
		//5 Rider menu
				public static int riderMenu(Scanner keyboard)
				{
					System.out.println("");
					System.out.println("	----Rider menu----");
					System.out.println("	1.  Create account");
					System.out.println("	2.  Login");
					System.out.println("	3.  Return ");
					
					System.out.println("");
					
					int choice;
					System.out.println("");
					
					do 
					{
						System.out.println("	Enter choice: ");
						choice = keyboard.nextInt();
						
					}while(choice < 1 || choice > 3);
				
					return choice;
				}

				
				
				//6 Rider menu 2
				public static int riderMenu2(Scanner keyboard)
				{
					System.out.println("");
					System.out.println("	1.  View Order");
					System.out.println("	2.  Accept or reject delivery order");
					System.out.println("	3.  Update food delivery status");
					System.out.println("	4.  Cash collection update");
					System.out.println("	5.  Return ");
					
					System.out.println("");
					
					int choice;
					System.out.println("");
					
					do 
					{
						System.out.println("	Enter choice: ");
						choice = keyboard.nextInt();
						
					}while(choice < 1 || choice > 5);
				
					return choice;
				}
				
				
				//7 Restaurant menu
				public static int restaurantMenu(Scanner keyboard)
				{
					System.out.println("");
					System.out.println("	----Restaurant menu----");
					System.out.println("	1.  Create account");
					System.out.println("	2.  Login");
					System.out.println("	3.  Return");
					
					System.out.println("");
					
					int choice;
					System.out.println("");
					
					do 
					{
						System.out.println("	Enter choice: ");
						choice = keyboard.nextInt();
						
					}while(choice < 1 || choice > 3);
				
					return choice;
				}
				
				//8 Restaurant menu 2
				public static int restaurantMenu2(Scanner keyboard)
				{
					System.out.println("");
					System.out.println("	1.  Add Food Details");
					System.out.println("	2.  Update/Delete Food");
					System.out.println("	3.  Check Food Order");
					System.out.println("	4.  Update Food delivery status");
					System.out.println("	5.  Calculate Bill ");
					System.out.println("	6.  Check customer Feedback");
					System.out.println("	7.  View all available food in menu");
					System.out.println("	8.  Return");
					
					System.out.println("");
					
					int choice;
					System.out.println("");
					
					do 
					{
						System.out.println("	Enter choice: ");
						choice = keyboard.nextInt();
						
					}while(choice < 1 || choice > 8);
				
					return choice;
				}
				
				//9 Show account creation menu for Restaurant
				public static void Menu()
				{
		
						System.out.println("");
						
						System.out.println("	Welcome to Restaurant Account Creation ");
						System.out.println("");
						
				}
				
				
				//10 Admin menu 
				public static int adminMenu(Scanner keyboard)
				{
					System.out.println("");
					System.out.println("	----Admin menu----");
					System.out.println("	1.  Create account");
					System.out.println("	2.  Login");
					System.out.println("	3.  Return ");
					
					System.out.println("");
					
					int choice;
					System.out.println("");
					
					do 
					{
						System.out.println("	Enter choice: ");
						choice = keyboard.nextInt();
						
					}while(choice < 1 || choice > 3);
				
					return choice;
				}

		//________________________________________________________________________________________________________________________________
					
					
				
}
