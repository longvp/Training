package exercise_test.thread;

import exercise_test.GeneralHandling;

public class Thread1 extends Thread{

	GeneralHandling generalHandling;
	
	public Thread1(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}
	
	@Override
	public void run() {
		generalHandling.work1();
	}
	
}
