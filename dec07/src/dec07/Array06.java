package dec07;

import java.util.Scanner;

//사용자가 원하는 게임 수 만큼 게임을 진행하고
// 그 승패를 비열에 저장, 승률을 출력하는 프로그램 만들기.
public class Array06 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input, com, game[];
		float win = 0; // 승률 저장 위한 변수

		System.out.println("가위바위보 게임을 진행하겠습니다.");
		System.out.println("몇 게임 하시겠습니까?");
		game = new int[sc.nextInt()];

		for (int i = 0; i < game.length; i++) {
			System.out.println("안내면 진다! 가위! 바위! 보!");
			System.out.println("1.가위 2.바위 3.보");

			input = sc.nextInt();
			com = (int) (Math.random() * 3 + 1);

			int result = input - com;

			if (result == 1 || result == -2) {
				game[i] = 1;
				System.out.println("승리! 1점을 획득합니다.");
				win++;
			}
			System.out.println("현재 점수 : "+win);
			System.out.println("현재 승률 : " + win / (i + 1) * 100+"\n");
		}
		System.out.println("총점 : " + win);
		win = win / game.length;
		System.out.println("당신의 승률 : " + win * 100);

	}

}
