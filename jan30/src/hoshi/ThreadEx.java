package hoshi;

/*
 * thread (p.520)
 * thread, io, net, gui
 * 프로젝트 제작 (자바+db)
 * 
 * 프로세스 : 운영체제에서는 실행중인 어플리케이션을 프로세스라고 한다.
 * 			사용자가 애플리케이션을 실행하면 운영체제로부터 실행에 필요한 메모리를 할당받아
 * 			어플리케이션의 코드를 실행하는것이 프로세스
 * 
 * 스레드 : 운영체제에는 두가지 이상의 작업을 동시에 처리하는 멀티테스킹을 할 수 있도록
 * 			CPU 및 메모리 자원을 프로세스마다 적절히 할당해주고, 병렬로 실행시킨다.
 * 
 * 스레드 생성과 실행하는 방법
 * 		1. Runable 인터페이스 구현
 * 		2. Thread 클래스 상속
 * 
 * 방법이 2가지인 이유 
 *		: 클래스가 이미 다른 클래스를 상속받은 경우 Thread 클래스를 상속받을 수 없다.
 *		  이 경우에 Runaable 인터페이스를 사용할 수 있다. // 대부분의 경우 Thread 클래스 상속해서 제작하는것이 편하다.
 *
 *	실행은 start()로 실행
 * 
 */

public class ThreadEx extends Thread{
	int seq;
	
	public ThreadEx(int seq) {
		this.seq = seq;
	}
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
			ThreadEx th02 = new ThreadEx(i);
			th02.start();
		}
		
		System.out.println("main 메소드 끝");
	}

}
