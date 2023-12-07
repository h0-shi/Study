package dec07;

import java.util.Arrays;

public class Array07 {
	public static void main(String[] args) {
		int arr01[] = new int [10];
		System.out.println(arr01);
		System.out.println(arr01[0]);
		System.out.println(arr01.length);
		
		arr01[0] = 10;
		int num2 = 11;
		arr01[1] = num2;

		for (int i = 0; i < arr01.length; i++) {
			System.out.println(arr01[i]);
		}
		System.out.println(Arrays.toString(arr01));
		
		for(int i : arr01) {
			System.out.println(i);
		}
		
	}
}
