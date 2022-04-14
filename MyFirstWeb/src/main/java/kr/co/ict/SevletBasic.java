package kr.co.ict;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SevletBasic
 */
@WebServlet("/apple")//www.localhost:8181/MyFristWeb/apple 로 접속할 시 작동한다는 의미
public class SevletBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevletBasic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {//서버를 켜고 최초 접속시에만 한 번 호출
		System.out.println("첫 접속시에만 실행됩니다.");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() { // 서버를 종료시에만 한 번 호출
		System.out.println("서버를 종료하기 위해 메모리에서 /apple를 비웁니다.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("유저가 접속했습니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *///접속할때마다 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("유저가 접속했습니다.");
		doGet(request, response);
	}

}
