import java.util.Scanner;

public class Operator {
	public static void takeCall(){
		int number = askNumber();
		String customerDetails[] = new String[2];
		
		
		customerDetails = askDetails(number);
		for(String str : customerDetails)
		   System.out.println(str);
		//storeNumber();
	}
	public static int askNumber(){
		int number;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter your phone number.");
		//error. Will not include 0 at the start of the number
		number = keyboard.nextInt();
		return(number);
	}
	public static String[] askDetails(int number){
		
		//customerDetails[address, ccDetails]
		String customerDetails[] = new String[2];
		Scanner keyboard = new Scanner(System.in);
		//checknumber();
		System.out.println("Please Enter your Address.");
		customerDetails[0] = keyboard.nextLine();
		System.out.println("Please Enter your Credit-Card Details.");
		customerDetails[1] = keyboard.nextLine();
		return(customerDetails);
	}
	public static void retrieveMenu(){
		//incomplete
		Menu.printMenu();
	}
	public static void selectItemNumber(){
		int itemNumber;
		Scanner keyboard = new Scanner(System.in);
		itemNumber = keyboard.nextInt();
		Order.addItem(itemNumber);
	}
	public static void selectQuantity(){
		int quantity;
		Scanner keyboard = new Scanner(System.in);
		quantity = keyboard.nextInt();
		Order.addQuantity(quantity);
	}
	public static void removeItem(){
		//going to bed now
	}
}

