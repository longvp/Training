package exercise_test.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread2 extends Thread{

	private Person person;
	private Queue<Integer> results = new LinkedList<Integer>();
	
	public Thread2(Person person, Queue<Integer> results) {
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
		String[] arrStr = {"Dad.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list= mainApp.run();
		int age = Integer.parseInt(list.get(1));
		if(person.getAge() == age) {
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
