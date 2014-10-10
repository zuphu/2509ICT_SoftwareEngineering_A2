import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DailyTakings {
	static float totalForDay;

	static void calculateDailyTakings () {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:database/OrdSystem.db");
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM dailyorders WHERE orderdate = '" + dateFormat.format(date) + "';");
        
	      while ( rs.next() ) {
	          float cost = rs.getFloat("totalordercost");
	          String orderdate = rs.getString("orderdate");
	          totalForDay += cost;
	       } 

        System.out.println("Total day takings is:" + totalForDay);

	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	}
}
