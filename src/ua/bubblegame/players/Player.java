/**
 * Потрібно обдумати механізм, який дозволивби крае використати методи
 * 	public abstract int[] makeSteepFrom(int[][] field);
 *	public abstract int[] makeSteepTo(int[][] field, int row, int col);
 *
 *  Поглянути на те, як можна обійтися без передачі параметра field. Поглянути в шаблони проектування. 
 */
package ua.bubblegame.players;

import ua.bubblegame.objects.BallsType;

public abstract class Player {
	
	private String name;			// Player name
	private int score;				// Current player score
	private BallsType ballsType;	// current balls type
	
	private boolean canMakeMove = true;	//
	
	/**
	 * 
	 * @param name Player nickname, user name, etc
	 * @param type type of balls, as the same color
	 */
	public Player(String name, BallsType type){
		setName(name);
		setScore(0);
		setBallsType(type);
	}
	
	public abstract int[] makeSteepFrom(int[][] field);
	
	public abstract int[] makeSteepTo(int[][] field, int row, int col);
	
	@Override
	public String toString(){
		return "Player(" + name + ")";
	}
	
	public final String getName(){
		return this.name;
	}

	public final int getScore(){
		return this.score;
	}
	
	public final BallsType getBallsType(){
		return this.ballsType;
	}
	
	public final void setName(String val){
		this.name = val;
	}
	
	protected final void setScore(int val){
		this.score = val;
	}
	
	public void incrementScore(){
		this.score++;
	}
	
	public final void setBallsType(BallsType val){
		this.ballsType = val;
	}
	
	
	public final boolean getCanMakeSteep(){
		return this.canMakeMove;
	}
	
	public final void setCanMakeSteep(boolean val){
		this.canMakeMove = val;
	}
	
}
