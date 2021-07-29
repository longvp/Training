package exercise_3;

import java.util.LinkedList;
import java.util.Queue;

public class Consumer extends Thread {

	private Queue<String> listMessage = new LinkedList<String>();

	public Consumer(Queue<String> listMessage) {
		this.listMessage = listMessage;
	}

	public synchronized void get() throws InterruptedException {
		while (listMessage.isEmpty()) {
			System.out.println("Hết hàng ... Đang thêm sản phẩm");
			listMessage.wait();
		}
		Thread.sleep(3000);
		System.out.println("Mua " + listMessage.poll());
		listMessage.notifyAll();
	}

	@Override
	public void run() {
		synchronized (listMessage) {
			while (true) {
				try {
					get();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}