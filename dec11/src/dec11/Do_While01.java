package dec11;

import java.util.Scanner;

public class Do_While01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		System.out.println("점수를 입력하세요.(1~100)");
//		int input = sc.nextInt();

//		do {
//			System.out.println("1~100 사이를 입력하세요.");
//			input = sc.nextInt();
//		} while (input < 0 || input > 100);
		
		System.out.println("1.가위\t2.바위\t3.보");
		int input = sc.nextInt();
		do {
			System.out.println("1~3을 입력하세요");
			input = sc.nextInt();
		} while (input > 3 || input < 1);
		
//		for (int i = 0; i < args.length; i++) {
//			
//		}
//		
//		for (String string : args) { args = 집합
//			
//		}
//		while (en.hasMoreElements()) {
//			type type = (type) en.nextElement();
//			
//		}
		
		
	}

}
