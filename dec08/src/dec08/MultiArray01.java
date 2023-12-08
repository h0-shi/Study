package dec08;

import java.util.Arrays;
import java.util.Iterator;

public class MultiArray01 {
	public static void main(String[] args) {

		int num = 10;
		int numbers[] = new int[5];
		int numbers02[] = new int[] { 10, 20, 30, 40, 50 };
		int numbers03[] = { 10, 20, 30, 40, 50 };

		int numbers4[][] = new int[5][5]; // 25
		int numbers5[][] = new int[2][3]; // 6

		// 값 대입
		numbers4[0][0] = 15;
		numbers4[0][1] = 25;
		numbers4[0][2] = 30;
		numbers4[0][3] = 35;
		numbers4[0][4] = 40;

		numbers4[1][0] = 17;
		numbers4[1][1] = 27;
		numbers4[1][2] = 37;
		numbers4[1][3] = 47;
		numbers4[1][4] = 57;

//		이중배열 numbers4의 모든 값 출력		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(numbers4[i][j] + ",");
			}
			System.out.println("");
		}

		for (int i = 0; i < numbers5.length; i++) {
			for (int j = 0; j < numbers5[i].length; j++) {
				System.out.print(numbers5[i][j] + ",");
			}
			System.out.println("");
		}

//		int numbers6[][] = new int[4][2];
//		for (int i = 0; i < numbers6.length; i++) {
//			for (int j = 0; j < numbers6.length; j++) { // 에러 발생. 2차원 배열의 길이가 2이나, length는 4임. 
//				System.out.print(numbers6[i][j] + ",");
//			}
//			System.out.println("");
//		}

		int score[][] = new int[2][3];
		//1~6까지 저장
		int number = 1;
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = number++;
			}
		}
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + ",");
			}
			System.out.println("");
		}
		for (int[] a : score) {	// for each 문으로 전체 출력
			System.out.println(Arrays.toString(a));
		}
		System.out.println(Arrays.deepToString(score));
		
		int arr01[] = {10,20,30,40,50,60,70,80,90,100};
		int arr02[][]	= {{10,20,30}, {40,50,60}};
		
		for (int i = 0; i < arr02.length; i++) {
			for (int j = 0; j < arr02[i].length; j++) {
				System.out.print(arr02[i][j]+",");
			}
			System.out.println("");
		}
	}

}
