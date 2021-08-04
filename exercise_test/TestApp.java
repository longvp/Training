package exercise_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class TestApp {
	
	private static boolean kt1 ;
	private static boolean kt2 ;
	private static boolean kt3 ;
	
	public static void main(String[] args) {
		Person person = new Person(22);	
		int currentYear = 2022; // Giả sử là năm 2022 để đúng với bài toán.
		String option = "io";
		Thread t1 = new Thread(new Runnable() {		
			@Override
			public void run() {
				synchronized (person) {
					String[] arrStr = {"Mom.dat", option};
					MainApp mainApp = new MainApp(arrStr);
					List<String> list= mainApp.run();
					String birthday = list.get(2);
					String[] str = birthday.split("-");
					int yearBorn = Integer.parseInt(str[2]);
					if(person.getAge() == currentYear-yearBorn) {
						person.setName(list.get(1));
						person.setBirthday(birthday);
						kt1 = true;
					}
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {			
			@Override
			public void run() {
				synchronized (person) {
					String[] arrStr = {"Dad.dat", option};
					MainApp mainApp = new MainApp(arrStr);
					List<String> list= mainApp.run();
					int age = Integer.parseInt(list.get(1));
					if(person.getAge() == age) {
						kt2 = true;
					}
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable() {			
			@Override
			public void run() {
				synchronized (person) {
					String[] arrStr = {"UBND.dat", option};
					MainApp mainApp = new MainApp(arrStr);
					List<String> list= mainApp.run();
					String birthday = list.get(6);
					String[] str = birthday.split("-");
					int yearBorn = Integer.parseInt(str[2]);
					if(person.getAge() == currentYear-yearBorn) {
						person.setAddress(list.get(1));
						person.setName(list.get(3));
						person.setNameFather(list.get(4));
						person.setNameMother(list.get(5));
						person.setBirthday(list.get(6));
						kt3 = true;
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		
		// Ghi dữ liệu ra file
		if(kt1 == true && kt2 == true && kt3 == true) {
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
