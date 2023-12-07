package dec07;

import java.util.Arrays;

public class Jc03 {
	public static void main(String[] args) {
		int temp;
		int a[] = { 75, 95, 85, 100, 50 };

		for (int k = 0; k < a.length; k++) {
			for (int l = 0; l < a.length - 1; l++) {
				if (a[l] > a[l + 1]) {
					temp = a[l];
					a[l] = a[l + 1];
					a[l + 1] = temp;
				}
			}

		}
		System.out.println(Arrays.toString(a));
	}
}
