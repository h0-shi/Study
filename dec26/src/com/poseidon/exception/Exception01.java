package com.poseidon.exception;

public class Exception01 {
	
	public static void main(String[] args) {
		System.out.println("시작");
		
		System.out.println("중간로직");
		int num = 10;
		int num2 = 0;
		
		try {
//			예외 발생 할 것 같은 문장;
			System.out.println(num / num2);
		} catch (Exception e) {
//			예외 발생 시 처리할 문장;
			System.out.println("예외 발생");
		}
		
		int arr[] = new int[] {10,20,30};
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		try {
			System.out.println(arr[3]);
			System.out.println(10/0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 길이 밖으로 나갔어요.");
		}
		
		System.out.println("끝");
	}
	

}
