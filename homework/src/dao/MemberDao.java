package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {
	
	private static MemberDao dao = null;
	
	private MemberDao() {
		DBConnection.initConnection();
	}
	
	public static MemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	public boolean addMember(MemberDto dto) {
		
		String sql = " INSERT INTO MEMBER_H(ID, PWD, NAME, BIRTH, DAUM,HEIGHT) "
				   + " VALUES(?, ?, ?, ?, ?, ? ) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 addMember success");
				
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getBirth());
			psmt.setString(5, dto.getDaum());
			psmt.setInt(6, dto.getHeight());
			System.out.println("2/3 addMember success");
			
			count = psmt.executeUpdate();	
			System.out.println("3/3 addMember success");
			
		} catch (SQLException e) {		
			System.out.println("addMember fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}
	
	public boolean getId(String id) {
		
		String sql = " SELECT ID "
				   + " FROM MEMBER_H "
				   + " WHERE ID=? ";
		/*
		String sql = " SELECT COUNT(*) "
				   + " FROM MEMBER "
				   + " WHERE ID=? ";
		*/
		
		Connection conn = null;			// DB 연결용
		PreparedStatement psmt = null; 	// Query 실행용
		ResultSet rs = null;			// 결과 취득용
		
		boolean findId = false;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 getId success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			System.out.println("2/3 getId success");
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				findId = true;
			}
			System.out.println("3/3 getId success");
			
		} catch (SQLException e) {
			System.out.println("getId fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return findId;
	}
	
	public MemberDto login(MemberDto dto) {
		
		String sql = " SELECT ID, NAME,BIRTH,DAUM,HEIGHT "
				   + " FROM MEMBER_H "
				   + " WHERE ID=? AND PWD=? ";
		
		Connection conn = null;			
		PreparedStatement psmt = null; 	
		ResultSet rs = null;
		
		MemberDto mem = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 login success");
				
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			System.out.println("2/3 login success");
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String birth = rs.getString(3);
				String daum = rs.getString(4);
				int height = rs.getInt(5);
				
				
				mem = new MemberDto(id, null, name, birth,daum, height);
			}		
			System.out.println("3/3 login success");
			
		} catch (SQLException e) {
			System.out.println("login fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return mem;
	}
	

	public boolean out(String pwd,MemberDto dto) {
		
		String sql=" DELETE  FROM MEMBER_H "+" WHERE ID=? AND PWD=?";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 out success");
				
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, pwd);
			System.out.println("2/6 out success");
			System.out.println("id: "+dto.getId());
			System.out.println("pwd: "+pwd);
			count = psmt.executeUpdate();
			System.out.println("3/6 out success");
			System.out.println("count:" + count);
			
		} catch (SQLException e) {		
			System.out.println("out fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}

}




