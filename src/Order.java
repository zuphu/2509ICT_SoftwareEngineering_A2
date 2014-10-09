import java.util.ArrayList;


public class Order {
	static ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	static int cost = 0;

	public static void addItem(int itemNumber, int quantity){
		OrderItem oi = new OrderItem();
		MenuItem mi = new MenuItem();
		mi = Menu.getMenuItem(itemNumber);
		oi.mi = mi;
		oi.quantity = quantity;
		orderItems.add(oi);
	}
	
	public static void orderCost() {
		
	}

	public static void addQuantity(int quantity){
		//add quantity to order
	}

	public static void updateCost(int quantity){
		//update cost to dailyTakings
	}

	public static void addOrderItem(MenuItem menuItem) {
		
	}

	public static void updateOrderCost() {
		cost = 0;
		for (OrderItem oi: orderItems)
			cost += oi.mi.itemCost;
		System.out.println(cost);
	}
}
