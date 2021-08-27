package exercise_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import exercise_2.reading.ReadingConfigFile;
import exercise_2.reading.ReadingInputFile;
import exercise_2.writing.WritingInputFile;

public class Main {
	
	public static void main(String[] args) {		
		ReadingConfigFile config = new ReadingConfigFile();
		int Max_Thread = config.getMax_Thread();
		int Size_Array = config.getSize();
		
//		WritingInputFile wif = new WritingInputFile();
//		wif.writeToFileInput("ex_2_input.txt");
		
		ReadingInputFile rif = new ReadingInputFile();
		
		Integer[] arr = rif.readFile("ex_2_input.txt");
		Sort sort = new Sort();
		long startTime = System.currentTimeMillis();
		sort.threadSort(arr, Max_Thread);
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time : " + (endTime-startTime));
		
		// Benchmark
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			File file = new File("Benchmark.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			String s = Max_Thread + " Thread - " + Size_Array + 
					" phần tử ==> " + (endTime-startTime) + "ms" + "\n";
			bw.write(s);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

}
