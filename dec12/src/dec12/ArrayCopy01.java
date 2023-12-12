package dec12;

import java.util.Arrays;

public class ArrayCopy01 {
	public static void main(String[] args) {
		int arr1[] = new int [] {10,20,30,40,50,60};
		int arr2[] = new int[arr1.length];
		
		arr2[0] = arr1[0];
		arr2[1] = arr1[1];
		arr2[2] = arr1[2];
		arr2[3] = arr1[3];
		arr2[4] = arr1[4];
		arr2[5] = arr1[5];
		
		arr1[0] = 1000;
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(arr1);
		System.out.println(Arrays.toString(arr2));
		System.out.println(arr2);
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		/*
		 * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		 *  src 원본 srcPos 어느 위치부터 복사?
		 *  dest 값을 담을 배열
		 *  destPos 어느 위치에 담을까
		 *  length 어느 길이만큼 복사?
		 */
		
		int arr3[] = new int[arr2.length];
		Arrays.copyOfRange(arr3, 0, 5);
		arr3 = arr2.clone();
		System.out.println(arr3);
		
	}
}
