package exercise_4;

import exercise_4.thread.ThreadA;
import exercise_4.thread.ThreadB;
import exercise_4.thread.ThreadC;

public class Main {

	public static void main(String[] args) {
		GeneralHandling gh = new GeneralHandling();
		
		ThreadA threadA = new ThreadA(gh);
		ThreadB threadB = new ThreadB(gh);
		ThreadC threadC = new ThreadC(gh);
		
		threadB.start();
		threadC.start();
		threadA.start();
		
	}

}
 