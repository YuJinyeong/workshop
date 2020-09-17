package com.ssafy.parameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiparam.do")
public class MultiParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		String fruits[] = request.getParameterValues("fruit");
		
		response.setContentType("text/html); charset=UTF_8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<div align=\"center\">");
		out.print(userName + "(<strong>" + userId + "</strong>)님이 좋아하는 과일은 ");
		StringBuilder sb = new StringBuilder();
		if(fruits != null) {
			int len = fruits.length;
			for(int i=0; i<len; i++) {
				sb.append(fruits[i]);
				if(i != len-1)
					sb.append(", ");
			}
			sb.append("입니다.");
		}else {
			sb.append("없습니다.");
		}
		out.print(sb.toString());
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}

}
