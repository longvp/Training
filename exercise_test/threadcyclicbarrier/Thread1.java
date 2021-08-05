package exercise_test.threadcyclicbarrier;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread1 extends Thread{
	
	private CyclicBarrier cyclicBarrier;
	private Person person;
	private boolean check;
	
	public Thread1 (CyclicBarrier cyclicBarrier, Person person) {
		this.cyclicBarrier = cyclicBarrier;
		this.person = person;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	@Override
	public void run() {
		System.out.println("Thread 1 start ...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
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
			this.setCheck(true);
		}
		System.out.println("Thread 1 finished ... waiting for other ...");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}
