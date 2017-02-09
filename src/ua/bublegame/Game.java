package ua.bublegame;

public class Game {

	private final static int SIZE_M = 10;	// Default height of game field
	private final static int SIZE_N = 10;	// Default width ...

	private int heightOfField;
	private int widthOfField;
	
	private int[][] field;					// Game field
	
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
	
	@Override
	public String toString(){
		String res = "Size: " + heightOfField + ":" + widthOfField + "\n";
		
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
