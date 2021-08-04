package exercise_test.thread;

import exercise_test.GeneralHandling;

public class Thread4 extends Thread{
	
	GeneralHandling generalHandling;
	
	public Thread4(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}
	
	@Override
	public void run() {
		generalHandling.work4();
	}
	
}
