package exercise_4.thread;

import java.util.ArrayList;
import java.util.List;

import exercise_4.Data;

public class ThreadC extends Thread{
	
	private List<Boolean> arrayResult = new ArrayList<Boolean>();
//	private List<Integer> listSearch = new ArrayList<Integer>();
	private Data data;
	
	public ThreadC(Data data, List<Boolean> arrayResult) {
		this.data = data;
		this.arrayResult = arrayResult;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Integer> listInput = data.getListInput();
		data.readFileSearch();
		List<Integer> listSearch = data.getListSearch();
		for(int i = 0; i < listSearch.size(); i++) {
			boolean result = false;
			for(int j = 0; j < listInput.size(); j++) {
				if(listSearch.get(i) == listInput.get(j)) {
					result = true;	
					break;
				}
			}
			arrayResult.add(result);
		}
	}

}
