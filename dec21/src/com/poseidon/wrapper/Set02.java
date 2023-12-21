package com.poseidon.wrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//set에 하나의 값만 저장하는데, 그 값이 처음 값인지 나중에 들어온 값인지?
public class Set02 {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		set1.add("가");
		
		String name = new String("가");
		System.out.println(System.identityHashCode(name));
		set1.add(name);
		
		 name = new String("나");
		System.out.println(System.identityHashCode(name));
		set1.add(name);
		
		System.out.println(set1.size());
		
		Set<Human> humans = new HashSet<>();
		Human n = new Human();
		humans.add(n);
		n.ssn = 1;
		humans.add(n);
		n.ssn = 2;
		humans.add(n);
		n.ssn = 3;
		humans.add(n);
		n.ssn = 4;
		humans.add(n);
		
		System.out.println("ssn");
		System.out.println(n.ssn);
		//---------
		System.out.println(humans.size());
		System.out.println(humans);

		System.out.println("set ssn?");
		List<Human> human = new ArrayList<>(humans);
		System.out.println(human.get(0).ssn);	//4
		//set은 기본 값을 지우고 새로운 값을 넣는구나..
		
	}
}

class Human{
	int ssn;
	static int number;
	public Human() {
		this.ssn = ++number;
	}
}