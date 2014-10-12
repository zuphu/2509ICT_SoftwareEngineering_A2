import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.sql.*;

public class OrderSystem {
	final static boolean ready = true;
	final static int addMenuItem = 1;
	final static int modifyOrder = 2;
	final static int finishOrder = 3;

	public static void main(String[] args){
		Operator.takeCall();
		Customer.enterType();
		Operator.retrieveMenu();
		do {
			if (Customer.state == Customer.stateOrdering) {
                Operator.listMenuItems();
                Customer.enterItemNumber();
                Operator.askQuantity();
                Customer.enterItemQuantity();
                Order.addItem(Customer.itemNumber, Customer.itemQuantity);
                Order.updateOrderCost();
                do {
                     Operator.giveOptions();
                     Customer.enterOptionNumber();
                     switch (Customer.option ) {
                     case addMenuItem:
                    	Customer.setState(Customer.stateOrdering);
                    	break; 
                     case modifyOrder:
                        Customer.setState(Customer.stateModifying);
                        Order.modifyOrder();
                        break;
                     case finishOrder:
                        Customer.setState(Customer.stateConfirm);
                    	 break;
                     default:
                    	 System.out.println("Invalid selection");
                     }
                     
                     if (Customer.state == Customer.stateConfirm) {
                    	 Order.listOrder();
                    	 Order.updateOrderCost();
                    	 Operator.askToConfirmOrder();
                    	 Customer.confirmOrder();
                    	 if (Customer.confirmOrder == Customer.confirmedOrder) {
                    		 System.out.println("Placing order");
                    		 Operator.placeOrder();
                    	 }
                    	 else {
                    		 Customer.state = Customer.stateModifying;
                    		 Customer.option = modifyOrder;
                    	 }
                     }
                } while (Customer.option == modifyOrder);
			}
		} while (Customer.option != finishOrder);
	}
	
	public static void db_connect() {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:database/OrdSystem.db");
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM customerdetails where phonenumber like '%04%'" );
	      
	      while ( rs.next() ) {
	          int itemId = rs.getInt("id");
	          String itemName = rs.getString("phonenumber");
	          String itemDescription = rs.getString("creditcardnumber");

	          System.out.println( "ID = " + itemId );
	          System.out.println( "NAME = " + itemName );
	          System.out.println( "Description = " + itemDescription );
	          System.out.println();
	       } 

	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}
	
	public static boolean newNum (String testNum) {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:database/OrdSystem.db");
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT phonenumber FROM customerdetails WHERE phonenumber LIKE '" + testNum + "';"  );
            /////
	        int countResults = 0;
	        while ( rs.next() ) {
	        	  countResults++;
		       } 
	        /////
	        //boolean test = rs.first();
            if(countResults < 1)
                return true;
            else
                return false;
	    }
	    catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
		return false;
	}

	public static void addItemToOrder(){
		Operator.selectItemNumber();
		Operator.selectQuantity();
	}
	
	public static void modifyOrder(){
		int selection;
		System.out.print("Remove item (1)\n, Alter item (2)");
		Scanner keyboard = new Scanner(System.in);
		selection = keyboard.nextInt();
		if(selection != 1 && selection != 2){
			System.out.print("Invalid selection");
			modifyOrder();
		}
		else
			Operator.removeItem();
		if(selection == 2){
			Operator.selectItemNumber();
			Operator.selectQuantity();
		}
	}
	
	public static void giveOptions(){
		int choice = 0;
		Scanner keyboard = new Scanner(System.in);
			System.out.print("Add new item (1)\n, Finish order (2)\n, Modify order (3)");
			choice = keyboard.nextInt();
			if(choice == 1)
				addItemToOrder();
			else if(choice == 2)
				//order finished
				choice = 2;
			else if(choice == 3)
				modifyOrder();
			else{
				System.out.print("Invalid selection");
				giveOptions();
			}
	}
	
	public static void saveCustomer(){
		Connection c = null;
	    Statement stmt = null;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:database/OrdSystem.db");
	        stmt = c.createStatement();
	        stmt.execute("INSERT INTO customerdetails (phonenumber, address, creditcardnumber) VALUES ('" + CustomerDetails.getNumber()
	        		+ "', '" + CustomerDetails.getAddress() + "', '" + CustomerDetails.getccNumber() + "');");
	    }
	    catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	}
}

