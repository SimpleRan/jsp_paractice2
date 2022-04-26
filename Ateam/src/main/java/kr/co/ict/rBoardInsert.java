package kr.co.ict;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.ict.domain.rDAO;

/**
 * Servlet implementation class boardInsert
 */
@WebServlet("/boardInsert")
public class rBoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rBoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식인 경우 제일먼저 한글 인코딩 설정부터
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		int udate = Integer.parseInt(request.getParameter("udate"));
		int utime = Integer.parseInt(request.getParameter("utime"));
		int person = Integer.parseInt(request.getParameter("person"));
		int review = Integer.parseInt(request.getParameter("review"));
		
		System.out.println(num + ", " + name + ", " + phone + ", " + udate + ", " + utime + ", " + utime +  ", " +  person + ", " + review);
		// dao생성
		rDAO dao = rDAO.getInstance();
		// dao의 insert기능 호출 및 파라미터 매칭
		dao.rBoardInsert(num, name, phone, udate, utime, person, review);
		
		// /boardList로 리다이렉트(서블릿 주소로 리다이렉트시 파일이름 노출 안됨.)
		response.sendRedirect("http://localhost:8181/Ateam/rboardList");
    }
}
