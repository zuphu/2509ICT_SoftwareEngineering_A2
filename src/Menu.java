import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Menu {

	static ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
	static int numberOfMenuItems = 0;

	public Menu () {
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
	    	  Menu.numberOfMenuItems++;
	    	  MenuItem mi = new MenuItem();
	          String itemName = rs.getString("itemname");
	          String itemDescription = rs.getString("itemdescription");
	          Float itemCost = rs.getFloat("cost");
	          mi.setItemName(itemName);
	          mi.setItemDescription(itemDescription);
	          mi.setItemCost(itemCost);
	          menuList.add(mi);
	       } 
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	}

	public static void printMenu(){
		int itemNumber = 0;

		System.out.println("[Menu Items]");
		System.out.println("*-=-=-=-=-=-=-=-=-=-=-*");
		for (MenuItem mi: menuList) {
			++itemNumber;
			System.out.println("Item #:\t\t"+ itemNumber);
			System.out.println("Name:\t\t" + mi.itemName);
			System.out.println("Cost:\t\t" + mi.itemCost);
			System.out.println("*-=-=-=-=-=-=-=-=-=-=-*");
		}
	}
	
	public static MenuItem getMenuItem(int index) {
		return menuList.get(index-1);
	}

}
