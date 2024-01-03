package hoshi;

import java.util.ArrayList;
import java.util.List;

public class Thread03 extends Thread {
	int seq;

	public Thread03(int seq) {
		this.seq = seq;
	}

	@Override
	public void run() {
		System.out.println(this.seq+"스레드 시작");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.seq+"끝");
	}

	public static void main(String[] args) {
		System.out.println("Main Starts");
		
		List<Thread> tList = new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			Thread th1 = new Thread03(i);
			th1.start();
			tList.add(th1);
		}
		
		for (int i = 0; i < tList.size(); i++) {
			Thread t = tList.get(i);
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Main Ends");
	}
}
