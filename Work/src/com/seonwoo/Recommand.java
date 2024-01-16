package com.seonwoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.seonwoo.dao.WorkDAO;
import com.seonwoo.dto.RoutineDTO;
import com.seonwoo.dto.WorkDTO;

public class Recommand {
	static Scanner scan = new Scanner(System.in);
//	추천하는 메서드
	public void recommand() {

		WorkDAO dao = new WorkDAO();
		
		int tNum;
		boolean saved = false;
		
		String type = "";
		
		List<List<String>> wList = new ArrayList<List<String>>();
		
		List<String> shoulder = new ArrayList<String>();
		shoulder.add("어깨");
		wList.add(shoulder);

		List<String> chest = new ArrayList<String>();
		chest.add("가슴");
		wList.add(chest);
		
		List<String> leg = new ArrayList<String>();
		leg.add("하체");
		wList.add(leg);
		
		List<String> back = new ArrayList<String>();
		back.add("등");
		wList.add(back);
		
		List<String> arm = new ArrayList<String>();
		arm.add("팔");
		wList.add(arm);
		
		List<String> wBody = new ArrayList<String>();
		wBody.add("전신");
		wList.add(wBody);

		A: while (true) {
//			부위 입력
			System.out.println("\n-------------운동 부위 선택---------------");
			System.out.println("0.종료 1.어깨 2.가슴 3.하체 4.등 5.팔 6.전신");
			System.out.print("입력 : ");
			tNum = scan.nextInt();
			while (6 < tNum || tNum < 0) {
				System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요.");
				System.out.println("\n-------------운동 부위 선택---------------");
				System.out.println("0.종료 1.어깨 2.가슴 3.하체 4.등 5.팔 6.전신");
				System.out.print("입력 : ");
				tNum = scan.nextInt();
			}
			switch (tNum) {
			case 0:
				break A;
			case 1:
				tNum--;
				type = "어깨";
				break;
			case 2:
				tNum--;
				type = "가슴";
				break;
			case 3:
				tNum--;
				type = "하체";
				break;
			case 4:
				tNum--;
				type = "등";
				break;
			case 5:
				tNum--;
				type = "팔";
				break;
			case 6:
				tNum--;
				type = "전신";
				break;
			}
			List<WorkDTO> list = dao.recommand(type);

//			몇가지 운동할지 입력
			System.out.println("");
			System.out.print("["+type+"]을(를) 선택하셨습니다. ");
			System.out.println("몇 종류의 "+type+"운동을 하시겠습니까?");
			System.out.print("입력 : ");
			
			int count = scan.nextInt();
//			저장된 운동 종류보다 많은 수 입력 시.
			while (count > list.size()) {
				System.out.println("\n저장된 운동의 종류보다 큰 수를 입력했습니다.\n다시 입력해주세요.");
				System.out.println("");
				System.out.println("몇 종류의 "+type+"운동을 하시겠습니까?");
				System.out.print("입력 : ");
				count = scan.nextInt();
			}
//			랜덤한 운동 뽑기
			for (int i = 0; i < count; i++) {
				int ran = (int) (Math.random() * list.size());
				String temp = list.get(ran).getwName();
				
				if (!wList.get(tNum).contains(temp)) {
					wList.get(tNum).add(temp);
					saved = true;
				} else {
					i--;
				}
			}
			
			System.out.println("\n========================================");
			System.out.println("현재까지의 추천 루틴\n");
			
			for (int i = 0; i < wList.size(); i++) {
				if(wList.get(i).size()>1) {  // 부위 유무 확인
					System.out.print(wList.get(i).get(0) + " : ");
					System.out.print(wList.get(i).subList(1,wList.get(i).size()));
					System.out.println();
				}
		}	
			System.out.println("========================================");
		}
		if (saved) {
			System.out.println("\n오늘의 추천 루틴은 \n");
			for (int i = 0; i < wList.size(); i++) {
				if(wList.get(i).size()>1) {  // 부위 유무 확인
					System.out.print(wList.get(i).get(0) + " : ");
					System.out.print(wList.get(i).subList(1,wList.get(i).size()));
					System.out.println();
				}
			}
			
//			저장
//			save(parts);
			System.out.println("----------------");
		} else {
			System.out.println("아무것도 입력하지 않으셨습니다.");
			System.out.println("추천 서비스가 종료됩니다.\n");
		}

	}

	// 루틴 저장하는 메서드
	public void save(List<String> result) {
		WorkDAO dao = new WorkDAO();
		// 루틴 저장 여부 확인
		while (true) {
			System.out.print("해당 루틴을 저장하시겠습니까? [Y/N] \n입력 : ");
			
			String answer = scan.next();
			// 루틴 저장
			if (answer.equals("Y")) {
				System.out.println("\n사용자의 이름을 입력해주세요.");
				System.out.print("사용자 이름 : ");
				String name = scan.next();
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
				System.out.println("추천 서비스가 종료됩니다.\n");
				break;
				// 루틴 저장하지 않음
			} else if (answer.equals("N")) {
				System.out.println("\n저장하지 않습니다.");
				System.out.println("추천 서비스가 종료됩니다.\n");
				break;
			} else {
				System.out.println("\n잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	// 저장한 루틴 확인하는 메서드
	public void showRecord() {
		WorkDAO dao = new WorkDAO();
		System.out.println("저장된 사용자 루틴을 조회합니다.");
		System.out.print("사용자 이름 : ");
		String name = scan.nextLine();
		List<RoutineDTO> list = dao.showRoutine(name);
		System.out.println("\n-----" + name + "님의 루틴-----");
		for (int i = 0; i < list.size(); i++) {
			System.out.print("루틴No:" + list.get(i).getId() + " / ");
			System.out.print(list.get(i).getName() + "님 / ");
			System.out.print(list.get(i).getwNames() + " / ");
			System.out.println(list.get(i).getwDate());
		}
		if (list.isEmpty()) {
			System.out.println("존재하지 않는 사용자 입니다.");
		}
		System.out.println("");

	}

	public void delRecord() {
		WorkDAO dao = new WorkDAO();
		System.out.println("\n저장된 루틴을 삭제합니다.");
		System.out.print("루틴 번호 : ");
		int id = scan.nextInt();
		int result = dao.delRoutine(id);
		if (result == 1) {
			System.out.println(id + "번 루틴이 삭제되었습니다.");
		} else {
			System.out.println("존재하지 않는 루틴번호 입니다.");
		}
	}
	
	
}
