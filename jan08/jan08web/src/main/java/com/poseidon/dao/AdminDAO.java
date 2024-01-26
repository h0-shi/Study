package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.poseidon.db.DBConnection;
import com.poseidon.dto.MemberDTO;

public class AdminDAO extends AbstractDAO {
	DBConnection db = DBConnection.getInstance();
	
	public List<MemberDTO> memberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member ORDER BY mgrade, mno";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO d = new MemberDTO();
				d.setMno(rs.getInt("mno"));
				d.setMid(rs.getString("mid"));
				d.setMname(rs.getString("mname"));
				d.setMdate(rs.getString("mdate"));
				d.setMgrade(rs.getInt("mgrade"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<MemberDTO> memberList(int grade) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE mgrade = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, grade);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO d = new MemberDTO();
				d.setMno(rs.getInt("mno"));
				d.setMid(rs.getString("mid"));
				d.setMname(rs.getString("mname"));
				d.setMdate(rs.getString("mdate"));
				d.setMgrade(rs.getInt("mgrade"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public int memberUpdate(int grade, int mno) {
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET mgrade=? WHERE mno=?";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade);
			pstmt.setInt(2, mno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, con);
		}
		return result;
	}


}
