package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println("login.do의 post요청을 처리하는 담당자입니다.");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String my = req.getParameter("my");
		System.out.println("받은 파라메터 값들입니다.");
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("my : " + my);
//		resp.sendRedirect("http://www.naver.com");
		if( id.equals("hello") && pw.equals("ssafy") )
		{
			int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			String msg = (hour < 12) ? "good morning" : "good afternoon";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("hello.jsp").forward(req, resp);
		}
		else
			resp.sendRedirect("form.jsp");
	}
	
}