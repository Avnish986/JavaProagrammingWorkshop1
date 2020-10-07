package com.game.tictactoe;

import java.util.*;
import java.util.Scanner;

public class TicTacToe {
	static int player = 0;
	static char playerVal;
	static char compVal;
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
			compVal = 'X';
		}
		else {
			System.out.println("Computer alloted O");
			playerVal = 'X';
			compVal = 'O';
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
		int cnt=0;
		for(int i=1;i<BOARD.length;i++){
			if(BOARD[i]!='e') {
				cnt++;
			}
		}
		if(cnt==9)
			notFull = false;
	}

	static void getPosition() {
		
		Scanner i = new Scanner(System.in);
		int pos;
		if(playerAction == 0) {
		System.out.println("Enter a pos between 1- 9 to enter your option");
		pos=i.nextInt();
		if(BOARD[pos]=='e') {
			BOARD[pos]=playerVal;
		}
		else {
			System.out.println("Entered position filled already");
			getPosition();
		}
		}
		else if(playerAction == 1){
			playerAction=0;
		}

	}
	static int turn(String a) {
		Random rand = new Random();
		int t = rand.nextInt(2);
		System.out.println(t);
                int c1 = -1;
                if(a.equalsIgnoreCase("head")) c1=0;
                if(a.equalsIgnoreCase("tail")) c1=1;
		if(t==c1)
			playerAction=0; //user turn
		else
			playerAction=1; //comp turn
		
		return playerAction;
	}
	static boolean win() {
		return (((BOARD[1] == BOARD[2]) && (BOARD[2] == BOARD[3]) && BOARD[1]!='e')
				|| ((BOARD[4] == BOARD[5]) && (BOARD[5] == BOARD[6]) && BOARD[4]!='e')
				|| ((BOARD[7] == BOARD[8]) && (BOARD[8] == BOARD[9]) && BOARD[7]!='e')
				|| ((BOARD[1] == BOARD[5]) && (BOARD[5] == BOARD[9]) && BOARD[1]!='e')
				|| ((BOARD[3] == BOARD[5]) && (BOARD[5] == BOARD[7]) && BOARD[3]!='e')
				|| ((BOARD[1] == BOARD[4]) && (BOARD[4] == BOARD[7])&& BOARD[1]!='e' )
				|| ((BOARD[2] == BOARD[5]) && (BOARD[5] == BOARD[8]) && BOARD[2]!='e')
				|| ((BOARD[3] == BOARD[6]) && (BOARD[6] == BOARD[9])&& BOARD[3]!='e'));
	}
	static boolean draw(){
		int cnt=1;
		for(int i=1;i<BOARD.length;i++){
			if(BOARD[i]=='e'){
				return false;
			}
			else{
				cnt++;
			}
		}
			return true;
	}
	static void play() {
		startBoard();
		while (notFull) {
			System.out.println("Players turn");
			getPosition();
			showBoard();
			if (win()) {
				System.out.println("Player won");
				return;
			}
			if(draw()) {
				System.out.println("Player tie");
				return;
			}
		}
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
		play();
		
//		showBoard();
//		getPosition();
//		System.out.println("");
//		showBoard();
	}

}
