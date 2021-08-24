package exercise_test.th2;

import java.util.ArrayList;
import exercise_test.Person;

public class ValidateAgeChecker implements ICheckerResult {

	private final ArrayList<Boolean> arrayResult = new ArrayList<Boolean>();

	public boolean validate() {
		Person person = new Person(22);

		Thread1 thread1 = new Thread1(person, this);
		Thread2 thread2 = new Thread2(person, this);
		Thread3 thread3 = new Thread3(person, this);

		thread1.start();
		thread2.start();
		thread3.start();

		// Thread main
		int countAll = 0;
		int countTrue = 0;

		while (countAll < 3 && countTrue < 2) {
			synchronized (arrayResult) {
				for (Boolean b : arrayResult) {
					if (b) {
						countTrue++;
					}
					countAll++;
				}
				arrayResult.clear();
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return countTrue >= 2;

	}

	@Override
	public void onResult(boolean result) {
		synchronized (arrayResult) {
			arrayResult.add(result);
		}
	}

}
