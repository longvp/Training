package exercise_test.thread;

import exercise_test.GeneralHandling;

public class Thread3 extends Thread{
	
GeneralHandling generalHandling;
	
	public Thread3(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}
	
	@Override
	public void run() {
		generalHandling.work3();
	}

}
