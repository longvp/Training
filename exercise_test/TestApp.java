package exercise_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import exercise_test.thread.Thread1;
import exercise_test.thread.Thread2;
import exercise_test.thread.Thread3;

public class TestApp {
	
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		
		Person person = new Person(22);
		
		Thread1 thread1 = new Thread1(cyclicBarrier ,person);
		Thread2 thread2 = new Thread2(cyclicBarrier ,person);
		Thread3 thread3 = new Thread3(cyclicBarrier ,person);
		
		thread1.start(); // Check Mom.dat
		thread2.start(); // Check Dad.dat	
		thread3.start(); // Check UBND.dat
		
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main start ...");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if(thread1.getCheck() == true && thread2.getCheck() == true && 
				thread3.getCheck() == true) {
			try {
				File file = new File("result.bin");
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(person);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(fos != null) {
						fos.close();
					}
					if(oos != null) {
						oos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
