package kr.co.ict.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class rDAO {
	
	private DataSource ds = null;
	
	private static rDAO dao = new rDAO();

	private rDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static rDAO getInstance() {
		if(dao == null) {
			dao = new rDAO();
		}
		return dao;
	}
	
	public rVO getUserInfo() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		rVO user = new rVO();
		try {
	
			con = ds.getConnection();

			String sql = "SELECT * FROM boardnum";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setNum(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPhone(rs.getInt(3));
				user.setUdate(rs.getDate(4));
				user.setUtime(rs.getDate(5));
				user.setPerson(rs.getInt(6));
				user.setReview(rs.getInt(7));
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
				rs.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public void rBoardInsert(int num, String name, int phone, int udate, int utime, int person, int review) {
		// TODO Auto-generated method stub
		
	}

	public List<rVO> rboardList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void rboardDelete(int boardNum) {
		// TODO Auto-generated method stub
		
	}
}
