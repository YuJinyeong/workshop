

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/test.do")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public testServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String a = request.getParameter("a");
		if(!a.equals(null)) {
			if(a.equals("1"))
				response.sendRedirect("result1.jsp");
			else if(a.equals("2"))
				response.sendRedirect("result2.jsp");
			else if(a.equals("3"))
				response.sendRedirect("result3.jsp");
			else if(a.equals("4"))
				response.sendRedirect("result4.jsp");
			else if(a.equals("5"))
				response.sendRedirect("result5.jsp");
			else if(a.equals("6"))
				response.sendRedirect("result6.jsp");
		}
		else {
			throw new RuntimeException();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
