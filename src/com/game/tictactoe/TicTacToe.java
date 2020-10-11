package com.game.tictactoe;

import java.util.*;
import java.util.Scanner;

public class TicTacToe {
	static int player = 0;
	static char playerVal;
	static char compVal;
	static int playerAction;
	static char[] BOARD = new char[10];
	static boolean notFull = true;

	static void startBoard() {
		System.out.println("'e' means empty");
		for (int i = 1; i < BOARD.length; i++) {
			BOARD[i] = 'e';
		}
	}

	static void selectOption() {
		char op = 0;
		if (player == 0) {
			System.out.println("Player selecting between O and X");
			Scanner sc = new Scanner(System.in);
			op = sc.next().charAt(0);
		}
		if (op == 'O' || op == 'o') {
			System.out.println("Computer alloted X");
			playerVal = 'O';
			compVal = 'X';
		} else {
			System.out.println("Computer alloted O");
			playerVal = 'X';
			compVal = 'O';
		}
		System.out.println("Player alloted " + playerVal);

	}

	static void showBoard() {
		for (int i = 1; i < BOARD.length; i++) {
			System.out.print(BOARD[i] + " ");
			if (i % 3 == 0) {
				System.out.println("");
			}
		}
		int cnt = 0;
		for (int i = 1; i < BOARD.length; i++) {
			if (BOARD[i] != 'e') {
				cnt++;
			}
		}
		if (cnt == 9)
			notFull = false;
	}
	public static boolean isAvailable(int position) {
		if (BOARD[position] == 'e' && position >= 1 && position < 10)
			return true;
		else
			return false;
	}


	static void playComp() {
		int position = ifPossibleToWin(compVal);
		if (position == 0) {
			position = blockPlayer();
		}
		if (BOARD[position] == 'e') {
			BOARD[position] = compVal;
		} else {
			playComp();
		}
		if (winCondition(compVal)) {
			System.out.println("Computer has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			playerTurn();
	}
	
	public static boolean winCondition(char ch) {
		if ((BOARD[1] == ch && BOARD[2] == ch && BOARD[3] == ch) || (BOARD[4] == ch && BOARD[5] == ch && BOARD[6] == ch)
				|| (BOARD[7] == ch && BOARD[8] == ch && BOARD[9] == ch)
				|| (BOARD[1] == ch && BOARD[5] == ch && BOARD[9] == ch)
				|| (BOARD[3] == ch && BOARD[5] == ch && BOARD[7] == ch)
				|| (BOARD[1] == ch && BOARD[4] == ch && BOARD[7] == ch)
				|| (BOARD[2] == ch && BOARD[5] == ch && BOARD[8] == ch)
				|| (BOARD[3] == ch && BOARD[6] == ch && BOARD[9] == ch)) {
			System.out.println("The game is over");
			return true;
		} else
			return false;
	}

	public static boolean drawCondition() {
		for (int i = 1; i < 10; i++) {
			if (BOARD[i] == 'e') {
				return false;
			}
		}
		return true;
	}

	public static int ifPossibleToWin(char ch) {
		if (isAvailable(1) && ((BOARD[2] == ch && BOARD[3] == ch) || (BOARD[4] == ch && BOARD[7] == ch)
				|| (BOARD[5] == ch && BOARD[9] == ch)))
			return 1;

		if (isAvailable(2) && ((BOARD[1] == ch && BOARD[3] == ch) || (BOARD[5] == ch && BOARD[8] == ch)))
			return 2;

		if (isAvailable(3) && ((BOARD[2] == ch && BOARD[1] == ch) || (BOARD[6] == ch && BOARD[9] == ch)
				|| (BOARD[5] == ch && BOARD[7] == ch)))
			return 3;

		if (isAvailable(4) && ((BOARD[1] == ch && BOARD[7] == ch) || (BOARD[5] == ch && BOARD[6] == ch)))
			return 4;

		if (isAvailable(5) && ((BOARD[1] == ch && BOARD[9] == ch) || (BOARD[3] == ch && BOARD[7] == ch)
				|| (BOARD[2] == ch && BOARD[8] == ch) || (BOARD[4] == ch && BOARD[6] == ch)))
			return 5;

		if (isAvailable(6) && ((BOARD[3] == ch && BOARD[9] == ch) || (BOARD[5] == ch && BOARD[4] == ch)))
			return 6;

		if (isAvailable(7) && ((BOARD[1] == ch && BOARD[4] == ch) || (BOARD[9] == ch && BOARD[8] == ch)
				|| (BOARD[5] == ch && BOARD[3] == ch)))
			return 7;

		if (isAvailable(8) && ((BOARD[2] == ch && BOARD[5] == ch) || (BOARD[7] == ch && BOARD[9] == ch)))
			return 8;

		if (isAvailable(9) && ((BOARD[7] == ch && BOARD[8] == ch) || (BOARD[3] == ch && BOARD[6] == ch)
				|| (BOARD[5] == ch && BOARD[1] == ch)))
			return 9;

		else
			return 0;

	}

	public static int blockPlayer() {
		int position = ifPossibleToWin(playerVal);
		if (position == 0) {
			int flag = 0;
			while (flag == 0) {
				position = ((int) Math.floor(Math.random() * 10) % 9) + 1;
				if (isAvailable(position))
					flag = 1;
			}
		}
		return position;
	}
	public static void playerMove() {
		int flag = 0;
		while (flag == 0) {
			System.out.println("Enter a pos between 1- 9 to enter your option");
			Scanner in = new Scanner(System.in);
			int position = in.nextInt();
			if (isAvailable(position)) {
				BOARD[position] = playerVal;
				flag = 1;
			} else
				System.out.println("Already Occupied");
		}
	}


	public static void computerMove() {
		int position = ifPossibleToWin(compVal);
		if (position == 0) {
			position = blockPlayer();
		}
		System.out.println("computer placed "+compVal+" at "+position);
		BOARD[position] = compVal;
	}
	public static void playerTurn() {
		playerMove();
		showBoard();
		if (winCondition(playerVal)) {
			System.out.println("Player has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			computerTurn();
	}

	public static void computerTurn() {
		computerMove();
		showBoard();
		if (winCondition(compVal)) {
			System.out.println("Computer has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			playerTurn();
	}

	static void getPosition() {

		Scanner i = new Scanner(System.in);
		int pos;
		if (playerAction == 0) {
			System.out.println("Enter a pos between 1- 9 to enter your option");
			pos = i.nextInt();
			if (BOARD[pos] == 'e') {
				BOARD[pos] = playerVal;
			} else {
				System.out.println("Entered position filled already");
				getPosition();
			}
		} else if (playerAction == 1) {
			playComp();
		}

	}

	static int turn(String a) {
		Random rand = new Random();
		int t = rand.nextInt(2);
		System.out.println(t);
		int c1 = -1;
		if (a.equalsIgnoreCase("head"))
			c1 = 0;
		if (a.equalsIgnoreCase("tail"))
			c1 = 1;
		if (t == c1)
			playerAction = 0; // user turn
		else
			playerAction = 1; // comp turn

		return playerAction;
	}

	static boolean win() {
		return (((BOARD[1] == BOARD[2]) && (BOARD[2] == BOARD[3]) && BOARD[1] != 'e')
				|| ((BOARD[4] == BOARD[5]) && (BOARD[5] == BOARD[6]) && BOARD[4] != 'e')
				|| ((BOARD[7] == BOARD[8]) && (BOARD[8] == BOARD[9]) && BOARD[7] != 'e')
				|| ((BOARD[1] == BOARD[5]) && (BOARD[5] == BOARD[9]) && BOARD[1] != 'e')
				|| ((BOARD[3] == BOARD[5]) && (BOARD[5] == BOARD[7]) && BOARD[3] != 'e')
				|| ((BOARD[1] == BOARD[4]) && (BOARD[4] == BOARD[7]) && BOARD[1] != 'e')
				|| ((BOARD[2] == BOARD[5]) && (BOARD[5] == BOARD[8]) && BOARD[2] != 'e')
				|| ((BOARD[3] == BOARD[6]) && (BOARD[6] == BOARD[9]) && BOARD[3] != 'e'));
	}

	static void play() {
		startBoard();
		while (notFull) {
			if (playerAction == 1) {

				System.out.println("Comp turn");
				getPosition();
				showBoard();
				playerAction = 0;
				if (win()) {
					System.out.println("Computer won");
					return;
				}
			} else if (playerAction == 0) {
				System.out.println("Players turn");
				getPosition();
				showBoard();
				playerAction = 1;
				if (win()) {
					System.out.println("Player won");
					return;
				}
			}
		}
		if (!notFull && !win()) {
			System.out.println("Draw");
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe");
		startBoard();
		System.out.println("Enter head/tail");
		Scanner p = new Scanner(System.in);
		String value = p.nextLine();
		if (turn(value) == 0) {
			System.out.println("User wins");
			selectOption();
			playerTurn();
		} else {
			System.out.println("Comp wins");
			selectOption();
			computerTurn();
		}
		

	}

}