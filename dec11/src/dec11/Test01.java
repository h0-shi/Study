package dec11;

public class Test01 {
	public static void main(String[] args) {

		// 2진수 계산 -> num이 1보다 작아질 때 까지 나눔 = 1까지 나눔
		// 그걸 reversedParse에 저장 = 그럼 2진수가 뒤집어져서 저장됨
		int num = 10;
		String reversedParse = "";
		while (num >= 1) {
			reversedParse += Integer.toString(num % 2);
			num /= 2;
		}
		// reversedParse를 뒤집기
		String parse = "";
		for (int i = 0; i < reversedParse.length(); i++) {
			char temp;
			temp = reversedParse.charAt(reversedParse.length() - i - 1);
			parse += Character.toString(temp);
		}
		System.out.println(parse);

	}

}
