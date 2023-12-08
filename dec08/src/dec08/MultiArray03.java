package dec08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiArray03 {
	public static void main(String[] args) {
		int arr[] = new int[5];
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		System.out.println(list);

		list.remove(0);
		System.out.println(list);

		list.add(1);
		System.out.println(list);

		list.add(0, 1);
		System.out.println(list);

		System.out.println(list.get(0));
		System.out.println(list.size());

		System.out.println("=========");

// 		2번째 방법
//		숫자를 랜덤하게 뽑고 중복되지 않으면 배열에 저장

		int random[] = new int[9];
		int sam[][] = new int[3][3];

		A: for (int i = 0; i < random.length; i++) {
			int temp = (int) (Math.random() * 9 + 1); // 랜덤하게 숫자 뽑고
			System.out.println(i);
			for (int j = 0; j < random.length; j++) {
				if (random[j] == temp) { // 숫자의 중복 확인
					i--; // 중복이면 전단계로
					System.out.println(i);
					continue A;
				}
			}
			random[i] = temp; // 중복 아니면 입력.
		}
		System.out.println(Arrays.toString(random));
		int count = 0;
		for (int i = 0; i < sam.length; i++) {
			for (int j = 0; j < sam.length; j++) {
				sam[i][j] = random[count++];
			}
		}
		for (int[] is : sam) {
			System.out.println(Arrays.toString(is));
		}

		System.out.println("--------");
		// index를 랜덤하게 뽑아서 index에 값이 0이면 입력.
		sam = new int[3][3];
		int r1, r2; // indexNo
		for (int i = 1; i < 10; i++) { // i는 1~10
			r1 = (int) (Math.random() * 3); // 1차원
			r2 = (int) (Math.random() * 3); // 2차원
			if (sam[r1][r2] == 0) { // index에 들어있는 값이 0 이면 대임
				sam[r1][r2] = i;
				System.out.println(r1 + ":" + r2 + "=" + i);
			} else {
				i--; // 아니면 전단계로 회귀
				System.out.println("중복 발생");
			}
		}
		// 출력
		for (int[] is : sam) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("======");
		
		sam = new int[3][3];
		
		for (int i = 0; i < sam.length; i++) {
			B: for (int j = 0; j < sam[i].length; j++) {
				int temp = (int) (Math.random() * 9 + 1);
				//중복검사
				for (int k = 0; k < sam.length; k++) {
					for (int k2 = 0; k2 < sam[i].length; k2++) {
						if (sam[k][k2] == temp) {
							j--;
							continue B;
						}
					}
				}
				sam[i][j] = temp;
			}
		}
		for (int[] is : sam) {
			System.out.println(Arrays.toString(is));
		}
	}
}
