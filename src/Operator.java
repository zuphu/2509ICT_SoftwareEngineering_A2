import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Operator {
	final static int numberMin = 8;
	final static int numberMax = 10;
	final static int creditCardLen = 16;
	
	static Scanner keyboard = new Scanner(System.in);
	public static void takeCall(){
		askNumber();
	}

	public static void askNumber(){
		System.out.println("Enter your phone number.");
		try {
			CustomerDetails.setNumber(keyboard.nextLine());
			if (CustomerDetails.number.length() < numberMin || CustomerDetails.number.length() > numberMax)
				throw new Exception();
			else
				checkExisting();
		} catch (Exception e) {
			System.out.println("INVALID: Number is too short or long (must be between " + numberMin + " and " + numberMax + " characters)");
			askNumber();
		}
	}

	public static void askDetails(){
		askAddress();
		askccNumber();
		OrderSystem.saveCustomer();
	}
	
	public static void askAddress(){
		System.out.println("Please Enter your Address.");
		CustomerDetails.setAddress(keyboard.nextLine());
	}
	
	public static void askccNumber(){
		System.out.println("Please Enter your Credit-Card Details. (no spaces)");
		try {
			CustomerDetails.setccNumber(keyboard.nextLine());
			if(CustomerDetails.ccNumber.length() != creditCardLen)
				throw new Exception();
		} catch (Exception e) {
			System.out.println("INVALID: Credit card number must be " + creditCardLen + " characters");
			askccNumber();
		}
	}
	public static void retrieveMenu(){
		Menu.db_connect();
	}
	public static void selectItemNumber(){
		int itemNumber;
		itemNumber = keyboard.nextInt();
		//Order.addItem(itemNumber);
	}
	public static void selectQuantity(){
		int quantity;
		quantity = keyboard.nextInt();
		Order.addQuantity(quantity);
	}
	public static void removeItem(){
		//going to bed now
	}

	public static void listMenuItems(){
		Menu.printMenu();
		System.out.println("Please enter a menu item number: ");
	}
	public static void askQuantity() {
		System.out.println("Please enter a quantity: ");
		// TODO Auto-generated method stub
	}

	public static void giveOptions() {
		System.out.println("1.Add Menu Item\n2.Modify Order \n3.Finish Order");
	}
	
	public static void checkExisting() {
		if (OrderSystem.newNum(CustomerDetails.number)) {
			System.out.println("{New Customer}");
			askDetails();
		}
		else
			System.out.println("{Existing Customer}");
	}

	public static void askModifyItem() {
		System.out.println("Please enter an item number to modify:");
	}
	
	public static void askModifyOption() {
		System.out.println("Would you like to: 1.Modify item quantity 2.Delete item from order");
	}

	public static void askToConfirmOrder() {
		System.out.println("Are you sure you woud like to place your order? 1. Confirm 2.Cancel:");
	}

	public static void placeOrder() {
		insertOrder();
		DailyTakings.calculateDailyTakings();
	}
	
	public static void insertOrder() {
		Connection c = null;
	    Statement stmt = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:database/OrdSystem.db");
	        stmt = c.createStatement();
	        stmt.execute("INSERT INTO dailyorders (id, orderdate, totalordercost) VALUES (null, '" + dateFormat.format(date) + "', " + Order.cost + ");" );
	    }
	    catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	}	
}
