package ua.bublegame;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class Services {

	public static int[][] readFieldFromFile(String inputFile){
		int[][] result = null;
		
		Path path = Paths.get(inputFile);
		
		if(!Files.exists(path))
			return null;
		
		try{
			List<String> lines = Files.readAllLines(path);
			
			int m = lines.size();
			result = new int[m][];
			
			for (int i=0; i<m; i++) {
				String[] numbers = lines.get(i).split(" ");
				
				int n=numbers.length;
				
				result[i] = new int[n];
				for(int j=0; j<n; j++){
					result[i][j] = Integer.parseInt(numbers[j]);
				}
			}
		}
		catch(Exception ex){
			return null;
		}
		
		return result;
	}
	
}
