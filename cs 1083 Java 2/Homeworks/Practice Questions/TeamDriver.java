import java.util.Scanner;
import java.util.HashMap;

class Player{
	private String name;
	private int number;

	public Player(String name){
		this.name = name;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return this.number;
	}

	public String getName(){
		return this.name;
	}
}

class Team{
	private String teamName;
	private int maxPlayer;
	private Player[] players;
	private int numberOfPlayers;
	private HashMap<Player, Integer> hashPlayers = new HashMap<Player, Integer>();
	private int playerCounter;

	public Team(String teamName, int maxPlayer){
		this.teamName = teamName;
		this.maxPlayer = maxPlayer;
		this.players = new Player[this.maxPlayer];
		this.numberOfPlayers = 0;
		this.playerCounter = 0;
	}

	public Boolean addPlayer(Player player){
		if(this.numberOfPlayers >= maxPlayer){
			return false;
		}

		if(this.hashPlayers.containsKey(player)){
			return false;
		}

		// set player number
		player.setNumber(this.playerCounter);
		this.playerCounter += 1;

		// add player
		int i;
		for(i = 0; i < this.maxPlayer; i++){
			if(this.players[i] != null){
				this.players[i] = player;
				break;
			}
		}

		// recode player
		this.hashPlayers.put(player, i);
		this.numberOfPlayers += 1;

		return true;
	}

	public Boolean removePlayer(Player player){
		if(this.hashPlayers.containsKey(player)){
			player.setNumber(-1);
			int index = this.hashPlayers.remove(player);
			this.players[index] = null;
			this.numberOfPlayers -= 1;

			return true;
		}
		return false;
	}

	public String[] getPlayers(){
		String[] playerList = new String[this.numberOfPlayers];
		int j = 0;
		for(int i = 0; i < this.maxPlayer; i ++){
			if(this.players[i] != null){
				playerList[j] = this.players[i].getName() + " " + this.players[i].getNumber();
				// System.out.println(this.players[i].getName());
			}
		}
		return playerList;
	} 



}

public class TeamDriver{

	public static void main(String[] args){

		Team myTeam = new Team("UNB V Reds", 4);
		Player p1 = new Player("Emily");
		Player p2 = new Player("Bob");
		Player p3 = new Player("John");
		Player p4 = new Player("Jill");
		Player p5 = new Player("Jack");
		
		System.out.println("Test adding players to a team:");
		System.out.println(myTeam.addPlayer(p1));
		System.out.println(myTeam.addPlayer(p2));
		System.out.println(myTeam.addPlayer(p3));
		System.out.println(myTeam.addPlayer(p4));

		System.out.println("Test adding player to a full team:");
		if(myTeam.addPlayer(p5)){
			System.out.println("Added Player:\n" + myTeam);
		}
		else{
			System.out.println("Player not added.");
		}
		
		System.out.println(myTeam.getPlayers());

		//what other test cases should be included?
	}
}
