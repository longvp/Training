package exercise_test.thread;

import exercise_test.GeneralHandling;

public class Thread2 extends Thread{
	
GeneralHandling generalHandling;
	
	public Thread2(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}
	
	@Override
	public void run() {
		generalHandling.work2();
	}

}
