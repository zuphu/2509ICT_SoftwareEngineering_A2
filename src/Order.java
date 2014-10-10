import java.util.ArrayList;


public class Order {
	static ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	static float cost = 0;
	final static int modifyItem = 1;
	final static int deleteItem = 2;

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
			cost += (oi.mi.itemCost * oi.quantity);

		System.out.println("The cost is: " + cost);
	}

	public static void modifyOrder() {
		listOrder();
		Operator.askModifyItem();
		Customer.enterModifyOrderItem();
		Operator.askModifyOption();
		Customer.enterModifyOrderOption();
		editOrder(Customer.modifyOption);
	}
	
	public static void listOrder() {
		int counter = 0;
		
		System.out.println("[Current Order]");
		for (OrderItem oi: orderItems) {
			counter++;
			System.out.println(counter + ". " +  oi.mi.itemName + "($" + oi.mi.itemCost + ")" + " x " + oi.quantity + " = " + (oi.mi.itemCost * oi.quantity) );
		}
	}
	
	public static void editOrder(int selection) {
		if (selection == modifyItem)
		{
			Operator.askQuantity();
			Customer.enterItemQuantity();
			OrderItem oi = orderItems.get(Customer.modifyItem - 1);
			oi.quantity = Customer.itemQuantity;
		}
		else if (selection == deleteItem)
		{
			orderItems.remove(Customer.modifyItem - 1);
		}
	}
}
