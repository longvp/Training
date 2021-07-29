package exercise_1;

import java.io.File;

import exercise_1.factory.TailAlgoFactory;
import exercise_1.intf.TailAlgoIF;

public class MainApp {
	
	CommandLineProcessor cmdP;
	
	public MainApp(String args[]) {
		cmdP = new CommandLineProcessor(args);
	}
	
	public String run() {
		String option = cmdP.getOption();
		String filePath = cmdP.getFilePath();
		int n = cmdP.getN();
		TailAlgoIF tailAlgo = TailAlgoFactory.createTailAlgo(option);
		File file = new File(filePath);
		return tailAlgo.doTail(file, n);
	}

}
