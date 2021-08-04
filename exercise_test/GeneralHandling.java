package exercise_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GeneralHandling {
	
	private Person person;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private int check = 0;
	
	public int getCheck() {
		return this.check;
	}
	
	public void setCheck(int check) {
		this.check = check;
	}
	
	MainApp mainApp;
	
	public GeneralHandling(Person person) {
		this.person = person;
	}
	
	// CHECK FILE Mom.dat
	public void work1() {
		lock.lock();
		try {
			String[] arrStr = {"Mom.dat", "io"};
			MainApp mainApp = new MainApp(arrStr);
			List<String> list = mainApp.run();
			String birthday = list.get(2);
			String[] str = birthday.split("-");
			int yearBorn = Integer.parseInt(str[2]);
			if(person.getAge() == 2022-yearBorn) {
				person.setName(list.get(1));
				person.setBirthday(birthday);
				check++;
				System.out.println("Checking ....." + check);
			}
			cond.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	// CHECK FILE Dad.dat
	public void work2() {
		lock.lock();
		try {
			String[] arrStr = {"Dad.dat", "io"};
			MainApp mainApp = new MainApp(arrStr);
			List<String> list= mainApp.run();
			int age = Integer.parseInt(list.get(1));
			if(person.getAge() == age) {
				check++;
				System.out.println("Checking ..... " + check);
			}
			cond.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	//CHECK FILE UBND.dat
	public void work3() {
		lock.lock();
		try {
			String[] arrStr = {"UBND.dat", "io"};
			MainApp mainApp = new MainApp(arrStr);
			List<String> list= mainApp.run();
			String birthday = list.get(6);
			String[] str = birthday.split("-");
			int yearBorn = Integer.parseInt(str[2]);
			if(person.getAge() == 2022-yearBorn) {
				person.setAddress(list.get(1));
				person.setName(list.get(3));
				person.setNameFather(list.get(4));
				person.setNameMother(list.get(5));
				person.setBirthday(list.get(6));
				check++;
				System.out.println("Checking ..... " + check);
			}
			cond.signalAll();
		} finally {
			lock.unlock();
		}	
	}
	
	// WRITE IN FILE result.bin
	public void work4() {
		lock.lock();
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			while(check != 3) {
				System.out.println("Wating .....");
				cond.await();
			}
			System.out.println("Checking End ..... And Write Data in to File");
			File file = new File("result.bin");
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(person);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			lock.unlock();
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
