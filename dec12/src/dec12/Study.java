package dec12;

import java.util.ArrayList;
import java.util.Arrays;

public class Study {
	public static void main(String[] args) {
		
		int arr1[][] = new int[3][4];	//그냥 배열
		int arr2[][] = new int[3][]; // 동적가변배열 미완성 -> 추상화 -> 인터페이스
		
		System.out.println(arr2);			//[[I@3d012ddd
		System.out.println(arr2.length);	//3
		
		System.out.println(arr2[0]);		//null
//		System.out.println(arr2[0].length);		//null => null이기 때문에 길이 못구해
		
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = new int [(int)(Math.random()*5+1)];	// 각 차원들의 길이 정하기
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = i*j+1;
			}
		}
		System.out.println(arr2[0].length);		//
		System.out.println(Arrays.deepToString(arr2));
		
		for(int[] is: arr2) {
			System.out.println(Arrays.toString(is));
		}
		
		System.out.println("===선===");
		/*
		 * 2차원 배열을 리스트로 만들기
		 * 1. 다차원 list 생성
		 * 2. 1번의 list보다 차수가 1 낮은 list생성
		 * 3. 2번의 list에 값 입력
		 * 4. 1번에 list에 .add(list)로 조짐
		 *  => 결과적으로 list 안에 list가 들어가는거지
		 */
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ele = new ArrayList<Integer>();
		ele.add(1);
		ele.add(2);
		ele.add(3);
		list.add(ele);
		
		ele = new ArrayList<Integer>(); // list 초기화
		ele.add(4);
		ele.add(5);
		ele.add(6);
		ele.add(7);
		list.add(ele);
		
		System.out.println(ele);
		System.out.println(list);
		
		System.out.println("===선===");
		
		int arr3[][] = new int [][] {{1,2,3},{4,5,6},{7,8,9}};	//[3][3] 3개짜리가 3개 있음
		System.out.println(Arrays.deepToString(arr3));

	}
}
