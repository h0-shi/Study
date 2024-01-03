package com.hoshi.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IO03 {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("c:/temp/test.txt");
		
		while(true) {
			int data = is.read();
			if(data == -1) {
				break;
			}
			System.out.println((char)data);
			
			is.close();
		}
	}
}
