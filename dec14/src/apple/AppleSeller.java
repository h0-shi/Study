package apple;

import java.util.Scanner;

// 사과를 파는 사람
public class AppleSeller {
	// 속성
//	1. 가격, 객수, 보유금액, 
//	가격은 정찰제 appleprice(상수처리)

	final int APPLE_PRICE = 1000; // 사과가격
	int amount = 50;; // 보유사과
	int sellerMoney; // 보유 현금
// 생성자

//	사과를 파는 기능
	public void sell() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇개의 사과를 판매할까요?");
		int count = sc.nextInt();

		while (count > amount) {
			System.out.println("팔 수 있는 사과가 부족합니다.");
			System.out.println("사과는 " + amount + "개 판매 가능합니다.");
			System.out.println("몇개의 사과를 판매할까요?");
			count = sc.nextInt();
			continue;
		}
		amount -= count;
		sellerMoney += count * APPLE_PRICE;
	}
// 판매자의 정보를 말하는 기능
	public void tellSeller() {
		System.out.println("남은 사과는 " + amount + "개 입니다.");
		System.out.println("오늘 매출은 " + sellerMoney + "원 입니다.");

	}

}
