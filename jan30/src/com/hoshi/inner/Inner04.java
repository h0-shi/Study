package com.hoshi.inner;

import java.util.ArrayList;
import java.util.List;

/*
 * 클래스 명이 없는 클래서, 선언과 동시에 인스턴스 생성을 하나로 통합한 클래스
 * 클래스를 인수값으로 사용하는 클래스
 * 객체를 한번만 사용 할 경우에 사용한다.
 * 
 * 클래스의 선언부가 없기 때문에 이름이 없고, 생성자를 가질 수 없다.
 * 슈퍼클래스의 이름이나 구현할 인터페이스를 구현하거나 둘 이상의 인터페이스를 구현할 수 없다.
 * 오직 하나의 클래스를 상속받거나 하나의 인터페이스만 구현 가능하다
 * 
 * 코드 블럭에 클래스를 선언하는 저만 제외하고는 생성자를 호출하는것과 동일하다.
 * 객체를 구성하는 new 문장 뒤에 클래스의 블럭{} 
 * 즉, 메서드를 구혀난 블럭이 있고 블럭 끝에는 세미콜론이 붙는다.
 * new 뒤에 오는 생성자명이 기존 클래스명이면 익명클래스이고, 자동으로 클래스의 하위 클래스가 된다.
 * 
 * 인터페이스인 경우에는 인터페이스를 상속하는 부모 클래스가 Object가 된다.
 */

class Anonumous {
	public void print() {
		System.out.println("출력한다옹");
	}
}

public class Inner04 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Anonumous any = new Anonumous() { 
//			얘가 자식 타입이 되었기 때문에 Override 한 메서드가 실행된다.
			@Override
			public void print() {
				System.out.println("출력하자용~");
			}

		};
		
		System.out.println("이제 끝낼거임");
		System.exit(0);
		any.print();
	}

}
