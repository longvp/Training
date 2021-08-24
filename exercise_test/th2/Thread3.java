package exercise_test.th2;

import java.util.List;

import exercise_test.MainApp;
import exercise_test.Person;

public class Thread3 extends Thread{
	
	private final ICheckerResult checkerResult;
	private Person person;
	
	public Thread3(Person person, ICheckerResult checkerResult) {
		this.person = person;
		this.checkerResult = checkerResult;
	}
	
	@Override
	public void run() {
		boolean result = false;
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
			result = true;
		}
		System.out.println("3");
		checkerResult.onResult(result);
	}

}
