package com.poseidon.wrapper;

public class WrapperEx {
	public static void main(String[] args) {
		int num = 100;
//		Integer가 래핑클래스임
		Integer number = 100;
//		객체 특성 상 아래와 같이 적어야 하지만 위처럼 적어도 허용하기로 함
		Integer number2 = new Integer(100);

//		P타입과 래핑클래스간 같은 관계라면 자동 형변환 됨		
		num = number2;
//		P타입과 래핑클래스간의 형변환은 .~Value(); 메서드		
		byte bNum = number2.byteValue();
		short sNum = number2.shortValue();
		
		
		Short number3 = 100;
		bNum = number3.byteValue();
		
		System.out.println(Integer.MAX_VALUE);
		int minValue = Integer.MIN_VALUE;
		System.out.println(minValue);
		System.out.println(Byte.MIN_VALUE);
//		오토박싱?
		Integer ingerger = Integer.valueOf("300");
		
		Integer integer = 30;
		Integer integer2 = new Integer("30");
		
		if(integer == integer2){
			System.out.println("같은 객체에여");
		} else {
			System.out.println("다른 객체에요");
		}
		
	}

}
