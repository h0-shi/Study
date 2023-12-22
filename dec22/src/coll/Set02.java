package coll;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set02 {

	public static void main(String[] args) {
//		Set<Integer> ts = new HashSet<Integer>();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for (int i = 0; i < 6; i++) {
			ts.add((int)(Math.random()*45+1));
		}
		System.out.println(ts);
		//////
//		LinkedHashSet<Integer> lhSet = new LinkedHashSet<Integer>();
		Set<Integer> lhSet = new HashSet<Integer>();
		for (int i = 0; i < 6; i++) {
			int num = (int)(Math.random()*45+1);	
			System.out.println("뽑은 숫자 : "+num);
			lhSet.add(num);
		}
		System.out.println("결과 : "+lhSet);
		
	}
	
}
