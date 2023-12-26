package com.poseidon.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {	
		DBConnection dbConn = new DBConnection();  //-> 메서드마다 반복작업 되므로 class변수로 두기
	public List<EmployeesDTO> selectEmployees(){
		List<EmployeesDTO> result = null;
//		접속정보
		Connection con = dbConn.getConncetion();
//		각종 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employees LIMIT 0,10";
//		로직
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<EmployeesDTO>();
			while(rs.next()) {
				EmployeesDTO dto = new EmployeesDTO	();
				dto.setEMP_no(rs.getInt("emp_no"));
				dto.setBirth_date(rs.getString(2));
				dto.setFirst_name(rs.getString(3));
				dto.setLast_name(rs.getString(4));
				dto.setGender(rs.getString(5));
				dto.setHire_date(rs.getString(6));
				
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
//	데이터베이스 접속 객체(Data Access Object)
	public List<EmployeesDTO> selectDepartments(){		// list를 리턴하는 메서드 
		List<EmployeesDTO> result = null;
//		데이터베이스 접속 정보
//		DBConnection dbConn = new DBConnection();  //-> 메서드마다 반복작업 되므로 class변수로 두기
		Connection conn = dbConn.getConncetion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		sql
		String sql = "SELECT * FROM departments";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<EmployeesDTO>();
//			EmployeesDTO dto = new EmployeesDTO();  //얘가 여기 있으면 같은 주소를 사용하기 때문에, 중복값만 출력됨(?)
//			-> 새로운 값을 넣기 위해 dto에 다른 값을 넣는다고 한들 list에 이미 들어간 값 또한 새로운 값으로 변경됨
			
			while(rs.next()) {
				EmployeesDTO dto = new EmployeesDTO(); // 여기서 새로운 주소를 계속 생성해야됨.
				dto.setDept_no(rs.getString(1));
				dto.setDept_name(rs.getString(2));
//				로우 세팅하는거지 지금
				result.add(dto);
			} 
		} catch (SQLException e) {
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
			
		}
//		데이터베이스 만드는 작업
		
		
		return result;
	}
}
