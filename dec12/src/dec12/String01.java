package dec12;

public class String01 {
	public static void main(String[] args) {
		String hi = new String("Hi");
		String hi2 = new String("Hi");
		
		System.out.println(hi==hi2); // true
		// R타입에서는 == 비교는 같은 객체인지 비교
		
		System.out.println(System.identityHashCode(hi));
		System.out.println(System.identityHashCode(hi2));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			System.out.println(System.identityHashCode(sb));
			sb.append(i);
		}
		
		sb.append("Hi");
		sb.append("hi");
		sb.append("Hello");
		sb.append("안녕");
		
		System.out.println(sb);
		String temp  = sb.toString();
		System.out.println(temp);
		System.out.println("====");
		temp = "안녕하세요";
		System.out.println(temp.indexOf('요'));
		System.out.println(temp.contains("녕"));
	}
}
