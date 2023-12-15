package com.poseidon.constructor;

class Apple {
	String name;
	int age = 1;
	int money;
	String location;


	Apple(String name) {
		this.name = name;
	}

	Apple(String name, int age) {
		this(name);
		this.age = age;
	}
	
	public Apple(String string, int i, int j) {
		this(string, i);
		this.money = j;
	}


	void Apple() { // 얘는 생성자일까? 아니. void가 있으니 리턴타입이 있는거야~
		System.out.println("생성자가 동작합니다.");
	}

	public int sleep() {
		return 0;
	}
}

public class Constructor01 {
	public static void main(String[] args) {
		Apple apple01 = new Apple("수민", 21);
		Apple apple02 = new Apple("기찬");
		Apple apple03 = new Apple("균협",1,500);

	}

}
