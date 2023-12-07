package dec07;

public class Array08 {
	public static void main(String[] args) {

		String text[] = new String[5];
		text[0] = "홍길동";
		text[1] = "김길동";
		text[2] = "최길동";
		text[3] = "정길동";
		text[4] = "박길동";

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
