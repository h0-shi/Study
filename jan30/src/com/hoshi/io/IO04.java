package com.hoshi.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class IO04 {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("c:/temp/test.txt");
		
		byte arr[] = new byte[2];
		
		while(true) {
//			1회차
//			readBytenum에 2가 들어감. 왜냐. arr에서 2개만 읽어들이기 때문에
//			2회차엔 1이 들어감
//			근데 배열에 한칸이 남으니 마지막 1칸에 이전 값 가져옴
			int readByteNum = is.read(arr);
			if(readByteNum == -1) {
				break;
			}
			
			for (int i = 0; i < readByteNum; i++) {
				System.out.print((char)(arr[i])+" ");
			}
//			System.out.println(readByteNum + " : "+Arrays.toString(arr));
		}
		
		
		is.close();
	}

}
