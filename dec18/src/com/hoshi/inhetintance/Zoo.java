package com.hoshi.inhetintance;

class Mouse extends Animal {
	public Mouse(String name, int age) {
		super(name, age);
		System.out.println(name + "이 태어납니다.");
	}

}

class ZooKeeper extends Animal {
	public ZooKeeper(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	public void feed(Animal animal) {
		animal.hp++;
	}
	
}

class KoreaShortHairCat extends Cat{

	public KoreaShortHairCat(String name, int age) {
		super(name, age);
	}
	
}

public class Zoo {
	public static void main(String[] args) {
		ZooKeeper zookeeper = new ZooKeeper("박시호", 27);
		Dog dog = new Dog("김수민", 24);
		Animal cat = new Cat("박기찬", 21);
		Mouse mouse = new Mouse("김동한", 26);
		KoreaShortHairCat koCat = new KoreaShortHairCat("나비", 0);

		zookeeper.feed(dog);
		zookeeper.feed(mouse);
		zookeeper.feed(cat);
		zookeeper.feed(cat);
		zookeeper.feed(cat);
		zookeeper.feed(cat);
		zookeeper.feed(koCat);
		System.out.println(cat.hp);
		System.out.println(koCat.hp);
		
	}
}
