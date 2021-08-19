package exercise_test.th2;

import java.util.List;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread3 extends Thread{
	
	private Manager manager;
	private Person person;
	
	public Thread3(Manager manager, Person person) {
		this.manager = manager;
		this.person = person;
	}
	
	@Override
	public void run() {
		String[] arrStr = {"UBND.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list= mainApp.run();
		String birthday = list.get(6);
		String[] str = birthday.split("-");
		int yearBorn = Integer.parseInt(str[2]);
		if(person.getAge() == 2022-yearBorn) {
			person.setAddress(list.get(1));
			person.setName(list.get(3));
			person.setNameFather(list.get(4));
			person.setNameMother(list.get(5));
			person.setBirthday(list.get(6));
			manager.increaseCheck();
			System.out.println("Thread 3 - Check: " + manager.getCheck());
		}
		manager.decreaseThread();
		System.out.println(manager.getNumberOfThread());
	}

}
