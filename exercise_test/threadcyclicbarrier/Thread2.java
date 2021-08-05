package exercise_test.threadcyclicbarrier;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread2 extends Thread{
	
	private CyclicBarrier cyclicBarrier;
	private Person person;
	private boolean check;
	
	public Thread2 (CyclicBarrier cyclicBarrier, Person person) {
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
		System.out.println("Thread 2 start ...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String[] arrStr = {"Dad.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list= mainApp.run();
		int age = Integer.parseInt(list.get(1));
		if(person.getAge() == age) {
			this.setCheck(true);
		}
		System.out.println("Thread 2 finished ...  waiting for other ...");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
