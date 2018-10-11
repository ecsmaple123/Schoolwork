import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*SortItOut V1.0
 * You Li 2017-08-08
 * SortItOut features a bubble sort method and a selection sort method to sort certain namess
 */

public class SortItOut {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("D:\\Downloads\\unsortedNames.txt"));
		String[] name = new String[100]; //first array
		String line;
		int i = 0;
		while ((line = in.readLine()) != null) {
			name[i] = line;
			i++;
		}
		// First time loading the names to an array
		bubbleSort(name, 1);
		selectionSort(name, 2);
		// First sorting
		
		String[] name1 = new String[100]; // second array
		BufferedReader in1 = new BufferedReader(new FileReader("D:\\Downloads\\unsortedNames.txt"));
		i = 0;
		while ((line = in1.readLine()) != null) {
			name1[i] = line;
			i++;
		}
		// Second time loading the names to a new array

		bubbleSort(name1, 2);
		selectionSort(name1, 1);
		// Second sorting
		in.close();
		in1.close();
		// Closing the readers

	}

	public static void bubbleSort(String[] names, int c) {

		if (c == 1) {
			int counter = 0; //couting the swaps
			
			//looping through array
			for (int i = 0; i < names.length; i++) {
				for (int j = 0; j < names.length - 1 - i; j++) {
					
					 //comparing j and j + 1 strings, swapping
					if (names[j].compareTo(names[j + 1]) > 0) {
						String temp = names[j];
						names[j] = names[j + 1];
						names[j + 1] = temp;
						counter++;
					}
				}
			}
			for (int i = 0; i < names.length; i++) {
				System.out.println(names[i]);
			}
			System.out.println(counter + " swaps performed to bubble sort");

		}
		if (c == 2) {
			int counter = 0;
			for (int i = 0; i < names.length; i++) {
				for (int j = 0; j < names.length - 1 - i; j++) { //Exact same method with different conditioning
					if (names[j].compareTo(names[j + 1]) < 0) {
						String temp = names[j];
						names[j] = names[j + 1];
						names[j + 1] = temp;
						counter++;
					}
				}
			}
			for (int i = 0; i < names.length; i++) {
				System.out.println(names[i]);
			}
			System.out.println(counter + " swaps performed to bubble sort");
		}

	}

	public static void selectionSort(String[] names, int c) {

		if (c == 1) {
			int counter = 0; // Counter to count the swaps
			for (int i = 0; i < names.length - 1; i++) {
				int min = i; // smallest flag
				for (int j = i + 1; j < names.length; j++) {

					if (names[j].compareTo(names[min]) < 0) { // Comapring the
																// strings
						min = j;
					}
				}

				// swap the smallest
				String temp = names[i];
				names[i] = names[min];
				names[min] = temp;
				// Swapping
				counter++;
			}

			for (int i = 0; i < names.length; i++) {
				System.out.println(names[i]);
			}
			System.out.println(counter + " swaps performed to selection sort");
			// outputting

		} else if (c == 2) {
			int counter = 0;
			for (int i = 0; i < names.length - 1; i++) {
				int min = i;
				for (int j = i + 1; j < names.length; j++) {

					if (names[j].compareTo(names[min]) > 0) { // exact same
																// method as
																// previous only
																// chaging the
																// condition
						min = j;
					}
				}

				String temp = names[i];
				names[i] = names[min];
				names[min] = temp;
				counter++;
			}

			for (int i = 0; i < names.length; i++) {
				System.out.println(names[i]);
			}
			System.out.println(counter + " swaps performed to selection sort");

		}

	}

}
