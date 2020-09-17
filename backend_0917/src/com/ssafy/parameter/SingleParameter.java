package com.ssafy.parameter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

@WebServlet("/singleparam.do")
public class SingleParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		int area = Integer.parseInt(request.getParameter("area"));
		
		String color[] = {"steelblue", "orange", "tomato", "green"};
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("	<div align=\"center\">");
		out.println(userName + "(<font color=\"" + color[area] + "\">" + userId + "</font>)님 안녕하세요!!!<br>");
		out.println("	</div>");
		out.println("	</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		int area = Integer.parseInt(request.getParameter("area"));
		
		String color[] = {"navi", "orange", "blue", "red"};
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("	<div align=\"center\">");
		out.println(userName + "(<font color=\"" + color[area] + "\">" + userId + "</font>)님 안녕하세요!!!<br>");
		out.println("	</div>");
		out.println("	</body>");
		out.println("</html>");
	}

}
