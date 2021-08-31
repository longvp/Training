package exercise_4;

import java.util.ArrayList;
import java.util.List;

import exercise_4.thread.ThreadA;
import exercise_4.thread.ThreadB;
import exercise_4.thread.ThreadC;

public class Validator{
	
	private final List<Boolean> arrayResult = new ArrayList<Boolean>();
	
	public void solve() {
		Data data = new Data();
		data.readFileSearch();
		int length = data.getListSearch().size();
		
		ThreadB threadB = new ThreadB(data);
		ThreadC threadC = new ThreadC(data, arrayResult);
		ThreadA threadA = new ThreadA(data, arrayResult);
		
		threadB.start();
		threadC.start();
		threadA.start();
		
		int countAll = 0;
		int countBool = 0;
		while(countAll < 4 && countBool <= length) {
			synchronized (arrayResult) {
				for (Boolean b : arrayResult) {
					countBool++;
				}
				countAll++;
			}
		}
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
