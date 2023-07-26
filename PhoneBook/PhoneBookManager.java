package PhoneBook;

import java.util.Scanner;
/**
 * @author Joshua House
 * PhoneBookManager class that holds the main method to run the user interface
 * Calls functions from PhoneBook.java and Person.java
 */
public class PhoneBookManager {
	public static void main(String args[]) {
		PhoneBook NumberCatalog = new PhoneBook();
		Scanner keyboard = new Scanner(System.in);
		String name, number;
		int choice = 0;
		
		NumberCatalog.fillTree();
		/**
		 * While loop to run the menu and call methods based on users choice
		 */
		while (choice != 6) {
			System.out.println("1) Add a contact");
			System.out.println("2) Delete a contact");
			System.out.println("3) Search for phone number");
			System.out.println("4) Update phone number");
			System.out.println("5) Display phone book in sorted order");
			System.out.println("6) Save and Exit");
			choice = keyboard.nextInt();
			keyboard.nextLine();
			/**
			 * Switch statement based off the users choice
			 */
			switch(choice) {
			case 1: // Add a contact
				System.out.println("Enter the name of the person you would like to add:");
				name = keyboard.nextLine();
				System.out.println("Enter the number of the person you would like to enter:");
				number = keyboard.nextLine();
				NumberCatalog.add(new Person(name, number));
				break;
			case 2: // Delete a contact
				System.out.println("Enter the name of the person you would like to delete from the phone book:");
				name = keyboard.nextLine();
				try {
				NumberCatalog.delete(name);
				} catch(TreeException e) {
					System.out.println("Person not found in the tree");
				}//End catch
				break;
			case 3: // Search for phone number
				System.out.println("Enter the name of the person whos number you would like:");
				name = keyboard.nextLine();
				System.out.println(NumberCatalog.retrieve(name));
				break;
			case 4: // Update phone number
				System.out.println("Enter the name of the person whos number you would like to change:");
				name = keyboard.nextLine();
				System.out.println("Enter the updated number:");
				number = keyboard.nextLine();
				NumberCatalog.retrieve(name).setNumber(number);
				break;
			case 5: // Display phone book in sorted order
				NumberCatalog.DisplaySorted();
				break;
			case 6: // Saves and exits
				NumberCatalog.save();
				break;
			default: // Default message if the user puts anything other than 1-6
				System.out.println("Invalid choice");
				break;
			} // End of switch
			System.out.println("Press Enter to continue");
			keyboard.nextLine();
		}// End of while
		keyboard.close();
	}//End of main
}//End of class
