package com.poseidon.util;

public class Util {
//	String값이 들어오면 int 타입인지 확인해보는 메서드
//	127 = t
//	127A = f
	
	public static int str2Int(String str) {
//		A59->59
		StringBuilder temp = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				temp.append(str.charAt(i));
			}
		}
		
		int result = 0;
		if(temp.length()>0) {
			result = Integer.parseInt(temp.toString());
			System.out.println("변환된 숫자 : "+result);
		}
		return result;
	}
	public static boolean intCheck(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean intCheck2(String str) {
		boolean result = true;
		
		for (int i = 0; i < str.length(); i++) {
			char ascii = str.charAt(i);
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return result;
	}

}
