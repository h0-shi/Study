
public class Memory {
	public static void main(String[] args) {
		System.out.println("main method starts");
		System.out.println("main method is processing now");
		first();
		System.out.println("main method ends");
	}
	
	static void first() {
		System.out.println("first method strats");
		System.out.println("first method is processing now");
		second();
		System.out.println("first method ends");
	}
	
	static void second() {
		System.out.println("second method starts");
		System.out.println("second method ends");
	}
}
