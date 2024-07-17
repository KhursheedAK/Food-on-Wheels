package BusinessLogic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Restaurant 
{
	
	
	
	Scanner sc=new Scanner(System.in);
	
	
	// attributes
	protected ArrayList<Integer> price1 = new ArrayList<Integer>(15);
	protected ArrayList<String> menu = new ArrayList<String>(15);
	
	protected ArrayList<String> newpassword = new ArrayList<String>(30);
	protected ArrayList<String> restaurantname = new ArrayList<String>(30);

	protected ArrayList<Integer> newID = new ArrayList<Integer>(30);
	protected ArrayList<Integer> phone = new ArrayList<Integer>(30);
	
	protected ArrayList<String> cart = new ArrayList<String>(30);
	protected ArrayList<Integer> cartprice = new ArrayList<Integer>(30);
	
	
	
	protected String name;
	
	protected String item;
	
	protected int id;
	
	protected String password;


	private static final AtomicLong sequence = new AtomicLong(System.currentTimeMillis() / 1000);

    public static long getNext() 
    {
        return sequence.incrementAndGet();
    }
    
	
	Random rand = new Random(); //instance of random class
    protected int billNumber = rand.nextInt(900);
    protected int orderNumber = rand.nextInt(450);
	
	
	// default constructor
	Restaurant()
	{
		
	}
	
	
	//Parameterized constructor
	Restaurant(String name, int id, String password)
	{
		this.name=name;
		this.id=id;
		this.password=password;
	}
		
	
	// getter and setter
	
	
	public int getBillNumber() {
		return billNumber;
	}

	
	
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	
	
	public int getOrderNumber() {
		return orderNumber;
	}

	
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	
	
	public ArrayList<Integer> getPrice1() {
		return price1;
	}
	
	

	public void setPrice1(ArrayList<Integer> price1) {
		this.price1 = price1;
	}
	
	

	public ArrayList<String> getMenu() {
		return menu;
	}
	
	

	public void setMenu(ArrayList<String> menu) {
		this.menu = menu;
	}
	
	

	public ArrayList<String> getNewpassword() {
		return newpassword;
	}
	
	

	public void setNewpassword(ArrayList<String> newpassword) {
		this.newpassword = newpassword;
	}
	
	

	public ArrayList<String> getRestaurantname() {
		return restaurantname;
	}
	
	

	public void setRestaurantname(ArrayList<String> restaurantname) {
		this.restaurantname = restaurantname;
	}

	
	
	public ArrayList<Integer> getNewID() {
		return newID;
	}
	
	

	public void setNewID(ArrayList<Integer> newID) {
		this.newID = newID;
	}
	
	

	public ArrayList<Integer> getPhone() {
		return phone;
	}
	
	

	public void setPhone(ArrayList<Integer> phone) {
		this.phone = phone;
	}
	
	

	public ArrayList<String> getCart() {
		return cart;
	}
	
	

	public void setCart(ArrayList<String> cart) {
		this.cart = cart;
	}
	
	

	public ArrayList<Integer> getCartprice() {
		return cartprice;
	}
	
	

	public void setCartprice(ArrayList<Integer> cartprice) {
		this.cartprice = cartprice;
	}
	
	
	
	public Scanner getSc() {
		return sc;
	}


	public void setSc(Scanner sc) {
		this.sc = sc;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
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
	

    
	// end of getter and setters

	
	
	
	// Restaurant Abstract functions 
	
	public abstract void addFood();
	public abstract void updateFood();
	public abstract void deleteFood();
	public abstract void checkFoodOrder();
	public abstract void deliveryStatus();
	public abstract void Bill();
	public abstract void foodDeliveryStatus();
	public abstract boolean feedback();
	
	
	
	

}
