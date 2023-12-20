package com.poseidon.inter;

//인터페이스 만들기
interface Do{
	public abstract void attack();	// abstract가 없어도 무관
	public void play(); // {  바디 있으면 추상 메서드가 아니기 때문에 오류 발생
//	}
	
}


abstract class Hero {
	String name;
//	public abstract void attack();	//미완성된 메서드 = 추상메서드 
	public void print() { 		// 추상 클래스는 일반 메서드 가질 수 있음
	}
}

class Superman extends Hero implements Do{
	String name;
	// 부모의 메서드를 자식이 재정의하여 사용

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}

public class Inter01 {

}
