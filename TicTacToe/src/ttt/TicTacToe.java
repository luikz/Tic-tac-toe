package ttt;

import java.util.Scanner;

public class TicTacToe {
	static String[][] vet = new String[6][6];
	static String simb;
	static int count, po;
	static boolean R;
	public static void main(String[] args) {
		count = 1;
		simb = "X";
		for(int l = 1; l<=3; l++) {
			for(int c = 1; c<=3; c++) {
				vet[l][c] = Integer.toString(count);
				count++;
			}
		}
		screen();
		do {
			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("What position would you like to play [" + simb + "]? ");
				po = sc.nextInt();
				R = play(simb,po);
				if(R == false) {
					System.out.println("Invalid!");
				}
			}while(R != true);
			changePlayer();
			screen();
		}while(gameFinished() != true);
		System.out.println("GAME FINISHED!");
	}
	
	public static void screen() {
		System.out.println("==========");
		for(int l = 1; l <=3; l++) {
			for(int c = 1; c<=3; c++) {
				System.out.print("| " + vet[l][c]);
			}
			System.out.print("|");
			System.out.println();
			System.out.println("==========");
		}
	}
	
	public static void changePlayer() {
		if(simb.equals("X")) {
			simb = "O";
		}else {
			simb = "X";
		}
	}
	
	public static boolean play(String S, int P) {
		boolean changed = false;
		for(int l = 1; l<=3; l++) {
			for(int c = 1; c<=3; c++) {
				if(vet[l][c].equals(Integer.toString(P))) {
					vet[l][c] = S;
					changed = true;
				}
			}
		}
		return changed;
	}
	
	public static boolean gameFinished() {
		boolean finished = false;
		int ocorr = 0;
		for(int l = 1; l<=3; l++) {
			if(vet[l][1] == vet[l][2] && vet[l][2] == vet[l][3]) {
				finished = true;
			}
		}
		
		for(int c = 1; c <=3; c++) {
			if(vet[1][c] == vet[2][c] && vet[2][c] == vet[3][c]) {
				finished = true;
			}
		}
		
		if(vet[1][1] == vet[2][2] && vet[2][2] == vet[3][3]) {
			finished  = true;
		}
		
		if(vet[1][3] == vet[2][2] && vet[2][2] == vet[3][1]) {
			finished = true;
		}
		
		for(int l = 1; l<=3; l++) {
			for(int c = 1; c <=3; c++) {
				if(vet[l][c] != "X" && vet[l][c] != "O") {
					ocorr++;
				}
			}
		}
		
		if(ocorr == 0) {
			finished = true;
		}
		return finished;
	}
}
