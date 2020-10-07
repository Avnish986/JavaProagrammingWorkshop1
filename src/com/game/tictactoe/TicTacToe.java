package com.game.tictactoe;

public class TicTacToe {
	static char[] BOARD=new char [10];
	static boolean notFull = true;
	static void startBoard() {
		System.out.println("TIC TAC TOE GAME\nComputer is O\nPlayer is X ");
		for (int i = 1; i < BOARD.length; i++) 
		 {
			BOARD[i] = 'z';
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe");
		startBoard();
	}

}
