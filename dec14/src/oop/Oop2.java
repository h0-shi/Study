package oop;

class Human{	//클래스는 절대 겹치지 않게 한다. 클래스 속 클래스X
	//속성 = 변수
	String name;
	int age;
	String addr;
	
	// 생성자는 리턴 타입이 없음. 클래스명과 동일
	public Human(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public Human(String name, int age) { 
		this.name = name;
		this.age = age;
	}
	
	//기능 메소드
	public void introduction(){

	}
}

public class Oop2 {
	public static void main(String[] args) {
//		인간
		Human h1 = new Human("박기찬",1);	//이름, 나이
		System.out.println(h1);		// oop.Human@73a28541
		System.out.println(h1.name);// 박기찬
		System.out.println(h1.age);	// 1

		Human h2 = new Human("김수민",7);	//이름, 나이
		System.out.println(h2);		// oop.Human@6f75e721
		System.out.println(h2.name);// 김수민
		System.out.println(h2.age);	// 5
		
		Human h3 = new Human("금수자",10 ,"강남");
		System.out.println(h3);
		System.out.println(h3.name);
		System.out.println(h3.age);
		System.out.println(h3.addr);
		
		Human h4 = new Human("집없어", 125, null);
		System.out.println(h4);
		System.out.println(h4.name);
		System.out.println(h4.age);
		System.out.println(h4.addr);

		
		
	}
}
