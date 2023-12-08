package dec08;

import java.util.Random;

//AADDA-ADDAA-ADAAD-ADDDD-AAAAD

public class Test03 {
	public static void main(String[] args) {

		Random random = new Random();
		String serials[] = new String[10];
		// A~X , 1~9
		for (int i = 0; i < 10; i++) {
			String temp = "";
			String serialTemp = "";
			for (int k = 0; k < 5; k++) {
				switch (k) {
				case 0:
					temp = "";
					for (int j = 0; j < 5; j++) {
						if (j < 2 || j == 4) {
							char eng = (char) random.nextInt(65, 88);
							temp += String.valueOf(eng);
						} else {
							char eng = (char) random.nextInt(49, 57);
							temp += String.valueOf(eng);
						}
					}
					serialTemp += temp + "-";
					break;

				case 1:
					temp = "";
					for (int j = 0; j < 5; j++) {
						if (j == 0 || j > 2) {
							char eng = (char) random.nextInt(65, 88);
							temp += String.valueOf(eng);
						} else {
							char eng = (char) random.nextInt(49, 57);
							temp += String.valueOf(eng);
						}
					}
					serialTemp += temp + "-";
					break;

				case 2:
					temp = "";
					for (int j = 0; j < 5; j++) {
						if (j == 0 || j == 2 || j == 3) {
							char eng = (char) random.nextInt(65, 88);
							temp += String.valueOf(eng);
						} else {
							char eng = (char) random.nextInt(49, 57);
							temp += String.valueOf(eng);
						}
					}
					serialTemp += temp + "-";
					break;

				case 3:
					temp = "";
					for (int j = 0; j < 5; j++) {
						if (j == 0) {
							char eng = (char) random.nextInt(65, 88);
							temp += String.valueOf(eng);
						} else {
							char eng = (char) random.nextInt(49, 57);
							temp += String.valueOf(eng);
						}
					}
					serialTemp += temp + "-";
					break;

				case 4:
					temp = "";
					for (int j = 0; j < 5; j++) {
						if (j != 4) {
							char eng = (char) random.nextInt(65, 88);
							temp += String.valueOf(eng);
						} else {
							char eng = (char) random.nextInt(49, 57);
							temp += String.valueOf(eng) + "";
						}
					}
					serialTemp += temp;
					break;

				}
				serials[i] = serialTemp;
			}
		}
		for (int j = 0; j < serials.length; j++) {
			System.out.println(serials[j]);
		}

	}
}
