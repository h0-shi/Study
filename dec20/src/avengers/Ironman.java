package avengers;

public class Ironman extends Hero implements Javis, Fly, Attack {

	@Override
	public void attack() {
		System.out.println("레이쟈");
	}

	@Override
	public void defence() {
		System.out.println("방어");
	}

	@Override
	public void fly() {
		System.out.println("날아라");
	}

	@Override
	public void makeSuit(int count) {
		System.out.println(count+"개 만들어줘.");
	}

}
