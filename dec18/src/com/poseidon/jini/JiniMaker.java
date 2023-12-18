package com.poseidon.jini;

import java.util.Scanner;

public class JiniMaker {
	public static void main(String[] args) {
		JINI jini = new JINI();
		
		Scanner sc = new Scanner(System.in);
		
		while (jini.isQute) {
			System.out.println("명령어를 입력하세요.");
			String result = sc.next();
			jini.scheck(result);
		}
	}

}
