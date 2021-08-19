package exercise_test.th2;

import java.util.List;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread2 extends Thread{

	private Manager manager;
	private Person person;
	
	public Thread2(Manager manager, Person person) {
		this.manager = manager;
		this.person = person;
	}
	
	@Override
	public void run() {
		String[] arrStr = {"Dad.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list= mainApp.run();
		int age = Integer.parseInt(list.get(1));
		if(person.getAge() == age) {
			manager.increaseCheck();
			System.out.println("Thread 2 - Check: " + manager.getCheck());
		}
		manager.decreaseThread();
		System.out.println(manager.getNumberOfThread());
	}
	
}
