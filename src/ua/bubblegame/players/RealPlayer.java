package ua.bubblegame.players;

import ua.bubblegame.objects.BallsType;

public class RealPlayer extends Player {

	public RealPlayer(String name, BallsType type) {
		super(name, type);
	}
	
	@Override
	public int[] makeSteepFrom(int[][] field) {
		int row = 0, col = 0;
		// Получить координаты (нажатие по екрану) НЕОБХОДИМА МНОГО ПОТОЧНОСТЬ notify wait pair
		// Проверить можно ли походить
		// Вернуть точку или запросить повторное нажатие
		
		return new int[]{row, col};
	}
	

	@Override
	public int[] makeSteepTo(int[][] field, int row, int col) {

		int rowRes = 0, colRes = 0;
		// Алгоритм принятия решения куда ходить. Пока примитивно
		// Поиск куда можно походить
		
		return new int[]{rowRes, colRes};
	}
}
