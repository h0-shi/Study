package com.hoshi.access;
/*
 * 접근 제어자 Access Modifiers
 * 자바에서는 접근제어자를 통해 각 api의 접근 권한을 제한할 수 있다.
 */

class Apple { // default class
	private String name; // default field
	int age;

	private Apple() {
	}
	
	static Apple getInstance() {
		return new Apple(); 
	}
	
	void print() {
		System.out.println("저는 " + name + "입니다.");
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}
	
	void setAge(int age) {
		if(0 > age) {
			this.age = 1;
		} else {
			this.age = age;
		}
	}
}

public class AccesModifiers {

	public static void main(String[] args) {
		Apple a = Apple.getInstance();

		a.setName("3PO");
		System.out.println(a.getName());
		a.setAge(30);
		System.out.println(a.getAge());
	}

}
