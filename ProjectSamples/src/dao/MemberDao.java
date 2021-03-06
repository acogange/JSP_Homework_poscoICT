package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {
	private static MemberDao dao = null;

	private MemberDao() {
		DBConnection.initConnection();

	}

	public static MemberDao getInstance() {
		if (dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}

	
	public boolean getId(String id) {
		String sql = "SELECT ID" + " FROM MEMBER " + "WHERE ID=?";
		// String sql="SELECT COUNT(*)"+"FROM MEMBER"+"WHERE ID=?"; //실무에 더 잘사용

		Connection conn = null; // DB 연결용
		PreparedStatement psmt = null; // Query 실행문
		ResultSet rs = null;

		boolean findId = false;

		conn = DBConnection.getConnection();
		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next())
				findId = true;

		} catch (SQLException e) {
			System.out.println("getId fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}

		return findId;

	}

	public MemberDto login(MemberDto dto) {
		String sql = " SELECT ID,NAME, EMAIL,AUTH " + " FROM MEMBER " + " WHERE ID=? AND PWD=? ";
		System.out.println(sql);
		Connection conn = null; // DB 연결용
		PreparedStatement psmt = null; // Query 실행문
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

			if (rs.next()) {// 한개니까 if 여러개면 for
				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int auth = rs.getInt(4);

				mem = new MemberDto(id, null, name, email, auth);

			}
			System.out.println("3/3 login success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("login fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return mem;

	}
	
	public boolean addMember(MemberDto dto) {
	      
	      String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) "
	            + " VALUES(?, ?, ?, ?, 3) ";
	      
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
	         psmt.setString(4, dto.getEmail());
	         System.out.println("2/3 addMember success");
	         
	         count = psmt.executeUpdate();
	         System.out.println("3/3 addMember success");
	         
	         
	      } catch (SQLException e) {
	         System.out.println("addMember fail");
	         e.printStackTrace();
	      }finally {
	         //DB Close
	         DBClose.close(conn, psmt, null);
	      }
	      return count>0?true:false;
	   }
}
