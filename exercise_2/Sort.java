package exercise_2;

import java.util.ArrayList;

public class Sort {

	private static class SortThreads extends Thread {

		private Integer[] array;
		private int begin;
		private int end;

		public SortThreads(Integer[] array, int begin, int end) {
			this.array = array;
			this.begin = begin;
			this.end = end;
		}

		@Override
		public void run() {
			mergeSort(array, begin, end);
		}
	}

	public void threadSort(Integer[] arr, int Max_Threads) {	
		int length = arr.length;
		
		int maxlimit = 0;
		if(length % Max_Threads == 0) {
			maxlimit = length/Max_Threads;
		}else {
			maxlimit = length / (Max_Threads - 1);
		}
		
		if(maxlimit < Max_Threads) {
			maxlimit = Max_Threads;
		}
		
		ArrayList<SortThreads> threads = new ArrayList<SortThreads>();

		for (int i = 0; i < length; i += maxlimit) {
			int beg = i;
			int remain = length - i;
			int end = 0;
			if(remain < maxlimit) {
				end = i + remain - 1;
			}else {
				end = i + maxlimit - 1;
			}
			SortThreads t = new SortThreads(arr, beg, end);
			t.start();
			threads.add(t);
		}

		for (SortThreads t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < length; i += maxlimit) {
			int mid = i == 0 ? 0 : i - 1;
			int remain = (length) - i;
			int end = 0;
			if(remain < maxlimit) {
				end = i + remain - 1;
			}else {
				end = i + maxlimit - 1;
			}
			merge(arr, 0, mid, end);
		}

	}

	public static void mergeSort(Integer[] array, int begin, int end) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			mergeSort(array, begin, mid);
			mergeSort(array, mid + 1, end);
			merge(array, begin, mid, end);
		}
	}

	public static void merge(Integer[] array, int begin, int mid, int end) {

		Integer[] temp = new Integer[(end - begin) + 1];

		int i = begin, j = mid + 1;
		int k = 0;

		while (i <= mid && j <= end) {
			if (array[i] <= array[j]) {
				temp[k] = array[i];
				i += 1;
			} else {
				temp[k] = array[j];
				j += 1;
			}
			k += 1;
		}

		while (i <= mid) {
			temp[k] = array[i];
			i += 1;
			k += 1;
		}

		while (j <= end) {
			temp[k] = array[j];
			j += 1;
			k += 1;
		}

		for (i = begin, k = 0; i <= end; i++, k++) {
			array[i] = temp[k];
		}
	}

}
