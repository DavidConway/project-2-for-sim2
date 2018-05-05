/*
 * @author Leah
 * 
 * player class contains player constructor and several getters and setters
 */
public class Player {
	private String playerName, playerToken;
	private char token;

	/*
	 * @author Leah
	 * @edit david removed extra and redundent code
	 * constructor
	 */
	public Player(String playerName, String playerToken){
		if(playerName.length() > 20){
			this.playerName = playerName.substring(0, 20);
		}else{
			this.playerName = playerName;
		}
		token = playerToken.charAt(0);
	}

	/*
	 * @author Leah
	 * @edit david removed extra methods and corrected names
	 * getters and setters ^.^
	 */
	public char getPlayerToken(){
		return token;
	}
	
	public void setPlayerToken(){
		token = playerToken.charAt(0);
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		if(playerName.length() > 20){
			this.playerName = playerName.substring(0, 20);
		}else{
			this.playerName = playerName;
		}
	}
}
