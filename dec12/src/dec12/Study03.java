package dec12;

import java.util.Scanner;

public class Study03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 직급은?");
		System.out.println("1.사장, 2.부장, 3.대리, 4.사원, 5.알바");
		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.print("5");
			break;
		case 2:
			System.out.print("4");
			break;
		case 3:
			System.out.print("3");
			break;
		case 4:
			System.out.print("2");
			break;
		case 5:
			System.out.print("1");
		default:
			break;
		}
		System.out.println("층까지 갈 수 있습니다~");
		
		System.out.println(1/2);
	}
}
