package dec13;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일 주소를 입력하세요.");
		String input = sc.next();
		while(input.contains("@") == false) {
			System.out.println("올바르지 않은 형식입니다.");
			System.out.println("이메일 주소를 입력하세요.");
			input = sc.next();
		}
//		indexOf 사용
//		while(input.indexOf("@") == -1) {
//			System.out.println("올바르지 않은 형식입니다.");
//			System.out.println("이메일 주소를 입력하세요.");
//			input = sc.next();
//		}
		System.out.println(input);
		
	}
	

}
