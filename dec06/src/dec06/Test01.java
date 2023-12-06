package dec06;

public class Test01 {
	public static void main(String[] args) {
		char random = (char) (Math.random() * 127 + 1);
		System.out.println(random);
		if ('0' <= random && random <= '9') {
			System.out.println("이건 숫자네요");
		} else if ('A' <= random && random <= 'Z') {
			System.out.println("이건 영어 대문자네요");
		} else if ('a' <= random && random <= 'z') {
			System.out.println("이건 영어 소문자에요");
		} else {
			System.out.println("특수기호인데요?!");
		}
		
		if(Character.isDigit(random)) {
			System.out.println("숫자에요");
		} else if(Character.isUpperCase(random)) {
			System.out.println("대문자에요~");
		} else if(Character.isLowerCase(random)) {
			System.out.println("소문자에요!");
		} else {
			System.out.println("특수기호임다!");
		}
	}

}
