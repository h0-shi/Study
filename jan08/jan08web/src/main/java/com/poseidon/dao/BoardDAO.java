package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.BoardDTO;
import com.poseidon.dto.MemberDTO;
import com.poseidon.dto.VisitCountDTO;

public class BoardDAO extends AbstractDAO {
	
	public List<BoardDTO> boardList(int page) {
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
		
		String sql = "SELECT * FROM boardview LIMIT ?,10";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (page-1)*10);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO e = new BoardDTO();
				e.setNo(rs.getInt(1));
				e.setTitle(rs.getString("board_title"));
				e.setWrite(rs.getString(3));
				e.setDate(rs.getString(4));
				e.setCount(rs.getInt("board_count"));
				e.setComment(rs.getInt(6));
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
		String sql = "SELECT COUNT(*) FROM boardview";

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

	public int delete(BoardDTO dto) {
		int result = 0;
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET board_del='0' WHERE board_no=? AND mno=(SELECT mno FROM member WHERE mid=?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getMid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		
		
		return result;
	}
	

	public BoardDTO detail(int no) {
		BoardDTO dto = new BoardDTO();
		
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT b.board_no, b.board_title, b.board_content, m.mname as board_write, m.mid, "
					+ "b.board_date, board_ip, (SELECT COUNT(*) FROM visitcount WHERE board_no=b.board_no) AS board_count  "
			        + "FROM board b JOIN member m ON b.mno=m.mno "
			        + "WHERE b.board_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNo(rs.getInt("board_no"));
				dto.setTitle(rs.getString("board_title"));
				dto.setContent(rs.getString("board_content"));
				dto.setWrite(rs.getString("board_write"));
				dto.setDate(rs.getString("board_date"));
				dto.setIp(rs.getString("board_ip"));
				dto.setCount(rs.getInt("board_count"));
				dto.setMid(rs.getString("mid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dto;
	}
	
	public void countUp(int no, String mid) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM visitcount WHERE board_no=? AND mno="
				+ "(SELECT mno FROM member WHERE mid=?)";		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int result = rs.getInt(1);
				
				System.out.println("내가 해당 페이지에 방문 한 적이 있나? : "+result);
				
				if(result==0) {
					realCountup(no, mid);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		
	}
	
	private void realCountup(int no, String mid) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO visitcount (board_no, mno) "
				+ "VALUES (?,(SELECT mno FROM member WHERE mid=?))";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, mid);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		
	}

	public int write(BoardDTO dto) {
		int result  = 0;
		
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO board (board_title, board_content, mno, board_ip) "
				+ "VALUES (?,?,(SELECT mno FROM member WHERE mid=?),?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getMid());
			pstmt.setString(4, dto.getIp());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public void update(BoardDTO dto) {
		
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE board SET board_title=?, board_content=? "
				+ "WHERE board_no=? AND mno=(SELECT mno FROM member WHERE mid = ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
			pstmt.setString(4, dto.getMid());
			System.out.println(dto.getMid());
			System.out.println(dto.getNo());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		
	}
	

	public List<Map<String, Object>> readData(MemberDTO dto) {
		 List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		 Connection con = db.getConnection();
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "SELECT b.board_no, b.board_title, v.vdate FROM visitcount v "
		 		+ "JOIN board b ON b.board_no = v.board_no WHERE v.mno = (SELECT mno FROM member WHERE MID=?)"
		 		+ "ORDER by vdate DESC";
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> e = new HashMap<String, Object>();
				e.put("board_no", rs.getInt("board_no"));
				e.put("board_title", rs.getString("board_title"));
				e.put("vdate", rs.getString("vdate"));
				data.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return data;
	}
}
