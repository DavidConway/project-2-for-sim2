import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/*
 * @author Leah
 * @edit fixed load and save. set david.help to false and removed useles methods
 * this class contains the arraylist which holds all players. it also contains save and load functions
 * 
 * 
 */

public class PlayerList {
	private Scanner input  = new Scanner(System.in);
	private ArrayList<Player>players;
	
	public PlayerList(){
		players = new ArrayList<Player>();
	}
	
	public void add(Player player){
		players.add(player);
	}
	
	public void load() throws Exception{
		
    	 System.out.println("Loading player details...");
    	 XStream xstream = new XStream(new DomDriver());
    	 ObjectInputStream is = xstream.createObjectInputStream
    	 (new FileReader("players.xml"));
    	 players = (ArrayList<Player>) is.readObject();
    	 is.close();
	}
	
	@SuppressWarnings("Unchecked")
	 public void save() throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("players.xml"));
        out.writeObject(players);
        out.close();    
    }
	
	public Player getplayer() {
		String out = "";
		int i = 0;
		for (Player playerOut: players){
			out += ("("+i+")"+playerOut.getPlayerName()+ " "+playerOut.getPlayerToken() + "\n");
			i++;
			}
		System.out.println(out);
		System.out.println("Please enter your player choice ==>>");
		int choice = input.nextInt();
		if(choice <= players.size()) {
			return players.get(choice);
		}
		System.out.println("invaled chouce");
		return getplayer();
	}
}
