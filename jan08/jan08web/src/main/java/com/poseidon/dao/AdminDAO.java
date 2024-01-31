package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.BoardDTO;
import com.poseidon.dto.CommentDTO;
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
	
	public List<BoardDTO> boardList(String str) {
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
		
		String sql = "SELECT b.board_no, b.board_title, m.mname, if(date_format(current_timestamp(),'%Y-%m-%d') = date_format(`b`.`board_date`,'%Y-%m-%d'),date_format(`b`.`board_date`,'%h:%i'),date_format(`b`.`board_date`,'%m-%d')) AS `board_date`,"
				+ "		(select count(0) from `visitcount` where `visitcount`.`board_no` = `b`.`board_no`) AS `board_count`,"
				+ "		(select count(0) from comment c where c.board_no = b.board_no) as comment,"
				+ "		b.board_ip, b.board_del FROM board b JOIN member m ON b.mno = m.mno"
				+ "		WHERE board_title LIKE CONCAT('%',?,'%')"
				+ "		OR \r\n"
				+ "		board_content LIKE CONCAT('%',?,'%')"
				+ "		OR\r\n"
				+ "		mname LIKE CONCAT ('%',?,'%')"
				+ "		ORDER BY b.board_no desc";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str);
			pstmt.setString(2, str);
			pstmt.setString(3, str);
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
	
	public int boardDel(BoardDTO dto) {
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET board_del=? WHERE board_no=?";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getDelete()+"");
			pstmt.setInt(2, dto.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, con);
		}
		return result;
	}

	public List<CommentDTO> commentList() {
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select c.cno , c.board_no, c.ccomment ,"
				+ "if(date_format(c.cdate,'%y-%m-%d') = date_format(current_timestamp(),'%y-%m-%d'),date_format(c.cdate,'%H:%i'),date_format(c.cdate,'%y-%m-%d')) AS cdate, "
				+ "c.clike ,m.mno ,m.mid ,m.mname ,c.cdel ,c.cip from (comment c join member m on(c.mno = m.mno)) order by c.cno desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setCno(rs.getInt(1));
				dto.setBoard_no(rs.getInt(2));
				dto.setComment(rs.getString(3));
				dto.setCdate(rs.getString(4));
				dto.setClike(rs.getInt(5));
				dto.setMno(rs.getInt(6));
				dto.setMid(rs.getString(7));
				dto.setMname(rs.getString(8));
				dto.setdel(rs.getInt(9));
				dto.setIp(rs.getString(10));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return list;
	}
	
	public List<CommentDTO> commentList(String del) {
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select c.cno , c.board_no, c.ccomment ,"
				+ "if(date_format(c.cdate,'%y-%m-%d') = date_format(current_timestamp(),'%y-%m-%d'),date_format(c.cdate,'%H:%i'),date_format(c.cdate,'%y-%m-%d')) AS cdate, "
				+ "c.clike ,m.mno ,m.mid ,m.mname ,c.cdel ,c.cip from (comment c join member m on(c.mno = m.mno)) where cdel=? order by c.cno desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, del);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setCno(rs.getInt(1));
				dto.setBoard_no(rs.getInt(2));
				dto.setComment(rs.getString(3));
				dto.setCdate(rs.getString(4));
				dto.setClike(rs.getInt(5));
				dto.setMno(rs.getInt(6));
				dto.setMid(rs.getString(7));
				dto.setMname(rs.getString(8));
				dto.setdel(rs.getInt(9));
				dto.setIp(rs.getString(10));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return list;
	}
	
	public List<Map<String, Object>> ipList(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM iplog";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("ino", rs.getInt(1));
			m.put("iip",rs.getString(2));
			m.put("idate",rs.getString(3));
			m.put("iurl",rs.getString(4));
			m.put("idata",rs.getString(5));
			list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<Map<String, Object>> ipList(String iip){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM iplog where iip=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, iip);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("ino", rs.getInt(1));
				m.put("iip",rs.getString(2));
				m.put("idate",rs.getString(3));
				m.put("iurl",rs.getString(4));
				m.put("idata",rs.getString(5));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<Map<String, Object>> ipTop(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT iip, COUNT(*) as count FROM iplog group by iip order by count DESC LIMIT 0,5";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("iip",rs.getString(1));
				m.put("idata",rs.getInt(2));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<Map<String, Object>> distinictIp(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROW_NUMBER() OVER (ORDER BY iip) AS num, iip FROM iplog group BY iip";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("ino", rs.getInt(1));
				m.put("iip",rs.getString(2));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}

}
