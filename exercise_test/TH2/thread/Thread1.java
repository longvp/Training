package exercise_test.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread1 extends Thread{
	
	private Person person;
	private Queue<Integer> results = new LinkedList<Integer>();
	
	public Thread1(Person person, Queue<Integer> results) {
		this.person = person;
		this.results = results;
	}
	
	public synchronized void xuly() {
		while(results.isEmpty()) {
			try {
				results.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String[] arrStr = {"Mom.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list = mainApp.run();
		String birthday = list.get(2);
		String[] str = birthday.split("-");
		int yearBorn = Integer.parseInt(str[2]);
		if(person.getAge() == 2022-yearBorn) {
			person.setName(list.get(1));
			person.setBirthday(birthday);
			results.add(1);
			results.notifyAll();
		}
	}
	
	@Override
	public void run() {
		while(results.size() != 2) {
			xuly();
		}
	}
	
}
