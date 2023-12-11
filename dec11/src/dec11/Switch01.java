package dec11;

public class Switch01 {
	public static void main(String[] args) {

//		100-90 : A   80: b, 70 C, 60 D, 남지F
		int score = 75;
		char hakzum;

		if (score >= 90) {
			hakzum = 'A';
		} else if (score >= 80) {
			hakzum = 'B';
		} else if (score >= 70) {
			hakzum = 'C';
		} else if (score >= 60) {
			hakzum = 'D';
		} else {
			hakzum = 'F';

		}
		System.out.println(hakzum);

		switch ((score) / 10) {
		case 10:
			hakzum = 'A';
			break;
		case 9:
			hakzum = 'A';
			break;
		case 8:
			hakzum = 'B';
			break;
		case 7:
			hakzum = 'C';
			break;
		case 6:
			hakzum = 'E';
			break;
		default:
			hakzum = 'F';
		}
		System.out.println(hakzum);

	}

}
