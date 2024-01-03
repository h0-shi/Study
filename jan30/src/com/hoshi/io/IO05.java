package com.hoshi.io;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class IO05 {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/temp/test4.txt");
		Writer writer = new OutputStreamWriter(fos);
		
		writer.write("문자열 저장함");
		writer.flush();
		writer.close();
		
	}

}
