package dec08;

import java.io.IOException;

public class While01 {
	public static void main(String[] args) throws IOException {
		int count = 0;
		boolean quit = true;

		while (quit) {
			System.out.println("게임을 시작합니다.");
			System.out.println("게임중...");
			System.out.println("종료할까요?(Y/N)");

			char input = (char) System.in.read();
//			read는 엔터까지 같이 읽는다. Y\n\r NextLine같네
//			n = new line // r = return
			System.in.read();// 엔터키 처리
			System.in.read();// 엔터키 처리
			if (input == 'Y'||input=='y') {
				System.out.println("시스템 종료");
				quit = !quit;
			}
		}
	}
}
