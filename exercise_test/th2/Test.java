package exercise_test.th2;

import exercise_test.Person;

public class Test {
	
	public static void main(String[] args) {
		Person person = new Person(22);
		
		Manager manager = new Manager(3);
		
		Thread1 thread1 = new Thread1(manager, person);
		Thread2 thread2 = new Thread2(manager, person);
		Thread3 thread3 = new Thread3(manager, person);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
