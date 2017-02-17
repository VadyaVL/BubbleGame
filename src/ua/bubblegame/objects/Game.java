package ua.bubblegame.objects;

import ua.bubblegame.Services;
import ua.bubblegame.players.Player;

public class Game {

	private final static int SIZE_M = 10;	// Default height of game field
	private final static int SIZE_N = 10;	// Default width ...

	private int heightOfField;
	private int widthOfField;
	
	private int[][] field;					// Game field

	private boolean firstMakeSteep = true;	// first player make steep if true
	private Player _playerOne;
	private Player _playerTwo;
	
	/**
	 * Create game with field by default size.
	 */
	public Game(){
		this(SIZE_M, SIZE_N);
	}
	
	/**
	 * Create game with field.
	 * @param height count of row field
	 * @param width count of column field
	 */
	public Game(int height, int width){
		heightOfField = height;
		widthOfField = width;
		
		field = new int[heightOfField][widthOfField];
	}
	
	/**
	 * Create game with field by field from input array.
	 * @param inputField array read from file
	 */
	public Game(int[][] inputField){
		heightOfField = inputField.length;
		widthOfField = inputField[0].length;
		
		field = inputField.clone();
	}
	
	public void setPlayers(Player playerOne, Player playerTwo){
		setPlayerOne(playerOne);
		setPlayerTwo(playerTwo);
	}
	
	private void setPlayerOne(Player player){
		this._playerOne = player;
	}
	
	private void setPlayerTwo(Player player){
		this._playerTwo = player;
	}
	
	/**
	 * Make next game steep by computer or real player.
	 */
	public void nextSteep(){
		
		if(_playerOne == null || _playerTwo == null){
			return;
		}
		
		Player currentPlayer = firstMakeSteep ? _playerOne : _playerTwo;
		
		// Check can player make steep
		if(checkCanPlayerMakeSteep(currentPlayer)){
			System.out.println(currentPlayer + " can make steep");

			int[] coordFrom = currentPlayer.makeSteepFrom(field); // get coord from ball for steep
			System.out.println("Make steep from: " + coordFrom[0] + "x" + coordFrom[1]);
				
			int[] coordTo = currentPlayer.makeSteepTo(field, coordFrom[0], coordFrom[1]); // get coord from ball for steep
			System.out.println("Make steep to: " + coordTo[0] + "x" + coordTo[1]);
			// ѕроверить на соседство		
			if(Services.isNeighbors(coordFrom, coordTo))
				System.out.println("It\'s normal steep!");
			else
				System.out.println("It\'s not normal steep!");

			// make steep
			field[coordTo[0]][coordTo[1]] = currentPlayer.getBallsType().getNumber();
			currentPlayer.incrementScore();
			
			// click on empty cell - make click
			// | anywhere - reset and remake steep
			// next player
			
			firstMakeSteep = !firstMakeSteep;
		}
		else{
			System.out.println(currentPlayer + " can't make steep");
			// We can mark win or lose player
			firstMakeSteep = !firstMakeSteep;
		}
		System.out.println("-*-*-*-*-*-*-*-*-*-");

		// repeat to end
	}
	
	/**
	 * 
	 * @param player check opportunity make steep for this player
	 * @return
	 */
	private boolean checkCanPlayerMakeSteep(Player player){
		// Need check for every balls of this player opportunity make steep
		// if ball has near empty
		return Services.checkBallTypeMakeSteep(field, player.getBallsType().getNumber());
	}
	
	@Override
	public String toString(){
		String res = "Size: " + heightOfField + ":" + widthOfField + "\n";

		res += "Player 1: " + _playerOne.getName() + " (" + _playerOne.getScore() + ")\n";
		res += "Player 2: " + _playerTwo.getName() + " (" + _playerTwo.getScore() + ")\n";
		
		for(int i=0; i<heightOfField; i++){
			for(int j=0; j<widthOfField; j++){
				//res += field[i][j] + " ";
				if(field[i][j]==0)
					res += " ";
				else if(field[i][j]==1)
					res += "*";
				else if(field[i][j]==9)
					res += "E";
				else if(field[i][j]==8)
					res += "M";
				else
					res += "U";
			}
			res += "\n";
		}
		
		return res;
	}
	
	/**
	 * 
	 * @return count of row field
	 */
	public final int getFieldHeight(){
		return this.heightOfField;
	}

	/**
	 * 
	 * @return count of column field
	 */
	public final int getFieldWidth(){
		return this.widthOfField;
	}
}

/*
ѕосл≥овн≥сть д≥й:
1) ѕерев≥р€Їмо чи гравець може зд≥йснити х≥д.
   якщо н≥, то к≥нець гри.
2) якщо може зд≥йснити х≥д, обираЇмо кульку натиском.
   якщо з нењ можна зд≥йснити х≥д, позначаЇмо њњ активною.
   якщо н≥ н≥чого не робимо, пропонуЇмо ще кл≥кнути.
3) ќбравши кульку - кл≥каЇмо по позиц≥њ куди п≥ти
   якщо порожньо, робимо х≥д ≥ переходимо до ≥ншого гравц€.
   якщо не порожньо скидаЇмо активну кульку
4) ≤ так повторюЇмо до виграшу чи програшу одного з гравц≥в.
5) –ахуЇмо к≥льк≥сть очок кожного.
*/