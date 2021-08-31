package exercise_4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
	
	private List<Integer> listInput = new ArrayList<Integer>();
	private List<Integer> listSearch = new ArrayList<Integer>();

	public List<Integer> getListInput() {
		return listInput;
	}

	public void setListInput(List<Integer> listInput) {
		this.listInput = listInput;
	}
	
	public List<Integer> getListSearch() {
		return listSearch;
	}

	public void setListSearch(List<Integer> listSearch) {
		this.listSearch = listSearch;
	}

	public Data() {
		try {
			File file = new File("ex_4_input.txt");
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				listInput.add(scanner.nextInt());
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readFileSearch(){
		try {
			List<Integer> list = new ArrayList<Integer>();
			File file = new File("ex_4_search.txt");
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				list.add(scanner.nextInt());
			}
			scanner.close();
			this.setListSearch(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
