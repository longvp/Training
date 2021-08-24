package exercise_test.th2;

import java.util.List;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread1 extends Thread{
	
	private final ICheckerResult checkerResult;
	private Person person;
	
	public Thread1(Person person, ICheckerResult checkerResult) {
		this.person = person;
		this.checkerResult = checkerResult;
	}
	
	@Override
	public void run() {
		boolean result = false;
		String[] arrStr = {"Mom.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list = mainApp.run();
		String birthday = list.get(2);
		String[] str = birthday.split("-");
		int yearBorn = Integer.parseInt(str[2]);
		if(person.getAge() == 2022-yearBorn) {
			person.setName(list.get(1));
			person.setBirthday(birthday);
			result = true;
		} 
		
		System.out.println("1");
		checkerResult.onResult(result);
	}
	
}
