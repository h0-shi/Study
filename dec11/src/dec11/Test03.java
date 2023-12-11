package dec11;

public class Test03 {
	public static void main(String[] args) {
		
		int i = 0;
		int sum  = 0;
		while(i<10)	{
			i++;
			if( i%2 == 1) { // 1,3,5,7,9 생략 2,4,6,8,10만 더함
				continue;
			}
			sum +=i;
		}
		System.out.println(sum);
	}

}
