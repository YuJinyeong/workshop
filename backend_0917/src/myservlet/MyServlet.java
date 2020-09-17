package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello.do")
public class MyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

		resp.setContentType("text/html;charset=UTF-8"); // 순서가 중요! getWriter하기 전에~
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("이건서블릿");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.print(hour);
		if(hour < 12) {
			pw.println("Good Morning");
		}else {
			pw.println("Good Afternoon");
		}
		pw.println("</body>");
		pw.println("</html>");
	}

}
