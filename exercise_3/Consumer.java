package exercise_3_new;

public class Consumer extends Thread {
	
	private GeneralHandling generalHandling;
	
	public Consumer(GeneralHandling generalHandling) {
		this.generalHandling = generalHandling;
	}

	@Override
	public void run() {
		while (true) {
			generalHandling.get();
		}
	}

}
