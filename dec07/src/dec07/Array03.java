package dec07;

import java.util.Arrays;

public class Array03 {
	public static void main(String[] args) {
//		1~20까지 저장하는 배열 arr01
		int arr01[] = new int[20];
		for (int i = 0; i < arr01.length; i++) {
			arr01[i] = i + 1;
		}
		System.out.println(Arrays.toString(arr01));
		for (int i = 0; i < arr01.length; i++) {
			if (arr01[i] % 2 == 0) {
				arr01[i] *= 10;
			}

		}
		System.out.println(Arrays.toString(arr01));
	}
}
