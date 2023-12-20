package Zoo;

public class Zoo {
	
	public static void main(String[] args) {
		ZooTrainer trainer = new ZooTrainer();
		Dog dog = new Dog();
		dog.setName("3PO");
		trainer.feed(dog);
		
		Cat cat = new Cat();
		cat.setName("R2D2");
		
		Mouse mouse = new Mouse();
		mouse.setName("miki");
		
		trainer.feed(cat);
		trainer.feed(mouse);
		
	}

}
