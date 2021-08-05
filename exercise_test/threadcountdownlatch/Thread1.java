package exercise_test.threadcountdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread1 extends Thread{
	
	
	private CountDownLatch countDownLatch;
	private Person person;
	
	public Thread1(CountDownLatch countDownLatch, Person person) {
		this.countDownLatch = countDownLatch;
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
			CHECK.numberCheck++;
		}
		countDownLatch.countDown();
	}
	

}
