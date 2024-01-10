package com.seonwoo;

import java.util.Scanner;

public class WorkIn {
	public static void main(String[] args) {
		Recommand rec = new Recommand();
		Scanner sc = new Scanner(System.in);
		System.out.println("사용할 기능을 선택하시오");
		System.out.println("1.운동 추천\t2.루틴 조회\t3.루틴 삭제");
		int choice = sc.nextInt();
		switch(choice) {
		case 1 :
			rec.recommand();
			break;
		case 2:
			rec.showRecord();
			break;
		case 3:
			rec.delRecord();
			break;
		}
		
	}
}
