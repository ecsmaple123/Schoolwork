
/* MyFriendsList Ver 1.0
 * You Li 2017-08-04
 * This program features a arrayList that includes the functions of adding, searching and displaying elements using various methods
 */

import java.io.IOException;
import java.util.Scanner;

public class MyFriendList {

	static int counter = 0; // Integer variable for the counter of the array

	static String[] name = new String[100]; // The array used to store names for
											// friends

	static Scanner sc = new Scanner(System.in); // Scanner used to take inputs
												// from the user

	public static void main(String[] args) throws IOException {
		menu(); // Calls the method to start the program

	}

	public static void menu() throws IOException {
		int choice = -1; // This will be used to indicate the choice of the
							// user, initializing it as -1

		while (choice != 4) { // 4 is the exit option of the menu

			System.out.println("Main Menu");
			System.out.println("1. Display Friends\n2. Add Friends\n3. Search for a Friend\n4. Quit");

			try {
				choice = -1;
				choice = Integer.valueOf(sc.nextLine()).intValue();

			} catch (NumberFormatException e) {

			} // In case if the user does not input a integer, resetting the
				// choice after every loop

			switch (choice) {
			// The menu is handled through a switch command with various options
			case 1:
				displayFriends();
				// Calling the method to display the elements in the array
				break;
			case 2:
				addFriend();
				// Calling the method to add an element in the array
				break;
			case 3:
				System.out.println("What is the name of the friend?");
				String key = sc.nextLine();
				searchFriends(key);
				// Calling the method to search for a specific element
				break;

			case 4:
				System.out.println("Goodbye!");// Exiting
				break;
			default:
				System.out.println("OOPS!");

			}

		}
	}

	public static void addFriend() throws IOException {
		// addFriend is a method to add an element into the array

		if (counter < 100) { // It is important to first check if the list is
								// full

			System.out.println("Enter the Friend's name:");
			name[counter] = sc.nextLine(); // Defining the next avaible spot to
											// a new element

			System.out.println("This Friend is now in the list!");

			counter++; // The counter must be increased as there is a new
						// element in the list
		} else {
			System.out.println("Sorry the list is full!");
			// Notifing the user that the list is full
		}

	}

	public static void displayFriends() throws IOException {
		// displayFriends is a method to display all elements currently present
		// in the array

		if (counter == 0) {

			System.out.println("Your Friend list is empty");
			// If counter is 0, it means that there are no elements in the list

		} else {

			System.out.println("Here is the list of your Friends");

			for (int i = 0; i < counter; i++) {
				System.out.println(name[i]);

			} // for loop to display all elements
		}

	}

	public static void searchFriends(String key) throws IOException {
		// searchFriends is a method that search for a specific element in an
		// array, that element is defined as key which we take from the user

		int flag = 0;
		// Flag is used to mark a spot in the array

		boolean found = false;
		// Boolean indicates if the search key has a match

		for (int i = 0; i < 100; i++) {
			// Looping through the list

			if (key.equals((name[i]))) { // Comparison between the current
											// element in the array and user's
											// input
				flag = i;
				found = true;
			}
		}
		// actual output
		if (found == false) {
			System.out.println("Name not found");
		} else {
			System.out.println("Name: " + key + " found in position: " + flag);
		}

	}

}
