package com.poseidon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public Connection getConn() {
		Connection connection = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://guro.wisejia.com:3307/employees";
			String user = "c23c_07";
			String pw = "kiri!94859485";
			
			connection = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("사용자 정보가 올바르지 않습니다.");
			e.printStackTrace();
		}
		
		return connection;
		
	}

}
