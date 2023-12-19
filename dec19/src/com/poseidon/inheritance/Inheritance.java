package com.poseidon.inheritance;

import dec19.Test03;

class Animal extends Test03{
	protected String name;
	private int age;
	
	public void sleep() {
		testNumber = 10;
	}
	
//	public void setTestNumber(int testNumber) {
//		this.testNumber = testNumber;
//	}
//	
//	public int getTestNumber() {
//		return testNumber;
//	}
}

class Cat extends Animal{
	@Override
	public void sleep() {
		System.out.println("고양이는 침대에서 잔다옹");
	}
}

class Dog extends Animal{
	@Override
	public void sleep() {
		System.out.println(name+"은 바닥에서 잔다 멍");
	}
	
	public void walk() {
		System.out.println("산책갈까?");
	}
}


public class Inheritance extends Test03 {
	public static void main(String[] args) {
		
		Animal animal = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.name = "기찬";
		dog.sleep();
		cat.sleep();
//		cat.age = 10;
		cat.name = "감가상각";
		Inheritance inheritance = new Inheritance();
		System.out.println(inheritance.testNumber);
		
		
//		cat.testNumber = 10;
		
		Animal a = dog;
		a.sleep();
		
		Animal b = new Dog();
		
		b.sleep();
//		b.walk();		// Animal class에는 walk 메서드가 없음 부모->자식은 되는데 자식->부모는 안됨
		((Dog)b).walk();	// 하위 클래스의 속성으로 캐스팅해서 이건 됨
		dog.walk();
		
		Object obj = b;
		((Dog)(obj)).walk();
		
	
		
	}

}
