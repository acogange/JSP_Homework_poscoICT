package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao {

	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {
	}
	
	public static BbsDao getInstance() {
		return dao;		
	}
	
	public List<BbsDto> getBbsList() {
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ "           TITLE, CONTENT, WDATE, DEL, READCOUNT "
				+ "    FROM BBS "
				+ "    ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 bbslist success");
				
			psmt = conn.prepareStatement(sql);
			System.out.println("2/4 bbslist success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 bbslist success");
			
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), 
										rs.getString(2), 
										rs.getInt(3), 
										rs.getInt(4), 
										rs.getInt(5), 
										rs.getString(6), 
										rs.getString(7), 
										rs.getString(8), 
										rs.getInt(9), 
										rs.getInt(10));
				list.add(dto);
			}
			System.out.println("4/4 bbslist success");
			
		} catch (SQLException e) {
			System.out.println("bbslist fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
	}
	
	public boolean writeBbs(BbsDto dto) {
		
		String sql = "  INSERT INTO BBS(ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				+    "  VALUES(?, (SELECT IFNULL(MAX(REF), 0)+1 FROM BBS a), 0, 0, "
				+    "   	?, ?, NOW(), 0, 0) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 writeBbs success");
				
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			System.out.println("2/3 writeBbs success");
			
			count = psmt.executeUpdate();
			System.out.println("3/3 writeBbs success");
			
		} catch (SQLException e) {
			System.out.println("writeBbs fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count>0?true:false;
	}
	
	public BbsDto getBbs(int seq) {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT "
				   + " FROM BBS "
				   + " WHERE SEQ=? ";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		BbsDto bbs = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 getBbs success");
				
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/3 getBbs success");
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				int n = 1;
				bbs = new BbsDto(	rs.getInt(n++), 
									rs.getString(n++), 
									rs.getInt(n++), 
									rs.getInt(n++), 
									rs.getInt(n++), 
									rs.getString(n++), 
									rs.getString(n++), 
									rs.getString(n++), 
									rs.getInt(n++), 
									rs.getInt(n++));
			}
			System.out.println("3/3 getBbs success");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return bbs;
	}
	
	public void readcount(int seq) {
		String sql = " UPDATE BBS "
				   + " SET READCOUNT=READCOUNT+1 "
				   + " WHERE SEQ=? ";
		
		Connection conn = null;			
		PreparedStatement psmt = null;	
		
		try {
			conn = DBConnection.getConnection();
				
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			
			psmt.execute();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}		
	}
	
	// 댓글				// 부모글의 번호, 새로운 댓글	
	public boolean answer(int seq, BbsDto bbs) {
		
		// update
		String sql1 = " UPDATE BBS "
				    + " SET STEP=STEP+1 "
				    + " WHERE REF = (SELECT REF FROM (SELECT REF FROM BBS a WHERE SEQ=?) A ) "
				    + "   AND STEP > (SELECT STEP FROM (SELECT STEP FROM BBS b WHERE SEQ=?) B ) ";
		
		// insert
		String sql2 = " INSERT INTO BBS(ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				    + " VALUES(?, "
				    + "          (SELECT REF FROM BBS a WHERE SEQ=?), "
				    + "          (SELECT STEP FROM BBS b WHERE SEQ=?) + 1, "
				    + "          (SELECT DEPTH FROM BBS b WHERE SEQ=?) + 1, "
				    + "        ?, ?, NOW(), 0, 0)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
				
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			System.out.println("1/6 answer success");
			
			// update
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("count:" + count);
			System.out.println("3/6 answer success");
			
			// psmt 초기화
			psmt.clearParameters();
			
			// insert
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, bbs.getId());
			psmt.setInt(2, seq);
			psmt.setInt(3, seq);
			psmt.setInt(4, seq);
			psmt.setString(5, bbs.getTitle());
			psmt.setString(6, bbs.getContent());
			System.out.println("4/6 answer success");
		
			count = psmt.executeUpdate();
			System.out.println("count:" + count);
			System.out.println("5/6 answer success");
			
			conn.commit();
			System.out.println("6/6 answer success");
			
		} catch (SQLException e) {
			System.out.println("answer fail");
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		} finally {
			
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
			DBClose.close(conn, psmt, null);
		}
		
		return count>0?true:false;		
	}
	
	public List<BbsDto> getBbsSearchList(String choice, String search) {
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ "           TITLE, CONTENT, WDATE, DEL, READCOUNT "
				+ "    FROM BBS ";
		
		String sWord = "";
		if(choice.equals("title")) {
			sWord = "  WHERE TITLE LIKE '%" + search + "%' ";
		}else if(choice.equals("content")) {
			sWord = "  WHERE CONTENT LIKE '%" + search + "%' ";
		}else if(choice.equals("writer")) {
			sWord = "  WHERE ID='" + search + "' ";
		}
		sql = sql + sWord;
		
		sql += "    ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 bbslist success");
				
			psmt = conn.prepareStatement(sql);
			System.out.println("2/4 bbslist success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 bbslist success");
			
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), 
										rs.getString(2), 
										rs.getInt(3), 
										rs.getInt(4), 
										rs.getInt(5), 
										rs.getString(6), 
										rs.getString(7), 
										rs.getString(8), 
										rs.getInt(9), 
										rs.getInt(10));
				list.add(dto);
			}
			System.out.println("4/4 bbslist success");
			
		} catch (SQLException e) {
			System.out.println("bbslist fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
	}
	
	public List<BbsDto> getBbsPagingList(String choice, String search, int pageNumber) {
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT "
				+ " FROM "
				+ "	(SELECT ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM, "
				+ "		SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT "
				+ "	FROM BBS ";
		
		String sWord = "";
		if(choice.equals("title")) {
			sWord = "  WHERE TITLE LIKE '%" + search + "%' ";
		}else if(choice.equals("content")) {
			sWord = "  WHERE CONTENT LIKE '%" + search + "%' ";
		}else if(choice.equals("writer")) {
			sWord = "  WHERE ID='" + search + "' ";
		}
		sql = sql + sWord;
		
		sql +=  "	ORDER BY REF DESC, STEP ASC) A "
				+ "WHERE RNUM BETWEEN ? AND ? ";
		
		int start, end;
		start = 1 + 10 * pageNumber;	// 0 -> 1 
		end = 10 + 10 * pageNumber; 	// 0 -> 10
				
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 bbslist success");
				
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, start);
			psmt.setInt(2, end);			
			System.out.println("2/4 bbslist success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 bbslist success");
			
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), 
										rs.getString(2), 
										rs.getInt(3), 
										rs.getInt(4), 
										rs.getInt(5), 
										rs.getString(6), 
										rs.getString(7), 
										rs.getString(8), 
										rs.getInt(9), 
										rs.getInt(10));
				list.add(dto);
			}
			System.out.println("4/4 bbslist success");
			
		} catch (SQLException e) {
			System.out.println("bbslist fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
	}
	
	// 글의 총수
	public int getAllBbs(String choice, String search) {
		String sql = " SELECT COUNT(*) FROM BBS ";
		
		String sWord = "";
		if(choice.equals("title")) {
			sWord = "  WHERE TITLE LIKE '%" + search + "%' ";
		}else if(choice.equals("content")) {
			sWord = "  WHERE CONTENT LIKE '%" + search + "%' ";
		}else if(choice.equals("writer")) {
			sWord = "  WHERE ID='" + search + "' ";
		}
		sql = sql + sWord;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int len = 0;
		
		try {
			conn = DBConnection.getConnection();
				
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				len = rs.getInt(1);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return len;
	}
	
	public boolean updateBbs(int seq, String title, String content) {
		String sql = "  UPDATE BBS "
					+ " SET TITLE=?, CONTENT=? "
					+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 S updateBbs");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, seq);
			
			System.out.println("2/3 S updateBbs");
			
			count = psmt.executeUpdate();
			System.out.println("3/3 S updateBbs");
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			DBClose.close(conn, psmt, null);			
		}		
		
		return count>0?true:false;
	}
	
	public boolean deleteBbs(int seq) {
		
		String sql = " UPDATE BBS "
					+ " SET DEL=1 "
					+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 S deleteBbs");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/3 S deleteBbs");
			
			count = psmt.executeUpdate();
			System.out.println("3/3 S deleteBbs");
			
		} catch (Exception e) {		
			System.out.println("fail deleteBbs");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}
	
}









