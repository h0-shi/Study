package dec06;

public class Test03 {
	public static void main(String[] args) {

		String text = "1q2w3e4r5t";
		String result = "";
		// 여기서 숫자만 출력해라
		for (int i = 0; i < text.length(); i++) {
			if (Character.isAlphabetic(text.charAt(i)) != true) {
				result += (text.charAt(i));
			}
		}
		System.out.println(result);
	}

}
