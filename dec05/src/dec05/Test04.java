package dec05;

public class Test04 {
	public static void main(String[] args) {
		int n = 1;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if(i==1) {
					System.out.print(j+"단\t\t");
				} else {
				n = i*j;
				System.out.print(j+" * "+i+" : "+n+"\t"); }
			}System.out.println();

		}
	}

}
