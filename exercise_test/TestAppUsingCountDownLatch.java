package exercise_test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.CountDownLatch;

import exercise_test.threadcountdownlatch.CHECK;
import exercise_test.threadcountdownlatch.Thread1;
import exercise_test.threadcountdownlatch.Thread2;
import exercise_test.threadcountdownlatch.Thread3;

public class TestAppUsingCountDownLatch {
	
	public static void main(String[] args) {
		Person person = new Person(22);
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		Thread1 thread1 = new Thread1(countDownLatch, person);
		Thread2 thread2 = new Thread2(countDownLatch, person);
		Thread3 thread3 = new Thread3(countDownLatch, person);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(CHECK.numberCheck == 3) {
			// GHI FILE NIO
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = null;
	        RandomAccessFile raf = null;
	        FileChannel fc = null;
	        try {
	        	File file = new File("result.txt");
	        	oos = new ObjectOutputStream(baos);
	        	oos.writeObject(person);
	        	byte[] dataByte = baos.toByteArray();
	            raf = new RandomAccessFile(file, "rw");
	            fc = raf.getChannel();
	            ByteBuffer buffer = fc.map(MapMode.READ_WRITE, 0, dataByte.length);
	            buffer.put(dataByte);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(baos != null) {
						baos.close();
					}
					if(fc != null) {
						fc.close();
					}
					if(raf != null) {
						raf.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}else {
			System.out.println("t");
		}
		
		
		
		
	}

}
