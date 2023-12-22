package coll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test02 {
	public static void main(String[] args) {

//		게시판 만들 때 이런식의 코드가 사용된다!
//		Map 타입의 값을 갖는 List 생성				
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

//		Map 생성
		Map<String, String> map = new HashMap<String, String>();
//		Map에 값 추가
		map.put("no", "1");
		map.put("title", "첫번째 글");
		map.put("write", "poseidon");
		map.put("date", "2023-12-10");
		map.put("like", "5");
//		list에 Map값 추가
		list.add(map);

//		반복
		map = new HashMap<String, String>();
		map.put("no", "2");
		map.put("title", "두번째 글");
		map.put("write", "hong");
		map.put("date", "2023-12-11");
		map.put("like", "15");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("no", "3");
		map.put("title", "세번째 글");
		map.put("write", "kim");
		map.put("date", "2023-12-12");
		map.put("like", "6");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("no", "4");
		map.put("title", "네번째 글");
		map.put("write", "park");
		map.put("date", "2023-12-13");
		map.put("like", "23");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("no", "5");
		map.put("title", "다섯번째 글");
		map.put("write", "choi");
		map.put("date", "2023-12-14");
		map.put("like", "9");
		list.add(map);

		System.out.println(list.size());
		System.out.println("= for-each문 =");
		for (Map<String, String> map2 : list) {
			System.out.println(map2);
		}

		System.out.println("= for문 =");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		List<String> sort = new ArrayList<>();
		sort.add("no");
		sort.add("title");
		sort.add("write");
		sort.add("date");
		sort.add("like");
		System.out.println(sort);
		System.out.println("번호|\t제 목\t|글쓴이\t|날짜\t|좋아요");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("no")+"  ");
			System.out.print(list.get(i).get("title")+"  ");
			System.out.print(list.get(i).get("write")+"  ");
			System.out.print(list.get(i).get("date")+"  ");
			System.out.println(list.get(i).get("like"));
		}

//		번호 | 제목 | 글쓴이 | 날짜 | 좋아요 순서로 출력하도록 해봐

	}
}
