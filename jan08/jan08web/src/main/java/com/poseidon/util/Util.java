package com.poseidon.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.el.stream.Stream;

public class Util {
//	String값이 들어오면 int 타입인지 확인해보는 메서드
//	127 = t
//	127A = f

	public static int str2Int2(String str) {
		String numberOnly = str.replaceAll("[^0-9]", "");
		return Integer.parseInt(numberOnly);
	}

	public static int str2Int(String str) {
//		A59->59
		StringBuilder temp = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				temp.append(str.charAt(i));
			}
		}

		int result = 0;
		if (temp.length() > 0) {
			result = Integer.parseInt(temp.toString());
			System.out.println("변환된 숫자 : " + result);
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
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return result;
	}

	//ip 가져오기
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
//	HTML 태그를 특수기호로 변경하기 < : &lt // > $gt
	public static String removeTag(String str) {
		str = str.replaceAll("<", "&lt");
		str = str.replaceAll(">", "&gt");
		
		return str;
	}
	
	public static String addBR(String str) {
		return str.replaceAll("(\r\n|\r|\n|\n\r)","<br>");
	}
	
	public static String ipChange(String str) {
		StringBuffer sb = new StringBuffer();
		int idx = str.indexOf(".");
		int idx2 = str.indexOf(".",idx);

		sb.append(str.substring(0,idx));
		sb.append("☆");
		sb.append(str.substring(idx2));
		
		str = sb.toString();
		return str;
	}

}
