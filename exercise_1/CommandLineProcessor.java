package exercise_1;

public class CommandLineProcessor {
	
	private String[] args;
	
	public CommandLineProcessor(String[] args) {
		this.args = args;
	}
	
	public String getFilePath() {
		return args[0];
	}
	
	public int getN() {
		return Integer.parseInt(args[1]);
	}
	
	public String getOption() {
		return args[2];
	}

}
