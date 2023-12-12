package dec12;

import java.util.Scanner;

public class Study04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		String nArt[][] = new String[input][input];

		for (int i = 0; i < nArt.length; i++) {
			for (int j = 0; j < nArt[i].length; j++) {
				if (j == 0 || j == nArt[i].length - 1 || i == j) {
					nArt[i][j] = "N";
				}
				if (nArt[i][j] != "N") {
					nArt[i][j] = " ";
				}
			}
		}

		for (String[] str : nArt) {
			for (String str2 : str) {
				System.out.print(str2);
			}
			System.out.println(" ");
		}
	}

}
