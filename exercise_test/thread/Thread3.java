package exercise_test.thread;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread3 extends Thread{
	
	private CyclicBarrier cyclicBarrier;
	private Person person;
	private boolean check;
	
	public Thread3 (CyclicBarrier cyclicBarrier, Person person) {
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
		System.out.println("Thread 3 start ...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
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
			this.setCheck(true);
		}
		System.out.println("Thread 3 finished ...  waiting for other ...");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
