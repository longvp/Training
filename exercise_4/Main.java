package exercise_4;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		Data dataFromInput = new Data();
		dataFromInput.readDataFromFile("ex_4_input.txt");
		ArrayList<Integer> dataInput = (ArrayList<Integer>) dataFromInput.getList();

		Data dataFromSearch = new Data();
		dataFromSearch.readDataFromFile("ex_4_search.txt");
		ArrayList<Integer> dataSearch = (ArrayList<Integer>) dataFromSearch.getList();

		//	THREAD B: SẮP XẾP MẢNG
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (dataFromInput) {
					Collections.sort(dataInput);
					System.out.print("Sap xep: ");
					for (int i = 0; i < dataInput.size(); i++) {
						System.out.printf("%d ", dataInput.get(i));
					}
				}
			}
		});

		int[] arr = new int[dataSearch.size()];
		// MẢNG arr DÙNG ĐỂ LƯU CÁC GIÁ TRỊ 0 HOẶC 1
		// NẾU PHẦN TỬ ĐƯỢC TÌM THẤY THÌ = 1 else = 0
		
		// THREAD C: TÌM KIẾM PHẦN TỬ
		Thread threadC = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (dataFromInput) {
					for (int i = 0; i < dataSearch.size(); i++) {
						for (int j = 0; j < dataInput.size(); j++) {
							if(dataSearch.get(i) == dataInput.get(j)) {
								arr[i] = 1;
							}
						}
					}

				}
			}
		});
		
		//THREAD A: HIEN THI KET QUA DA TIM KIEM
		Thread threadA = new Thread(new Runnable() {		
			@Override
			public void run() {
				synchronized (dataFromInput) {
					System.out.println("\n=======================");
					for(int i = 0; i < dataSearch.size(); i++) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(arr[i] == 1) {
							System.out.println(dataSearch.get(i) + " ton tai trong file input.");
						}else {
							System.out.println(dataSearch.get(i) + " ko ton tai trong file input.");
						}
					}
				}
			}
		});

		try {
			threadB.start();
			threadB.join();
			threadC.start();
			threadC.join();
			threadA.start();
			threadA.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
