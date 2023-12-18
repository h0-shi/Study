package com.hoshi.inhetintance;
class A{
	int field1;
	void methid1() {
		
	}
}

class B extends A{	//B가 A를 상속받음
	int field2;
	void method2() {
		
	}
}

class C extends B{

}

public class Inherintance {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		b.field1 = 100;
		b.methid1();
		C c = new C();
		c.methid1();
		
		Cat cat = new Cat(null, 0);
		Dog dog = new Dog(null, 0);
		
	}
}
