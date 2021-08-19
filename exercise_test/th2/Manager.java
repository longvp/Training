package exercise_test.th2;

public class Manager {

	private int check = 0;
	private int numberOfThread;

	public Manager(int numberOfThread) {
		this.numberOfThread = numberOfThread;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public int getNumberOfThread() {
		return numberOfThread;
	}

	public void setNumberOfThread(int numberOfThread) {
		this.numberOfThread = numberOfThread;
	}

	public synchronized void decreaseThread() {
		numberOfThread--;
	}

	public synchronized void increaseCheck() {
		if (check < 2) {
			check++;
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
