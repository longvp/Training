package exercise_test.th2;

import java.util.List;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread1 extends Thread{
	
	private Manager manager;
	private Person person;
	
	public Thread1(Manager manager, Person person) {
		this.manager = manager;
		this.person = person;
	}
	
	@Override
	public void run() {
		String[] arrStr = {"Mom.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list = mainApp.run();
		String birthday = list.get(2);
		String[] str = birthday.split("-");
		int yearBorn = Integer.parseInt(str[2]);
		if(person.getAge() == 2022-yearBorn) {
			person.setName(list.get(1));
			person.setBirthday(birthday);
			manager.increaseCheck();
			System.out.println("Thread 1 - Check: " + manager.getCheck());
		} 
		manager.decreaseThread();
		System.out.println(manager.getNumberOfThread());
	}
	
}
