package exercise_3_new;

public class Main {
	
	public static void main(String[] args) {
		GeneralHandling generalHandling = new GeneralHandling();
		
		Producer producer = new Producer(generalHandling);
		Consumer consumer = new Consumer(generalHandling);
		
		producer.start();
		consumer.start();
	}

}
