

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register.do")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public registerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html");
		System.out.println("register.do의 post요청을 처리하는 담당자입니다.");
		String n = req.getParameter("pName");
		String p = req.getParameter("pPrice");
		String c = req.getParameter("pCont");
		System.out.println("받은 파라메터 값들입니다.");
		System.out.println("pName : " + n);
		System.out.println("pPrice : " + p);
		System.out.println("pCont : " + c);
	}

}
