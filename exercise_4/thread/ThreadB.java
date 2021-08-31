package exercise_4.thread;

import java.util.Collections;
import java.util.List;

import exercise_4.Data;

public class ThreadB extends Thread {

	private Data data;

	public ThreadB(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		List<Integer> listInput = data.getListInput();
		Collections.sort(listInput);
		data.setListInput(listInput);
		System.out.println("Sap xep: ");
		for (Integer i : listInput) {
			System.out.printf("%d ", i);
		}
		System.out.println();
	}

}
