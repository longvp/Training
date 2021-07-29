package exercise_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
	
	private ArrayList<Integer> list;
	
	public Data() {
		
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	
	public void readDataFromFile(String filePath) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		File file = new File(filePath);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				list.add(scanner.nextInt());
			}
			scanner.close();
			this.list =  list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
