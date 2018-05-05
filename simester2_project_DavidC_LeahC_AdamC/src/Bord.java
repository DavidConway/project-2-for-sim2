// 
	// DC
public class Bord {
	int width,height;//sets up vereabuls
	char[][] position_s; 
	char player_1,player_2;
	boolean player1Turn = true;
	boolean GameOver = false;
	//Player player;
	
	Bord(char player_1s, char player_2s){//comen constructor
		//player = new Player(); 
		player_1 = player_1s;//oneRoken();
		player_2 = player_2s;//twoToken();
	}

	void winCheck(){
		if(width ==3 & height==3){ //checks if x and o bord is 3 by 3
			for (int i=0; i<3; i++) {
				if ((position_s[0][i] == (player_1) && position_s[1][i] == (player_1) && position_s[2][i] == (player_1))|// tests all possible win conditions
					(position_s[0][i] == (player_2) && position_s[1][i] == (player_2) && position_s[2][i] == (player_2))|// note (player_1|player_2) dose not work
					(position_s[i][0] == (player_1) && position_s[i][1] == (player_1) && position_s[i][2] == (player_1))|
					(position_s[i][0] == (player_2) && position_s[i][1] == (player_2) && position_s[i][2] == (player_2))|
					(position_s[0][0] == (player_1) && position_s[1][1] == (player_1) && position_s[2][2] == (player_1))|
					(position_s[2][0] == (player_2) && position_s[1][1] == (player_2) && position_s[0][2] == (player_2))) {
					
					if (player1Turn) {
						System.out.println(player_1 + " wins");//checks to see if the game was won on player ones turn and respons
					}
					else {
						System.out.println(player_2 + " wins");//if it wasten player ones turn then states two won
					}
					GameOver = true;
				}
				else {//if the game isen't won
					/*for (int x = 0; x<width; x++){// runes torow all of the position aray
						
						for (int y = 0; y<height; y++){
							if (position_s[x][y] == '.'){// checks if all the spaces are full and ses its a tie if it is
								player1Turn = !player1Turn;
							}
							else{
								System.out.println("Tie!");
								GameOver = true;	// if the game isent won or ties it changes the players turn
							}
						}
					}*/
				}
			}
		}
		else{// same as x and o whith logical changes
			for (int x = 0; x <= width-4; x++) {
				for (int y = 0; y <= height -4; y++) {
					if ((position_s[x][y] == (player_1) && position_s[x+1][y] == (player_1) && position_s[x+2][y] == (player_1) && position_s[x+3][y] == (player_1))|
						(position_s[x][y] == (player_2) && position_s[x+1][y] == (player_2) && position_s[x+2][y] == (player_2) && position_s[x+3][y] == (player_2))|
						(position_s[x][y] == (player_1) && position_s[x][y+1] == (player_1) && position_s[x][y+2] == (player_1) && position_s[x][y+3] == (player_1))|
						(position_s[x][y] == (player_2) && position_s[x][y+1] == (player_2) && position_s[x][y+2] == (player_2) && position_s[x][y+3] == (player_2))|
						(position_s[x][y] == (player_1) && position_s[x+1][y+1] == (player_1) && position_s[x+2][y+2] == (player_1) && position_s[x+3][y+3] == (player_1))|
						(position_s[x][y] == (player_2) && position_s[x+1][y+1] == (player_2) && position_s[x+2][y+2] == (player_2) && position_s[x+3][y+3] == (player_2))|
						(position_s[((width-1) -(x))][((height-1) -(y))] == (player_1) && position_s[((width-1) -(x))-1][((height-1) -(y))-1] == (player_1) && position_s[((width-1) -(x))-2][((height-1) -(y))-2] == (player_1) && position_s[((width-1) -(x))-3][((height-1) -(y))-3] == (player_1))|
						(position_s[((width-1) -(x))][((height-1) -(y))] == (player_2) && position_s[((width-1) -(x))-1][((height-1) -(y))-1] == (player_2) && position_s[((width-1) -(x))-2][((height-1) -(y))-2] == (player_2) && position_s[((width-1) -(x))-3][((height-1) -(y))-3] == (player_2))){
						
						if (player1Turn) {
							System.out.println(player_1 + " wins");
						}
						else {
							System.out.println(player_2 + " wins");
						}
						GameOver = true;
						
						
					}
					else {
						/*for (int a = 0; a<width; a++){
							for (int b = 0; b<height; b++){
								if (position_s[a][b] == '.'){	
									player1Turn = !player1Turn;	
								}
								else{
									System.out.println("Tie!");
									GameOver = true;	
								}
							}
						}*/
					}
				}
			}
		}
	}
}
	//
//
