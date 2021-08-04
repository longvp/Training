package exercise_test;

import exercise_test.thread.Thread1;
import exercise_test.thread.Thread2;
import exercise_test.thread.Thread3;
import exercise_test.thread.Thread4;

public class TestApp {
	
	public static void main(String[] args) {
		
		Person person = new Person(22);
		
		GeneralHandling gh = new GeneralHandling(person);
			
		Thread1 thread1 = new Thread1(gh);
		Thread2 thread2 = new Thread2(gh);
		Thread3 thread3 = new Thread3(gh);
		Thread4 thread4 = new Thread4(gh);
		
		thread1.start();
		thread2.start();	
		thread3.start();
		thread4.start();
		
	}
	
}
