package test;

//2022년 1회차 3번
class A {
	int a;
	int b;
}

public class Test02 {

	static void func1(A m) {
		m.a *= 10;
	}

	static void func2(A m) {
		m.a += m.b;
	}

	public static void main(String[] args) {
		A m = new A();

		m.a = 100;
		func1(m);	//100*10 = 1000
		m.b = m.a;	//mb = 1000 +1000
		func2(m);	//2000

		System.out.printf("%d", m.a); //2000
	}
}
