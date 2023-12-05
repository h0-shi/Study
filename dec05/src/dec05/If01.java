package dec05;

import java.util.*;

public class If01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num > 5) {
			System.out.println("5보다 큽니다");
		} else if (num < 5) {
			System.out.println("5보다 작아유");
		} else {
			System.out.println("딱 5네요~");
		}
	}
}
