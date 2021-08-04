package exercise_test;

import exercise_test.thread.Thread1;
import exercise_test.thread.Thread2;
import exercise_test.thread.Thread3;
import exercise_test.thread.Thread4;

public class TestApp {
	
	public static void main(String[] args) {
		
		Person person = new Person(22);
		
		GeneralHandling gh = new GeneralHandling(person);
			
		Thread1 thread1 = new Thread1(gh); // CHECK FILE Mom.dat
		Thread2 thread2 = new Thread2(gh); // CHECK FILE Dad.dat
		Thread3 thread3 = new Thread3(gh); // CHECK FILE UBND.dat
		Thread4 thread4 = new Thread4(gh); // WRITE IN TO FILE result.bin
		
		thread1.start();
		thread2.start();	
		thread3.start();
		thread4.start();
		
	}
	
}
