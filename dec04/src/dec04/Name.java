package dec04;

import java.util.Scanner;

public class Name {
	public static void main(String[] args) {
		int num = 100;
		int APLLE_COUNT = 10;
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			num = num + n;
			System.out.println(num);
			if (n == 00) {
				break;
			}
		}
		System.out.println(num);
	}

}
