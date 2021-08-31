package exercise_4.thread;

import java.util.ArrayList;
import java.util.List;

import exercise_4.Data;


public class ThreadA extends Thread{
	
	private List<Boolean> arrayResult = new ArrayList<Boolean>();
	private Data data;

	public ThreadA(Data data, List<Boolean> arrayResult) {
		this.data = data;
		this.arrayResult = arrayResult;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(arrayResult);
		System.out.println(data.getListSearch());
	}
	
}
