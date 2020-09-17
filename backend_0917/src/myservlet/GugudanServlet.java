package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanServlet.do")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GugudanServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		int num = Integer.parseInt(request.getParameter("dan"));
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>구구단(Servlet)</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<<< " + num + "단 >>> <br>");
		for(int dan=2; dan<10; dan++) {
			out.print(num + " * " + dan + " = " + num * dan);
			out.print("<br>");
		}
		out.print("</body>");
		out.print("</html>");
	}
	
}
