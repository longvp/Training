package exercise_3_new;

public class Producer extends Thread {
	
	private GeneralHandling generalHandling;
	
	public Producer(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}

	@Override
	public void run() {
		while (true) {
			generalHandling.add();
		}
	}
	
}
