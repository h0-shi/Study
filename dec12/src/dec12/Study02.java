package dec12;

import java.util.Arrays;

public class Study02 {
	public static void main(String[] args) {
		// 배열의 형태변환 char, int

		int number = 97;
		char chArray[] = new char[10];
//		int to char
		for (int i = 0; i < chArray.length; i++) {
			chArray[i] = (char)(number++);
		}
		for (char c : chArray) {
			System.out.printf("%2c",c);
		}
		System.out.println("");
//		String에서 char 추출 후 배열에
		String name = "홍길동";
		Character names[]	= new Character[name.length()];
		
		for (int i = 0; i < names.length; i++) {
			names[i] = name.charAt(i);
		}
		System.out.println(Arrays.toString(names));
		chArray = name.toCharArray();
		
		String temp = String.valueOf(chArray);
		temp = new String(chArray);
		System.out.println(temp);
		
		String str = "홍길동";
		System.out.println(System.identityHashCode(str));
		
		str += "?";
		System.out.println(System.identityHashCode(str));
		System.out.println(str);

		
	}
}
