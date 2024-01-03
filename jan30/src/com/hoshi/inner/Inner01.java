package com.hoshi.inner;
/*
 * 중첩클래스 : 클래스 속 클래스
 * 
 * Immer Class 내부 클래스
 * 클래스 내부에 선언된 클래스이다 = 두 클래스간 서로 긴밀한 관계
 * 
 * 장점
 * 내부 클래스에서 외브 클래스의 멤버들을 쉽게 접근 할 수 있다.
 * 캡슐화, 코드 복잡성을 줄여준다
 * 
 * 보통의 클래스
 * class A{}
 * class B{}
 * 
 * 내부클래스 : 두 클래스가 긴밀하고, 내부 클래스는 잘 사용되지 않음
 * 
 * class A{
 * 		class B{
 * 		}
 * }
 * 
 * 종류
 * 스태틱 클래스
 * :외부 클래스의 멤버 변수 위치에 사용
 * 	외부 클래스의 스태틱 멤버처럼 다뤄진다.
 * 	주로 외부 클래스의 스태틱 멤버, 특히 스태틱메서드에서 사용 될 목적으로 선언	
 * 
 * 멤버 클래스
 * :외부 클래스의 멤버 변수 위치에 선언
 * 	외부 클래스의 인스턴스 멤버처럼 사용한다.
 * 	주로 외부 클래스의 인스턴스 멤버들과 관련된 작업에 활용된다.
 *  
 * 지역 클래스
 * :외부 클래스의 메서드나 초기화 블럭 안에서 선언
 * 	선언된 영역 내부에서만 사용 가능하다
 * 
 * 익명 클래스
 * :클래스 선언과 객체 생성을 동시에 하는 이름없는 일회용 클래스
 */
//class A{
//	int num;
//	class B{ // 멤버클래스 = 정적 멤버 클래스
//		public B() {
//			class BB{ //지역 클래스(생성자 안에서 생성된 클래스)
//				
//			}
//		}
//		
//	}
//}
//
//class C{
//	interface D{
//		
//	}
//}

class A{
	public A() {
		System.out.println("A클래스가 생성됨");
	}
	class B{ // 인스턴스 멤버 클래스
		int field;
//		static int field2;
		public B() {
			System.out.println("B 객체가 생성됨");
		}
		public void methodB() {
			
		}
		
//		public static void methodB2() {	} // 중첩클래스에서는 static을 못쓰는구나
	}
	
	static class C{
		int field1;
		static int field2;
		public C() {
			System.out.println("C객체 생성");
		}
		public void methodC() {}
		public static void methodC2() {}
	}
}

public class Inner01 {

}
