import java.util.Scanner;

public class Operator {
	static Scanner keyboard = new Scanner(System.in);
	public static void takeCall(){
		askNumber();
		//OrderSystem.checkNumber(CustomerDetails.getNumber());
		askDetails(); //Check if correct...
	}
	public static void askNumber(){
		System.out.println("Enter your phone number.");
		CustomerDetails.setNumber(keyboard.nextLine());
	}
	public static void askDetails(){
		askAddress();
		askccNumber();
	}
	public static void askAddress(){
		//checkNumber();
		System.out.println("Please Enter your Address.");
		CustomerDetails.setAddress(keyboard.nextLine());
		
	}
	public static void askccNumber(){
		String ccNumber;
		System.out.println("Please Enter your Credit-Card Details.");
		ccNumber = keyboard.nextLine();
		CustomerDetails.setccNumber(ccNumber);
	}
	public static void retrieveMenu(){
		Menu.db_connect();
	}
	public static void selectItemNumber(){
		int itemNumber;
		itemNumber = keyboard.nextInt();
		//Order.addItem(itemNumber);
	}
	public static void selectQuantity(){
		int quantity;
		quantity = keyboard.nextInt();
		Order.addQuantity(quantity);
	}
	public static void removeItem(){
		//going to bed now
	}

	public static void listMenuItems(){
		System.out.println("xxx");
		Menu.printMenu();
		System.out.println("Please enter a menu item number: ");
	}

}