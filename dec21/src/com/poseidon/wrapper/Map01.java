package com.poseidon.wrapper;

import java.util.HashMap;
import java.util.Map;

public class Map01 {
	public static void main(String[] args) {
		//부모타입의 Map을 상속한 HashMap 생성
		Map<String, String> map = new HashMap<String, String>();
		map.put("충주", "사과");
		map.put("춘천", "닭갈비");
		map.put("수원", "왕갈비");
		map.put("수원", "반도체");
		
		System.out.println(map.size());
		System.out.println(map);
		
//		키값을 알아여 밸류값을 뽑임
		System.out.println(map.get("수원"));
		
//		키값 유무 확인
		System.out.println(map.containsKey("수원"));
		System.out.println(map.containsKey("화성"));
		
		System.out.println(map.containsValue("반도체"));
		System.out.println(map.containsValue("굴비"));
		
		//HashMap 생성
//		HashMap<String, String>map2 = new HashMap<String, String>();
	}
}
