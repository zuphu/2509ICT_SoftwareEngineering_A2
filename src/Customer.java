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
	
	public static void enterItemNumber () {
		System.out.println("Please enter a menu item number: ");
		try {
			itemNumber = keyboard.nextInt();
			if(itemNumber > 4 || itemNumber < 1)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("Invalid selection");
			enterItemNumber();
		}
	}

	public static int askNumber() {
		return 0;
	}

	public static void enterItemQuantity() {
		itemQuantity = keyboard.nextInt();
	}

	public static void enterOptionNumber() {
		try {
			option = keyboard.nextInt();
			if(option < 1 || option > 3)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("Invalid selecton");
			Operator.giveOptions();
			enterOptionNumber();
		}
	}

	public static void enterModifyOrderItem() {
		try {
			modifyItem = keyboard.nextInt();
			if(modifyItem < 1 || modifyItem > Order.getItems())
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("Invalid selection");
			Operator.askModifyItem();
			enterModifyOrderItem();
		}
	}

	public static void enterModifyOrderOption() {
		try {
			modifyOption = keyboard.nextInt();
			if(modifyOption < 1 || modifyOption > 2)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("Invalid selection");
			Operator.askModifyOption();
			enterModifyOrderOption();
		}
	}

	public static void setState(int state) {
		Customer.state = state;
	}

	public static void confirmOrder() {
		try {
			confirmOrder = keyboard.nextInt();
			if(confirmOrder < 1 || confirmOrder > 2)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("Invalid selection");
			Operator.askToConfirmOrder();
			confirmOrder();
		}
	}

	public static void enterType() {
		System.out.println("Please select either takeaway(1) or home delivery(2):");
		try {
			orderType = keyboard.nextInt();
			if(orderType > 2 || orderType < 1)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("Invaldid selection");
			enterType();
		}
		if(orderType == 1)
			System.out.println("Take-away selected");
		else
			System.out.println("Home-delivery selected");
	}
}
