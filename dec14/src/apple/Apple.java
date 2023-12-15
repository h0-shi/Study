package apple;
// 두 인스턴스가 발생하는 장소
public class Apple {
	public static void main(String[] args) {
		
		AppleSeller seller = new AppleSeller();
		AppleBuyer buyer = new AppleBuyer();
		
		seller.sell();
		seller.tellSeller();
		
		System.out.println("====");
		
		buyer.buy();
		buyer.tellBuyer();
	
		
	}

}
