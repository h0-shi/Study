package com.seonwoo.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seonwoo.db.DBConnection;
import com.seonwoo.dto.RoutineDTO;
import com.seonwoo.dto.WorkDTO;

public class WorkDAO {
	DBConnection dbc = new DBConnection();

	public void insertWork(WorkDTO dto) {
		String sql = "INSERT INTO work (wSet,wNumber,wSec,wName) VALUES (?,?,?,?)";
		try {
			Connection conn = dbc.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getwSet());
			pstmt.setInt(2, dto.getwNumber());
			pstmt.setInt(3, dto.getwSec());
			pstmt.setString(4, dto.getwName());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<WorkDTO> selectWork(String name) {
		List<WorkDTO> list = new ArrayList<WorkDTO>();

		String sql = "SELECT * FROM work WHERE wName=?";

		try {
			Connection conn = dbc.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				WorkDTO dto = new WorkDTO();
				dto.setwNo(rs.getInt(1));
				dto.setwName(rs.getString(2));
				dto.setwSet(rs.getInt(3));
				dto.setwNumber(rs.getInt(4));
				dto.setwSec(rs.getInt(5));
				dto.setwDate(rs.getDate(6));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*------이하 박시호 수정-----*/
//	close 메서드
	private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	루틴 추천하는 메서드
	public List<WorkDTO> recommand(String wType) {
		List<WorkDTO> list = new ArrayList<WorkDTO>();

		String sql = "SELECT * FROM work WHERE wType=?";

		Connection conn = dbc.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wType);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				WorkDTO dto = new WorkDTO();
				dto.setwNo(rs.getInt(1));
				dto.setwName(rs.getString(2));
				dto.setwSet(rs.getInt(3));
				dto.setwNumber(rs.getInt(4));
				dto.setwSec(rs.getInt(5));
				dto.setwType(rs.getString(6));
				dto.setwDate(rs.getDate(7));

				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}

		return list;

	}

//	루틴 추가하는 메서드
	public void insertRountine(String name, String result) {
		String sql = "INSERT INTO routine (name, wNames) VALUES (?,?)";
		Connection conn = dbc.getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, result);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
	}

//	추가된 루틴 조회하는 메서드
	public List<RoutineDTO> showRoutine(String name) {
		
		List<RoutineDTO> list = new ArrayList<RoutineDTO>();
		
		String sqlMax = "SELECT MAX(JSON_LENGTH(wNames)) FROM routine";
		int max = 0;
		
		Connection conn = dbc.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sqlMax);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			    max = rs.getInt(1);
			    System.out.println("최대 길이: " + max);
			} else {
			    // 결과 집합이 비어있는 경우
			    System.out.println("결과가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		----------------------------
		String sql = "SELECT * FROM routine WHERE name=?";
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					RoutineDTO dto = new RoutineDTO();
					dto.setId(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setwNames(rs.getString(3));
					dto.setwDate(rs.getDate(4));
					list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs, pstmt, conn);
			}
		return list;
	}

	/* 발송 이후 추가본 */
//	조회된 루틴 삭제하는 메서드
	public int delRoutine(int id) {
		int result = 0;

		String sql = "DELETE FROM routine WHERE id=?";
		Connection conn = dbc.getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}

		return result;
	}

}
