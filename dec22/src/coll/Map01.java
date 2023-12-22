package coll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Map01 {
	public static void main(String[] args) {
		Map<String, String>map = new HashMap<String, String>();
		map.put("수원", "왕갈비");
		map.put("제주", "갈치");
		map.put("서울", "마카롱");
		map.put("장충동", "왕족발보쌈");
		map.put("이천", "반도체");
		
		System.out.println(map);
		System.out.println(map.get("장충동"));
		
//		키값이 있는지 여부 T/F
		map.containsKey("장충동");
		map.containsKey("제주");
		
		Set<String> key = map.keySet();
		System.out.println(key);
		
		Set<String> value = new HashSet<String>(map.values());
		System.out.println(value);
		List<String> keys = new ArrayList<>(key);
		for (int i = 0; i < map.size(); i++) {
			System.out.println(keys.get(i)+" : "+map.get(keys.get(i)));
		}
		System.out.println("===");
		for (String keye : key) {
			System.out.println(keye+" : "+map.get(keye));
		}
		
	}
}
