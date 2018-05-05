import java.util.Scanner;

//
	//DC
public class connect_4 extends Bord{
	public char placeholder = '.';
	public Scanner input = new Scanner(System.in);
	
	connect_4(char player_1s, char player_2s,int width, int height){//constructor with width and height
		super(player_1s, player_2s); //sends player 1 and 2 cymbals to the Bord constructor
		 //sets up the array
		this.width = width;
		this.height = height;
		position_s = new char [width][height];
		for (int i =0; i<width; i++){
			for (int x =0; x<height; x++){// sets all positions status to .
				position_s[i][x] = '.';
			}
	
		}
	}
	//
//DC
// AC
	//
	public String drawBoard() {
		String boardString = "";
		int i = 1;
		while(i <= width) {
			boardString += "--"+i+"-";
			i++;
		}
		
		boardString += "-\n";
		
		for(int h=0;h<width;h++) {
			for(int w=0;w<height;w++) {
				boardString += "| " + position_s[h][w] + " ";
			}
			boardString += "|\n";
			for(int w=0;w<width;w++) {
				boardString += "----";
			}
			boardString += "-\n";
		}
		
		
		return boardString;
		
	}
	
	public void play() {
		char player;
		System.out.println(drawBoard());
		do {
		if(player1Turn) {
			player = player_1;
		}
		else {
			player = player_2;
		}
		
		System.out.print("Player "+player+"'s Turn: chouse colom ");
		int choice = input.nextInt()-1;
		
			
		if(!(0<=choice && choice < width)) {
			System.out.println("Choice is out of bounds!");
			play();
		}
			
		for(int i = height-1;i>=0; i--) {
			if(position_s[i][choice]==placeholder) {
				position_s[i][choice] = player;
				break;
			}
			if(i==0) {
				System.out.println("This column is full.");
			}
		}
		System.out.println(drawBoard());
		winCheck();
		player1Turn = !player1Turn;
		}while(GameOver == false);
    }
}
	//
//AC

