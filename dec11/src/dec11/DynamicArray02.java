package dec11;

public class DynamicArray02 {
	public static void main(String[] args) {
		
		char stars[][] = new char[10][];
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new char[i+1];
			for (int j = 0; j < stars[i].length; j++) {
				stars[i][j] = '*';
				System.out.printf("%c",stars[i][j]);
			}
			System.out.printf("%n");
		}
	}

}
