package exercise_test.factory;

import exercise_test.intf.ReadFile;
import exercise_test.read.ReadUsingIO;
import exercise_test.read.ReadUsingNIO;

public class ReadFileFactory {

	public static ReadFile readOption(String option) {
		if(option.equals("io")) {
			return new ReadUsingIO();
		}else if(option.equals("nio")) {
			return new ReadUsingNIO();
		}
		return null;
	}
	
}
