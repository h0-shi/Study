package dec05;

import java.util.*;

public class IF02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민등록번호 뒷자리를 적어봐요");
		int num = sc.nextInt();
		if (num % 2 == 0) {
			System.out.println("여자시네용");
		} else {
			System.out.println("남자시네용");
		}
	}

}