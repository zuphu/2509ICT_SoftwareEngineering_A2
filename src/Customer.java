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
	static final int confirmOrderMin = 1;
	static final int confirmOrderMax = 2;
	static final int modifyOrderOptionMin = 1;
	static final int modifyOrderOptionMax = 2;
	static final int itemNumberMin = 1;
	static final int itemQuantityMin = 1;
	static final int itemQuantityMax = 200;
	static final int optionMin = 1;
	static final int optionMax = 3;
	static final int modifyOrderItemMin = 1;
	static int state = stateOrdering;
	
	public static int getItemNumber () {
		return Customer.itemNumber;
	}
	
	public static void enterItemNumber () {
		System.out.println("Please enter a menu item number: ");
		try {
			itemNumber = keyboard.nextInt();
			if(itemNumber < itemNumberMin || itemNumber > Menu.numberOfMenuItems)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("INVALID: Invalid selection, valid selections are between " + itemNumberMin + " and " + Menu.numberOfMenuItems);
			keyboard.nextLine();
			enterItemNumber();
		}
	}

	public static int askNumber() {
		return 0;
	}

	public static void enterItemQuantity() {
		try {
			itemQuantity = keyboard.nextInt();
			if(itemQuantity < itemQuantityMin || itemQuantity > itemQuantityMax)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("INVALID: Invalid item quantity, valid quantities are between " + itemQuantityMin + " and " + itemQuantityMax);
			keyboard.nextLine();
			enterItemQuantity();
		}
	}

	public static void enterOptionNumber() {
		try {
			option = keyboard.nextInt();
			if(option < optionMin || option > optionMax)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("INVALID: Invalid option selected. Selection must be between " + optionMin +" and " + optionMax);
			keyboard.nextLine();
			enterOptionNumber();
		}
	}

	public static void enterModifyOrderItem() {
		try {
			modifyItem = keyboard.nextInt();
			if(modifyItem < modifyOrderItemMin || modifyItem > Order.getItems())
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("INVALID: Invalid selection must be between " + modifyOrderItemMin + " and " + Order.getItems() );
			keyboard.nextLine();
			enterModifyOrderItem();
		}
	}

	public static void enterModifyOrderOption() {
		try {
			modifyOption = keyboard.nextInt();
			if(modifyOption < modifyOrderOptionMin || modifyOption > modifyOrderOptionMax)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("INVALID: Invalid selection for option, please select a number between " + 
								modifyOrderOptionMin + " and " + modifyOrderOptionMax);
			keyboard.nextLine();
			enterModifyOrderOption();
		}
	}

	public static void setState(int state) {
		Customer.state = state;
	}

	public static void confirmOrder() {
		try {
			confirmOrder = keyboard.nextInt();
			if(confirmOrder < confirmOrderMin || confirmOrder > confirmOrderMax)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("INVALID: Invalid selection for option, please select a number between " + 
								confirmOrderMin + " and " + confirmOrderMax);
			keyboard.nextLine();
			confirmOrder();
		}
	}

	public static void enterType() {
		System.out.println("Please select either takeaway(1) or home delivery(2):");
		try {
			orderType = keyboard.nextInt();
			if(orderType < confirmOrderMin || orderType > confirmOrderMax)
				throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println("INVALID: Invalid selection, please enter a valid selection");
			keyboard.nextLine();
			enterType();
		}
		if(orderType == 1)
			System.out.println("Take-away selected");
		else
			System.out.println("Home-delivery selected");
	}
}
