package dec07;

import java.util.Arrays;

public class Array04 {
	public static void main(String[] args) {
		int numbers[] = new int [10];
		numbers[0] = 1;
		numbers[1] = 2;
		
		for (int i = 2; i < numbers.length; i++) {
			numbers[i]=numbers[i-2]+numbers[i-1];
		}
		System.out.println(Arrays.toString(numbers));
		
	}
}
