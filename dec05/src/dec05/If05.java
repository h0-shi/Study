package dec05;

import java.util.*;

public class If05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위 바위 보!");
		System.out.println("1:가위 2:바위 3:보");
		int input = sc.nextInt();
		int com = (int) (Math.random() * 3 + 1);
		System.out.println(com);
		
		//User의 경우
		if (input == 1) {
			System.out.println("당신은 가위");
		} else if (input == 2) {
			System.out.println("당신은 바위");
		} else {
			System.out.println("당신은 보");
		}

		//com 의 경우
		if (com == 1) {
			System.out.println("PC는 가위");
		} else if (com == 2) {
			System.out.println("PC는 바위");
		} else {
			System.out.println("PC는 보");
		}
		//
		int win = input - com;
		// Result
		if (input == com) {
			System.out.println("비김");
		} else if (win == -1 || win == 2) {
			System.out.println("패배");
		} else if (win == 1 || win == -2) {
			System.out.println("승리");
		} else {
			System.out.println("1~3 사이 입력");
		}
	}
}

