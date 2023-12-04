package dec04;

public class Variable02 {
	public static void main(String[] args) {
		// 변수 선언 =

		byte num = 127;
		short num02 = num;
		int num03 = num02;
		long num04 = num03;
		num03 = (int) num04;
		num02 = (short) num04;
		num02 = (short) (num02 + 1);

		num02 = (byte) -129;
		float pi = 3.14f;
		double pi2 = pi;

		int number = 150;
		double pi3 = number;
		System.out.println(pi3);

		pi3 = 3.14;
		System.out.println(pi3);
		number = (int) pi3;
		System.out.println(number);

		char ch = 97;
		System.out.println((int) ch);
		System.out.println((int) 'A');

		final int FINAL_INT = 79;
		System.out.println(FINAL_INT);

		// 논리타입
		boolean check = false;
		check = check == true;
		System.out.println(check);
		if (check) {
			System.out.println("체크가 참이다.");
		} else {
			System.out.println("체크가 거짓이다.");
		}
		
		int maxValue = 2147483647;
		int minVAlue = -2147483648;
		
		long lValue = 2147483648L;
		float pi4 = 3.14F;
		
		HelloWorld helloWorld = new HelloWorld();
		
		

	}
}
