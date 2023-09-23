package Game;

import java.util.Scanner;

public class Game {
	protected static Scanner scanner = new Scanner(System.in);
	protected static int[][] GameState = new int[9][2];
	
	public static void main(String[] args) {
		Interface UI = new Interface();
		Game MainGame = new Game();
		int coin = 0;
		while(MainGame.WinCondition() == false) {
			UI.display();
			UI.prompt(coin);
			if (coin == 0) {
				coin = 1;
			}
			else {
				coin = 0;
			}
		}
		UI.display();
		System.out.print("\n winner");
		scanner.close();
	}
	
	public boolean WinCondition() {
		for (int i = 0; i<9; i++) {
			if (GameState[i][1] != 0 && (HorizontalCheck(i) || VerticalCheck(i) || DiagonalCheck(i))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean HorizontalCheck(int i) {
		if ((i == 0 || i == 3 || i == 6) && GameState[i][1] == GameState[i+1][1] && GameState[i][1] == GameState[i+2][1]) {
			return true;
		}
		return false;
	}
	public boolean VerticalCheck(int i) {
		if ((i == 0 || i == 1 || i==2) && GameState[i][1] == GameState[i+3][1] && GameState[i][1] == GameState[i+6][1] ) {
			return true;
		}
		return false;
	}
	public boolean DiagonalCheck(int i) {
		if (i == 0 && GameState[i][1] == GameState[i+4][1] && GameState[i][1] == GameState[i+8][1]) {
			return true;
		}
		else if (i == 2 && GameState[i][1] == GameState[i+2][1] && GameState[i][1] == GameState[i+4][1]) {
			return true;
		}
		return false;
	}
}
