package ua.bubblegame;

/**
 * Balls type.
 * Red number 9
 * Blue number 8
 * @author Vadym
 *
 */
public enum BallsType {
	RED("Red", 0), BLUE("Blue", 0);
	
	private String _strData;
	private int numberEquivalent;
	
	private BallsType(String strData, int number){
		this._strData = strData;
		this.numberEquivalent = number;
	}
	
	@Override
	public String toString(){
		return this._strData;
	}
	
	public int getNumber(){
		return this.numberEquivalent;
	}
}
