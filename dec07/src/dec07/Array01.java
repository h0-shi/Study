package dec07;

import java.util.Arrays;

public class Array01 {
	public static void main(String[] args) {

//		1. 배열 선언
		int arr1[] = new int[5];
//		int arr2[] = null;

		double ary[] = new double[3];
		System.out.println(ary[ary.length - 1]);

//		System.out.println(arr1);
//		System.out.println(arr1[0]);
//		System.out.println(arr1[1]);
//		System.out.println(arr1[2]);
//		System.out.println(arr1[3]);
//		System.out.println(arr1[4]);

		ary[0] = 123;
		ary[1] = 200;
		ary[2] = 300;
//		ary[3] = 500;
		System.out.println(ary[0]);

		for (int i = 0; i < ary.length; i++) {
			ary[i] = i + 100;
		}
		for (int i = 0; i < ary.length; i++) {
			System.out.println(ary[i]);
		}
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i + 1;
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		for(int i : arr1) {
			System.out.println(i);
		}
		System.out.println(Arrays.toString(arr1));

	}

}
