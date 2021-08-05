package exercise_test.threadcountdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread3 extends Thread{
	
	private CountDownLatch countDownLatch;
	private Person person;
	
	public Thread3(CountDownLatch countDownLatch, Person person) {
		this.countDownLatch = countDownLatch;
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
			CHECK.numberCheck++;
		}
		countDownLatch.countDown();
	}

}
