import java.util.Scanner;


public class Customer {
	static int itemNumber = -1;
	static int itemQuantity = -1;
	static Scanner keyboard = new Scanner(System.in);
	
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
/*		System.out.println("damn");
		itemQuantity = Integer.parseInt(keyboard.nextLine());*/
	}

}
