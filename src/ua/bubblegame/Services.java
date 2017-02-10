package ua.bubblegame;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class Services {

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
	
}
