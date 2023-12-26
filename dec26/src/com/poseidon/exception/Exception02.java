package com.poseidon.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception02 {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
//			예외가 발생 할 문장
			fr = new FileReader("temp.text");
		} catch (FileNotFoundException e) {
//			예외가 발생했다면 처리 할 문장
			e.printStackTrace();
			System.out.println("File Not Found");
		} finally {
//			예외 발생과 상관 없이 처리 할 문장
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("끝");
	}
}
