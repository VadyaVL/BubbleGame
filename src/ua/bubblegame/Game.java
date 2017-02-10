package ua.bubblegame;

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
		
		if(firstMakeSteep){	// first player make steep
			
		}
		else{				// second player make steep
			
		}
		
		// Check can player make steep
		// click on player ball
		// check can player make steep from this ball
		// click on empty cell | anywhere
		// make click, next player
		// repeat to end
		
	}
	
	/**
	 * 
	 * @param player check opportunity make steep for this player
	 * @return
	 */
	private boolean checkCanPlayerMakeSteep(Player player){
		boolean result = true;
		int ballsTypeNumber = player.getBallsType().getNumber();
		
		// Need check for every balls of this player opportunity make steep
		// if ball has near empty
		
		return result;
	}
	
	@Override
	public String toString(){
		String res = "Size: " + heightOfField + ":" + widthOfField + "\n";

		res += "Player 1: " + _playerOne.getName() + " (" + _playerOne.getScore() + ")\n";
		res += "Player 2: " + _playerTwo.getName() + " (" + _playerTwo.getScore() + ")\n";
		
		for(int i=0; i<heightOfField; i++){
			for(int j=0; j<widthOfField; j++){
				res += field[i][j] + " ";
			}
			res += "\n";
		}
		
		return res;
	}
	
	/**
	 * 
	 * @return count of row field
	 */
	public int getFieldHeight(){
		return this.heightOfField;
	}

	/**
	 * 
	 * @return count of column field
	 */
	public int getFieldWidth(){
		return this.widthOfField;
	}
}
