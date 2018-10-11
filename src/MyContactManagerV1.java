/* MyContactManager Ver 1.0
 * You Li 2017-08-08
 * This program features multiple arrayLists that includes the functions of adding, deleting, displaying, 
 * saving and loading the elements using various mehods.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyContactManagerV1 {

	static int counter = 0;
	static String[] name = new String[100]; // Array to store names
	static String[] email = new String[100]; // Array to store email addresses
	static String[] address = new String[100];// Array to store addresses
	static long[] number = new long[100]; // Array to store numbers, using long
											// as phone numbers are rather large
	static Scanner sc = new Scanner(System.in);// Scanner used to take inputs
												// from the user

	public static void main(String[] args) throws IOException {

		menu(); // Calls the method to start the program
	}

	public static void menu() throws IOException {
		int choice = -1; // This will be used to indicate the choice of the
							// user, initializing it as -1

		while (choice != 6) { // 4 is the exit option of the menu

			System.out.println("Main Menu");
			System.out.println(
					"1. Display Contacts\n2. Add a Contact\n3. Delete a Contact\n4. Save To a File\n5. Load From a File\n6. Quit");

			try {
				choice = -1;
				choice = Integer.valueOf(sc.nextLine()).intValue();

			} catch (NumberFormatException e) {

			} // In case if the user does not input a integer, resetting the
				// choice after every loop

			switch (choice) {
			// The menu is handled through a switch command with various options
			case 1:
				displayContacts();
				// Calling the method to display the elements in the array
				break;
			case 2:
				addContact();
				// Calling the method to add an element in the array
				break;
			case 3:
				if (counter > 0) { // Checking if list is empty

					System.out.println("What is the name of the contact?");
					String key = sc.nextLine();
					deleteContact(key);
				} else
					System.out.println("There is no Contact to delete!\n");
				// Calling the method to delete an element in the array
				break;

			case 4:
				if (counter > 0) { // Checking if list is empty
					saveFile();
					// Calling the method to save the Contacts to a file
				} else
					System.out.println("There is no Contact to save!\n");
				break;

			case 5:
				loader();
				break;

			case 6:
				System.out.println("Goodbye!");// Exiting
				System.exit(0);
				break;
			default:
				System.out.println("OOPS!\n");

			}

		}
	}

	public static void displayContacts() throws IOException {
		// displayContacts is a method to display all elements currently present
		// in the array

		if (counter == 0) {

			System.out.println("Your Contact list is empty\n");
			// If counter is 0, it means that there are no elements in the list

		} else {

			System.out.println("Here is the list of your Contacts");

			for (int i = 0; i < counter; i++) {
				System.out.println("Contact " + (i + 1) + "\n  Name: " + name[i] + "\n  Number: " + number[i]
						+ "\n  Address: " + address[i] + "\n  Email: " + email[i] + "\n");

			} // for loop to display all elements
		}

	}

	public static void addContact() throws IOException {
		// addFriend is a method to add an element into the array

		if (counter < 100) { // It is important to first check if the list is
								// full

			System.out.println("Enter the Contact's name:");
			name[counter] = sc.nextLine(); // Defining the next avaible spot to
											// a new element

			int temp = 0;
			while (temp == 0) {
				try { // Catching error in case user enters a non integer value

					System.out.println("Enter the Contact's number:");
					number[counter] = sc.nextLong();
					temp = 1;

				} catch (InputMismatchException e) {
					System.out.println("Error! Please enter a number with no spaces!");
					sc.next();
				}
			}

			sc.nextLine();
			System.out.println("Enter the Contact's address:");
			address[counter] = sc.nextLine();

			System.out.println("Enter the Contact's email address:");
			email[counter] = sc.nextLine();

			System.out.println("This Contact is now in the list!\n");

			counter++; // The counter must be increased as there is a new
						// element in the list
		} else {
			System.out.println("Sorry the list is full!\n");
			// Notifing the user that the list is full
		}

	}

	public static void deleteContact(String key) throws IOException {

		int flag = -1;

		// search the array for the Contact
		for (int i = 0; i < counter; i++) {

			if (key.compareTo(name[i]) == 0) {

				flag = i;
			}
		}

		// record was not found
		if (flag == -1) {
			System.out.println("Contact not found\n");
		} else { // record was found, flag is a positive index position

			// if the record is the last record, simply remove it and
			// decrement
			// the counter
			if (flag == counter - 1) {
				name[flag] = "";
				address[flag] = "";
				email[flag] = "";
				number[flag] = 0;
				counter--;
				System.out.println("Success!\n");
			} else {

				// record is not the last record, shift all later records
				// down
				for (int i = flag; i < counter; i++) {

					name[i] = name[i + 1];
					number[i] = number[i + 1];
					address[i] = address[i + 1];
					email[i] = email[i + 1];
					counter--;
					System.out.println("Success!\n");
				}

			}
		}
	}

	public static void loader() throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("D:\\Downloads\\Contacts.txt"));
		int x = Integer.valueOf(in.readLine()).intValue(); // Amount to load
		for (int i = 0; i < x; i++) {
			String temp = in.readLine();
			String delims = "[ ]+"; // Seperating by space
			String[] tokens = temp.split(delims); // Splitting the line into
													// different parts so that
													// it can be saved in
													// different arrays

			name[counter] = tokens[0]; // First spot is name
			number[counter] = Long.valueOf(tokens[1]); // Second spot is phone
														// number
			address[counter] = tokens[2]; // Third spot is address
			email[counter] = tokens[3]; // Fourth spot is email
			counter++; // Increase the counter

		}
		System.out.println("Success !\n");
		in.close();
	}

	public static void saveFile() throws IOException {
		// counter
		int i;
		// Create File output
		PrintWriter output;
		output = new PrintWriter(new FileWriter("D:\\Downloads\\Contacts.txt"));
		// Output a header to the file, in this case it is the number of
		// contacts
		output.println(counter);
		// loop through the array outputting to a file

		for (i = 0; i < counter; i++) {
			;
			output.print(name[i]);
			output.print(" " + number[i]);
			output.print(" " + address[i]);
			output.print(" " + email[i]);
			output.println("");
		}

		System.out.println("Success! Contacts are now saved!\n");
		// close file!
		output.close();

	}

}
