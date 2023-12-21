package com.poseidon.wrapper;

import java.util.ArrayList;

public class List02 {
	public static void main(String[] args) {
		//문자열 저장하는 list1 생성
		ArrayList<String> list01 = new ArrayList<String>();
		list01.add("고종현");
		list01.add("김상진");
		list01.add("박기찬");
		list01.add("장균협");
		list01.add("김수민");
		list01.add("박기찬");
		list01.add("김동한");
		
		System.out.println(list01.size());	//7
		System.out.println(list01);
		
		//String type의 list는 idx 대신 value 넣어도 됨
		//같은 값이 2개 이상인 경우 가장 앞쪽의 값이 지워짐
		list01.remove("박기찬");	
		System.out.println(list01.size());	//6 박기찬 2개중 1개 지워짐
		System.out.println(list01);
		
		list01.remove("박기찬");	
		System.out.println(list01.size());	//5
		System.out.println(list01);
		
		//remove 할 값이 없으면 아무 변화도 없음
		list01.remove("박기찬");		
		System.out.println(list01.size());	//5
		System.out.println(list01);
		
		
	}
}
