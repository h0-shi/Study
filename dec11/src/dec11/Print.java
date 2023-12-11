package dec11;

import java.util.Scanner;

public class Print {
	public static void main(String[] args) {

		System.out.println(""); // 문자열 출력 + \n
		System.out.print(""); // 문자열 출력

		System.out.print("여기까지가 print 출력");
		System.out.println("ln 있는 것");
//		System.out.printf("출력 서식", 출력 내용);

		String name = "홍길동";
		System.out.println(name);
		System.out.printf("", name);
		System.out.printf("저는 %s 입니다. \n", name);
		System.out.printf("제 나이는 %d 입니다. \n", 35); // double
		System.out.printf("제 나이는 %f 입니다. \n", 35.0); // float

		System.out.printf("%d를 8진수로 변환 %o \n", 10, 10);
		System.out.printf("%d를 16진수로 변환 %x \n", 16, 16);

		double pi = 3.1415926535;
		System.out.printf("pi는 %f%n", pi);

		System.out.printf("pi는 %.10f%n", pi); // 소숫점 10자리까지 찍어라

		System.out.printf("%d%n", 5);
		System.out.printf("%05d%n", 1300);

		System.out.printf("%s%n", name);
		System.out.printf("%5s%n", name);
		System.out.printf("%-5s%n", name);
		name = "홍길동입니다.";

		System.out.printf("글자수 : %d,%n", name.length());
		System.out.printf("%s %n", name);
		System.out.printf("%.5s %n", name);
		System.out.printf("%6.5s %n", name);

	}

	public static Scanner add() {
		Scanner sc = new Scanner(System.in);
		return null;
	}
}
