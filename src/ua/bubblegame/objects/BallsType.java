package ua.bubblegame.objects;

/**
 * Balls type.
 * Red number 9
 * Blue number 8
 * @author Vadym
 *
 */
public enum BallsType {
	RED("Red", 9), BLUE("Blue", 8);
	
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
