package ua.bubblegame;

import ua.bubblegame.players.ComputerPlayer;
import ua.bubblegame.players.RealPlayer;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(Services.readFieldFromFile("1.txt"));
		RealPlayer realPlayer = new RealPlayer("Vadym", BallsType.BLUE);
		ComputerPlayer computerPlayer = new ComputerPlayer("Android", BallsType.RED); 
		
		game.setPlayers(realPlayer, computerPlayer);
		System.out.println(game);
		
	}

}
