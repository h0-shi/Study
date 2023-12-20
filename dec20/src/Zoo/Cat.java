package Zoo;

public class Cat extends Animal implements Predator, Play {
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void play() {
	
	}
}
