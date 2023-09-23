package Game;

import java.util.Scanner;

public class Interface extends Game{
	public void display() {
		
		System.out.print("\n");
		for (int i = 0; i<9; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.print("\n-+-+-\n");
			}
			if (GameState[i][0] == 1) { //[][0] == SPOT TAKEN?
				if(GameState[i][1] == 2) { //[][1] == THE SHAPE
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
		
	}
	
	public void prompt(int coin) {
		System.out.print("\nEnter your placement (1-9): ");
		while(true) {
			//if scanner does not have nextInt. give an error
			//this is looped as its always waiting until the correct response is given
			while(!scanner.hasNextInt()) {
				scanner.next();
				System.out.print("\n Wrong input, try again");
			}
			//at this point we do have an int as our input
			int num = scanner.nextInt();
			if (num > 0 && num <= 9) {
				if (GameState[num - 1][0] == 1) {
					System.out.print("\n Spot is taken, try again");
					scanner.nextLine(); //flush the input stream if more than 1 input was given
					continue;
				}
				GameState[num - 1][0] = 1;
				if (coin == 1) {
					GameState[num - 1][1] = 2;
				}
				else {
					GameState[num - 1][1] = 1;
				}
				scanner.nextLine();
				break;
			}
			else {
				System.out.print("\n Wrong input, try again");
			}
		}
	}
}
