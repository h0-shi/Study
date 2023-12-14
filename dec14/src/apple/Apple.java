package apple;

public class Apple {
	public static void main(String[] args) {
		
		AppleSeller seller = new AppleSeller();
		AppleBuyer buyer = new AppleBuyer();
		
		seller.sell();
		seller.tellSeller();
		
		buyer.buy();
		buyer.tellBuyer();
	
		
	}

}
