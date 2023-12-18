package zoo;

class Mouse {
	String name;
	int age;
	String breed;
	int hp;
}

class Horse {
	String name;
	int age;
	String breed;
	int hp;
}
class Bunny {
	String name;
	int age;
	String breed;
	int hp;
}

class ZooKeeper {
	public void feed(Mouse mouse) {
		mouse.hp++;
	}

	public void feed(Horse horse) {
		horse.hp++;
	}
	public void feed(Bunny bunny) {
		bunny.hp++;
	}
}

public class Zoo {
	public static void main(String[] args) {
		ZooKeeper zookeeper = new ZooKeeper();
		Mouse mouse = new Mouse();
		Horse horse = new Horse();
		Bunny bunny = new Bunny();

		zookeeper.feed(horse);
		zookeeper.feed(mouse);
		zookeeper.feed(bunny);
	}
}
