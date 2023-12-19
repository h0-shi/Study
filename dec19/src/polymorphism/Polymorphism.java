package polymorphism;

import java.util.ArrayList;
import java.util.List;

class Hero {
	String name;

	void attack() {
		System.out.println("공격");
	}
}

class Ironman extends Hero {

	public void makeSuit() {
		System.out.println("javis 수트 만들어.");
	}

	@Override
	void attack() {
		System.out.println("레이자 공격");
	}
}

class Hulk extends Hero {
	@Override
	void attack() {
		System.out.println("주먹!");
	}
}

class Superman extends Hero {

}

class Xman extends Hero {

}

public class Polymorphism {
	public static void main(String[] args) {
		Ironman ironman = new Ironman();
		Hero h = new Ironman();

		ironman.makeSuit();
//		h.makeSuit();	//안됨 부모가 자식의 메소드 상속 불고
		Ironman mark2 = (Ironman) h;// Hero타입 h 를 Ironman타입의 mark2에 대입
		mark2.makeSuit();
		((Ironman) h).makeSuit();

//		Hulk hulk = (Hulk)h;
//		hulk.makeSuit;	// 당연히 안됨
		Hulk hulk = new Hulk();
		hulk.attack();
//		((Ironman)((Hero)hulk).makeSuit();

		Hero avengers[] = new Hero[5];

		avengers[0] = new Ironman();
		avengers[1] = new Hulk();
		avengers[2] = new Superman();
		avengers[3] = new Xman();
		avengers[4] = new Ironman();

		for (Hero hero : avengers) {
			hero.attack();
		}
		
		List<Integer> list = new ArrayList<Integer>();
	}

}
