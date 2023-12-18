package com.hoshi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB01 {
//	구로에 있는 db 자바로 접속해보기~

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null; // 변수선언
		Statement stmt = null;
		String url = "jdbc:mariadb://wisejia.iptime.org:3308/employees";
		String id = "c23b_15";
		String pw = "c23b_15";

		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		stmt = conn.createStatement();

//		DB에 질의하기 (sql)
		String sql = "SELECT * FROM departments ORDER BY dept_no";
//		오는 값 저장하기
		ResultSet rs = stmt.executeQuery(sql);
//		출력하기
		while(rs.next()) {
			System.out.print(rs.getString(1)+" : ");
			System.out.print(rs.getString(2)+"\n");
		}
//		가장 최근에 생성한 인스턴스부터 닫기
		rs.close();
		stmt.close();
		conn.close();
		
		
	}

}
