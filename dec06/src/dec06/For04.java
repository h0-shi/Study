package dec06;

public class For04 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println(i);
		}

		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 4; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
