package exercise_2;

import java.util.List;

import exercise_2.reading.ReadingConfigFile;
import exercise_2.reading.ReadingInputFile;
import exercise_2.writing.WritingInputFile;

public class Main {
	
	public static void main(String[] args) {		
		ReadingConfigFile config = new ReadingConfigFile();
		int Max_Thread = config.getMax_Thread();
		
//		WritingInputFile wif = new WritingInputFile();
//		wif.writeToFileInput("ex_2_input.txt");
		
		ReadingInputFile rif = new ReadingInputFile();
		List<Integer> list = rif.readFile("ex_2_input.txt");
		for(Integer i : list) {
			System.out.println(i);
		}
		
	}

}
