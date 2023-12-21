package com.poseidon.wrapper;

public class Wrapper02 {

	public static void main(String[] args) {
		Integer obj1 = 300;
		Integer obj2 = 300;
		
		System.out.println(obj1==obj2);
		
		System.out.println(obj1.equals(obj2));

		obj2 = 10000;

		int result = obj1.compareTo(obj2);
		System.out.println(result);
		
		
		if(result == 0){	// 0이면 같은 값
			System.out.println("같은 값");
		} else if(result < 0) {	// -1인 경우, 매개변수로 들어간 값이 더 큼
			System.out.println("다른 값 / obj2가 큼");
		}else {	// 1인 경우, 변수가 더 큼
			System.out.println("다른 값/ obj1이 더 큼");
		}
		
		int iNum = obj1;	// r->p로 자동 변환
		Object obj = 40;
		iNum = (int) obj;
		iNum = ((Integer)obj).intValue();	//(obj -> Integer) -> int
		
	}
	
}
