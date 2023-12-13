package dec13;

import java.util.Arrays;
import java.util.StringTokenizer;

public class String02 {
	public static void main(String[] args) {

		String email = "whdgus9655@kakao.com";
		System.out.println(email.indexOf("@"));

		System.out.println("\n" + email.substring(email.indexOf("@") + 1));

		int index = email.indexOf("@");
		String subString = email.substring(index + 1);
		System.out.println(subString);

		//
		System.out.println(email.substring(0, 10));

		if (email.indexOf("@") != -1) {
			System.out.println("올바른 이메일입니다.");
			System.out.println("당신의 아이디는 "
					+ email.substring(0, email.indexOf("@")));

			System.out.println("당신의 이메일 서버는 "
					+ email.substring(email.indexOf("@")+1));
		} else {
			System.out.println("올바르지 않은 이메일입니다.");
		}
		//
		System.out.println(email.lastIndexOf("o"));
		System.out.println(email.lastIndexOf("k"));
		System.out.println(email.replace('o','O'));
		String text = " 안녕하세요 전 곧 퇴근합니다 ";
		System.out.println(text.trim());
		String name = "shi ho";
		System.out.println(name.toLowerCase());
		name = String.valueOf(name.charAt(0)).toUpperCase() + name.substring(1);
		System.out.println(name);
		
		String emailArr[] = text.split(" ");
		System.out.println(Arrays.toString(emailArr));
		text = "85,65,100";
		System.out.println(Arrays.toString(text.split(",")));
		
		StringTokenizer st = new StringTokenizer("Hello,World,java,Spring",",");
		System.out.println(st);
		while(st.hasMoreTokens()) {
			System.out.println("몇번 반복?");
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
		}
		
	}
	public static void print() {}			// 파라미터 없음
	public static void print(int number) {}	// 파라미터 int

}
