
/*
* Fugitive on the Run 
*
* Version 1.0
* 
* You Li 2017-07-12
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FugitiveOnTheRun {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File F1 = new File("D:\\Downloads\\creditCards1.txt");
		File F2 = new File("D:\\Downloads\\creditCards2.txt");
		File F3 = new File("D:\\Downloads\\creditCards3.txt");

		// Initializing three new files using File, these are saved under the
		// dowloads directory

		Scanner S1 = new Scanner(F1); // Declare first scanner to scan first
										// file

		while (S1.hasNext()) {
			String L1 = S1.next();

			// Scan through the first file while declaring the value of the line
			// to String L1 that resets every loop
			Scanner S2 = new Scanner(F2);
			// Declare second scanner to scan second file

			while (S2.hasNext()) {
				String L2 = S2.next();
				// Scan through the second file while declaring a second string
				// value that resets evvery loop

				if (L1.equals(L2)) {
					Scanner S3 = new Scanner(F3);
					// If there is a match between the first and second file,
					// move on to the third file, declaring a third scanner to
					// scan the third file

					while (S3.hasNext()) {
						String L3 = S3.next();

						if (L3.equals(L1) && L3.equals(L2)) {
							// Finally finding a match between all three files
							// then outputting the match during loop
							System.out.println("Matching credit card number: "+L1);
						}
					}
					S3.close(); // Resetting scanner after every loop

				}
			}
			S2.close(); // Resetting scanner after every loop

		}

		S1.close(); // Resetting scanner after every loop

	}

}
