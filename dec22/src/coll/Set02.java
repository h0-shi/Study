package coll;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set02 {

	public static void main(String[] args) {
//		Set<Integer> ts = new HashSet<Integer>();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for (int i = 0; i < 9; i++) {
			ts.add((int)(Math.random()*9+1));
		}
		System.out.println(ts);
		//////
//		LinkedHashSet<Integer> lhSet = new LinkedHashSet<Integer>();
		Set<Integer> lhSet = new HashSet<Integer>();
		for (int i = 0; i < 9; i++) {
			int num = (int)(Math.random()*9+1);	
			lhSet.add(num);
		}
		System.out.println("결과 : "+lhSet);
		
	}
	
}
