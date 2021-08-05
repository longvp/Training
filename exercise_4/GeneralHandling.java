package exercise_4;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GeneralHandling {
	
	Data data = new Data();
	private List<Integer> dataInput;
	private List<Integer> dataSearch;
	private int[] arr;
	private int check = 0;
	
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	public GeneralHandling() {
		
	}
	
	// SORT DATA IN FILE ex_4_input.tx
	public void sort() {
		lock.lock();
		try {
			Data data = new Data();
			dataInput = data.readDataFromFile("ex_4_input.txt");
			Collections.sort(dataInput);
			System.out.print("Sort: ");
			for (int i = 0; i < dataInput.size(); i++) {
				System.out.printf("%d ", dataInput.get(i));
			}
			System.out.println("Sorting finished ...");
			check++;
			cond.signalAll();;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	// SEARCH DATA IN FILE ex_4_search.tx
	public void search() {
		lock.lock();
		try {
			while(check != 1){
				cond.await();
				System.out.println("Waiting to search ...");
			}
			Data data = new Data();
			dataSearch = data.readDataFromFile("ex_4_search.txt");
			for (int i : dataSearch) {
				System.out.printf("%d ", i);
			}
			arr = new int[dataSearch.size()];
			for (int i = 0; i < dataSearch.size(); i++) {
				for (int j = 0; j < dataInput.size(); j++) {
					if(dataSearch.get(i) == dataInput.get(j)) {
						arr[i] = 1;
					}
				}
			}
			check++;
			System.out.println("Searching finished ...");
			cond.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	// DISPLAY DATA IS FINDED
	public void display() {
		lock.lock();
		try {
			while(check != 2) {
				cond.await();
				System.out.println("Waiting to display ...");
			}
			for(int i = 0; i < dataSearch.size(); i++) {
				if(arr[i] == 1) {
					System.out.println(dataSearch.get(i) + " ton tai trong file input.");
				}else {
					System.out.println(dataSearch.get(i) + " ko ton tai trong file input.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
