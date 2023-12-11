package dec11;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		
//		 배열 a에 8비트 담을 수 있음
		int a[] = new int[8]; //00000000
		int i = 0;	//임의의 수
		int n = 10; // 나눌 수
		
//		배열 a에 n의 2진수 저장
//		0자리수에 1회차로 n을 2로 나눈 값이 저장됨 = 2진수 역순
		while(n >= 1)	{
			a[i++]=n%2;
			n /= 2;
		}
		System.out.println(Arrays.toString(a));
		
//		그리고 배열 a를 뒤집어서 출력
		for (i = 7; i >= 0; i--) {
			System.out.print(a[i]);
		}

	}
}
