package dec26;

import java.util.HashSet;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
//		1970.01.01 부터 지금까지의 밀리 세컨 반환
//		시작
		System.out.println("시작"+startTime);
		
//		int ary[] = new int [9];
		Set<Integer> set = new HashSet<>();
		while(set.size() != 9) {
			int input = (int) (Math.random()*9+1);
			set.add(input);
			System.out.print(input+" ");
		}
		
		
		
		for (Integer integer : set) {
			System.out.println(integer);
		}
		
		
//		끝
		long endTime = System.currentTimeMillis();
		System.out.println("시작"+endTime);
		System.out.println("경과시간 : " + (endTime - startTime));
	}
}
