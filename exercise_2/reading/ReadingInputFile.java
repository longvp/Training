package exercise_2.reading;

import java.io.File;
import java.util.Scanner;

public class ReadingInputFile {
	
//	public List<Integer> readFile(String filePath){
//		List<Integer> list = new ArrayList<Integer>();
//		try {
//			File file = new File(filePath);
//			Scanner scanner = new Scanner(file);
//			while(scanner.hasNext()) {
//				list.add(scanner.nextInt());
//			}
//			scanner.close();
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public Integer[] readFile(String filePath){
		ReadingConfigFile config = new ReadingConfigFile();
		Integer[] arr = new Integer[config.getSize()];
		try {
			File file = new File(filePath);
			Scanner scanner = new Scanner(file);
			int i = 0;
			while(scanner.hasNext()) {
				arr[i] = scanner.nextInt();
				i++;
			}
			scanner.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
