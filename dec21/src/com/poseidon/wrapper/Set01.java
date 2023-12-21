package com.poseidon.wrapper;


import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// set은 순서가 없으며 중복도 허용하지 않는다.

public class Set01 {
	public static void main(String[] args) {
	
		Set<String> set = new HashSet<String>();
//		총 7개의 값 add 최자는 2개
		set.add("최자");
		set.add("김자");
		set.add("이자");
		set.add("황자");
		set.add("최자");
		set.add("라자");
		set.add("명자");

		System.out.println(set); // 최자 제외한 6개만 나옴
		System.out.println(set.size());	//얘도 당연히 6
		
		Set<Integer> lotto = new HashSet<Integer>();
		
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random()*45+1));
		}
		System.out.println(lotto);
		List<Integer> list = new ArrayList<>(lotto);
		Collections.sort(list);
		System.out.println(list);
		
		//Iterator	반복자, = 리스트를 순회할 수 있게 해주는 객체
		Iterator<Integer> iter = lotto.iterator();

		while (iter.hasNext()) {
			Integer integer = (Integer) iter.next();
			System.out.println(integer);
		}
		/*
		 * 반복자
		 * 컬렉션 인터페이스의 iterator()메서드는 Iterator를 리턴한다.
		 * Iterator는 Enumeration의 인터페이스와 비슷하나 Enumeration보다 나중에 만들어 짐
		 */
		
		List<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("김관");
		names.add("홍길동");
		names.add("최자");
		names.add("홍길동");
		names.add("홍길동");
		names.add("여명");
		names.add("홍길동");
		names.add("홍길동");
		
		System.out.println(names.size());
//		List를 Set으로 바꿔서 중복 제거
		Set<String>names2 = new HashSet<>(names);
		System.out.println(names2.size());  // [홍길동, 김관, 최자, 여명]
		System.out.println(names2);
	
	}
}
