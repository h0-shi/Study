package static01;

class Car {
	final static double PI = 3.14;
	
	String model;
	String color;
	int speed;
	int id;
	static int numbers = 0;
	
	public Car(String model, String color, int speed ) {
		this.model = model;
		this.color = color;
		this.speed = speed;
		this.id = ++ numbers;
	}
	
	public static void aaa() {
	}
	public void bbb() {
	}
	public void ccc() {
	}
}

public class Static02 {
	
	public static void main(String[] args) {
		
	}
	
}
