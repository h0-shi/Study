package dec05;

public class Operator {
	public static void main(String[] args) {
		System.out.println("몇번째 글자일까~?");
		String name = "홍길동";
		System.out.println(name.indexOf("홍"));
		System.out.println(Math.random());

		// 선행증감
		int num = 1;
		int num2 = ++num; // num에도 +1을 할당하는것임
		System.out.println(num);
		System.out.println(num2);

		int num3 = ++num + num2;
		System.out.println(num); // 3
		System.out.println(num2); // 2
		System.out.println(num3); // 5

		int num4 = --num + --num2 + --num3;
		System.out.println(num);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4); // 7
		// 후행증감
		num = 1;
		num2 = 1;
		num3 = 1;
		num2 = num--; // num == 0
		System.out.println("---------");
		System.out.println(num); // 0
		System.out.println(num2); // 1
		System.out.println("---");

		num4 = ++num - --num2 + num3--;
		System.out.println(num); // 1
		System.out.println(num2); // 0
		System.out.println(num3); // 0

		num4 = 2;
		System.out.println(1 != 2); // t
		System.out.println(1 != (num4 - 1));

		// 10진법 1을 2진법으로 변환
		String result = Integer.toBinaryString(-1); // 1 = 000 0001
		System.out.println(result);
		/*
		 * -1: 11111111111111111111111111111111 
		 * 0 : 00000000000000000000000000000000 
		 * 1 : 00000000000000000000000000000001 
		 * 2 : 00000000000000000000000000000010 
		 * 3 : 00000000000000000000000000000011
		 */
		System.out.println("--");
		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(~1));
		System.out.println("--");
		num = 2;
		num2 = 2;
		num3 = 6 % 3; // 0 ... 2니까 나머지 2가 맞는뎁쇼
		System.out.println(num3);
		System.out.println("--비트연산--");

//		1010 = 10
//		0110 = 6
//		1100 = 12
//		0011 = 3
		System.out.println(10 ^ 6); // 12
		System.out.println("------삼항연산-------");
		System.out.println(num2 == 1 ? "1입니다." : "1이 아닌디요?");
		
		System.out.println("------배정대입-------");
		int number = 10;
		number += 1;
		System.out.println(number);
		number -= 1;
		System.out.println(number);
		number /= 2;
		System.out.println(number);
	}
}
