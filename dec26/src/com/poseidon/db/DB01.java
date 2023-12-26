package com.poseidon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 자바와 DB 연결하기
public interface DB01 {
	public static void main(String[] args) {
		Connection conn = null;	//접속 정보를 받음
		PreparedStatement pstmt = null;	// 여기에 최종 정보가 담겨. 정보 배달원 -> rs에게 배달
		ResultSet rs = null;	// 최종 결과가 담기는 곳
		
		String db = "jdbc:mariadb://guro.wisejia.com:3307/employees";
		String id = "c23c_07";
		String pw = "kiri!94859485";
		String sql = "SELECT * FROM departments";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(db, id, pw);	// url, id, pw
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// rs에서 남은 값이 있다면 t, 더이상 값이 없다면 f
				String dept_no = rs.getString("dept_no");
				String dept_name = rs.getString("dept_name");
				System.out.println(dept_no+" : "+dept_name);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스가 없습니다.");
		} catch (SQLException e) {
			System.out.println("접속정보를 확인해주세요.");
		} finally {	//예외 유무와 상관 없이 실행
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("closing 오류");
			}			

		}
		
	}
}
