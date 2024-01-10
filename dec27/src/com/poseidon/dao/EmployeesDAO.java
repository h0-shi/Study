package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.EmployeesDTO;

public class EmployeesDAO {
	DBConnection dbCon = new DBConnection();
	
	public List<EmployeesDTO> selectEmployees(){
		List<EmployeesDTO> result = new ArrayList<EmployeesDTO>();
		
		Connection conn = dbCon.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM employees WHERE first_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Aamer");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmployeesDTO em = new EmployeesDTO();
				em.setEmp_no(rs.getInt(1));
				em.setBirth_date(rs.getString(2));
				em.setFirst_name(rs.getString(3));
				em.setLast_name(rs.getString(4));
				em.setGender(rs.getString(5));
				em.setHire_date(rs.getString(6));
				result.add(em);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public List<EmployeesDTO> recommandEmp(String gen){
		List<EmployeesDTO> result = new ArrayList<EmployeesDTO>();
		
		Connection conn = dbCon.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM employees WHERE first_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gen);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmployeesDTO em = new EmployeesDTO();
				em.setEmp_no(rs.getInt("emp_no"));
				em.setBirth_date(rs.getString("birth_date"));
				em.setFirst_name(rs.getString("first_name"));
				em.setLast_name(rs.getString("last_name"));
				em.setGender(rs.getString("gender"));
				em.setHire_date(rs.getString("hire_date"));
				result.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
}
