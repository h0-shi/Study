package oop;

class Conv {
	public Conv(int a) {
		this.a = a;
	}

	int func() {
		int b = 1;
		for (int i = 1; i < a; i++) { // a = 5, for구문은 4번 돌아 1,2,3,4
			b = a * i + b; //  a+i = 1a/5,2a/10,3a/15,4a/20,5a/25
		}					// b =   5+1 ,10+6 ,15+16,20+31. b = 51 
		return a + b;	// 5+51 = 56
	}

	int a;	//속성
}

public class Test01 {
	public static void main(String[] args) {
		Conv obj = new Conv(3);
		obj.a = 5;	
		int b = obj.func();	//8
		System.out.println(obj.a+b);	//56+5 = 61
	}

}
