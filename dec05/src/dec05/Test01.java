package dec05;
/* 나는 과수원 사장이다
 * 나는 사과 배 오렌지를 판다
 * 하루에 사과5, 배7, 오렌지5개가 열린다
 * 하루 과일의 총 생산량을 구하고 시간당 몇개의 과일이 열리는지 출력
 */

public class Test01 {
	public static void main(String[] args) {
	int apple = 5;
	int pear = 7;
	int orange = 5;
	int total = apple+pear+orange;
	float average = total/24F;
	System.out.println("하루 총 생산량 : "+total);
	System.out.println("시간당 생산량 : "+average);
	}
}
