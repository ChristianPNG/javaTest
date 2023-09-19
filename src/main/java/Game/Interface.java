package Game;

import java.util.Scanner;

public class Interface {
	public void display() {
		
		int[][] GameState = new int[9][2];
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n");
		for (int i = 0; i<9; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.print("\n-+-+-\n");
			}
			if (GameState[i][0] == 1) {
				if(GameState[i][1] == 0) {
					System.out.print("O");
				}
				else {
					System.out.print("X");
				}
			}
			else {
				System.out.print(" ");
			}
			if (!((i+1)%3 == 0)){
				System.out.print("|");
			}
		}
		System.out.print("\nEnter your placement (1-9): ");
		while(true) {
			while(!scanner.hasNextInt()) {
				scanner.next();
				System.out.print("\n Wrong input, try again");
			}
			int num = scanner.nextInt();
			if (num > -1 && num <= 9) {
				System.out.print("\n Correct input");
				break;
			}
			else {
				System.out.print("\n Wrong input, try again");
			}
		}
		scanner.close();
	}
}
