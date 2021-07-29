package exercise_3;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> listMessage = new LinkedList<String>();
		int size = 5;
		Producer producer = new Producer(listMessage, size);
		Consumer consumer = new Consumer(listMessage);
		producer.start();
		consumer.start();
	}
	
}
