package com.hoshi.io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IO06 {
	public static void main(String[] args) {
		File dir = new File("c:/temp/images");
		
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File temp = new File("c:/temp");
		File content[] = temp.listFiles();
		
		System.out.println("시간\t\t\t형태\t\t크기\t이름");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for (File file : content) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t"+file.getName());
			} else {
				System.out.print("\t\t\t"+file.length()+"\t"+file.getName());
			}
			System.out.println("");
		}
	}
}
