package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.poseidon.db.DBConnection;
import com.poseidon.dto.BoardDTO;
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
	
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		// db정보
		// DBConnection db = DBConnection.getInstance();
		// conn 객체
		Connection con = DBConnection.getInstance().getConnection();
		// pstmt
		PreparedStatement pstmt = null;
		// rs
		ResultSet rs = null;
		// sql
		
		String sql = "SELECT b.board_no, b.board_title, m.mname, "
				+ "if(date_format(current_timestamp(),'%Y-%m-%d') = date_format(`b`.`board_date`,'%Y-%m-%d'),date_format(`b`.`board_date`,'%h:%i'),date_format(`b`.`board_date`,'%m-%d')) AS `board_date`, "
				+ "(select count(0) from `visitcount` where `visitcount`.`board_no` = `b`.`board_no`) AS `board_count`,"
				+ "(select count(0) from comment c where c.board_no = b.board_no) as comment, "
				+ "b.board_ip, b.board_del "
				+ "FROM board b JOIN member m ON b.mno = m.mno ORDER BY b.board_no DESC";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO e = new BoardDTO();
				e.setNo(rs.getInt(1));
				e.setTitle(rs.getString(2));
				e.setWrite(rs.getString(3));
				e.setDate(rs.getString(4));
				e.setCount(rs.getInt(5));
				e.setComment(rs.getInt(6));
				e.setIp(rs.getString(7));
				e.setDelete(rs.getInt(8));
				list.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return list;
	}
	
	public int totalCount() {
		int result = 0;
		// db정보
		// DBConnection db = DBConnection.getInstance();
		// conn 객체
		Connection con = DBConnection.getInstance().getConnection();
		// pstmt
		PreparedStatement pstmt = null;
		// rs
		ResultSet rs = null;
		// sql
		String sql = "SELECT COUNT(*) FROM board";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return result;
	}
	
	public List<BoardDTO> search(int no) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		// db정보
		// DBConnection db = DBConnection.getInstance();
		// conn 객체
		Connection con = DBConnection.getInstance().getConnection();
		// pstmt
		PreparedStatement pstmt = null;
		// rs
		ResultSet rs = null;
		// sql
		
		String sql = "SELECT b.board_no, b.board_title, m.mname, "
				+ "if(date_format(current_timestamp(),'%Y-%m-%d') = date_format(`b`.`board_date`,'%Y-%m-%d'),date_format(`b`.`board_date`,'%h:%i'),date_format(`b`.`board_date`,'%m-%d')) AS `board_date`, "
				+ "(select count(0) from `visitcount` where `visitcount`.`board_no` = `b`.`board_no`) AS `board_count`,"
				+ "(select count(0) from comment c where c.board_no = b.board_no) as comment, "
				+ "b.board_ip, b.board_del "
				+ "FROM board b JOIN member m ON b.mno = m.mno WHERE no = ? ORDER BY b.board_no DESC";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO e = new BoardDTO();
				e.setNo(rs.getInt(1));
				e.setTitle(rs.getString(2));
				e.setWrite(rs.getString(3));
				e.setDate(rs.getString(4));
				e.setCount(rs.getInt(5));
				e.setComment(rs.getInt(6));
				e.setIp(rs.getString(7));
				e.setDelete(rs.getInt(8));
				list.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return list;
	}

}
