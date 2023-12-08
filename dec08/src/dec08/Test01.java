package dec08;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String pw = "";

		for (;;) {
			String inputPw = sc.next();
			int count = sc.nextInt();

			for (int j = 0; j < count; j++) {
				pw = pw + inputPw;
			}
			
			System.out.println(pw);
			
			System.out.println("입력이 끝났다면 N, 아직 더 입력할것이 있다면 아무 키나 눌러주세요.");
			inputPw = sc.next();
			if (inputPw == "0") {
				break;
			
			}			
			
		}
		System.out.println(pw);
	}
}
