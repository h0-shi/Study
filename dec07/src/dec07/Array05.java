package dec07;

import java.util.Arrays;
import java.util.Scanner;

public class Array05 {
	public static void main(String[] args) {
		int num = 5;
		String text = "5";

		text = String.valueOf(num);
		num = Integer.parseInt(text);
		System.out.println(num);
		System.out.println("====절취선===");
		text = 5 + 5 + "";
		System.out.println(text);
		text = 5 + "" + 5;
		System.out.println(text);
		text = "" + 5 + 5;
		System.out.println(text);

		System.out.println("====절취선===");

		Scanner sc = new Scanner(System.in);
		String msg = " 점수 입력";
		String subject[] = { "JAVA", "jsp", "spring" };

		// 점수 저장 위한 배열 생성
		int score[] = new int[subject.length+1];

		for (int i = 0; i < subject.length; i++) {
			System.out.println(subject[i] + msg);
			score[i] = sc.nextInt();
		}
		score[score.length-1] = score[0] + score[1]+score[2];
		System.out.println("총점 : "+ score[score.length-1]);
		System.out.println("평균 : "+ score[score.length-1]/3);
		
	}
}
