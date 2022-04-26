package kr.co.ict.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class testDAO {
	
	private DataSource ds = null;
	
	private static testDAO dao = new testDAO();

	private testDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static testDAO getInstance() {
		if(dao == null) {
			dao = new testDAO();
		}
		return dao;
	}
	
	public testVO getUserInfo() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		testVO user = new testVO();
		try {
	
			con = ds.getConnection();

			String sql = "SELECT * FROM boardnum";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setNum(rs.getInt(1));
				user.setUdate(rs.getDate(2));
				user.setUtime(rs.getDate(3));
				user.setPerson(rs.getInt(4));
				user.setReview(rs.getInt(5));
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
}
