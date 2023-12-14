package dec14;

import java.util.Scanner;

class Cat {
//	속성 : 변수
	String name; // 초기화 필요 없음
	int satatus = 0;

//	생성자 : 인스턴스를 생성할 때 사용하는 메서드
	public Cat(String name) {
		this.name = name;
	}

//	기능 : 메서드
	// 고양이를 괴롭히면 status+1 되는 기능
	// status 15 이상 시 고양이가 반격함
	public void attack(int count) {
		if (satatus >= 15) {
			System.out.println(name + "이(가) 개빡쳤습니다.");
			System.out.println("당신을 향해 냥냥펀치를 날립니다.");
		} else {
			System.out.println(name + "을(를) 괴롭혔습니다.");
			System.out.println(name + "의 분노가 현재 " + ++satatus + "입니다.");
		}
	}

	// 고양이를 쓰다듬으면 status가 -1되는 기능
	// status 10 이하로 되면 고양이가 골골댐
	public void stroke() {
		System.out.println(name + "를 쓰다듬었습니다.");
		System.out.println(name + "의 분노가 현재 " + --satatus + "입니다.");
		if (satatus < 9) {
			System.out.println(name + "이(가) 골골송을 부릅니다.");
		}
	}

	public int sleep() {
		System.out.println(name + "이(가) 잠을 잡니다.");
		return this.name.length();
	}
	
	public int add(int num1, int num2) {
		int num3 = num1+num2;
		return num3;
	}

}

public class CM01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Cat cat1 = new Cat("아롱");
		Cat cat2 = new Cat("다롱");
		Cat cat3 = new Cat("젤리");
		Cat cat4 = new Cat("푸딩");
		cat1.sleep();
		cat2.sleep();
		cat3.sleep();
		cat4.sleep();

		System.out.println("==");
		Cat cats[] = new Cat[4];
		cats[0] = cat1;
		cats[1] = cat2;
		cats[2] = cat3;
		cats[3] = cat4;

		for (int i = 0; i < cats.length; i++) {
			cats[i].sleep();
		}
		System.out.println("==");

		System.out.println("어떤 고양이를 괴롭히겠습니까? 1~4");
		int num =  1;//sc.nextInt();
		System.out.println("고양이를 몇번 괴롭히시겠습니까?");
		int count = 5;//sc.nextInt();
		for (int i = 0; i < count; i++) {
			cats[num - 1].attack(count);
		}
		System.out.println("==");
		System.out.println("고양이를 몇번 쓰다듬으시겠어요?");
		num = 5; //sc.nextInt();
		for (int i = 0; i < num; i++) {
			cat1.stroke();
		}
		
		int length = cat1.sleep();
		System.out.println(length);

		int result = cat4.add(10,20);//호출 할 때에는 파라미터 수, 순서, 타입에 맞게
		
		System.out.println(result);
		
	}

}
