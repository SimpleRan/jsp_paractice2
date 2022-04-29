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
import kr.co.ict.service.BoardDetailService;
import kr.co.ict.service.BoardListService;
import kr.co.ict.service.IBoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식을 처리하는 경우도 생기므로, 인코딩 설정
		request.setCharacterEncoding("utf-8");
		// 프론트 컨트롤러는 여러 주소 유형을 처리해야하니 uri부터 받아옵니다.
		String uri = request.getRequestURI();
		// 포워딩시 .jsp주소의 경로를 미리 저장할 변수
		String ui = null;
		// dao생성
		BoardDAO dao = BoardDAO.getInstance();
		// 어떤 종류이 서비스라도 다 받을 수 있는 서비스 인터페이스 생성
		IBoardService sv = null;
		
		if(uri.equals("/MyFirstWeb/boardList.do")) {
			// boardList.do를이용해 글목록 페이지로 넘어가도록 로직을 작성해주세요.
			// -> getboardlist.java에서 복사 맨위랑 아래 겹치는거 지우기 주소(/board/getBoardList.jsp)만 남기고 ui= ;으로 
			
			// 서비스 생성 
			sv = new BoardListService();
			// 서비스의 .execute(request, response)호출 
			sv.execute(request, response);			
			ui = "/board/getBoardList.jsp";
			
		}else if(uri.equals("/MyFirstWeb/boardDetail.do")) {
			//디테일페이지 로드 로직을 직접 추가해보세요.
			sv = new BoardDetailService();
			sv.execute(request, response);
			ui = "/board/boardDetail.jsp";

		}else if(uri.equals("/MyFirstWeb/boardInsertForm.do")) {
			//글쓰기 창으로 넘어가는 로직
			ui = "/board/boardInsertForm.jsp";			
			//글쓰기 로직을 완성시켜주세요(4.28 숙제)
		}else if(uri.equals("/MyFirstWeb/boardInsert.do")) {
	
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// dao의 insert기능 호출 및 파라미터 매칭
			dao.boardInsert(title, content, writer);
			
			ui = "/boardList.do";// 리다이렉트시는 폴더명 없이 마지막 주소만 적습니다.
			
		}else if(uri.equals("/MyFirstWeb/boardDelete.do")) {
			String strBoardNum = 
					request.getParameter("board_num");
			int boardNum = Integer.parseInt(strBoardNum);

			// delete로직 호출
			dao.boardDelete(boardNum);
			// boardList로 리다이렉트
			ui = "/boardList.do";
			
		}else if(uri.equals("/MyFirstWeb/boardUpdateForm.do")) {
			String strBoardNum = request.getParameter("board_num");
			int boardNum = Integer.parseInt(strBoardNum);	
			BoardVO board = dao.getBoardDetail(boardNum);
			
			// 바인딩
			request.setAttribute("board", board);
			// 포워딩
			ui = "/board/boardUpdateForm.jsp";
			
		}else if(uri.equals("/MyFirstWeb/boardUpdate.do")) { //수정로직처리하는 내용			
			String strBoardNum = request.getParameter("board_num");
			int boardNum = Integer.parseInt(strBoardNum);			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			dao.boardUpdate(boardNum, title, content, writer);
		
			ui = "/boardDetail.do?board_num=" + boardNum;
			
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
	
}
