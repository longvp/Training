package exercise_test.threadcountdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread2 extends Thread{
	
	private CountDownLatch countDownLatch;
	private Person person;
	
	
	public Thread2(CountDownLatch countDownLatch, Person person) {
		this.countDownLatch = countDownLatch;
		this.person = person;
	}
	
	@Override
	public void run() {
		String[] arrStr = {"Dad.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list= mainApp.run();
		int age = Integer.parseInt(list.get(1));
		if(person.getAge() == age) {
			CHECK.numberCheck++;
		}
		countDownLatch.countDown();
		
	}

}
