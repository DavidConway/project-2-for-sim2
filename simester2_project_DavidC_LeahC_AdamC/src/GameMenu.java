import java.util.Scanner;

/**
 * This menu class shows up first. It allows players to choose to play either
 * tic tac toe or connect four. It also allows users to load a previous game
 * or start a new game.
 * 
 * @author Leah Cullen-O'Leary
 * @version 1.0
 *
 */
public class GameMenu {
	private Scanner input;
	private Player player1 = new Player("defaltPlayer1","x");
	private Player player2 = new Player("defaltPlayer2","o");
	//private Bord game;
	PlayerList playerlist = new PlayerList(); //calls in the playerlist class
	
	public GameMenu() {
		try{
			playerlist.load();
		}catch(Exception e){
			System.out.println("Error reading player file");
		}
		input = new Scanner(System.in);
	}
	
	public static void main(String arg[]){
		GameMenu play = new GameMenu();
		play.gameMenu();
	}
	
	/*
	 * @author Leah
	 * 
	 * main game menu which allows players to choose one of two games to play
	 */
	private void gameMenu(){
		System.out.println("Game Menu!");
		System.out.println("~~~~~~~~~~~");
		System.out.println("Pick a game to play.");
		System.out.println("\t 1) Connect Four");
		System.out.println("\t 2) Tic Tac Toe");
		System.out.println("\t 0) Exit");
		System.out.println("Please enter your option ==>>");
		int choice = input.nextInt();
		switch(choice){
		case 1:
			connectFourMenu();
			break;
		case 2:
			ticTacToeMenu();
			break;
		default:
			System.out.println("Please enter a valid game option");
			break;
		}
	}
	
	
	/*
	 * @author Leah
	 * @edit david split the player choice into player 1 and 2. also added a start option, defalt player names and added a loop back to menu were needed
	 * allows player to enter what height and width game board they would like. its then followed by a new menu asking users to choose
	 * existing players or create new players. input is placed into the switch statements above
	 */
	private void connectFourMenu(){
		System.out.println("Do you want to play using existing players or set up new ones?");
		System.out.println("\t 1) Existing Player 1");
		System.out.println("\t 2) New Player 1");
		System.out.println("\t 3) Existing Player 2");
		System.out.println("\t 4) New Player 2");
		System.out.println("\t 5) start");
		System.out.println("player 1: "+player1.getPlayerName()+"  player 2: "+player2.getPlayerName());
		System.out.println("Please enter your option: ");
		int playerChoice = input.nextInt();
		switch(playerChoice){
		case 1:
			player1 = playerlist.getplayer();
			connectFourMenu();
			break;
		case 2:
			newPlayer1();
			connectFourMenu();
			break;
		case 3:
			player2 = playerlist.getplayer();
			connectFourMenu();
			break;
		case 4:
			newPlayer2();
			connectFourMenu();
			break;
		case 5:
			System.out.println("What height board do you want: ");
			int height = input.nextInt();
			System.out.println("What width board do you want: ");
			int width = input.nextInt();
			connect_4 game = new connect_4(player1.getPlayerToken(),player2.getPlayerToken(),width,height);
			game.play();
			break;
		default:
			System.out.println("Please enter a valid option");
			connectFourMenu();
			break;
		}
		System.out.println("Now exiting the game");
		System.out.println("See you next time!");
	}
	
	/*
	 * @author Leah
	 * @edit david split the player choice into player 1 and 2. also added a start option, defalt player names and added a loop back to menu were needed
	 * asks users to choose whether or not to create new players or choose existing players.
	 * input is placed into the switch statements above
	 */
	private void ticTacToeMenu(){
		System.out.println("Do you want to play using existing players or set up new ones?");
		System.out.println("\t 1) Existing Player");
		System.out.println("\t 2) New Player");
		System.out.println("\t 3) Existing Player 2");
		System.out.println("\t 4) New Player 2");
		System.out.println("\t 5) start");
		System.out.println("player 1: "+player1.getPlayerName()+"  player 2: "+player2.getPlayerName());
		System.out.println("Please enter your option: ");
		int playerChoice2 = input.nextInt();
		switch(playerChoice2){
		case 1:
			player1 = playerlist.getplayer();
			ticTacToeMenu();
			break;
		case 2:
			newPlayer1();
			ticTacToeMenu();
			break;
		case 3:
			player2 = playerlist.getplayer();
			ticTacToeMenu();
			break;
		case 4:
			newPlayer2();
			ticTacToeMenu();
			break;
		case 5:
			XAndO game = new XAndO(player1.getPlayerToken(),player2.getPlayerToken());
			game.play();
			break;
		default:
			System.out.println("Please enter a valid option");
			ticTacToeMenu();
			break;
		}
		System.out.println("Now exiting the game");
		System.out.println("See you next time!");
	}

	
	/*
	 * @author Leah
	 * @edit split new player into two seperit methods and ajusted the names
	 * allows players to add two new players to the game. it asks both players to choose their names and characters for their game
	 */
	private void newPlayer1(){
		System.out.println("Player 1. Please enter your name(max 20 chars): ");
		String playerName = input.nextLine();
		playerName = input.nextLine();
		
		System.out.println("Player 1. Please enter your token(max 1 character): ");
		String playerToken = input.nextLine();
		
		playerlist.add(new Player(playerName, playerToken));
		player1 = new Player(playerName, playerToken);
		try{
			playerlist.save();
		}catch(Exception e){
			System.out.println("Error saveing player file");
		}
	}
	
	
	private void newPlayer2() {
		System.out.println("Player 2. Please enter your name(max 20 chars): ");
		String playerName = input.nextLine();
		playerName = input.nextLine();
		
		System.out.println("Player 2. Please enter your token(max 1 character): ");
		String playerToken = input.nextLine();

		playerlist.add(new Player(playerName, playerToken));
		player2 = new Player(playerName, playerToken);
		try{
			playerlist.save();
		}catch(Exception e){
			System.out.println("Error saveing player file");
		}
	}
}
