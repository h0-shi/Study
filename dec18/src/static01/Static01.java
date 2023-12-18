package static01;

class Cat{
	static String name;
	
	public static void print() {
		
	}
}

public class Static01 {

	public static void main(String[] args) {

		Cat.name = "3PO";
		
		Cat.print();
	}
}
