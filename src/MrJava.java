import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
	Skeleton code for Mr.Java's program
	The task is to sort the 2D array
	
	Author: Mike King, 2013
*/

public class MrJava {

	public static void main(String[] args) throws IOException {

		// declare the 2D String array
		String[][] seats = new String[10][10];

		// populate the 2D array from the file myNames.txt
		populateArray(seats);

		// print the unsorted contents of the 2D array
		printArray(seats);

		// TO DO: Implement a sorting algorithm here

		// counter indicates the number of criminals in the array

		for (int i = 0; i < 10; i++) {
			// Starting with row one, initiate the regular bubble sort to every
			// row.
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					// 2 for loops to compare each name to every other name
					if (seats[i][k].compareTo(seats[i][k + 1]) > 0) {
						String temp = seats[i][k];
						seats[i][k] = seats[i][k + 1];
						seats[i][k + 1] = temp;
					}

				}
			}
		}

		// This bubble sort method only sorts each inidvidual row, so the
		// results horizontally are in alphabetical order while the verticle results
		// are not

		System.out.println();

		// print the sorted array
		printArray(seats);

	}

	/*
	 * populateArray reads the list of names from the file myNames.txt
	 */
	static void populateArray(String[][] array) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("D:\\Downloads\\myNames.txt"));

			for (int i = 0; i < 10; i++) {
				for (int y = 0; y < 10; y++) {
					array[i][y] = reader.readLine();
				}
			}

			// close the reader
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * printArray prints the contents of the 2D array input
	 */
	static void printArray(String[][] in) {

		for (int i = 0; i < 10; i++) {
			for (int y = 0; y < 10; y++) {
				if (in[i][y] == null) {

					if (y == 9) {
						System.out.println(in[i][y] + "\n");
					} else {
						System.out.println("_\t");
					}

				}
				if (y == 9) {
					System.out.print(in[i][y] + "\n");
				} else {
					System.out.print(in[i][y] + "\t");
				}
			}
		}
	}
}
