package dec06;

public class For01 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			String j = "*";
			System.out.print(j);
		}
		System.out.println("");
		for (int i = 1; i <= 100; i++) {
			if (i == 100) {
				System.out.println(i);
				break;
			} else if( i%10==0) {
				System.out.println(i + ",");
			} else {
				System.out.print(i + ",");
			}
		}
		System.out.println("===절취선====");
		System.out.println("1~25 짝수의 갯수는?");
		int count = 0;
		for (int i = 1; i <= 25; i++) {
			if(i%2 == 0) {
				++count;
			}
		} System.out.println(count);
		
		}
}
