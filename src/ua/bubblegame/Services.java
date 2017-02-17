package ua.bubblegame;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class Services {

	/**
	 * Read field from txt file
	 * @param inputFile
	 * @return
	 */
	public static int[][] readFieldFromFile(String inputFile){
		
		Path path = Paths.get(inputFile);
		
		if(!Files.exists(path)){
			return null;
		}
		
		try{
			List<String> lines = Files.readAllLines(path);
			int m = lines.size();
			int[][]  result = new int[m][];
			
			for (int i=0; i<m; i++) {
				String[] numbers = lines.get(i).split(" ");
				
				int n = numbers.length;
				result[i] = new int[n];
				
				for(int j=0; j<n; j++){
					result[i][j] = Integer.parseInt(numbers[j]);
				}
			}
			return result;
		}
		catch(Exception ex){
			return null;
		}
		
	}
	

	/**
	 * Проверка можно ли для определенного типа мяча сделать ход.
	 * @param ballsTypeNumber числовое представления типа мяча
	 * @return
	 */
	public static boolean checkBallTypeMakeSteep(int[][] field, int ballsTypeNumber){
		
		int heightOfField = field.length;
		
		if(heightOfField<0)
			return false;
		
		int widthOfField = field[0].length;
		
		for(int row=0; row<heightOfField; row++){
			for(int col=0; col<widthOfField; col++ ){
				if(field[row][col] == ballsTypeNumber){
					// Check on clear cell
					if(checkOnClearCell(field, row, col)){
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Check 3x3 area on clear cell
	 * @param row
	 * @param col
	 * @return
	 */
	public static boolean checkOnClearCell(int[][] field, int row, int col){
		
		int heightOfField = field.length;
		
		if(heightOfField<0)
			return false;
		
		int widthOfField = field[0].length;
		
		int bRow = row - 1 >= 0 ? row - 1 : 0;
		int eRow = row + 1 < heightOfField ? row + 1 : heightOfField - 1;

		int bCol = col - 1 >= 0 ? col - 1 : 0;
		int eCol = col + 1 < widthOfField ? col + 1 : widthOfField - 1;
		
		boolean res = false;

		exitFromCycle:
		for(int curRow = bRow; curRow <= eRow; curRow++){
			for(int curCol = bCol; curCol <= eCol; curCol++){
				if(field[curRow][curCol]==0){
					res = true;
					break exitFromCycle; // Проверка работы с goto в java... Лучше не юзать...
				}
			}
		}
		
		return res;
	}

	// Проверка соседние ли координаты
	public static boolean isNeighbors(int[] v1, int[] v2){
		
		if(v1.length!=2 || v2.length!=2 || (v1[0]==v2[0] && v2[1]==v2[1]))
			return false;

		int n1 = Math.abs(v1[0]-v2[0]);
		int n2 = Math.abs(v1[1]-v2[1]);
		
		return n2==1 || n1==1;
		
	}
	
}
