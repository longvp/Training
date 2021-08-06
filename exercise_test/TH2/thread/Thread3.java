package exercise_test.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread3 extends Thread{
	
	private Person person;
	private Queue<Integer> results = new LinkedList<Integer>();
	
	public Thread3(Person person, Queue<Integer> results) {
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
