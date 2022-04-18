package kr.co.ict;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.BoardDAO;
import kr.co.ict.domain.BoardVO;

/**
 * Servlet implementation class getBoardDetail
 */
@WebServlet("/boardDetail")
public class getBoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터로 글번호("board_Num")을 받아오세요.
		// request.getPrameter()는 무조건 문자로만 데이터를 전달함
		String strBoardNum = request.getParameter("board_num");
		// 정수로 바꿔줘야함
		int boardNum = Integer.parseInt(strBoardNum);
		System.out.println("조회예정인 글번호 : " + boardNum);
		
		// DAO를 생성하세요
		BoardDAO dao = BoardDAO.getInstance();
		
		// DAO를 호출한 디테일 글 정보를 저장해주세요.
		BoardVO board = dao.getBoardDetail(boardNum);
		
		// 얻어온 글 정보를 디버깅해주세요.
		System.out.println(board);
		
		// 바인딩해주세요.
		request.setAttribute("getBoardDetail", boardNum);
		
		// 포워딩해주세요(/board/boardDetail.jsp로)
		RequestDispatcher dp = request.getRequestDispatcher("/board/getBoardDetail.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
