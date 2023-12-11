package dec11;

import java.util.Scanner;

public class While04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력하세요. (0~100)");
		int input = sc.nextInt();
		while (input > 100 || input < 0) {
			System.out.println("올바른 숫자를 입력하세요.");
			input = sc.nextInt();
		}
		sc.close();
	}
}
