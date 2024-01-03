package hoshi;

public class Thread02 extends Thread{
	int seq;
	
	public Thread02(int seq) {
		this.seq = seq;
	}
	
	@Override
	public void run() {
		System.out.println(this.seq + " 스레드 시작");
		try {
			Thread.sleep(1000);// 1초 = 1000
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.seq + " 스레드 끝");
	}
	
	public static void main(String[] args) {
		System.out.println("main 메소드 시작");
		
		for (int i = 0; i < 10; i++) {
			Thread02 th02 = new Thread02(i);
			th02.start();
		}
		
		System.out.println("main 메소드 끝");
	}
}
