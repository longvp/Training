package exercise_1.factory;

import exercise_1.intf.TailAlgoIF;
import exercise_1.tail.FileMappingTail;
import exercise_1.tail.NormalTail;

public class TailAlgoFactory {
	
	public static TailAlgoIF createTailAlgo(String option) {
		if(option.equals("normal")) {
			return new NormalTail();
		}else if(option.equals("mapped")) {
			return new FileMappingTail();
		}
		return null;
	}
	
}
