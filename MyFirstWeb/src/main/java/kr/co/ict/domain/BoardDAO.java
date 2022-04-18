package kr.co.ict.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	// 생성자까지 만들어주세요.
	// 이미 커넥션플 설정이 되어있으니 UserDAO에서 활성화된 코드만 참조해서
	// 생성자 부분까지만 작성해서 저한테 보내주세요.
	private DataSource ds=null;
	private static BoardDAO dao = new BoardDAO();
	
	public BoardDAO() {
			try {
				Context ct = new InitialContext();
				ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			} catch (Exception e) {
				e.printStackTrace();
		  }
		}
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	// 게시판의 전체 글을 가져오는 getBoardList() 메서드를 작성해주세요.
	// 전체 글을 가져오므로 List<BoardVO>를 리턴하면 됩니다.
	// 작성시 UserDAO의 getAllUserList()메서드를 참조해주세요.
	public List<BoardVO> getBoardList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		
		try { 
			con = ds.getConnection();
			String sql = "SELECT * FROM boardTbl";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				BoardVO board = new BoardVO();
				System.out.println("집어넣기 전 : " + board);
				//int를 받아올땐 rs.getInt(), Date를 받아올때는 getDate()를 씁니다.
				board.setBoardNum(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setbDate(rs.getDate(5));
				board.setmDate(rs.getDate(6));
				board.setHit(rs.getInt(7));
				// 다 집어넣은 후 디버깅
				System.out.println("집어넣은 후 : " + board);
				// userList에 쌓기
				boardList.add(board);
			}
			System.out.println("리스트에 쌓인 자료 체크 : " + boardList);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return boardList;
	} // getBoardList()끝나는 지점
	
	// boardtbl 에서 row 1개를 가져오거나(글번호존재시), 안가져옴(없는글번호 입력시)
	public BoardVO getBoardDetail(int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = new BoardVO();
		
		try {
			con = ds.getConnection();
			String sql ="SELCET * FROM boardtbl WHERE board_num=?";
			
			pstmt =con.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setBoardNum(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setbDate(rs.getDate(5));
				board.setmDate(rs.getDate(6));
				board.setHit(rs.getInt(7));
			}else {
				System.out.println("계정이 없습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return board;
	}
	
	
	}
