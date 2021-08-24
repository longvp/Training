package exercise_test.th2;

import java.util.List;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread2 extends Thread{

	private final ICheckerResult checkerResult;
	private Person person;
	
	public Thread2(Person person, ICheckerResult checkerResult) {
		this.person = person;
		this.checkerResult = checkerResult;
	}
	
	@Override
	public void run() {
		boolean result = false;
		String[] arrStr = {"Dad.dat", "io"};
		MainApp mainApp = new MainApp(arrStr);
		List<String> list= mainApp.run();
		int age = Integer.parseInt(list.get(1));
		if(person.getAge() == age) {
			result = true;
		}
		System.out.println("2");
		checkerResult.onResult(result);	
	}
	
}
