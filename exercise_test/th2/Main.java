package exercise_test.th2;

public class Main {
	
	public static void main(String[] args) {
		ValidateAgeChecker checker = new ValidateAgeChecker();
		boolean validate = checker.validate();
		if(validate) {
			System.out.println("KQ đúng - Ghi ra file");
		}else {
			System.out.println("KQ sai");
		}
		System.out.println("Main");
	}

}
