package com.poseidon.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception03 {
	public static void fileOpen() throws IOException {
		FileReader fr = null; 
		fr = new FileReader("C:\\TEMP\\employees.sql");
		
		while(true) {
			int data = fr.read();
			if(data == -1) {
				break;
			}
			System.out.print((char)data);
		}
		
	}
	public static void main(String[] args)  {
		
		try {
			fileOpen();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main method ends");
	}

}
