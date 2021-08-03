package exercise_3_new;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GeneralHandling {
	private static final int SIZE = 5;
	private Queue<String> list = new LinkedList<String>();
	private int number = 0;
	
	private Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();
	
	public void add(){
		lock.lock();
		try {
			while(list.size() == SIZE) {
				Thread.sleep(1000);
				System.out.println("Hàng đầy ... Mua hàng đi");
				producer.await();
			}
			number++;
			String message = "sản phẩm " + number;
			list.add(message);
			Thread.sleep(1000);
			System.out.println("Thêm " + message);
			consumer.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void get() {
		lock.lock();
		try {
			while(list.size() == 0) {
				Thread.sleep(1000);
				System.out.println("Hết hàng ... Đang thêm sản phẩm");
				consumer.await();;
			}
			Thread.sleep(1000);
			System.out.println("Mua " + list.poll());
			producer.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
