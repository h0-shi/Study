package com.seonwoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.seonwoo.dao.WorkDAO;
import com.seonwoo.dto.RoutineDTO;
import com.seonwoo.dto.WorkDTO;

public class Recommand {
	static Scanner sc = new Scanner(System.in);
	
//	추천하는 메서드
	public void recommand() {

		WorkDAO dao = new WorkDAO();
		List<String> result = new ArrayList();
		int tNum;
		int count;
		String type = "";
//		int sCount, chCount, lCount, bCount, aCount = 0;
		
		A: while (true) {
//			부위 입력
			System.out.println("운동 부위 입력 / 종료 원할 시 \"0\"입력");
			System.out.println("1.어깨 2.가슴 3.하체 4.등 5.팔");
			tNum = sc.nextInt();
			while(5<tNum||tNum<0) {
				System.out.println("잘못된 값을 입력했습니다.");
				System.out.println("다시 입력해주세요");
				tNum = sc.nextInt();
			}
			switch (tNum) {
			case 0:
				break A;
			case 1:
				type = "어깨";
				break;
			case 2:
				type = "가슴";
				break;
			case 3:
				type = "하체";
				break;
			case 4:
				type = "등";
				break;
			case 5:
				type = "팔";
				break;
			}

//			몇가지 운동할지 입력
			System.out.println("운동 가짓수 입력");
			List<WorkDTO> list = dao.recommand(type);
			count = sc.nextInt();
//			저장된 운동 종류보다 많은 수 입력 시.
			while (count > list.size()) {
				System.out.println("저장된 운동의 양보다 많은 수를 입력했습니다.");
				System.out.println("다시 입력해주세요");
				count = sc.nextInt();
			}
			for (int i = 0; i < count; i++) {

				int ran = (int) (Math.random() * list.size());
				String temp = list.get(ran).getwName();
				if (!result.contains(temp)) {
					result.add(temp);
				} else {
					i--;
				}
			}
			System.out.println("지금까지의 추천 루틴은 "+result.toString() + "입니다.");
		}
		if (!result.isEmpty()) {
			System.out.print("오늘의 추천 루틴은 ");
			System.out.println(result.toString() + "입니다.");
			save(result);
		} else {
			System.out.println("아무것도 입력하지 않으셨습니다.");
			System.out.println("프로그램 종료");
		}

	}

//	저장하는 메서드
	public void save(List<String> result) {
		WorkDAO dao = new WorkDAO();
//		루틴 저장 여부 확인
		System.out.println("해당 루틴을 저장하시겠습니까? [Y/N]");
		while (true) {
			String answer = sc.next();
//			루틴 저장
			if (answer.equals("Y")) {
				System.out.println("사용자의 이름을 입력해주세요.");
				String name = sc.next();
				String temp = "[";
				for (int i = 0; i < result.size(); i++) {
					if (i == result.size() - 1) {
						temp = temp + "\"" + result.get(i) + "\"" + "]";
					} else {
						temp = temp + "\"" + result.get(i) + "\"" + ",";
					}
				}
				System.out.println(temp);
				dao.insertRountine(name, temp);
				System.out.println("저장되었습니다.");
				System.out.println("프로그램 종료.");
				break;
//				루틴 저장하지 않음	
			} else if (answer.equals("N")) {
				System.out.println("저장하지 않습니다.");
				System.out.println("프로그램 종료.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

//  저장한 루틴 확인하는 메서드
	public void showRecord() {
		WorkDAO dao = new WorkDAO();
		System.out.println("조회 할 사람의 이름을 입력해주세요.");
		String name = sc.next();
		List<RoutineDTO> list = dao.showRoutine(name);
		for (int i = 0; i < list.size(); i++) {
			System.out.print("루틴No:"+list.get(i).getId()+"/");
			System.out.print(list.get(i).getName()+"님/");
			System.out.print(list.get(i).getwNames()+"/");
			System.out.println(" "+list.get(i).getwDate());
		}
		if(list.isEmpty()) {
			System.out.println("존재하지 않는 사용자 입니다.");
		}
		
	}
	
	
	/*발송 이후 추가본*/
	public void delRecord() {
		WorkDAO dao = new WorkDAO();
		System.out.println("삭제 할 루틴의 번호을 입력해주세요.");
		int id = sc.nextInt();
		int result =  dao.delRoutine(id);
		if(result == 1) {
			System.out.println(id+"번 루틴이 삭제되었습니다.");
		}else {
			System.out.println("존재하지 않는 루틴번호 입니다.");
		}
	}
	
	
}
