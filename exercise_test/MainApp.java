package exercise_test;

import java.io.File;
import java.util.List;

import exercise_test.factory.ReadFileFactory;
import exercise_test.intf.ReadFile;

public class MainApp {
	
	CommandLineProcessor cmdP;
	
	public MainApp(String args[]) {
		cmdP = new CommandLineProcessor(args);
	}
	
	public List<String> run() {
		String option = cmdP.getOption();
		String filePath = cmdP.getFilePath();
		ReadFile read = ReadFileFactory.readOption(option);
		File file = new File(filePath);
		return read.readFile(file);
	}

	
}
