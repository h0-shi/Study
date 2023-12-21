package com.poseidon.wrapper;
import java.util.ArrayList;
import java.util.List;

//컬렉션
//List, Set, Map
/*
 *  클래스 선언부에 <E>, <T>, <K,V>이라는걸 볼 수 있다
 *  이를 제네릭이라고 함. Generic
 *  E	: 요소 Elements
 *  T	: 타입 Type
 *  K, V : 키값, Key Value
 */


public class Coll01 {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10); // 10이라는 값 추가
		list.add(20);
		list.add(0,100);
		
		list.set(2, 200);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+", ");
		}
		
		System.out.println("\n===for_each문===");
		for (Integer integer : list) {
			System.out.println(integer);
		}

		list.clear();
		System.out.println(list.isEmpty());
		
		ArrayList<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();	// 상속개념
		
		// 1~10까지 입력
		for (int i = 1; i <= 10; i++) {
			list4.add(i);
		}
//		list4 index 짝수만 지워
		for (int i = 0; i < list4.size(); i++) {
			list4.remove(i);
		}
		System.out.println(list4);
	}
}
