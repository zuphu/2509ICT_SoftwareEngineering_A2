import java.util.Scanner;
import java.sql.*;

public class OrderSystem {
	public static void main(String[] args){
		//boolean state = true;
		//Operator.takeCall();
		//Operator.retrieveMenu();
		//addItemToOrder();
		db_connect();
	}
	
	public static void db_connect() {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:database/OrdSystem.db");
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM menuitemdetails;" );

	      while ( rs.next() ) {
	          int itemId = rs.getInt("id");
	          String itemName = rs.getString("itemname");
	          String itemDescription = rs.getString("itemdescription");
	          Float itemCost = rs.getFloat("cost");

	          System.out.println( "ID = " + itemId );
	          System.out.println( "NAME = " + itemName );
	          System.out.println( "Description = " + itemDescription );
	          System.out.println( "Cost = " + itemCost );
	          System.out.println();
	       } 

	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    

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
}

