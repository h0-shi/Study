package dec12;


public class Test02 {
	public static void main(String[] args) {
		int arr1[][][] = new int[3][3][3];

		int num = 1;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				for (int j2 = 0; j2 < arr1.length; j2++) {
					arr1[i][j][j2] = num++;
				}
			}
		}
		
		for (int[][] is : arr1) {
			for (int[] is2 : is) {
				for (int i : is2) {
					System.out.printf("%3d",i);
				}
				System.out.printf("%n");
			}
			System.out.printf("%n");
		}

		
		num = 1;
		int arr4[][][][]= new int[3][4][5][6];
		
		
		for (int i = 0; i < arr4.length; i++) {
			for (int j = 0; j < arr4[i].length; j++) {
				for (int j2 = 0; j2 < arr4[i][j].length; j2++) {
					for (int k = 0; k < arr4[i][j][j2].length; k++) {
						arr4[i][j][j2][k] = num++;
					}
				}
			}
		}
		
		for (int [][][]is : arr4) {
			for (int[][]is2 : is) {
				for (int[] is3 : is2) {
					for (int is4 : is3) {
						System.out.printf("%4d",is4);
					}
					System.out.println(" ");
				}
				System.out.println(" ");
			}
			System.out.println(" ");
		}
	}

}
