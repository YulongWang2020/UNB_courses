import java.util.Scanner;

/**
Tests the methods of the IntList class.
*/
public class IntListTest {
	private static Scanner scan;
	private static IntList list = new IntList();

	/*
	Creates a list, then repeatedly prints the menu and does what
	the user asks until they quit.
	*/
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		printMenu();
		int choice = scan.nextInt();
		while (choice != 0) {
			dispatch(choice);
			printMenu();
			choice = scan.nextInt();
		}
	}

	/*
	Does what the menu item calls for.
	*/
	public static void dispatch(int choice) {
		int newVal;
		switch (choice) {
			case 0:
				System.out.println("Bye!");
				break;
			case 1: //add to front
				 System.out.println("Enter integer to add to front");
				 newVal = scan.nextInt();
				 list.addToFront(newVal);
				 break;
			case 2: //remove first element
				 list.removeFirst();
				 break;
			case 3: //print
				 list.print();
				 break;
			case 4: //length
				 System.out.println(list.length());
				 break;
			case 5: //addToEnd
				 System.out.println("Enter integer to add to end");
				 newVal = scan.nextInt();
				 list.addToEnd(newVal);
				 break;
			case 6: //removeLast
				 list.removeLast();
				 break;
			case 7: //replace
				 System.out.println("Enter old integer to be replaced");
				 int oldVal = scan.nextInt();
				 System.out.println("Enter new integer to replace with");
				 newVal = scan.nextInt();
				 list.replace(oldVal,newVal);
				 break;
			case 8: // print rec
				 list.printRec();
				 break;
			case 9: // print rec
				 list.printRecBackwards();
				 break;
			default:
				System.out.println("Sorry, invalid choice");
		}
	}
	
	/*
	Prints the user's choices
	*/
	public static void printMenu() {
		System.out.println("\n Menu ");
		System.out.println(" ====");
		System.out.println("0: Quit");
		System.out.println("1: Add an integer to the front of the list");
		System.out.println("2: Remove an integer from the front of the list");
		System.out.println("3: Print the list");
		System.out.println("4: returns the number of elements in the list");
		System.out.println("5: takes an integer and puts it on the end of the list");
		System.out.println("6: removes the last element of the list. If the list is empty, does nothing.");
		System.out.println("7: replaces all occurrences of oldVal in the list with newVal.");
		System.out.println("8: Print the list recursively");
		System.out.println("9: Print the list backwards recursively");
		System.out.print("\nEnter your choice: ");
	}
}
