package exercise_4.thread;

import exercise_4.GeneralHandling;

public class ThreadA extends Thread{

	GeneralHandling generalHandling;
	
	public ThreadA(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}
	
	@Override
	public void run() {
		generalHandling.display();
	}
	
}
