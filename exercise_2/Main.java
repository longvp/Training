package exercise_2;

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
		
		Integer[] arr = rif.readFile("ex_2_input.txt");
		System.out.println("Length : " + arr.length);

		Sort sort = new Sort();
		long startTime = System.currentTimeMillis();
		sort.threadSort(arr, Max_Thread);
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time : " + (endTime-startTime));
		
	}

}
