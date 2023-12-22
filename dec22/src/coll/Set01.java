package coll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Set01 {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		set.add("김동한");	//1
		set.add("박기찬");	//2
		set.add("김수민");	//3
		set.add("김상진");	//4
		set.add("김동한");	//5
		set.add("고종현");	//6
		System.out.println(set.size());	//5 중복 김동한 제외
		
		for (String str : set) {
			System.out.println(str);
		}
		
		System.out.println("NP ");
		List<String> list = new ArrayList<>(set);	//괄호 안은 생성자임
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
//		Iterator
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
