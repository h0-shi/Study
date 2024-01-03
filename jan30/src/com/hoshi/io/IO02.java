package com.hoshi.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IO02 {
	public static void main(String[] args) throws IOException {

		OutputStream os = new FileOutputStream("c:/temp/test.txt");

		byte arr[] = new byte[] { 72, 69, 76, 76, 79 };

		os.write(arr, 1, 3);

		os.flush();
		os.close();
	}

}
