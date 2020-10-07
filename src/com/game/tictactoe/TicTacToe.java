package com.game.tictactoe;

public class TicTacToe {
	static char[][] BOARD = new char[3][3];
	static boolean notFull = true;
	static void startBoard() {
		System.out.println("TIC TAC TOE GAME\nComputer is O\nPlayer is X ");
		for (int i = 0; i < BOARD.length; i++) {
			for (int j = 0; j < BOARD[i].length; j++) {
				BOARD[i][j] = ' ';
			}
		}
		System.out.println("Board: ");
		}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe");
		startBoard();
	}

}
