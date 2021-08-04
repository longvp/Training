package exercise_test;

public class CommandLineProcessor {

private String[] args;
	
	public CommandLineProcessor(String[] args) {
		this.args = args;
	}
	
	public String getFilePath() {
		return args[0];
	}
	
	public String getOption() {
		return args[1];
	}

	
}
