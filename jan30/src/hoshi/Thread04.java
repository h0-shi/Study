package hoshi;

import java.util.ArrayList;
import java.util.List;

class A {

}
// 지금 thread를 동시다발적으로, 병렬로 실행하는거구나
public class Thread04 extends A implements Runnable {
	int seq;

	public Thread04(int seq) {
		this.seq = seq;
	}

	@Override
	public void run() {
		System.out.println(this.seq + "스레드 시작");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.seq + "스레드 끝");
	}

	public static void main(String[] args) {
		System.out.println("main starts");
		List<Thread> tList = new ArrayList<Thread>();
		
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Thread04(i));
			// t의 생성자로 runnable을 구현한 객체의 모습
			
			t.start();
			tList.add(t);
		}
		
		for (int i = 0; i < tList.size(); i++) {
			Thread t = tList.get(i);
			
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("main ends");
	}

}
