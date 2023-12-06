package dec06;

public class For04 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println(i);
		}

		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 4; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		int number[] = {10,20,30,40,50};
		for(int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
		}
		for(int i : number) { // : 데이터 : 자료
			System.out.println(i);
		}
		System.out.println("===절취선===");
		for (char ch = 'a'; ch<'f';ch++) { // 숫자 없이 for문 돌리기
			System.out.println(ch);
		}
		for(;;) {	//무한루프
			System.out.println("나는 네모다");
		}
	}

}
