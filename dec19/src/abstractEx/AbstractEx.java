package abstractEx;

abstract class Hero {		// 추상메서드
	String name;
	int age;

	public abstract void attack(); 	// 추상클래스
	public abstract void sleep(); 	// 추상클래스
}

class Ironman extends Hero {
	@Override
	public void attack() {
		System.out.println("레이자 지지징");
	}
	@Override
	public void sleep() {
		
	}

}

class Hulk extends Hero {
	@Override
	public void attack() {
		System.out.println("주머어어억");
	}
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}
}

class Spider extends Hero {

	@Override
	public void attack() {			//미구현된 메서드를 자식 클래스에서 구현해야 함 
		
	}
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

}

class Hawkeye extends Hero{

	@Override
	public void attack() {		//바디만 있어도 구현한것으로 인정함
	}
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}
	
}

public class AbstractEx {
	public static void main(String[] args) {
			
//		Hero hero = new Hero();
		
		
	}
}
