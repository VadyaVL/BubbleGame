package ua.bublegame;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(Services.readFieldFromFile("1.txt"));
		System.out.println(game);
	}

}
