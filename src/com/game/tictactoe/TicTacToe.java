package com.game.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	static int player = 0;
	static char playerVal;
	static char[] BOARD=new char [10];
	static boolean notFull = true;
	static void startBoard() {
		System.out.println("TIC TAC TOE GAME");
		for (int i = 1; i < BOARD.length; i++) 
		 {
			BOARD[i] = 'z';
		}
	}
	
	static void selectOption()
	{
		char op = 0;
		if(player == 0) {
			System.out.println("Player selecting between O and X");
			Scanner sc = new Scanner(System.in);
			op = sc.next().charAt(0);
		}
		if(op == 'O' || op =='o') {
			System.out.println("Compuer play X");
			playerVal = 'O';
		}
		else {
			System.out.println("Computer play O");
			playerVal = 'X';
			
		}

	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe");
		startBoard();
		selectOption();
	}

}
