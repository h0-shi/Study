package dec13;

public class String03 {
	public static void main(String[] args) {
		/*
		 * String 		 = Immutable한 객체는 간단하게 사용 가능. 동기화에 대한건 생각 안함
		 * StringBuffer  = 각 메서드별로 Synchronized Keyword가 존재함, 멀티스레드 환경에서도 동기화지원 
		 * StringBuilder = 스레드에 안전한지 여부가 전혀 관계 없는 프로그램 개발시 사용
		 */
		
		StringBuilder sb = new StringBuilder();
//		append
		sb.append("가나다");
		sb.append("마바사");
		sb.append("아자차카타파하");
		System.out.println(sb);
//		toString
		String text = sb.toString();
		System.out.println(text);
		
//		equals
		System.out.println(text.equals(sb));
		System.out.println(text.equals(sb.toString()));
//		insert
		sb.insert(0,"하");
		sb.insert(sb.length(),"가");
		System.out.println(sb);
//		delete
		sb.delete(0, 4);
		System.out.println(sb);
//		replace
		sb.replace(3, sb.length(), "입니다.");
		System.out.println(sb);
//		reverse
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
//		subSequence
		System.out.println(sb.subSequence(0, 3));
		text = sb.toString();
		sb.append("가각가가니나다ㅏㅁ나바사차");
//		capacity
		System.out.println(sb.capacity());
	}

}
