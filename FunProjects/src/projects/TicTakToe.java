package projects;

import java.util.Scanner;

public class TicTakToe {

	public static char[][] board = new char[3][3];
	public static boolean player1Turn = true;
	public static boolean player2Turn = false;
	public static Scanner sc = new Scanner(System.in);
	public static boolean matchEnd = false;
	public static int row;
	public static int col;
	public static char playerIcon = 'X';
	static boolean rematch = true;

	public static void main(String[] args) {
		clearBoard();
		System.out.println("###### Welcome to TIC TAC TOE ######");
		boolean playerTurn = true;
		while (rematch) {
			while (!matchEnd) {

				if (!playerTurn) {
					playerIcon = 'O';
				} else {
					playerIcon = 'X';
				}
				playerTurn = !playerTurn;
				gameMove();

				if (checkWin()) {
					printBoard();
					System.out.println("Player " + playerIcon + " WINS !!!!");
					playAgain();
					break;
				}
				if (checkDraw()) {
					printBoard();
					System.out.println("Match Draw Thank For Playing !!!");
					playAgain();
					break;
				}
				matchEnd = false;
			}
		}
	}

	private static void playAgain() {
		System.out.println("Rematch??? Y-Yes N-No");
		String choice = sc.next();
		if (choice.equalsIgnoreCase("Y")) {
			clearBoard();
			rematch= true;
			
		}else if(choice.equalsIgnoreCase("N")) {
			rematch = false;
			System.out.println("##### Thanks For Playing #####");
		}else {
			System.out.println("Invalid choice please enter valid choice");
			playAgain();
		}
	}
	
	static void clearBoard(){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	private static void gameMove() {
		printBoard();
		System.out.println("Player " + playerIcon + "'s Turn");
		System.out.println("Enter your move row and columns 0-2");
		row = sc.nextInt();
		col = sc.nextInt();
		if (row < 3 && col < 3 && board[row][col] == ' ') {
			board[row][col] = playerIcon;
		} else {
			System.out.println("Invalid Input Please enter again");
			gameMove();
		}

	}

	private static boolean checkWin() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
				return true;
			}
			if (board[1][i] == board[2][i] && board[2][i] == board[0][i] && board[0][i] != ' ') {
				return true;
			}
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != ' ') {
			return true;
		}
		if (board[0][2] == board[1][1] && board[2][0] == board[1][1] && board[1][1] != ' ') {
			return true;
		}
		return false;

	}

	private static boolean checkDraw() {
		boolean fullBoard = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					fullBoard = false;
				}
			}

		}
		if (fullBoard) {
			return true;
		} else {
			return false;
		}
	}

	private static void printBoard() {

		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {

				System.out.print(board[i][j] + " | ");
			}
			System.out.println("\n-------------");
		}

	}

}
