import java.util.Scanner;

public class XAndO extends Bord {
	public Scanner input = new Scanner(System.in);
	char player = player_1;
	
	XAndO(char player_1s, char player_2s){//width and height is 3 and 3 in x an o so you do not need them in constructor
		super(player_1s,player_2s);//sends player 1 and 2 cymbals to the board constructor
		width =3;// sets width to 3
		height =3;// sets height to 3
		position_s = new char [3][3]; 
		char c = '1';
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				position_s[i][j] = c;
				c++;
			}
		}
	}
	
	/**
	 * @author Adam Cotter
	 * @return returns the tictactoe board
 	 */
	public String drawBoard() {
		String boardString = "";
		for(int h=0;h<3;h++) {
			for(int w=0;w<3;w++) {
				boardString += "| " + position_s[h][w] + " ";
			}
			boardString += "|\n";
			for(int w=0;w<3;w++) {
				boardString += "----";
			}
			boardString += "-\n";
		}
		return boardString;
	}
	
	/**
	 * @author Adam Cotter
	 * Takes the input from the console and places the player's char in the chosen cell
	 * Switches char each time
	 */
	void play() {
		System.out.println(drawBoard());
		do {
			System.out.println("It is "+player+"'s turn. Please choose a row (1 - 3): ");
			int row = input.nextInt() -1;
			System.out.println("Please choose a column(1 - 3): ");
			int col = input.nextInt() -1;
			
			if((position_s[row][col] == 'X')||(position_s[row][col] == 'O')){
				System.out.println("This space is taken. Please choose another row: ");
				row = input.nextInt() - 1;
				System.out.println("And column: ");
				col = input.nextInt() - 1;
				position_s[row][col] = player;
				
			}
			
			position_s[row][col] = player;
			System.out.println(drawBoard());
			winCheck();
			player1Turn = !player1Turn;
			if(player1Turn) {
				player = player_1;
			}
			else {
				player = player_2;
			}
		}while(GameOver == false);
	}
}
