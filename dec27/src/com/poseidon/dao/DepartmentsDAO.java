package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.DepartmentsDTO;

public class DepartmentsDAO {
	 DBConnection dbConn = new DBConnection();
	 
	 public List<DepartmentsDTO> selectDepartments() {
		 List<DepartmentsDTO> list = null;
		 
		 Connection con = dbConn.getConn();
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 String sql = "SELECT * FROM departments";
		 
		 try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<DepartmentsDTO>();
			
			while(rs.next()) {
				DepartmentsDTO dto = new DepartmentsDTO();
				dto.setDept_no(rs.getString("dept_no"));
				dto.setDept_name(rs.getString(2));
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return list;
	 }
	 
	
}
