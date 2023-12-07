package dec07;

import java.util.Arrays;
import java.util.Random;

public class Array02 {
	public static void main(String[] args) {
		//문자열 저장하는 arr1 배열 생성. 3칸
		String arr1[] = {"홍길동", "김길동", "이길동"};
		System.out.println(Arrays.toString(arr1));
		
		String name1 = arr1[0];
		System.out.println(name1);
		System.out.println(Arrays.toString(arr1));
		
		char chArray[] = name1.toCharArray();
		System.out.println(Arrays.toString(chArray));
		
		System.out.println(name1.length());	//"홍길동" - 3
		System.out.println(chArray.length);	//[홍,길,동] - 3
		System.out.println(arr1[0].length());//"홍길동" - 3
		System.out.println("==절취선==");
		/* 로또! 1~45 숫자중 6개 뽑기.
		 * 정수를 저장하는 lotto 배열 6칸짜리 생성
		 * 거기에 랜덤 수 뽑아서 저장
		 * 
		*/																	
		
		Random random = new Random();
		System.out.println((int)(Math.random()*45+1));
		
		int lotto[] = new int[6];
		int count = 0;
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = random.nextInt(1,45);		
		}
		System.out.println(Arrays.toString(lotto));
		
		while (count <6) {
			lotto[count] = (int)(Math.random()*45+1);
			count++;	
		}
		System.out.println(Arrays.toString(lotto));
				
	}
}
