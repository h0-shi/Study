package dec08;

import java.util.Arrays;

// 3*3배열 만든 후 1~9까지 데이터 입력
public class MultiArray02 {
public static void main(String[] args) {
	int arr[][] = new int [3][3];
	int count = 1;
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = count;
				count++;		
				System.out.print(arr[i][j]);
		}
	}
	
}
}
