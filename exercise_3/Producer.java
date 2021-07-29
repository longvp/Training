package exercise_3;

import java.util.LinkedList;
import java.util.Queue;

public class Producer extends Thread {

	private Queue<String> listMessage = new LinkedList<String>();
	private int size;
	private int messageNumber;

	public Producer(Queue<String> listMessage, int size) {
		this.listMessage = listMessage;
		this.size = size;
	}

	public synchronized void add() throws InterruptedException {
		while (listMessage.size() == size) {
			System.out.println("Hàng đầy ... Mua hàng đi");
			listMessage.wait();
		}
		Thread.sleep(2000);
		messageNumber++;
		String message = "sản phẩm " + messageNumber;
		listMessage.add(message);
		System.out.println("Thêm " + message);
		listMessage.notifyAll();
	}

	@Override
	public void run() {
		synchronized (listMessage) {
			while (true) {
				try {
					add();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}