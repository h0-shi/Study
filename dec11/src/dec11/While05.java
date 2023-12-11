package dec11;

import java.util.Scanner;

public class While05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("1.가위\t2.바위\t3.보 ");
		int input = sc.nextInt();
		
		while( input < 1 || 3 < input) {
			System.out.println("다시 입력하세요.");
			input = sc.nextInt();
		}
		sc.close();
	}
}
