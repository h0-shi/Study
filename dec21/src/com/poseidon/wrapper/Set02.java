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
		Human n2 = new Human();
		humans.add(n);
		n.ssn = 1;
		humans.add(n);
		n.ssn = 2;
		humans.add(n);
		n.ssn = 4;
		humans.add(n);
		n.ssn = 3;
		n2.ssn = 3;
		humans.add(n);
		humans.add(n2);
		
		System.out.println("ssn");
//		System.out.println(n.ssn);
		//---------
		System.out.println("두두둥");
		System.out.println(humans.size());
		System.out.println(humans);

//		지금 Set에 들어간게  n / n2인데 둘 다 ssn=3을 갖음
//		어떻게 Set에 같은 값이 들어갈 수 있지? 하고 잠시 생각을 해봤는데
//		Set에 들어간건 3이 아니라 n과 n2라는 객체임
//		3은 각 객체가 갖고있는 속성? 필드?임.
//		따라서 Set에는 서로 다른 두개의 객체가 들어간 상태임
		System.out.println("set ssn?");
		List<Human> human = new ArrayList<>(humans);
		System.out.println(human.get(0).ssn);	//4
		System.out.println(human.get(1).ssn);	//4
		
		
//		humans.add(new Human());
//		humans.add(new Human());
//		humans.add(new Human());
//		humans.add(new Human());
//		System.out.println("humans 크기");
//		System.out.println(humans.size());
		
		
	}
}

class Human{
	int ssn;
	static int number;
	public Human() {
		this.ssn = ++number;
	}
}