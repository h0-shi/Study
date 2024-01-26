package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;

import org.mariadb.jdbc.export.Prepare;

import com.poseidon.dto.MemberDTO;

//로그인, 회원가입, 회원탈퇴, 회원정보
public class MemberDAO extends AbstractDAO {

	public MemberDTO login(MemberDTO dto) {
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT count(*) as count, mname FROM member WHERE mid=? AND mpw=? AND mgrade >= 5";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMpw());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setCount(rs.getInt("count"));
				dto.setMname(rs.getString("mname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}

		return dto;
	}
	
	public int check(MemberDTO dto) {
		int result = 1;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) AS count FROM member WHERE mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public int join(MemberDTO dto) {
		int result = 0;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (mname, mid, mpw) VALUES (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getMid());
			pstmt.setString(3, dto.getMpw());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		return result;
	}
	
	public MemberDTO myInfo(MemberDTO dto){
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String Sql = "SELECT * FROM member WHERE mid=?";
		
		try {
			pstmt = con.prepareStatement(Sql);
			pstmt.setString(1, dto.getMid());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setMno(rs.getInt("mno"));
				dto.setMid(rs.getString("mid"));
				dto.setMpw(rs.getString("mpw"));
				dto.setMname(rs.getString("mname"));
				dto.setMdate(rs.getString("mdate"));
				dto.setMgrade(rs.getInt("mgrade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return dto;
	}
	
	public MemberDTO alterPw(MemberDTO dto) {
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET mpw=? WHERE mid = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMpw());
			pstmt.setString(2, dto.getMid());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, con);
		}
		
		return dto;
	}
	
	public MemberDTO list() {
		MemberDTO dto = new MemberDTO();
		
		
		return dto;
		
	}

}
