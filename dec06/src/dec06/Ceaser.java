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
		System.out.println("얼만큼 뒤로 보낼테인가.");
		int num = sc.nextInt();
		System.out.println(input);

		for (int i = 0; i < input.length(); i++) {
			char ch = (char) (input.charAt(i) + num);
			encrypted += ch;
		}
		System.out.println(encrypted);
	}
}
