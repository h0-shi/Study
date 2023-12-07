package dec07;

public class Jc01 {
	public static void main(String[] args) {
		int j = 0;
		for (int i = 0; i <= 5; i++) {
			j += i;
			System.out.print(i);
			if(i == 5) {
				System.out.print(" = ");
				System.out.print(j);
			} else {
				System.out.print(" + ");
			}
		}
	}

}
