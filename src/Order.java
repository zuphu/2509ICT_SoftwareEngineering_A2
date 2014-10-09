import java.util.ArrayList;


public class Order {
	ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

	public static void addItem(int itemNumber, int quantity){
		MenuItem mi = new MenuItem();
		mi = Menu.getMenuItem(itemNumber);
		System.out.println(mi.itemCost);
		System.out.println(mi.itemDescription);
		System.out.println(mi.itemName);
	}

	public static void addQuantity(int quantity){
		//add quantity to order
	}

	public static void updateCost(int quantity){
		//update cost to dailyTakings
	}

	public static void addOrderItem(MenuItem menuItem) {
		
	}
}
