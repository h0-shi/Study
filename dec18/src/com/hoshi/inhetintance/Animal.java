package com.hoshi.inhetintance;

public class Animal {
	String name;
	String breed;
	int age;
	int hp;
	
	public Animal(String name, int age) {
		System.out.println(name+"이(가) 태어납니다.");
		this.name = name;
		this.age = age;
	}
}
