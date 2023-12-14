package apple;

import java.util.Scanner;

// 사과 사는 사람
public class AppleBuyer {
	// 속성
//	갖고있는 사과의 수, 보유 자산, 
	int amount;
	int buyerMoney = 10000; // 보유금액

	AppleSeller appleSeller = new AppleSeller();
	// 생성자

	// 기능
//	 사과를 사는 기능
	public void buy() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇개의 사과를 구매할까?");
		int count = sc.nextInt();
		while (count * appleSeller.APPLE_PRICE > buyerMoney) {
			System.out.println("가진 돈이 부족합니다.");
			System.out.println("사과는 " + buyerMoney / appleSeller.APPLE_PRICE + "개 구매 가능합니다.");
			System.out.println("몇개의 사과를 구매할까?");
			count = sc.nextInt();
			continue;
		}
		amount += count;
		buyerMoney -= count * appleSeller.APPLE_PRICE;
	}

	public void tellBuyer() {
		System.out.println("구매한 사과는 " + amount + "개 입니다");
		System.out.println("남은 돈은 " + buyerMoney + "원 입니다.");
	}

}
