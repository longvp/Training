package exercise_4.thread;

import exercise_4.GeneralHandling;

public class ThreadB extends Thread{
	
	GeneralHandling generalHandling;
	
	public ThreadB(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}
	
	@Override
	public void run() {
		generalHandling.sort();
	}

}
