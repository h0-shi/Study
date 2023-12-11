package dec11;

import java.util.Random;

public class DynamicArray03 {
	public static void main(String[] args) {
		char da[][] = new char[10][];
//		랜덤을 사용하여 내부측 길이를 만들고 그 속을 *로 채우라?
//		2~15 사이 이용
		Random random = new Random();
		for (int i = 0; i < da.length; i++) {
			da[i] = new char[(char) (Math.random() * 14 + 2)];
			for (int j = 0; j < da[i].length; j++) {
				da[i][j] = '*';
				System.out.printf("%c", da[i][j]);
			}
			System.out.printf("%n");
		}
	}

}
