package test;

import com.poseidon.constructor.Human;

public class Test01 {
	public static void main(String[] args) {
		
		Human h1 = new Human("길동",17);
		System.out.println(h1.getName());
		h1.setMoney(5000);
		System.out.println(h1.getMoney());
		h1.setAddr("서울");
		System.out.println(h1.getAddr());
	}
}
