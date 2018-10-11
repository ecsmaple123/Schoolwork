import java.util.Scanner;

public class TicTacToe {

	static int Pos[][] = new int[3][3]; // Default board, 3 by 3 2D array

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		displayBoard();// Call the method to display the inital empty board
		String prompt = "Welcome to Tic-Tac-Toe \nA,B,C represents row and 1,2,3 represents column \nPlease enter your first move: ";
		// Default statement
		String humanMove = ""; // String to store human move
		String computerMove = ""; // String to store CPU move
		boolean gameIsWon = false; // Boolean to determine if game is won

		for (int i = 1; i <= 9; i++) {
			// for loop to operate the game, only 9 possible spots

			humanMove = getMove(prompt); // Calls the getMove method to get
											// human's move
			updateBoard(humanMove, 1); // Updates the board using updateBoard
										// with the human move acquired, 1
										// because it's human move and therefore
										// X
			displayBoard(); // Displays the updated board
			if (GameWon()) {
				System.out.println("You win!");
				gameIsWon = true;
				break;
			}
			// Calls the GameWon boolean to see if game is won, if so, break out
			// of loop and ends the game

			if (i < 9) {
				computerMove = ComputerMove();
				System.out.println("I will play at " + computerMove);
				updateBoard(computerMove, 2); // 2 because i t's CPU's move and
												// therefore O
				displayBoard();
				// Same method as getting human move except its for CPU move
				if (GameWon()) {
					System.out.println("You lose!");
					gameIsWon = true;
					break;
				} // Calls the GameWon boolean to see if game is lost, if so,
					// break out of loop and ends the game
				prompt = "Please enter your next move: ";
				i++;
				// End of CPU move if and change the prompt message, increase i
				// as i is the number of vacant spots
			}
		}
		if (!gameIsWon) // If after 9 spots game is still not won, end game as
						// draw
			System.out.println("It's a draw!");
	}

	/*
	 * getMove is a method to acquire the move from the user, takes the input as
	 * a prompt message, then outputs the messages and returns player's play as
	 * a play after checking for if it's a valid play
	 * 
	 */

	public static String getMove(String prompt) {
		String play;
		System.out.print(prompt);
		do {
			play = sc.nextLine();
			if (!ValidPlay(play)) { // calls the ValidPlay method to check if
									// it's a valid play
				System.out.println("That is not a valid play, try again.");
			}
		} while (!ValidPlay(play)); // Check once then enter loop if it's not a
									// valid play
		return play;
	}
	/*
	 * ValidPlay method takes the input as a String value from user to see if
	 * the play is Valid, all the possible valid plays are listed below, method
	 * returns true if the play matches one and false if it doesnt. All the if
	 * statements are used here to check for the play
	 * 
	 */

	public static boolean ValidPlay(String play) {
		if (play.equalsIgnoreCase("A1") & Pos[0][0] == 0)
			return true;
		if (play.equalsIgnoreCase("A2") & Pos[0][1] == 0)
			return true;
		if (play.equalsIgnoreCase("A3") & Pos[0][2] == 0)
			return true;
		if (play.equalsIgnoreCase("B1") & Pos[1][0] == 0)
			return true;
		if (play.equalsIgnoreCase("B2") & Pos[1][1] == 0)
			return true;
		if (play.equalsIgnoreCase("B3") & Pos[1][2] == 0)
			return true;
		if (play.equalsIgnoreCase("C1") & Pos[2][0] == 0)
			return true;
		if (play.equalsIgnoreCase("C2") & Pos[2][1] == 0)
			return true;
		if (play.equalsIgnoreCase("C3") & Pos[2][2] == 0)
			return true;
		return false;
	}
	/*
	 * updateBoard updates the 2D array. It takes input String play from either
	 * the player or CPU, and it takes integer value player to define spots in
	 * the 2D array. It outputs nothing however updates the 2D array. Here, the
	 * play is all valid after checking with ValidPlay and integer is either 1
	 * or 2 to represent X or O
	 * 
	 */

	public static void updateBoard(String play, int player) {
		if (play.equalsIgnoreCase("A1"))
			Pos[0][0] = player;
		if (play.equalsIgnoreCase("A2"))
			Pos[0][1] = player;
		if (play.equalsIgnoreCase("A3"))
			Pos[0][2] = player;
		if (play.equalsIgnoreCase("B1"))
			Pos[1][0] = player;
		if (play.equalsIgnoreCase("B2"))
			Pos[1][1] = player;
		if (play.equalsIgnoreCase("B3"))
			Pos[1][2] = player;
		if (play.equalsIgnoreCase("C1"))
			Pos[2][0] = player;
		if (play.equalsIgnoreCase("C2"))
			Pos[2][1] = player;
		if (play.equalsIgnoreCase("C3"))
			Pos[2][2] = player;
	}

	/*
	 * displayBoard displays the current game board, it mainly uses the XO
	 * method plus the set amount of lines. XO methods can be seen later in the
	 * program
	 */

	public static void displayBoard() {
		String line = ""; // Empty space for better visuals
		System.out.println();
		line = " " + XO(Pos[0][0]) + " | " + XO(Pos[0][1]) + " | " + XO(Pos[0][2]);
		System.out.println(line);
		System.out.println("-----------");
		line = " " + XO(Pos[1][0]) + " | " + XO(Pos[1][1]) + " | " + XO(Pos[1][2]);
		System.out.println(line);
		System.out.println("-----------");
		line = " " + XO(Pos[2][0]) + " | " + XO(Pos[2][1]) + " | " + XO(Pos[2][2]);
		System.out.println(line);
		System.out.println();
	}

	/*
	 * XO method determines the spot to be X or O, if input is 1, return X, if
	 * input is 2, return O
	 * 
	 */
	public static String XO(int square) {
		if (square == 1)
			return "X";
		if (square == 2)
			return "O";
		return " ";
	}
	/*
	 * A very simple AI move generator, takes the first avaible spot, it is a
	 * set algorithm, returns the first empty spot as the CPU's move
	 * 
	 */

	public static String ComputerMove() {
		if (Pos[0][0] == 0)
			return "A1";
		if (Pos[0][1] == 0)
			return "A2";
		if (Pos[0][2] == 0)
			return "A3";
		if (Pos[1][0] == 0)
			return "B1";
		if (Pos[1][1] == 0)
			return "B2";
		if (Pos[1][2] == 0)
			return "B3";
		if (Pos[2][0] == 0)
			return "C1";
		if (Pos[2][1] == 0)
			return "C2";
		if (Pos[2][2] == 0)
			return "C3";
		return "";
	}
	/*
	 * boolean to chekc if the game is won by either player, uses to RowWon
	 * method to check for any won row, if any row is won, return true and if
	 * not return false.
	 * 
	 */

	public static boolean GameWon() {
		if (RowWon(Pos[0][0], Pos[0][1], Pos[0][2]))
			return true;
		if (RowWon(Pos[1][0], Pos[1][1], Pos[1][2]))
			return true;
		if (RowWon(Pos[2][0], Pos[2][1], Pos[2][2]))
			return true;
		if (RowWon(Pos[0][0], Pos[1][0], Pos[2][0]))
			return true;
		if (RowWon(Pos[0][1], Pos[1][1], Pos[2][1]))
			return true;
		if (RowWon(Pos[0][2], Pos[1][2], Pos[2][2]))
			return true;
		if (RowWon(Pos[0][0], Pos[1][1], Pos[2][2]))
			return true;
		if (RowWon(Pos[0][2], Pos[1][1], Pos[2][0]))
			return true;
		return false;
	}

	/*
	 * boolean to chekc if give row is won, only returns true if all three slots
	 * are of the same number / letter
	 * 
	 */
	public static boolean RowWon(int a, int b, int c) {
		return ((a == b) & (a == c) & (a != 0)); // Return true of the three are
													// eqaul and not equal to 0
													// for example 1-1-1 means
													// X-X-X, therefore won
	}
}
