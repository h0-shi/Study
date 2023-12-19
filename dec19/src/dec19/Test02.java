package dec19;

class A {
	static int number; // 기울어짐
	int num;
}

class B {
	static B b = null;

	private int num;	//외부에서 활용 불가
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	private B() {
		System.out.println("생성자입니다.");
	}

	public static B getInsatnce() {
		if (b == null) {
			return b = new B();
		} else {
			return b;
		}
	}
}

public class Test02 {
	public static void main(String[] args) {
		A a = new A();
		A.number = 10;
		a.number = 100;
		
		B b = B.getInsatnce();
		B b2 = B.getInsatnce();
		B b3 = B.getInsatnce();
		B b4 = B.getInsatnce();
		
		b.setNum(1);
		b2.setNum(2);
		b3.setNum(3);
		b4.setNum(4);
		
		System.out.println(b.getNum());
		System.out.println(b2.getNum());
		System.out.println(b3.getNum());
		System.out.println(b4.getNum());
		
		
	}
}
