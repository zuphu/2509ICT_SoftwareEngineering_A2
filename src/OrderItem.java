
public class OrderItem {
	MenuItem mi = new MenuItem();
	int quantity = 0;
	
	public OrderItem () {
		
	}
	
	public OrderItem (MenuItem mi, int quantity) {
		this.mi = mi;
		this.quantity = quantity;
	}
	
}
