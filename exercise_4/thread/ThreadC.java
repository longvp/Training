package exercise_4.thread;

import exercise_4.GeneralHandling;

public class ThreadC extends Thread{
	
	GeneralHandling generalHandling;
	
	public ThreadC(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}
	
	@Override
	public void run() {
		generalHandling.search();;
	}

}
