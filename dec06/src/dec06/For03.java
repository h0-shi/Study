package dec06;

public class For03 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				{
					System.out.print(i + ":" + j + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("=====절취선=====");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");

		}

		for (int i = 3; i > 0; i--) {
			for (int j = 0; j < 5; j++) {
				{
					System.out.print(i + ":" + j + " ");
				}
			}
			System.out.println("");
		}

		System.out.println("=====절취선2=====");
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				{
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		System.out.println("=====절취선3=====");
	}
}
