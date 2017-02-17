package ua.bubblegame;

import ua.bubblegame.objects.BallsType;
import ua.bubblegame.objects.Game;
import ua.bubblegame.players.ComputerPlayer;
import ua.bubblegame.players.RealPlayer;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(Services.readFieldFromFile("1.txt"));
		//RealPlayer realPlayer = new RealPlayer("Vadym", BallsType.BLUE);
		ComputerPlayer computerPlayer = new ComputerPlayer("Android", BallsType.RED); 
		ComputerPlayer computerPlayer0 = new ComputerPlayer("Windows", BallsType.BLUE); 

		//game.setPlayers(realPlayer, computerPlayer);
		game.setPlayers(computerPlayer0, computerPlayer);
		
		do{
			System.out.println(game);
			game.nextSteep();

			try{
				System.in.read();
			}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}while(true);
	}

}
