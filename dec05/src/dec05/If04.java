package dec05;

public class If04 {
	public static void main(String[] args) {
		int num1 = 50;
		int num2 = 55;

		if (num1 > num2) {
			int temp = num2;
			num2 = num1;
			num1 = temp;
		}
		System.out.println(num1);
		System.out.println(num2);
	}
}
