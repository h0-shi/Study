package dec11;

import java.util.Arrays;

public class DyanamicArray01 {
	public static void main(String[] args) {

		int arr1[][] = new int[3][3];
		int arr2[][] = new int[3][];
		
/* 	3-0은 3칸
 * 	3-1은 6칸
 * 	3-2는 12칸
 */
		arr2[0]	= new int [3];
		arr2[1] = new int [6];
		arr2[2] = new int [12];
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j]);
			}
			System.out.printf("%n");
		}

	}
}
