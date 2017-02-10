package ua.bubblegame.players;

import ua.bubblegame.BallsType;

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
	
	
	
	public String getName(){
		return this.name;
	}

	public int getScore(){
		return this.score;
	}
	
	public BallsType getBallsType(){
		return this.ballsType;
	}
	
	public void setName(String val){
		this.name = val;
	}
	
	protected void setScore(int val){
		this.score = val;
	}
	
	public void setBallsType(BallsType val){
		this.ballsType = val;
	}
	
	
	public boolean getCanMakeSteep(){
		return this.canMakeMove;
	}
	
	public void setCanMakeSteep(boolean val){
		this.canMakeMove = val;
	}
	
}
