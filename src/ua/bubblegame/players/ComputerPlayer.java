package ua.bubblegame.players;

import ua.bubblegame.Services;
import ua.bubblegame.objects.BallsType;

public class ComputerPlayer extends Player {

	public ComputerPlayer(String name, BallsType type) {
		super(name, type);
	}

	@Override
	public int[] makeSteepFrom(int[][] field) {
		int rowRes = -1, colRes = -1;
		// Алгоритм принятия решения откуда ходить. Пока примитивно
		// Поиск с какой можно походить
		int heightOfField = field.length;
		
		if(heightOfField<0)
			return new int[]{rowRes, colRes};	// Улучшить. Соседство от и до не пройдет
		
		int widthOfField = field[0].length;
		int ballsTypeNumber = getBallsType().getNumber();
		
		exitAfterFindFirst:
		for(int row=0; row<heightOfField; row++){
			for(int col=0; col<widthOfField; col++ ){
				if(field[row][col] == ballsTypeNumber){
					// Check on clear cell
					if(Services.checkOnClearCell(field, row, col)){
						rowRes = row;
						colRes = col;
						break exitAfterFindFirst;
					}
				}
			}
		}
		
		return new int[]{rowRes, colRes};
	}

	@Override
	public int[] makeSteepTo(int[][] field, int row, int col) {

		int rowRes = -1, colRes = -1;
		// Алгоритм принятия решения куда ходить. Пока примитивно
		// Поиск куда можно походить
		int heightOfField = field.length;
		
		if(heightOfField<0)
			return new int[]{rowRes, colRes};;
		
		int widthOfField = field[0].length;
		
		int bRow = row - 1 >= 0 ? row - 1 : 0;
		int eRow = row + 1 < heightOfField ? row + 1 : heightOfField - 1;

		int bCol = col - 1 >= 0 ? col - 1 : 0;
		int eCol = col + 1 < widthOfField ? col + 1 : widthOfField - 1;
		
		exitAfterFindFirst:
		for(int curRow = bRow; curRow <= eRow; curRow++){
			for(int curCol = bCol; curCol <= eCol; curCol++){
				if(field[curRow][curCol]==0){
					rowRes = curRow;
					colRes = curCol;
					break exitAfterFindFirst;
				}
			}
		}
		
		return new int[]{rowRes, colRes};
	}

}
