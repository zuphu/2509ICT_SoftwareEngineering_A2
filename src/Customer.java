import java.util.Scanner;


public class Customer {
	static int itemNumber = -1;
	static int itemQuantity = -1;
	static int option = -1;
	static int modifyItem = -1;
	static int modifyOption = -1;
	static int confirmOrder = -1;
	static int orderType = -1;
	static Scanner keyboard = new Scanner(System.in);
	static final int stateOrdering = 0;
	static final int stateModifying = 1;
	static final int stateConfirm = 2;
	static final int confirmedOrder = 1;
	static int state = stateOrdering;
	
	public static int getItemNumber () {
		return Customer.itemNumber;
	}

	public static void enterCustomerNumber () {
		String number;
		Scanner keyboard = new Scanner(System.in);
		
		number = keyboard.nextLine();
	}
	
	public static void enterItemNumber () {
		itemNumber = keyboard.nextInt();
	}

	public static int askNumber() {
		return 0;
	}

	public static void enterItemQuantity() {
		itemQuantity = keyboard.nextInt();
	}

	public static void enterOptionNumber() {
		option = keyboard.nextInt();
	}

	public static void enterModifyOrderItem() {
		modifyItem = keyboard.nextInt();
	}

	public static void enterModifyOrderOption() {
		modifyOption = keyboard.nextInt();
	}

	public static void setState(int state) {
		Customer.state = state;
	}

	public static void confirmOrder() {
		confirmOrder = keyboard.nextInt();
	}

	public static void enterType() {
		System.out.println("Please select either takeaway(1) or home delivery(2):");
		orderType = keyboard.nextInt();
	}
}
