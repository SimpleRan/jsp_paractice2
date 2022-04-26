package kr.co.ict;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.rDAO;
import kr.co.ict.domain.rVO;

/**
 * Servlet implementation class testtestList
 */
@WebServlet("/rboardList")
public class rGetboardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rGetboardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param list 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, char[] list) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("name");
		
		rDAO dao = rDAO.getInstance();
		//rVO list = dao.getUserInfo();
		List<rVO> rboardList = dao.rboardList();
		
		//System.out.println(id);
		System.out.println(list);
		
		
			System.out.println("데이터 받아오는지 확인 : " + rboardList);
			
			// 포워딩 위치로 얻어온 데이터 보내기.(ServletCustom을 참고하세요.)
			request.setAttribute("rboardList", rboardList);
			// 포워딩으로 getBoardList.jsp와 연결해보겠습니다.
			RequestDispatcher dp = request.getRequestDispatcher("/board/getboardList.jsp");
			dp.forward(request, response);
	}

}
