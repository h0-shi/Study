package coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class List01 {
	public static void main(String[] args) {
		
		//List는 인터페이스임. 따라서 인스턴스화 시킬 수 없음.
		//자식 class인 ArrayList로 인스턴스 생성
		List<String> list = new ArrayList<String>();
		list.add("김수");
		list.add("한무");
		list.add("거북");
		list.add("이와");
		list.add("두루");
		
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(list.size()-1));
		
		for(String string : list) {
			System.out.print(string);
		}
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
		
		list.add(1, "무한");
		System.out.println(list);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("데이비드");
		list2.add("워쇼스키");
		list2.add("바이드");
		
//		add all => 두개의 리스트를 하나로 합치기
		list.addAll(list2);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		boolean in = list.contains("당근쿤");
		System.out.println(in);
		
		list.add("데이비드");
		System.out.println(list);
//		list에서 데이비드가 가장 처음 출현하는 인덱스
		System.out.println(list.indexOf("데이비드")); //2
//		list에서 데이비드가 마지막에 출현하는 인덱스
		System.out.println(list.lastIndexOf("데이비드"));  //9
		
		Object listToArr[] = list.toArray();
		System.out.println(Arrays.toString(listToArr));
		
		List<String> subList = list.subList(3, 5);
		System.out.println(subList);
	}
}
