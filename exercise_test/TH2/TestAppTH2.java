package exercise_test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.LinkedList;
import java.util.Queue;

import exercise_test.thread.Thread1;
import exercise_test.thread.Thread2;
import exercise_test.thread.Thread3;

public class TestAppTH2 {
	
	public static void main(String[] args) {
		Person person = new Person(22);
		Queue<Integer> results = new LinkedList<Integer>();
		
		Thread1 thread1 = new Thread1(person, results);
		Thread2 thread2 = new Thread2(person, results);
		Thread3 thread3 = new Thread3(person, results);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		if(results.size() == 2) {
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
		}
		
	}

}
