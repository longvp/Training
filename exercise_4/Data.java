package exercise_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
	
	private List<Integer> list = new ArrayList<Integer>();
	
	public Data() {
		
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	public List<Integer> readDataFromFile(String filePath) {
		File file = new File(filePath);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				list.add(scanner.nextInt());
			}
			scanner.close();
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
