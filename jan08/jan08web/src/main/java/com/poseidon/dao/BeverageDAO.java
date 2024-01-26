package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.BeverageDTO;

public class BeverageDAO extends AbstractDAO{
	
	DBConnection db = DBConnection.getInstance();
	
	public List<BeverageDTO> cList(){
		List<BeverageDTO> result = new ArrayList<BeverageDTO>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM beverage WHERE btype = 'c'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			BeverageDTO b = new BeverageDTO();
			b.setBeverage(rs.getString("beverage"));
			b.setBtype(rs.getString("btype"));
			result.add(b);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<BeverageDTO> tList(){
		List<BeverageDTO> result = new ArrayList<BeverageDTO>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM beverage WHERE btype = 't'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			BeverageDTO b = new BeverageDTO();
			b.setBeverage(rs.getString("beverage"));
			b.setBtype(rs.getString("btype"));
			result.add(b);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<BeverageDTO> bList(){
		List<BeverageDTO> result = new ArrayList<BeverageDTO>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM beverage WHERE btype = 'b'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			BeverageDTO b = new BeverageDTO();
			b.setBeverage(rs.getString("beverage"));
			b.setBtype(rs.getString("btype"));
			result.add(b);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	private int create(BeverageDTO dto) {
		int result = 0;
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO bselect (temp, beverage, ip) VALUES (?,?,?)";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTemp());
			pstmt.setString(2, dto.getBeverage());
			pstmt.setString(3, dto.getIp());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		
		
		return result;
	}
	
	public int check(BeverageDTO dto) {
		int result = 0;
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM bselect WHERE DATE = date_format(NOW(),'%Y-%m-%d') "
				+ "AND ip =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIp());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				if(result == 0 ) {
					result = create(dto);
				} else {
					result = 0;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<BeverageDTO> hot() {
		List<BeverageDTO> result = new ArrayList<BeverageDTO>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT beverage, COUNT(*) AS count FROM bselect where temp = 'hot' AND DATE = date_format(NOW(),'%Y-%m-%d') GROUP BY beverage ORDER BY COUNT desc"; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			BeverageDTO b = new BeverageDTO();
			b.setCount(rs.getInt("count"));
			b.setBeverage(rs.getString("beverage"));
			result.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<BeverageDTO> ice() {
		List<BeverageDTO> result = new ArrayList<BeverageDTO>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT beverage, COUNT(*) AS count FROM bselect where temp = 'ice' AND DATE = date_format(NOW(),'%Y-%m-%d') GROUP BY beverage ORDER BY COUNT desc"; 
				
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			BeverageDTO b = new BeverageDTO();
			b.setCount(rs.getInt("count"));
			b.setBeverage(rs.getString("beverage"));
			result.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public int del(String ip) {
		int result = 0;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM bselect WHERE ip = ? AND DATE = date_format(NOW(),'%Y-%m-%d')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ip);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
