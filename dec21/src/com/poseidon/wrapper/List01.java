package com.poseidon.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class List01 {
	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Integer> lotto = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			lotto.add(random.nextInt(45)+1);
//			lotto.add((int)(Math.random()*45+1));
		}
		System.out.println(lotto);
		//오름차순 정렬
		Collections.sort(lotto);
		System.out.println(lotto);
		//내림차순 정렬
		Collections.sort(lotto, Collections.reverseOrder());
		System.out.println(lotto);
	}
}
