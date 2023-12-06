package dec06;

import java.util.Scanner;

/*시저 암호 만들기 => 글자+5으로 출력
 * ex) a=d, c=e
 */

public class Ceaser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String encrypted = "";

		System.out.println("암호화 할 문장을 입력하세요.(대문자)");
		String input = sc.nextLine();
		System.out.println(input);

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'Z') {
				char ch = (char) (input.charAt(i) - 23);
				encrypted = encrypted + String.valueOf(ch);
			} else {
				char ch = (char) (input.charAt(i) + 3);
				encrypted = encrypted + String.valueOf(ch);
			}
		}
		System.out.println(encrypted);
	}
}
