package com.poseidon.db;
// 접속정보만 갖고있는 class

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public Connection getConncetion() {
		Connection con = null;
//		욕심은 이걸 싱클턴 패턴화 시키는 것

		try {
				Class.forName("org.mariadb.jdbc.Driver");
				String url = "jdbc:mariadb://guro.wisejia.com:3307/employees";
				String user = "c23c_07";
				String pw = "kiri!94859485";
				con = DriverManager.getConnection(url, user, pw);	// url, id, pw
			} catch (ClassNotFoundException e) {
				System.out.println("해당 클래스가 없습니다.");
			} catch (SQLException e) {
				System.out.println("접속 정보를 확인해주세요");
			}
		
		return con;
	}

}
