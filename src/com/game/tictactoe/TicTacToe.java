package com.game.tictactoe;

import java.util.*;
import java.util.Scanner;

public class TicTacToe {
	static int player = 0;
	static char playerVal;
	static int playerAction;
	static char[] BOARD=new char [10];
	static boolean notFull = true;
	static void startBoard() {
		System.out.println("TIC TAC TOE GAME");
		for (int i = 1; i < BOARD.length; i++) 
		 {
			BOARD[i] = 'e';
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
			System.out.println("Computer alloted X");
			playerVal = 'O';
		}
		else {
			System.out.println("Computer alloted O");
			playerVal = 'X';
			
		}
		System.out.println("Player alloted "+playerVal);

	}
	static void showBoard() {
		for(int i=1;i<BOARD.length;i++)
		{
			System.out.print(BOARD[i]+ " ");
			if(i%3==0) {
				System.out.println("");
			}
		}
	}
	static void getPosition() {
		
		Scanner i = new Scanner(System.in);
		int pos;
		System.out.println("Enter a pos between 1- 9 to enter your option");
		pos=i.nextInt();
		if(BOARD[pos]=='e') {
			BOARD[pos]=playerVal;
			getPosition();
		}
		else {
			System.out.println("Entered position filled already");
			getPosition();
		}

	}
	static int turn(String a) {
		Random rand = new Random();
		int t = rand.nextInt(1);
                int c1 = -1;
                if(a =="head") c1=0;
                if(a=="tail") c1=1;
		if(t==c1)
			playerAction=0; //user turn
		else
			playerAction=1; //comp turn
		
		return playerAction;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe");
		startBoard();
		System.out.println("Enter head/tail");
		Scanner p = new Scanner(System.in);
		String value = p.nextLine();
		if(turn(value)==0) {
			System.out.println("User wins");
		}
		else {
			System.out.println("Comp wins");
		}
		selectOption();
		showBoard();
	}

}
