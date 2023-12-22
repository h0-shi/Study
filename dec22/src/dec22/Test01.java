package dec22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		String morse[];

		System.out.println("부호를 임력하세요");
		input = sc.nextLine();

		morse = input.split(" ");
		System.out.println(Arrays.toString(morse));

//		Map 이용하기
		Map<String, String> alpha = new HashMap<String, String>();
		alpha.put(".-","A");
		alpha.put("-...","B");
		alpha.put("-.-.","C");
		alpha.put("-..","D");
		alpha.put(".","E");
		alpha.put("..-.","F");
		alpha.put("--.","G");
		alpha.put("....","H");
		alpha.put("..","I");
		alpha.put(".---","J");
		alpha.put("-.-","K");
		alpha.put(".-..","L");
		alpha.put("--","M");
		alpha.put("-.","N");
		alpha.put("---","O");
		alpha.put(".--.","P");
		alpha.put("--.-","Q");
		alpha.put(".-.","R");
		alpha.put("...","S");
		alpha.put("-","T");
		alpha.put("..-","U");
		alpha.put("...-","V");
		alpha.put(".--","W");
		alpha.put("-..-","X");
		alpha.put("-.--","Y");
		alpha.put("--..","Z");
		alpha.put(""," ");
		
		for (int i = 0; i < morse.length; i++) {
			System.out.print(alpha.get(morse[i]));
		}

//		2차원 배열 이용하기
		String alpha2[][] = new String[2][27];
// 원래 문자,코드 순서였는데 바꾸니까 아래 코드가 안먹음...
//		for (int i = 0; i < alpha2[0].length; i++) {
//			alpha2[0][i] = String.valueOf((char) (i + 65));
//		}
//		alpha2[0][26] = " ";
//		System.out.println(Arrays.toString(alpha2[0]));
//		
//		
//		for (int i = 0; i < morse.length; i++) {
//			System.out.print(alpha2[0][Arrays.asList(alpha2[1]).indexOf(morse[i])]);
//		}

		sc.close();

	}

}
