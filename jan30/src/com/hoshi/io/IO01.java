package com.hoshi.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IO01 {
	public static void main(String[] args) throws IOException {

		OutputStream os = new FileOutputStream("c:/temp/test.txt");

		byte a = 65;
		byte b = 67;
		byte c = 68;

		os.write(a);
		os.write(b);
		os.write(c);

		os.flush();
		os.close();

	}

}
