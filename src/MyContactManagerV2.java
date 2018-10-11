
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

public class MyContactManagerV2 {

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

		while (choice != 8) { // 4 is the exit option of the menu

			System.out.println("Main Menu");
			System.out.println(
					"1. Display Contacts\n2. Add a Contact\n3. Delete a Contact\n4. Save To a File\n5. Load From a File\n6. Search for a Contact\n7. Sort the Contacts\n8. Quit");

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
				if (counter > 0) {// Checking if list is empty
					System.out.println(
							"What field would you like to search in? \n1. Name\n2. Email\n3. Address\n4. Number");// Asking
																													// for
																													// a
																													// field
					int choice1 = -1;

					while (choice1 != 1 && choice1 != 2 && choice1 != 3 && choice1 != 4) {
						System.out.println("Please enter a number from 1 to 4");

						// Try catch for exceptions
						try {
							choice1 = sc.nextInt();

						} catch (InputMismatchException e) {

							sc.next();
						}
					}
					sc.nextLine();
					String key;
					long intKey = 0;
					switch (choice1) {
					// Switch for managing the user's choice
					case 1:
						System.out.println("What is the name?");
						key = sc.nextLine();
						Search(name, key);
						break;
					case 2:
						System.out.println("What is the email?");
						key = sc.nextLine();
						Search(email, key);
						break;
					case 3:
						System.out.println("What is the address?");
						key = sc.nextLine();
						Search(address, key);
						break;
					case 4:
						System.out.println("What is the number?");

						while (intKey == 0) {
							// Try catch in case user enters not a number
							try {
								intKey = sc.nextLong();
							} catch (InputMismatchException e) {
								System.out.println("Please enter a number");

								sc.next();
							}
						}

						SearchNum(number, intKey);
						sc.nextLine();
						break;
					}
				} else
					System.out.println("There is no Contact to sort!\n");
				break;

			case 7:

				System.out.println("What field would you like to sort by? \n1. Name\n2. Email\n3. Address");// Asking
				// field
				int choice2 = -1;

				while (choice2 != 1 && choice2 != 2 && choice2 != 3) {
					System.out.println("Please enter a number from 1 to 3");

					// Try catch for exceptions
					try {
						choice2 = sc.nextInt();

					} catch (InputMismatchException e) {

						sc.next();
					}
				}

				int choice3 = -1;
				System.out.println("1.A to Z \n2.Z to A");
				while (choice3 != 1 && choice3 != 2) {
					System.out.println("Please enter 1 or 2");

					try {
						choice3 = sc.nextInt();

					} catch (InputMismatchException e) {

						sc.next();
					}
				}

				sc.nextLine();
				// calling the method
				if (choice2 == 1) {
					bubbleSort(name,choice3);
				}
				if (choice2 == 2) {
					bubbleSort(email,choice3);
				}
				if (choice2 == 3) {
				 bubbleSort(address, choice3);
				 }

				break;

			case 8:
				System.out.println("Goodbye!");// Exiting
				System.exit(0);
				break;
			default:
				System.out.println("OOPS!\n");

			}

		}
	}

	/*
	 * displayContacts is a method to display all elements currently present in
	 * the array, It requires no input and outputs the entire contact list with
	 * their related arrat lists
	 */

	public static void displayContacts() throws IOException {

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

	/*
	 * addFriend is a method to add an element into the array It takes the input
	 * of the user of their choice of information about the contact and adds it
	 * to the existing arrays.
	 */

	public static void addContact() throws IOException {

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

	/*
	 * deleteContact takes the user's input of name as a String value then
	 * searches for the contact and setting it to nul therefore removing the
	 * contact from the array and all related arrays
	 * 
	 */

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

	/*
	 * loader attempts to read a text file with contact information within then
	 * loading these information to according arrays. It takes no input and
	 * outputs the loaded arrays into the program
	 */

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

	/*
	 * saveFile attemps to save the current information in the contact list into
	 * a file. It takes the current arrays as inputs and outputs a file with the
	 * information within
	 */

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
	/*
	 * Search searches for a specific element in a certain array. It takes the
	 * input array and the key then searches withtin the given array, outputs
	 * all the matching results.
	 */

	public static void Search(String[] array, String key) {

		// initialize a boolean the mark if the contact is found
		Boolean found = false;

		// loop through all the elements in the array
		for (int i = 0; i < array.length; i++) {

			if (key.equals(array[i])) {
				System.out.println("Contact " + (i + 1) + "\n  Name: " + name[i] + "\n  Number: " + number[i]
						+ "\n  Address: " + address[i] + "\n  Email: " + email[i] + "\n");
				found = true;
			}
		}

		// This portion notifies the user if the contact isn't found
		if (found == false) {
			System.out.println("Not found");
		}
	}

	/*
	 * SearchNum is exactly the same as Search but this one searches for a Long
	 * value.
	 */

	public static void SearchNum(long[] array, long key) {

		Boolean found = false;

		for (int i = 0; i < array.length; i++) {

			if (key == array[i]) {
				System.out.println("Contact " + (i + 1) + "\n  Name: " + name[i] + "\n  Number: " + number[i]
						+ "\n  Address: " + address[i] + "\n  Email: " + email[i] + "\n");
				found = true;
			}
		}

		if (found == false) {
			System.out.println("Not found");
		}
	}

	/*
	 * bubbleSort takes one array to sort by  as
	 * inputs then outputs all other related arrays the sorted arrays. 
	 */

	public static void bubbleSort(String[] array,int c) {
		// one sorting array and others are related arrys

		if (c == 1) {

			// looping through array
			for (int i = 0; i < counter; i++) {
				for (int j = 0; j < counter - 1 - i; j++) {

					// comparing j and j + 1 strings, swapping
					if (array[j].compareTo(array[j + 1]) > 0) {
						String temp = name[j];
						String tempR1 = email[i];
						String tempR2 = address[i];
						long tempR3 = number[i];

						name[j] = name[j + 1];
						email[j] = email[j + 1];
						address[j] = address[j + 1];
						number[j] = number[j + 1];

						name[j + 1] = temp;
						email[j + 1] = tempR1;
						address[j + 1] = tempR2;
						number[j + 1] = tempR3;
						// swapping related arrays
					}
				}
			}

			System.out.println("Success! Sorted list can be viewed through Display Contacts");

		}
		if (c == 2) {

			for (int i = 0; i < counter; i++) {
				for (int j = 0; j < counter - 1 - i; j++) { // Exact same
															// method
															// with
															// different
															// conditioning
					if (array[j].compareTo(array[j + 1]) < 0) {
						String temp = name[j];
						String tempR1 = email[i];
						String tempR2 = address[i];
						long tempR3 = number[i];

						name[j] = name[j + 1];
						email[j] = email[j + 1];
						address[j] = address[j + 1];
						number[j] = number[j + 1];

						name[j + 1] = temp;
						email[j + 1] = tempR1;
						address[j + 1] = tempR2;
						number[j + 1] = tempR3;

					}
				}
			}
			System.out.println("Success! Sorted list can be viewed through Display Contacts");

		}

	}


}
