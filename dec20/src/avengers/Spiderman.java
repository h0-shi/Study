package avengers;

public class Spiderman extends Hero implements Attack {

	@Override
	public void attack() {
		System.out.println("거미줄 공격");
	}

	@Override
	public void defence() {
		System.out.println("거미줄 방어");
	}

}
